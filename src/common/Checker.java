package common;

import models.Climate;

import java.util.Date;
import java.util.Scanner;
import static org.apache.commons.lang.StringUtils.isNumeric;
import static org.apache.commons.lang.StringUtils.trim;

public class Checker {
    public static int inputInteger(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String testString;
        int value;
        System.out.print(prompt);
        String message = "The entered value is not integer, enter correct value\nRepeat input: ";
        do {
            testString = scanner.nextLine();
            try {
                value = Integer.parseInt(testString);
                return value;
            } catch (IllegalArgumentException e) {
                System.out.print(message);
            }
        } while (true);
    }
    public static long inputLong(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String testString;
        long value;
        System.out.print(prompt);
        String message = "The entered value is not long, enter correct value\nRepeat input: ";
        do {
            testString = scanner.nextLine();
            try {
                value = Long.parseLong(testString);
                return value;
            } catch (IllegalArgumentException e) {
                System.out.print(message);
            }
        } while (true);
    }
    public static float inputFloat(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String testString;
        float value;
        System.out.print(prompt);
        String message = "The entered value is not float, enter correct value\nRepeat input: ";
        do {
            testString = scanner.nextLine();
            try {
                value = Float.parseFloat(testString);
                return value;
            } catch (IllegalArgumentException e) {
                System.out.print(message);
            }
        } while (true);
    }
    public static double inputDouble(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String testString;
        double value;
        System.out.print(prompt);
        String message = "The entered value is not double, enter correct value\nRepeat input: ";
        do {
            testString = scanner.nextLine();
            try {
                value = Double.parseDouble(testString);
                return value;
            } catch (IllegalArgumentException e) {
                System.out.print(message);
            }
        } while (true);
    }
    public static Date inputDate(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String message = "The entered value is not date, enter correct value\nRepeat input: ";
        String date;
        String dateTest;
        Date rightDate = null;
        System.out.print(prompt);
        Boolean right;
        do {
            date = scanner.nextLine();
            date = trim(date);
            dateTest = date.replace(".", "");
            right = isNumeric(dateTest);
            String[] dateArray = date.split("\\.");
            if (dateArray.length == 3 && right) {
                try {
                    int day = Integer.parseInt(dateArray[0]);
                    int month = Integer.parseInt(dateArray[1]);
                    int year = Integer.parseInt(dateArray[2]) - 1900;
                    rightDate = new Date(year, month, day);
                } catch (NumberFormatException e) {
                    System.out.println(message);
                    right = false;
                }
            } else {
                System.out.println(message);
            }
        } while (!right);
        return rightDate;
    }
    public static String inputStringNotNull(String prompt){
        Scanner scanner = new Scanner(System.in);
        String message = "The entered string is null, enter correct string\nRepeat input: ";
        String string;
        System.out.print(prompt);
        do {
            string = trim(scanner.nextLine());
            if (string.isEmpty()) {
                System.out.print(message);
                }
            else{
                return string;
            }
        } while (true);
    }
    public static int inputEnumNumber(String prompt, int maxValue, Boolean isNull){
        Scanner scanner = new Scanner(System.in);
        String testString;
        int value;
        System.out.print(prompt);
        String message = "The entered value is not correct, enter correct value\nRepeat input: ";
        do {
            testString = scanner.nextLine();
            if (testString == "" && isNull){
                return 0;
            }
            else {
                try {
                    value = Integer.parseInt(testString);
                } catch (IllegalArgumentException e) {
                    System.out.print(message);
                    continue;
                }
                if (1 > value || value > maxValue) {
                    System.out.print(message);
                }
                else{
                    return value;
                }
            }
        } while (true);
    }
}
