import java.util.InputMismatchException;
import java.util.Scanner;

public class highestlowest
{
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfMarks = readPositiveInt(sc, "Enter the number of marks: ");
        int[] marks = getMarks(sc, numberOfMarks);

        int highest = findHighest(marks);
        int lowest = findLowest(marks);

        System.out.println("Highest mark: " + highest);
        System.out.println("Lowest mark: " + lowest);

        sc.close();
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
    public static int[] getMarks(Scanner sc, int numberOfMarks) {
        int[] marks = new int[numberOfMarks];

        for (int i = 0; i < numberOfMarks; i++) {
            marks[i] = readIntInRange(sc, "Enter mark #" + (i + 1) + ": ", 0, 30);
        }

        return marks;
    }

    // This method asks user to enter a mark between min and max and checks if valid
    public static int readIntInRange(Scanner sc, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            try {
                int value = sc.nextInt();
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

    // This method finds the highest mark in the array
    public static int findHighest(int[] marks) {
        int highest = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }
        return highest;
    }

    // This method finds the lowest mark in the array
    public static int findLowest(int[] marks) {
        int lowest = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }
        return lowest;
    }
}