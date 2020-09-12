package com.in28minutes.spring.basics.springin5steps;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Should")
public class Scratch {

    @BeforeAll
    static void setup() {
        System.out.println("Before All");
    }

    List<Integer> a;

    public Integer praser(String a) throws NumberFormatException {
        return Integer.parseInt(a);
    }



    @Nested
    @DisplayName("Check Dates such that:")
    class DateTests{

        LocalDate yesterday, tomorrow;
        DateTimeFormatter yyyy_MM_dd = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @BeforeEach
        void init() {
            yesterday = LocalDate.now().minusDays(1);
            tomorrow = LocalDate.now().plusDays(1);
        }

        @Test
        @DisplayName("Today is 11th Sept 2020")
        // @Disabled // uncomment to make test inactive
        public void todaysDate() {
            LocalDate today = LocalDate.parse("2020-09-11", yyyy_MM_dd);
            assertTrue(LocalDate.now().equals(today));
        }

        @Test
        @DisplayName("Today comes 1 day after Yesterday")
        public void yesterday() {
            LocalDate today = LocalDate.parse("2020-09-11", yyyy_MM_dd);
            assertTrue(yesterday.plusDays(1).equals(today));
        }

        @Test
        @DisplayName("Tomorrow comes 1 day after Today")
        public void tomorrow() {
            LocalDate today = LocalDate.now();
            assertTrue(tomorrow.minusDays(1).equals(today));
        }

        @Test
        @DisplayName("All parts of a date are valid")
        public void shortCircuitPrevention() {
            LocalDate today = LocalDate.parse("2020-09-11", yyyy_MM_dd);

            // assertAll goes through all the tests,
            // instead of short-circuiting out on the first failed test
            assertAll(
                    () -> assertEquals(2020, today.getYear(), () -> "Year should be 2020"),
                    () -> assertEquals(9, today.getMonthValue(), () -> "September should give month value as 9"),
                    () -> assertEquals(11, today.getDayOfMonth(), () -> "Date should be 11th sept")
            );
        }
    }


    @BeforeEach
    void init() {
        a = Arrays.asList(1, 2, 3);
    }

    @Test
    @DisplayName("Test equality")
    public void equalityTest() {
        List<Integer> b = Arrays.asList(1, 2, 3);
        assertEquals(a.size(), b.size(), () -> "Error: Two lists must have the same size");
        // ^^ the non-equality message is generated lazily, only when equality fails

    }

    @Test
    @DisplayName("Test Iterables")
    public void iterableTest() {
        List<Integer> b = Arrays.asList(1, 2, 3);
        assertIterableEquals(a, b);
    }


    @Test
    @DisplayName("Test Exceptions")
    public void exceptionTest() {
        // a new feature in JUnit5: assertThrows
        // it can work on its own, or we can get the error returned from it, and assert on that error

        // assertThrows(Exception.class, () -> praser("a")); // standalone use

        Throwable err = assertThrows(Exception.class, () -> praser("a")); // more granular approach
        assertTrue(err.toString().contains("NumberFormatException")); // you can make it more custom, using any property of the error
    }

    @AfterEach
    void clean() {
        // TODO: get Test info
        System.out.println(a.size());
    }

    @AfterAll
    static void teardown() {
        System.out.println("After All");
    }
}
