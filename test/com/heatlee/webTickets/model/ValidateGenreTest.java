package com.heatlee.webTickets.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ValidateGenreTest {

    private String genre;

    public ValidateGenreTest(String genre) {
        this.genre = genre;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"a"}, {"aa"}, {"aaa"}, {"aaaa"}, {"aaaaa"},
                {"aaaaaa"}, {"aaaaaaa"}, {"aaaaaaaa"}, {"aaaaaaaaa"}, {"aaaaaaaaaa"}, {"aaaaaaaaaaaaaaaaaaaa"},
                {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"}};
        return Arrays.asList(data);
    }

    @Test
    public void isValidGenreTestValidGenreExpectTrue() {
        boolean actual = Validator.isValidGenre(genre);
        Assert.assertTrue(actual);
    }
}
