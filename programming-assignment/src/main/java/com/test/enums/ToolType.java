package com.test.enums;
public enum ToolType {
    LADW("Ladder", 1.99, true, true, false), // Corrected to include LADW
    CHNS("Chainsaw", 1.49, true, false, true),
    JAKD("Jackhammer", 2.99, true, false, false),
    JAKR("Ridgid", 0.0, false, false, false); // Assuming Ridgid is free of charge

    private final String type;
    private final double dailyCharge;
    private final boolean chargeOnWeekdays;
    private final boolean chargeOnWeekends;
    private final boolean chargeOnHolidays;

    ToolType(String type, double dailyCharge, boolean chargeOnWeekdays, boolean chargeOnWeekends, boolean chargeOnHolidays) {
        this.type = type;
        this.dailyCharge = dailyCharge;
        this.chargeOnWeekdays = chargeOnWeekdays;
        this.chargeOnWeekends = chargeOnWeekends;
        this.chargeOnHolidays = chargeOnHolidays;
    }

    public String getType() {
        return type;
    }

    public double getDailyCharge() {
        return dailyCharge;
    }

    public boolean isChargeOnWeekdays() {
        return chargeOnWeekdays;
    }

    public boolean isChargeOnWeekends() {
        return chargeOnWeekends;
    }

    public boolean isChargeOnHolidays() {
        return chargeOnHolidays;
    }
}
