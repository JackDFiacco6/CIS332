// The user needs to tell their choice of movie(String), their name(String), age (int), and money(double).

// Data that needs to be stored consists of the movie title(String), rating(String), and money(double).

// Calculations that need to be made are making change(makeChange) and a branch for age(amIOldEnough).

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class MoviePay {
    public static void main(String[] args) {
        //Variables should be at the top
        // These are parallel arrays
        String[] titles = {"Avatar: The Way of Water", "M3GAN", "Puss and Boots: The Last Wish"};
        String[] ratings = {"PG-13", "R", "PG"};

        // Red words are built into Java
        double[] movieCost = {22.50, 13.00, 8.00};

        System.out.println("Welcome to MoviePay");
        System.out.println("Here are your options today");
        for (int i = 0; i < titles.length; i++) {
            //1. Avatar

            // "an increment that adds 1 to the numbered list
            System.out.println((i + 1) + ". " + titles[i]);
        }

        System.out.println("Please provide your name and age in the system");

        Scanner userInput = new Scanner(System.in);

        // Saves words in the terminal
        String userName = userInput.nextLine();

        int userAge = userInput.nextInt();

        // Allows input for name and age
        System.out.println("Name:" + userName + ", Age: " + userAge);

        //User movie choice
        System.out.println("Please Choose a Movie to Watch Today: (Input a number)");

        int userMovieChoice = userInput.nextInt();

        boolean oldEnough = determineAgeBoolean(userAge, ratings[userMovieChoice - 1]); //Calculates if old enough

        //pay for the movie IF old enough
        if (oldEnough) {
            System.out.println("You are old enough to see this film.");
            System.out.println("This movie costs " + movieCost[userMovieChoice - 1]);
            System.out.println("How much are you paying with?");
            float userPayment = userInput.nextFloat();
            double change = (float) userPayment - movieCost[userMovieChoice - 1]; //Create another function?
            System.out.println(change); //Finish up making changes look neat

        } else {
            System.out.println("You are NOT old enough to see this movie");
            System.out.println("Have a nice day");
        }

    }

    static boolean determineAgeBoolean(int age, String rating) {
        if (age >= 17) {
            return true;
        } else if (age >= 13) {
            //Look at movie rating, if R return false, else return true
            //2
            if (rating.equals("R")) {
                return true;
            } else {
                return false;
            }
        } else {
            //Everyone under 13
            if (rating.equals("R") || rating.equals("PG-13")) {
                return false;
            } else {
                return true;
            }
        }
    }

}