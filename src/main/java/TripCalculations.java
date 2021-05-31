public class TripCalculations implements TripCalculationsInterface {
    private int days;
    private double money;
    private double currency;
    private String foreignCurrency;
    private int minutes;
    private int hours;


    public TripCalculations(int days, double money, double currency, String conversion) {
        this.days = days;
        this.money = money;
        this.currency = currency;
        this.foreignCurrency = conversion;
    }

    public TripCalculations() {

    }

    public void travelTimeConversion() {
        hours = days * 24;
        minutes = hours * 60;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getDays() {
        return days;
    }

    public double moneySpendPerDay() {
        return money / days;
    }

    public double getMoney() {
        return money;
    }

    public double foreignCurrencyPerDay() {
        return calculateForeignCurrency() / days;
    }

    public double calculateForeignCurrency() {
        return money * currency;
    }

    public String getForeignCurrency() {
        return foreignCurrency;
    }

    public int calculateTimeDifference(int timeDifference) {
        return timeDifference % 24;
    }

    public double calculateKilometresToMiles(int kilometres) {
        return kilometres * 0.38610;
    }

    public double calculateDistanceBetweenLocations(double homeLat, double homeLong, double destLat, double destLong) {
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(destLat - homeLat);
        double lonDistance = Math.toRadians(destLong - homeLong);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(homeLat)) * Math.cos(Math.toRadians(destLat))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000;
        distance = Math.pow(distance, 2) + Math.pow(0.0, 2);
        return Math.sqrt(distance);
    }


}
