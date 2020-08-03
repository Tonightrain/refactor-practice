package com.twu.refactoring;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberCruncherTest {

    int[] numbers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    int[] numbers2 = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4};

    @Test
    public void shouldCountEvenNumbers() {
        int[] count = new NumberCruncher(numbers1).evenOrOdd();
        assertThat(count[0],is(5));
        assertThat(count[1],is(6));
    }

    @Test
    public void shouldCountPositiveNumbers() {
        int[] count = new NumberCruncher(numbers2).posOrNeg();
        assertThat(count[0], is(5));
        assertThat(count[1], is(5));
    }
}
