package com.heatlee.webTickets.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ValidateNameTest {

    private String name;

    public ValidateNameTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"a"}, {"aa"}, {"aaa"}, {"aaaa"}, {"aaaaa"},
                {"aaaaaa"}, {"aaaaaaa"}, {"aaaaaaaa"}, {"aaaaaaaaa"}, {"aaaaaaaaaa"}, {"aaaaaaaaaaaaaaaaaaaa"},
                {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"}};
        return Arrays.asList(data);
    }

    @Test
    public void isValidNameTestValidNameExpectTrue() {
        boolean actual = Validator.isValidName(name);
        Assert.assertTrue(actual);
    }

}
