import java.util.Scanner;
import java.util.Random;
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;
        int totalScore = 0;
        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int maxAttempts = 5;
            int attempts = 0;
            boolean isGuessed = false;
            System.out.printf("\nI have chosen a number between %d and %d. You have %d attempts to guess it!\n", lowerBound, upperBound, maxAttempts);
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess == randomNumber) {
                    System.out.printf("Congratulations! You guessed the number %d in %d attempts!\n", randomNumber, attempts);
                    totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    isGuessed = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!isGuessed) {
                System.out.printf("You've used all %d attempts. The correct number was %d.\n", maxAttempts, randomNumber);
            }
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        System.out.printf("\nGame over! Your total score is %d. Thanks for playing!\n", totalScore);
        scanner.close();
    }
}
