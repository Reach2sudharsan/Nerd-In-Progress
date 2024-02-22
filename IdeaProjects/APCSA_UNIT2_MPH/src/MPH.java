/*
The program below calculates and prints the rate of change(miles per hour) with the double inputs
for the distance, the hours, and the minutes.
 */
import java.util.Scanner;
import java.lang.Math;

public class MPH {
    public static void main(String[] args) {

        MPHCalculator run = new MPHCalculator();
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the distance(miles): ");
        double distance = obj.nextDouble();

        System.out.println("Enter the hours: ");
        double hours = obj.nextDouble();


        System.out.println("Enter the minutes: ");
        double minutes = obj.nextDouble();
        run.calculateMPH(distance, hours, minutes);

    }


}
class MPHCalculator {
    public void calculateMPH(double distance, double hours, double minutes) {
        double onlyHours = minutes / 60.0;
        double totalHours = hours + onlyHours;
        double mph = distance / totalHours;
        System.out.println("Speed(mph): " + String.format("%.02g%n", mph));
    }


}


