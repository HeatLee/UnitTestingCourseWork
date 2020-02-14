package com.heatlee.webTickets.model.entity;

import com.heatlee.webTickets.exception.NullStringDataException;
import com.heatlee.webTickets.model.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
    private static final String DEFAULT_STR_VALUE = "NONE";
    private static final double DEFAULT_DOUBLE_VALUE = 0.0;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private String genre;
    private String rating;
    private double duration;
    private String beginsAt;
    private String date;

    public Ticket(String name, String genre, String rating, double duration, String beginsAt, String date) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
        this.beginsAt = beginsAt;
        this.date = date;
    }

    public Ticket(String name) {
        this.name = name;
        genre = DEFAULT_STR_VALUE;
        rating = DEFAULT_STR_VALUE;
        duration = DEFAULT_DOUBLE_VALUE;
        beginsAt = DEFAULT_STR_VALUE;
        date = DEFAULT_STR_VALUE;
    }

    public Ticket() {
    }

    public String getGenre() {
        return genre;
    }
    
    public boolean setGenre(String genre) {
        try {
            if (Validator.isValidGenre(genre)) {
                this.genre = genre;
                return true;
            } else {
                return false;
            }
        } catch (NullStringDataException e) {
            throw new NullStringDataException();
        }

    }

    public String getRating() {
        return rating;
    }

    public boolean setRating(String rating) {
        try {
            if (Validator.isValidRating(rating)) {
                this.rating = rating;
                return true;
            } else {
                return false;
            }
        } catch (NullStringDataException e) {
            throw new NullStringDataException();
        }

    }

    public String getDuration() {
        return duration+"";
    }

    public boolean setDuration(String duration) {
        try {
            if (Validator.isValidDuration(duration)) {
                this.duration = Double.parseDouble(duration);
                return true;
            } else {
                return false;
            }
        } catch (NullStringDataException e) {
            throw new NullStringDataException();
        }

    }

    public String getBeginsAt() {
        return beginsAt;
    }

    public boolean setBeginsAt(String beginsAt) {
        try {
            if (Validator.isValidTimeFormat(beginsAt)) {
                this.beginsAt = beginsAt;
                return true;
            } else {
                return false;
            }
        } catch (NullStringDataException e) {
            throw new NullStringDataException();
        }

    }

    public String getDate() {
        return date;
    }

    public boolean setDate(String date) {
        try {
            if (Validator.isValidDateFormat(date)) {
                this.date = date;
                return true;
            } else {
                return false;
            }
        } catch (NullStringDataException e) {
            throw new NullStringDataException();
        }
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        try {
            if (Validator.isValidName(name)) {
                this.name = name;
                return true;
            } else {
                return false;
            }
        } catch (NullStringDataException e) {
            throw new NullStringDataException();
        }

    }
}
