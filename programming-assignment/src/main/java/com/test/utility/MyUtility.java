package com.test.utility;

import java.time.LocalDate;

public class MyUtility {
    public static boolean isHoliday(LocalDate date) {
        LocalDate independenceDay = LocalDate.of(2023, 7, 4); // Example year
        LocalDate laborDay = LocalDate.of(2023, 9, 4); // Example year

        if (date.equals(independenceDay) || date.equals(laborDay)) {
            return true;
        }
        return false;
    }

    public static String getBrandByToolCode(String toolCode) {
        switch (toolCode) {
            case "CHNS":
                return "Stihl";
            case "LADW":
                return "Werner";
            case "JAKD":
                return "DeWalt";
            case "JAKR":
                return "Ridgid";
            default:
                throw new IllegalArgumentException("Invalid tool code: " + toolCode);
        }
    }
}
