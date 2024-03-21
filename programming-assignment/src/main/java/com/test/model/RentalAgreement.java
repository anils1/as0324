package com.test.model;

import com.test.enums.ToolType;
import com.test.utility.MyUtility;

import java.time.LocalDate;

public class RentalAgreement {
    private String toolCode;
    private ToolType toolType;
    private String brand;
    private int rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private double dailyRentalCharge;
    private int chargeDays;
    private double preDiscountCharge;
    private double discountPercent;
    private double discountAmount;
    private double finalCharge;

    public RentalAgreement(String toolCode, int rentalDays, double discountPercent, LocalDate checkoutDate) {
        this.toolCode = toolCode;
        this.toolType = ToolType.valueOf(toolCode.toUpperCase());
        this.brand = MyUtility.getBrandByToolCode(toolCode);
        this.rentalDays = rentalDays;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
        this.dueDate = checkoutDate.plusDays(rentalDays);
        this.dailyRentalCharge = toolType.getDailyCharge();
        this.chargeDays = calculateChargeDays();
        this.preDiscountCharge = calculatePreDiscountCharge();
        this.discountAmount = calculateDiscountAmount();
        this.finalCharge = calculateFinalCharge();
    }

    /**
     * Calculates the number of charge days between the checkout date and the due date,
     * excluding holidays based on the tool type's charging policy.
     *
     * @return The number of charge days.
     */
    private int calculateChargeDays() {
        int chargeDays = 0;
        // Start from the day after the checkout date
        LocalDate currentDate = checkoutDate.plusDays(1);
        // Loop through each day until the current date is after the due date
        while (!currentDate.isAfter(dueDate)) {
            // Check if the current date is not a holiday and if the tool type allows charging on that day
            if (!MyUtility.isHoliday(currentDate) &&
                    (toolType.isChargeOnWeekdays() || toolType.isChargeOnWeekends() || toolType.isChargeOnHolidays())) {
                chargeDays++;
            }
            // Move to the next day
            currentDate = currentDate.plusDays(1);
        }
        return chargeDays;
    }

    /**
     * Calculates the pre-discount charge amount based on the number of charge days,
     * the daily rental charge, and rounds the result to two decimal places.
     *
     * @return The pre-discount charge amount.
     */
    private double calculatePreDiscountCharge() {
        return Math.round(chargeDays * dailyRentalCharge * 100.0) / 100.0;
    }

    /**
     * Calculates the discount amount based on the pre-discount charge and the discount percent,
     * and rounds the result to two decimal places.
     *
     * @return The discount amount.
     */
    private double calculateDiscountAmount() {
        return Math.round(preDiscountCharge * discountPercent / 100.0 * 100.0) / 100.0;
    }

    /**
     * Calculates the final charge amount by subtracting the discount amount from the pre-discount charge,
     * and rounds the result to two decimal places.
     *
     * @return The final charge amount.
     */
    private double calculateFinalCharge() {
        return Math.round((preDiscountCharge - discountAmount) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("Tool code: %s\nTool type: %s\nFinal charge: $%.2f", toolCode, toolType.getType(), finalCharge);
    }
}
