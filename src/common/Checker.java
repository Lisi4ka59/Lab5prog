package common;

import models.Climate;

import java.util.Date;
import java.util.Scanner;
import static org.apache.commons.lang.StringUtils.isNumeric;
import static org.apache.commons.lang.StringUtils.trim;

public class Checker {
    public static int inputInteger(String prompt) {
        Scanner scanner = new Scanner(System.in);
        boolean hasInt;
        int value = 0;
        String message = "The entered value is not integer, enter correct value\nRepeat input: ";
        do {
            System.out.print(prompt);
            hasInt = scanner.hasNextInt();
            if (!hasInt) {
                System.out.println(message);
                scanner.nextLine();
            } else {
                try {
                    value = Integer.parseInt(scanner.nextLine());
                } catch (IllegalArgumentException e) {
                    hasInt = false;
                    System.out.println(message);
                }
            }
        } while (!hasInt);
        return value;
    }
    public static long inputLong(String prompt) {
        Scanner scanner = new Scanner(System.in);
        boolean hasLong;
        long value = 0;
        String message = "The entered value is not long, enter correct value\nRepeat input: ";
        do {
            System.out.print(prompt);
            hasLong = scanner.hasNextLong();
            if (!hasLong) {
                System.out.println(message);
                scanner.nextLine();
            } else {
                try {
                    value = Long.parseLong(scanner.nextLine());
                } catch (IllegalArgumentException e) {
                    hasLong = false;
                    System.out.println(message);
                }
            }
        } while (!hasLong);
        return value;
    }
    public static float inputFloat(String prompt) {
        Scanner scanner = new Scanner(System.in);
        boolean hasFloat;
        float value = 0;
        String message = "The entered value is not float, enter correct value\nRepeat input: ";
        do {
            System.out.print(prompt);
            hasFloat = scanner.hasNextFloat();
            if (!hasFloat) {
                System.out.println(message);
                scanner.nextLine();
            } else {
                try {
                    value = Float.parseFloat(scanner.nextLine());
                } catch (IllegalArgumentException e) {
                    hasFloat = false;
                    System.out.println(message);
                }
            }
        } while (!hasFloat);
        return value;
    }
    public static double inputDouble(String prompt) {
        Scanner scanner = new Scanner(System.in);
        boolean hasDouble;
        double value = 0;
        String message = "The entered value is not double, enter correct value\nRepeat input: ";
        do {
            System.out.print(prompt);
            hasDouble = scanner.hasNextFloat();
            if (!hasDouble) {
                System.out.println(message);
                scanner.nextLine();
            } else {
                try {
                    value = Double.parseDouble(scanner.nextLine());
                } catch (IllegalArgumentException e) {
                    hasDouble = false;
                    System.out.println(message);
                }
            }
        } while (!hasDouble);
        return value;
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
        Boolean right;
        String string;
        do {
            string = scanner.nextLine();
            string = trim(string);
            right = !string.isEmpty();
            if (!right) {
                System.out.println(message);
                }
        } while (!right);
        return string;
    }

}
