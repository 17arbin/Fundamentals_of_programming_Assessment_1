import java.util.Scanner;
import java.util.InputMismatchException;

public class meanvariance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfMarks = readPositiveInt(sc, "Enter the number of marks: ");
        double[] marks = getMarks(sc, numberOfMarks);

        double mean = calculateMean(marks);
        double variance = calculateVariance(marks, mean);

        System.out.println("Mean of marks: " + mean);
        System.out.println("Variance of marks: " + variance);
    }

    // This method asks user to enter a positive number and keeps asking until user enters valid input
    public static int readPositiveInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = sc.nextInt();
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next();
            }
        }
    }

        // This method reads all marks from user and stores them in an array
    public static double[] getMarks(Scanner sc, int numberOfMarks) {
        double[] marks = new double[numberOfMarks];

        for (int i = 0; i < numberOfMarks; i++) {
            marks[i] = readIntInRange(sc, "Enter mark #" + (i + 1) + ": ", 0, 30);
        }

        return marks;
    }
    
        // This method asks user to enter a mark between min and max and checks if valid
    public static double readIntInRange(Scanner sc, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            try {
                double value = sc.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Invalid input. Mark must be between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next();
            }
        }
    }

    // Method to calculate mean
    public static double calculateMean(double[] marks) {
        double sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return sum / marks.length;
    }

    // Method to calculate variance 
    public static double calculateVariance(double[] marks, double mean) {
        double sumSquaredDiff = 0;
        for (int i = 0; i < marks.length; i++) {
            double diff = marks[i] - mean;
            sumSquaredDiff += diff * diff;
        }
        return sumSquaredDiff / marks.length;
    }
}
