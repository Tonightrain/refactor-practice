package com.twu.refactoring;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class DateParserTest {
    @Test
    public void shouldThrowExceptionIfYearStringCannotBeParsed() {
        assertThrows(IllegalArgumentException.class,()-> new DateParser("111").parse());
    }

    @Test
    public void shouldThrowExceptionIfYearIsNotInteger() {
        assertThrows(IllegalArgumentException.class,()-> new DateParser("abcd").parse());
    }

    @Test
    public void shouldThrowExceptionIfYearIsLessThan2000() {
        assertThrows(IllegalArgumentException.class,()-> new DateParser("1999").parse());
    }

    @Test
    public void shouldThrowExceptionIfMonthStringCannotBeParsed() {
        assertThrows(IllegalArgumentException.class,()-> new DateParser("2012-1").parse());
    }

    @Test
    public void shouldThrowExceptionIfMonthIsNotInteger() {
        assertThrows(IllegalArgumentException.class,()->new DateParser("2012-ab").parse());
    }

    @Test
    public void shouldThrowExceptionIfMonthIsMoreThan12() {
        assertThrows(IllegalArgumentException.class,()->new DateParser("2012-13").parse());
    }

    @Test
    public void shouldThrowExceptionIfDateStringCannotBeParsed() {
        assertThrows(IllegalArgumentException.class,()->new DateParser("2012-12-1").parse());
    }

    @Test
    public void shouldThrowExceptionIfDateIsNotInteger() {
        assertThrows(IllegalArgumentException.class,()->new DateParser("2012-12-ab").parse());
    }

    @Test
    public void shouldThrowExceptionIfDateIsMoreThan31() {
        assertThrows(IllegalArgumentException.class,()->new DateParser("2012-12-32").parse());
    }

    @Test
    public void shouldThrowExceptionIfHourStringCannotBeParsed() {
        assertThrows(IllegalArgumentException.class,()->new DateParser("2012-12-11T0").parse());
    }

    @Test
    public void shouldThrowExceptionIfHourIsNotInteger() {
        assertThrows(IllegalArgumentException.class,()->new DateParser("2012-12-30Tab").parse());
    }

    @Test
    public void shouldThrowExceptionIfHourIsMoreThan23() {
        assertThrows(IllegalArgumentException.class,()->new DateParser("2012-12-31T24").parse());
    }

    @Test
    public void shouldThrowExceptionIfMinuteStringCannotBeParsed() {
        assertThrows(IllegalArgumentException.class,()->new DateParser("2012-12-11T01:1").parse());
    }

    @Test
    public void shouldThrowExceptionIfMinuteIsNotInteger() {
        assertThrows(IllegalArgumentException.class,()->new DateParser("2012-12-30T01:ab").parse());
    }

    @Test
    public void shouldThrowExceptionIfMinuteIsMoreThan59() {
        assertThrows(IllegalArgumentException.class,()->new DateParser("2012-12-31T23:60").parse());
    }

    @Test
    public void shouldParseDateForValidInput() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(2012, Calendar.DECEMBER, 31, 23, 59, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expectedDate = calendar.getTime();

        Date result = new DateParser("2012-12-31T23:59Z").parse();

        assertThat(result, is(expectedDate));
    }

}
