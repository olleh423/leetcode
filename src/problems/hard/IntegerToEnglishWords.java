package problems.hard;

import java.util.*;

/*
 * Author : Vijay Sharma 23-01-2021
 */
public class IntegerToEnglishWords {

    public static void main(String[] args) {

        IntegerToEnglishWords obj = new IntegerToEnglishWords();

        int num = 1563254;
        System.out.println(obj.numberToWords(num));
    }

    public String numberToWords(int num) {

        if(num == 0)
            return "Zero";

        StringBuilder result = new StringBuilder();

        int threeDigit = num % 1000;
        if(threeDigit > 0) {
            result.insert(0, convertThreeDigitsToString(threeDigit).trim() + " ");
        }

        num /= 1000;
        if(num <= 0)
            return result.toString().trim();

        threeDigit = num % 1000;
        if(threeDigit > 0) {
            result.insert(0, convertThreeDigitsToString(threeDigit).trim() + " Thousand ");
        }

        num /= 1000;
        if(num <= 0)
            return result.toString().trim();

        threeDigit = num % 1000;
        if(threeDigit > 0) {
            result.insert(0, convertThreeDigitsToString(threeDigit).trim() + " Million ");
        }

        num /= 1000;
        if(num <= 0)
            return result.toString().trim();

        threeDigit = num % 1000;
        if(threeDigit > 0) {
            result.insert(0, convertThreeDigitsToString(threeDigit).trim() + " Billion ");
        }

        return result.toString().trim();
    }

    private String convertThreeDigitsToString(int number) {

        int lastTwoDigits = number % 100;
        StringBuilder result = new StringBuilder(convertTwoDigitsToString(lastTwoDigits));
        int firstDigit = number / 100;
        if(firstDigit > 0) {
            result.insert(0, getString(firstDigit, false) + " Hundred ");
        }
        return result.toString();
    }

    private String convertTwoDigitsToString(int number) {

        StringBuilder result = new StringBuilder();

        if(number == 0)
            return result.toString();

        if(number % 10 == 0) {
            return getString(number / 10, true);
        }
        if(number < 20) {
            return getString(number, false);
        }

        result.append(getString(number / 10, true));
        result.append(" ");
        result.append(getString(number % 10, false));

        return result.toString();
    }

    private String getString(int number, boolean tens) {

        switch(number) {
            case 1 : {
                return tens ? "Ten" : "One";
            }
            case 2 : {
                return tens ? "Twenty" : "Two";
            }
            case 3 : {
                return tens ? "Thirty" : "Three";
            }
            case 4 : {
                return tens ? "Forty" : "Four";
            }
            case 5 : {
                return tens ? "Fifty" : "Five";
            }
            case 6 : {
                return tens ? "Sixty" : "Six";
            }
            case 7 : {
                return tens ? "Seventy" : "Seven";
            }
            case 8 : {
                return tens ? "Eighty" : "Eight";
            }
            case 9 : {
                return tens ? "Ninety" : "Nine";
            }
            case 10 : {
                return "Ten";
            }
            case 11 : {
                return "Eleven";
            }
            case 12 : {
                return "Twelve";
            }
            case 13 : {
                return "Thirteen";
            }
            case 14 : {
                return "Fourteen";
            }
            case 15 : {
                return "Fifteen";
            }
            case 16 : {
                return "Sixteen";
            }
            case 17 : {
                return "Seventeen";
            }
            case 18 : {
                return "Eighteen";
            }
            case 19 : {
                return "Nineteen";
            }
        }
        return "";
    }
}
