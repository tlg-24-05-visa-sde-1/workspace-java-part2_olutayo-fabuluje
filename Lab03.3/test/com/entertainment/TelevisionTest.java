package com.entertainment;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv;

    @Before
    public void setUp() {
        tv = new Television();
    }


    @Test
    public void changeChannel_shouldStoreValue_validInput_upperBound()
            throws InvalidChannelException {
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }


    @Test
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound()
            throws InvalidChannelException {
        try {
            tv.changeChannel(0);
            fail("Should have thrown InvalidChannelException");
        } catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
            throw e;
        }
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_upperBound()
            throws InvalidChannelException {
        tv.changeChannel(1000);
    }

    @Test
    public void changeChannel_shouldStoreValue_validInput_lowerBound()
            throws InvalidChannelException {
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }

/*
   // @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound()
            throws InvalidChannelException {
        tv.changeChannel(0);
    }
*/

    @Test
    public void setVolume_shouldStoreVolume_validInput_upperBound() {
        tv.setVolume(100);
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_upperBound() {
        tv.setVolume(101);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_lowerBound() {
        tv.setVolume(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldStoreValue_validInput_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());               // Should trigger exception
    }


    // compareTo tests
    Television tv2 = new Television();


    @Test
    public void compareTo_shouldReturnZero_whenSameBrand() {
        assertEquals(0, tv.compareTo(tv2));
        assertEquals(0, tv.compareTo(tv2));
    }

    @Test
    public void compareTo_shouldReturnNegativeNumber_when1stBrandLessThan2ndBrand() {
        tv.setBrand("A_lessThan");
        tv2.setBrand("B_greaterThan");
        assertTrue(tv.compareTo(tv2) < 0);
    }

    @Test
    public void compareTo_shouldReturnPositiveNumber_when1stBrandGreaterThan2ndBrand() {
        tv.setBrand("B_greaterThan");
        tv2.setBrand("A_lessThan");
        assertTrue(tv.compareTo(tv2) > 0);
    }

    // equals() tests


    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(tv, tv2);
    }
}