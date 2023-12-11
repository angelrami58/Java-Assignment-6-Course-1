/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramirez_tipperapp.ramirez_highlow;

import java.util.Scanner;
/**
 * Angel Ramirez-Rivera IT DEV 110 Assignment 7
 * @author angelramirez-rivera
 */
public class Controller {
    View view = new View();
    Model model = new Model();
    Scanner scanner = new Scanner(System.in);
    
    public void runApp(){
        int maxNumber;
        int maxGuesses;
        int credits = 100;

        model.intro();
        view.directions();
            // Prompt the user to select a level
            System.out.println("Select a level:");
            System.out.println("1. Easy (1-10)");
            System.out.println("2. Medium (1-50)");
            System.out.println("3. Hard (1-100)");
            int level = scanner.nextInt();

            // Set the maximum number and number of guesses based on the selected level
            switch (level) {
                case 1:
                    maxNumber = 10;
                    maxGuesses = 100;
                    break;
                case 2:
                    maxNumber = 50;
                    maxGuesses = 100;
                    break;
                case 3:
                    maxNumber = 100;
                    maxGuesses = 100;
                    break;
                default:
                    System.out.println("Invalid level. Please select again.");
                    return;
            }

            // Prompt the user to wager game credits
            System.out.println("You have " + credits + " game credits. How many credits do you want to wager?");
            int wager = scanner.nextInt();

            // Validate the user's wager
            while (wager < 1 || wager > credits) {
                System.out.println("Invalid wager. Please wager between 1 and " + credits + " credits.");
                wager = scanner.nextInt();
            }
            // Generate a random number between 1 and the maximum number
            int randomNumber = (int) (Math.random() * maxNumber) + 1;

            // Prompt the user to guess the number
            System.out.println("Guess the number between 1 and " + maxNumber + ".");
            for (int i = 1; i <= maxGuesses; i++) {
                System.out.println("Guess #" + i + ":");
                int guess = scanner.nextInt();

                // Subtract the user's wager from their game credits for each guess
                credits -= wager;

                // Check if the guess is correct, too high, or too low
                if (guess == randomNumber) {
                    int winnings = wager;
                    credits += winnings;
                    System.out.println("Congratulations! You guessed the number in " + i + " guesses.");
                    System.out.println("You won! " + credits + "credits");
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Guess again.");
                    System.out.println("Please wager between 1 and " + credits + " credits.");
                    wager = scanner.nextInt();
                } else {
                    System.out.println("Too high. Guess again.");
                    System.out.println(" Please wager between 1 and " + credits + " credits.");
                    wager = scanner.nextInt();
                }
                // If the user has run out of game credits, break out of the loop
                if (credits < 1) {
                    System.out.println("You have run out of game credits.");
                    System.out.println("Invalid wager. Please wager between 1 and " + credits + " credits.");
                    break;
                }
            }
        }
           
    public boolean runAgain(){
        int selection;
        boolean runAgain;
        System.out.println("\n\n (1) to play the game again (2) to exit\n\n");
        selection = scanner.nextInt();        
        if(selection == 1){
            runAgain = true;
            runApp();
    } else { 
            runAgain = false;
        }return runAgain;
    }
}