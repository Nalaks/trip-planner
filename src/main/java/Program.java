import java.util.Locale;
import java.util.Scanner;

public class Program implements ProgramInterface {
    private TripCalculations tripCalculations;
    private Scanner scanner;

    public Program() {
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }
    
    public void start() {
        greeting();
        getTravelInformation();
        printTravelInformation();
        getTimeInformation();
        getAreaInformation();
        printDistanceBetweenLocations();
    }

    public void greeting() {
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = scanner.nextLine();

        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String destination = scanner.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip");

    }

    public void getTravelInformation() {
        System.out.print("How many days are you gonna spend travelling? ");
        int days = scanner.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on the trip? ");
        int money = scanner.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String conversion = scanner.next();
        System.out.print("How many " + conversion + " are there in 1 USD? ");
        String currency = scanner.next();
        tripCalculations = new TripCalculations(days, money, Double.parseDouble(currency), conversion);
    }

    public void printTravelInformation() {
        tripCalculations.travelTimeConversion();
        String usdPerDay = String.format("%.2f", tripCalculations.moneySpendPerDay());
        String foreignCurrencyPerDay = String.format("%.2f", tripCalculations.foreignCurrencyPerDay());
        System.out.println("If you are travelling for " + tripCalculations.getDays() +
                " that is the same as " + tripCalculations.getHours() + " hours or "
                + tripCalculations.getMinutes() + " minutes");
        System.out.println("If you are going to spend $" + tripCalculations.getMoney()
                + " USD that means per day you can spend up to $" + usdPerDay + " USD");
        System.out.println("Your total budget in " + tripCalculations.getForeignCurrency() + " is "
                + tripCalculations.calculateForeignCurrency() + " " + tripCalculations.getForeignCurrency()
                + ", which per day is " + foreignCurrencyPerDay
                + " " + tripCalculations.getForeignCurrency());
    }

    public void getTimeInformation() {
        System.out.print("What is the time difference, in hours, between your home and destination? ");
        int timeDifference = scanner.nextInt();
        int time = tripCalculations.calculateTimeDifference(timeDifference);
        System.out.println("That means that when it is midnight at home it will be " + (time) + ":00 "
                + " in your travel destination and when it is noon at home it will be " + ((12 + time) % 24) + ":00");
    }

    public void getAreaInformation() {
        System.out.print("What is the square area of your destination country in km2? ");
        int kilometres = scanner.nextInt();
        String miles = String.format("%.2f", tripCalculations.calculateKilometresToMiles(kilometres));
        System.out.println("In miles2 that is " + miles);
    }

    public void printDistanceBetweenLocations() {
        tripCalculations = new TripCalculations();
        System.out.println("What is the latitude and longitude of your home location? ");
        double homeLat = scanner.nextDouble();
        double homeLong = scanner.nextDouble();

        System.out.println("What is the latitude and longitude of your destination? ");
        double destLat = scanner.nextDouble();
        double destLong = scanner.nextDouble();

        String calculatedDistance = String.format("%.2f",
                tripCalculations.calculateDistanceBetweenLocations(homeLat, homeLong, destLat, destLong) / 1000);
        System.out.println("The distance between your home and your destination is " + calculatedDistance + " km");
    }
}
