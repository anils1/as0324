package com.test.utility;

import java.time.LocalDate;

public class MyUtility {
    /**
     * Checks if the given date is a holiday.
     *
     * @param date The date to check.
     * @return true if the date is Independence Day or Labor Day, false otherwise.
     */
    public static boolean isHoliday(LocalDate date) {
        // Define the dates for Independence Day and Labor Day for the year 2023 as an example
        LocalDate independenceDay = LocalDate.of(2023, 7, 4);
        LocalDate laborDay = LocalDate.of(2023, 9, 4);

        // Check if the given date matches either Independence Day or Labor Day
        if (date.equals(independenceDay) || date.equals(laborDay)) {
            return true;
        }
        // If the date does not match any holiday, return false
        return false;
    }

    /**
     * Retrieves the brand name associated with a given tool code.
     *
     * @param toolCode The tool code to look up.
     * @return The brand name associated with the tool code.
     * @throws IllegalArgumentException if the tool code is not recognized.
     */
    public static String getBrandByToolCode(String toolCode) {
        // Use a switch statement to match the tool code to its corresponding brand
        switch (toolCode) {
            case "CHNS":
                return "Stihl";
            case "LADW":
                return "Werner";
            case "JAKD":
                return "DeWalt";
            case "JAKR":
                return "Ridgid";
            // If the tool code does not match any known codes, throw an exception
            default:
                throw new IllegalArgumentException("Invalid tool code: " + toolCode);
        }
    }

}
