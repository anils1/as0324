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

    private int calculateChargeDays() {
        int chargeDays = 0;
        LocalDate currentDate = checkoutDate.plusDays(1);
        while (!currentDate.isAfter(dueDate)) {
            if (!MyUtility.isHoliday(currentDate) &&
                    (toolType.isChargeOnWeekdays() || toolType.isChargeOnWeekends() || toolType.isChargeOnHolidays())) {
                chargeDays++;
            }
            currentDate = currentDate.plusDays(1);
        }
        return chargeDays;
    }

    private double calculatePreDiscountCharge() {
        return Math.round(chargeDays * dailyRentalCharge * 100.0) / 100.0;
    }

    private double calculateDiscountAmount() {
        return Math.round(preDiscountCharge * discountPercent / 100.0 * 100.0) / 100.0;
    }

    private double calculateFinalCharge() {
        return Math.round((preDiscountCharge - discountAmount) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("Tool code: %s\nTool type: %s\nFinal charge: $%.2f", toolCode, toolType.getType(), finalCharge);
    }
}
