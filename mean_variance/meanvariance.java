import java.util.Scanner;

public class meanvariance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMarks = getNumberOfMarks(scanner);
        double[] marks = getMarks(scanner, numberOfMarks);

        double mean = calculateMean(marks);
        double variance = calculateVariance(marks, mean);

        System.out.println("Mean of marks: " + mean);
        System.out.println("Variance of marks: " + variance);
    }

    // Method to get valid number of marks
    public static int getNumberOfMarks(Scanner scanner) {
        int number;
        System.out.print("Enter the number of marks: ");
        number = scanner.nextInt();

        while (number <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
            System.out.print("Enter the number of marks: ");
            number = scanner.nextInt();
        }

        return number;
    }

    // Method to get valid marks using an array
    public static double[] getMarks(Scanner scanner, int count) {
        double[] marks = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter mark " + (i + 1) + ": ");
            double mark = scanner.nextDouble();

            while (mark < 0 || mark > 30) {
                System.out.println("Invalid input. Mark must be between 0 and 30.");
                System.out.print("Enter mark " + (i + 1) + " again: ");
                mark = scanner.nextDouble();
            }

            marks[i] = mark;
        }

        return marks;
    }

    // Method to calculate mean
    public static double calculateMean(double[] marks) {
        double sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return sum / marks.length;
    }

    // Method to calculate population variance 
    public static double calculateVariance(double[] marks, double mean) {
        double sumSquaredDiff = 0;
        for (int i = 0; i < marks.length; i++) {
            double diff = marks[i] - mean;
            sumSquaredDiff += diff * diff;
        }
        return sumSquaredDiff / marks.length;
    }
}
