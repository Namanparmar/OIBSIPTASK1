import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Reservation {
    private String trainNumber;
    private String trainName;
    private String passengerName;
    private String classType;
    private String dateOfJourney;
    private String fromPlace;
    private String toDestination;

    public Reservation(String trainNumber, String trainName, String passengerName, String classType, String dateOfJourney, String fromPlace, String toDestination) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.passengerName = passengerName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.fromPlace = fromPlace;
        this.toDestination = toDestination;
    }

    @Override
    public String toString() {
        return "Train Number: " + trainNumber +
                "\nTrain Name: " + trainName +
                "\nPassenger Name: " + passengerName +
                "\nClass Type: " + classType +
                "\nDate of Journey: " + dateOfJourney +
                "\nFrom: " + fromPlace +
                "\nTo: " + toDestination;
    }
}

class ReservationSystem {
    private static Map<String, Reservation> reservations = new HashMap<>();

    public static void reserveTicket(String pnr, Reservation reservation) {
        reservations.put(pnr, reservation);
        System.out.println("Ticket reserved successfully!");
    }

    public static void cancelTicket(String pnr) {
        if (reservations.containsKey(pnr)) {
            reservations.remove(pnr);
            System.out.println("Ticket canceled successfully!");
        } else {
            System.out.println("Invalid PNR number. Ticket not found!");
        }
    }

    public static void displayReservationDetails(String pnr) {
        if (reservations.containsKey(pnr)) {
            System.out.println("Reservation details for PNR " + pnr + ":");
            System.out.println(reservations.get(pnr));
        } else {
            System.out.println("Invalid PNR number. Ticket not found!");
        }
    }
}

class LoginModule {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123";

    public static boolean login(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("===== Login Form =====");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            loggedIn = LoginModule.login(username, password);

            if (!loggedIn) {
                System.out.println("Login failed! Invalid credentials.");
            }
        }

        System.out.println("Login successful!");

        boolean exit = false;

        while (!exit) {
            System.out.println("===== Menu =====");
            System.out.println("1. Reserve Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display Reservation Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("===== Reservation System =====");
                    System.out.print("Enter PNR number: ");
                    String pnr = scanner.nextLine();
                    System.out.print("Enter Train Number: ");
                    String trainNumber = scanner.nextLine();
                    System.out.print("Enter Train Name: ");
                    String trainName = scanner.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("Enter Class Type: ");
                    String classType = scanner.nextLine();
                    System.out.print("Enter Date of Journey: ");
                    String dateOfJourney = scanner.nextLine();
                    System.out.print("Enter From Place: ");
                    String fromPlace = scanner.nextLine();
                    System.out.print("Enter To Destination: ");
                    String toDestination = scanner.nextLine();

                    Reservation reservation = new Reservation(trainNumber, trainName, passengerName, classType, dateOfJourney, fromPlace, toDestination);
                    ReservationSystem.reserveTicket(pnr, reservation);
                    break;
                case 2:
                    System.out.println("===== Cancellation Form =====");
                    System.out.print("Enter PNR number: ");
                    String cancelPnr = scanner.nextLine();
                    ReservationSystem.cancelTicket(cancelPnr);
                    break;
                case 3:
                    System.out.println("===== Display Reservation Details =====");
                    System.out.print("Enter PNR number: ");
                    String displayPnr = scanner.nextLine();
                    ReservationSystem.displayReservationDetails(displayPnr);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        System.out.println("Thank you for using the Online Reservation System. Goodbye!");
    }
}
