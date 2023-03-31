/**
 *  PalindromeDetector.java
 *  This program takes input from the user and runs a recursive check to see whether or not the inputted value is a palindrome.
 *  COSC-2436.902
 *  @author Joshua Williams
 *  2/22/2023
 */

import java.util.Scanner;

public class PalindromeDetector {
    public static void main(String[] args) throws Exception
    {
        Scanner s = new Scanner(System.in);
        boolean keepRunning = true;
        do
        {
            String palTest;
            System.out.println("\nEnter a word to test whether or not it is a palindrome:");
            palTest = s.nextLine();
            if(isPalindrome(palTest))
            {
                System.out.println(palTest + " is a palindrome!\n");
            }
            else
            {
                System.out.println(palTest + " is not a palindrome.\n");
            }

            // user decides whether or not to keep running the program to input values
            boolean isValidInput = true;
            String decision;
            do
            {
                System.out.print("Continue? (Y/N): ");
                decision = s.nextLine();
                if(decision.equals("y") || decision.equals("Y"))
                {
                    isValidInput = true;
                    keepRunning = true;
                }
                else if(decision.equals("n") || decision.equals("N"))
                {
                    isValidInput = true;
                    keepRunning = false;
                    System.out.println("Goodbye!");
                }
                else
                {
                    isValidInput = false;
                    System.out.println("Invalid input. Please enter either \"Y\" or \"N\".");
                }
            } while(!isValidInput);
        } while(keepRunning);

    }

    /**
     * This method runs the recursive check to determine whether or not the value is a palindrome.
     * @param str the value to check for a palindrome
     * @return whether or not the value is a palindrome
     */
    public static boolean isPalindrome(String str)
    {
        str = str.toUpperCase();                        // make the word all upper case
        int strLen = str.length();

        // create a new string and remove all non-alphabetical characters
        String strTest = "";
        for(int i = 0; i < strLen; i++)
        {
            if((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122))
            {
                strTest += str.charAt(i);
            }
        }

        // if the value is 1 or less characters long, it is a palindrome
        int strTestLen = strTest.length();
        if(strTestLen == 1 || strTestLen == 0)
        {
            return true;
        }

        // if the first character matches the last character, remove them and test the updated value.
        if(strTest.charAt(0) == strTest.charAt(strTestLen - 1))
        {
            return isPalindrome(strTest.substring(1, (strTestLen - 1)));    // keep doing this until length equals either 1 or 0.
        }

        return false;
    }
}
