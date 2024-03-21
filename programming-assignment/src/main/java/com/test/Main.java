package com.test;

import com.test.model.RentalAgreement;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate checkoutDate = LocalDate.of(2020, 7, 2); // July 12, 2023
        int rentalDays = 3;
        double discountPercent = 10;

        // Creating a rental agreement for a ladder
        RentalAgreement ladderAgreement = new RentalAgreement("LADW", rentalDays, discountPercent, checkoutDate);
        System.out.println(ladderAgreement.toString());
        System.out.println();
        System.out.println("============================================");


        // Creating a rental agreement for a chainsaw
        RentalAgreement chainsawAgreement = new RentalAgreement("CHNS", rentalDays, discountPercent, checkoutDate);
        System.out.println(chainsawAgreement.toString());

        System.out.println();
        System.out.println("============================================");

        // Creating a rental agreement for a jackhammer
        RentalAgreement jackhammerAgreement = new RentalAgreement("JAKD", rentalDays, discountPercent, checkoutDate);
        System.out.println(jackhammerAgreement.toString());
        System.out.println();
        System.out.println("============================================");

        // Creating a rental agreement for a Ridgid jackhammer
        RentalAgreement ridgidAgreement = new RentalAgreement("JAKR", rentalDays, discountPercent, checkoutDate);
        System.out.println(ridgidAgreement.toString());
    }
}
