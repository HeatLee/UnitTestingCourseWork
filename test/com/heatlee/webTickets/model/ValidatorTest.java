package com.heatlee.webTickets.model;

import com.heatlee.webTickets.exception.NullStringDataException;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    @Test
    public void isValidRatingCheckValidRatingThenReturnTrue() {
        boolean actual = Validator.isValidRating("G");
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidRatingCheckInvalidRatingThenReturnFalse() {
        boolean actual = Validator.isValidRating("some");
        Assert.assertFalse(actual);
    }

    @Test(expected = NullStringDataException.class)
    public void isValidRatingCheckNullThenThrowException() {
        Validator.isValidRating(null);
    }

    @Test(expected = NullStringDataException.class)
    public void isValidDurationTestNullExpectExceptionThrowing() {
        Validator.isValidDuration(null);
    }

    @Test
    public void isValidDurationTestValidDurationExpectTrue() {
        boolean actual = Validator.isValidDuration("1.5");
        Assert.assertTrue(actual);
    }


    @Test
    public void isValidDurationTestInvalidDurationExpectFalse() {
        boolean actual = Validator.isValidDuration("14.0");
        Assert.assertFalse(actual);
    }

    @Test(expected = NullStringDataException.class)
    public void isValidDateFormatCheckNullThenThrowException() {
        Validator.isValidDateFormat(null);
    }

    @Test
    public void isValidDateFormatCheckValidDateThenReturnTrue() {
        boolean actual = Validator.isValidDateFormat("2000-03-12");
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidDateFormatCheckInvalidDateThenReturnFalse() {
        boolean actual = Validator.isValidDateFormat("0000-00-0-1");
        Assert.assertFalse(actual);
    }

    @Test(expected = NullStringDataException.class)
    public void isValidTimeFormatCheckNullThenThrowException() {
        Validator.isValidTimeFormat(null);
    }

    @Test
    public void isValidTimeFormatCheckValidTimeFormatThenReturnTrue() {
        boolean actual = Validator.isValidTimeFormat("13:28");
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidTimeFormatCheckInvalidTimeFormatThenReturnFalse() {
        boolean actual = Validator.isValidTimeFormat("24:01");
        Assert.assertFalse(actual);
    }

    @Test(expected = NullStringDataException.class)
    public void isValidGenreTestNullExpectExceptionThrowing() {
        Validator.isValidGenre(null);
    }

    @Test
    public void isValidGenreTestInvalidGenreExpectFalse() {
        boolean actual = Validator.isValidGenre("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Assert.assertFalse(actual);
    }

    @Test(expected = NullStringDataException.class)
    public void isValidNameTestNullExpectExceptionThrowing() {
        Validator.isValidName(null);
    }

    @Test
    public void isValidNameTestInvalidNameExpectFalse() {
        boolean actual = Validator.isValidName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Assert.assertFalse(actual);
    }
}
