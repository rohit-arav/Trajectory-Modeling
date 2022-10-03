import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Find ideal angle and speed to hit the given distance in a cannon
 *
 * @author Rohit Aravandy
 * @version 20221002
 **/
public class TrajectoryModelingLab {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // prompt user for distance
        System.out.print("Enter a distance to target: ");
        double d = input.nextDouble();

        // set variable for gravity constant
        double g = 9.8;

        // set number to calibrate the smallest difference in the nested for loop
        double smallest = 100;

        // create variables for outputs at the end
        double smallAng = 0;
        double smallV = 0;
        double distanceTravelled = 0;

        // create for loop that goes through angles by 5s
        for (double angle = 25.0; angle <= 85; angle += 5) {
            double difference = 0.0;
            //create for loop that goes through speeds by 1
            for (double v = 1; v <= 30; v++) {
                //calculate the distance using the numbers in the for loop
                double angRad = (Math.toRadians(angle));
                double cosRad = (Math.toRadians(angle));
                double sinAng = sin(angRad);
                double cosAng = cos(cosRad);
                double tD = ((2 * v * sinAng) / g);
                double distance = v * tD * cosAng;
                difference = abs(distance - d);
                // find the smallest difference in the loops
                if (difference < smallest) {
                    smallest = difference;
                    smallAng = angle;
                    smallV = v;
                    distanceTravelled = distance;

                }
            }
        }
        // print outputs using printf
        System.out.printf("Best angle: %.2f degrees\n", smallAng);
        System.out.printf("Best speed: %.2f m/s\n", smallV);
        System.out.printf("Distance travelled: %.2f meters\n", distanceTravelled);
        System.out.printf("Missed the target center by: %.2f meters\n", smallest);
    }
}



