package com.heatlee.webTickets.model;

import com.heatlee.webTickets.exception.NullStringDataException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Validator {
    private static final String[] RATINGS = {"G", "PG", "PG-13", "R", "NC-17", "NR", "U"};
    private static boolean ratingsContains(String rating) {
        boolean flag = false;
        for (String e : RATINGS) {
            if (rating.equals(e)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    private static void checkNull(String data) {
        if (data == null) {
            throw new NullStringDataException();
        }
    }
    private static boolean isDoubleValue(String data) {
        checkNull(data);
        return data.matches("-?\\d+\\.\\d+");
    }

    public static boolean isValidName(String name) {
        checkNull(name);
        return name.length() >= 1 && name.length() <= 30;
    }

    public static boolean isValidRating(String data) {
        checkNull(data);
        return ratingsContains(data);
    }

    public static boolean isValidDateFormat(String data) {
        checkNull(data);
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        return data.matches("^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))" +
                "|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$") && data.compareTo("0000-00-00") > 0;
    }

    public static boolean isValidTimeFormat(String data) {
        checkNull(data);
        return data.matches("^(20|21|22|23|[01]\\d|\\d)((:[0-5]\\d){1,2})$");
    }

    public static boolean isValidGenre(String data) {
        checkNull(data);
        return data.length() >= 1 && data.length() <= 30 && data.matches("^[a-zA-Z]+$");
    }

    public static boolean isValidDuration(String data) {
        checkNull(data);
        boolean flag = false;
        if (isDoubleValue(data)) {
            double number = Double.parseDouble(data);
            if (number >= 0.1 && number <= 12) {
                flag = true;
            }
        }
        return flag;
    }
}
