package com.test;

import com.test.model.RentalAgreement;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


class RentalAgreementTest {
    @Test
    void testRentalAgreement() {
        RentalAgreement agreement = new RentalAgreement("LADW", 7, 20, LocalDate.of(2023, 7, 12));
        assertEquals("Tool code: LADW\nTool type: Ladder\nFinal charge: $9.99", agreement.toString());
    }
}
