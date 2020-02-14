package com.heatlee.webTickets.model.entity;

import com.heatlee.webTickets.exception.NullStringDataException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicketTest {
    private Ticket ticket;

    @Before
    public void setUp() {
        ticket = new Ticket("name", "Drama", "R", 2.5, "21:00", "2020-01-10");
    }

    @Test
    public void setGenreTestInvalidGenreExpectFalse() {
        Assert.assertFalse(ticket.setGenre("3sdfgh4rhwh5hw5wh5h4"));
    }

    @Test
    public void setGenreTestValidGenreExpectTrue() {
        Assert.assertTrue(ticket.setGenre("Thriller"));
    }

    @Test(expected = NullStringDataException.class)
    public void setGenreTestNullExpectExceptionThrowing() {
        ticket.setGenre(null);
    }

    @Test
    public void setRatingTestInvalidRatingExpectFalse() {
        Assert.assertFalse(ticket.setRating("for old mans"));
    }

    @Test
    public void setRatingTestValidRatingExpectTrue() {
        Assert.assertTrue(ticket.setRating("U"));
    }

    @Test(expected = NullStringDataException.class)
    public void setRatingTestNullExpectExceptionThrowing() {
        ticket.setRating(null);
    }

    @Test
    public void setDurationTestInvalidDurationExpectFalse() {
        Assert.assertFalse(ticket.setDuration("a few hours"));
    }

    @Test
    public void setDurationTestValidDurationExpectTrue() {
        Assert.assertTrue(ticket.setDuration("3.0"));
    }

    @Test(expected = NullStringDataException.class)
    public void setDurationTestNullExpectExceptionThrowing() {
        ticket.setDuration(null);
    }

    @Test
    public void setBeginsAtTestInvalidTimeExpectFalse() {
        Assert.assertFalse(ticket.setBeginsAt("night"));
    }

    @Test
    public void setBeginsAtTestValidTimeExpectTrue() {
        Assert.assertTrue(ticket.setBeginsAt("23:00"));
    }

    @Test(expected = NullStringDataException.class)
    public void setBeginsAtTestNullExpectExceptionThrowing() {
        ticket.setBeginsAt(null);
    }

    @Test
    public void setDateTestInvalidDateExpectFalse() {
        Assert.assertFalse(ticket.setDate("next week"));
    }

    @Test
    public void setDateValidDateExpectTrue() {
        Assert.assertTrue(ticket.setDate("2020-12-17"));
    }

    @Test(expected = NullStringDataException.class)
    public void setDateTestNullExpectExceptionThrowing() {
        ticket.setDate(null);
    }

}
