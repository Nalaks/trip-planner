public interface TripCalculationsInterface {
    void travelTimeConversion();

    int getDays();

    int getHours();

    int getMinutes();

    double moneySpendPerDay();

    double getMoney();

    double foreignCurrencyPerDay();

    double calculateForeignCurrency();

    String getForeignCurrency();

    int calculateTimeDifference(int timeDifference);

    double calculateKilometresToMiles(int kilometres);

    double calculateDistanceBetweenLocations(double homeLat, double homeLong, double destLat, double destLong);
}
