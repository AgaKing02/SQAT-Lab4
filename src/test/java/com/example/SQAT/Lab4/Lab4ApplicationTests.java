package com.example.SQAT.Lab4;

import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Log
class Lab4ApplicationTests {
    public static Integer number;

    @Test
    void contextLoads() {

    }

	@BeforeAll
    static void init(){
		log.info("Initialized");
	}
    @Test
    @Order(1)
    public  void setNumber() {
        Lab4ApplicationTests.number = 10;
    }

    @Test
    @Order(2)
    void givenEvenNumber_whenCheckingIsNumberEven_thenTrue() {
        boolean result = isNumberEven(number);
        Assertions.assertTrue(result);
    }

    @Test
    @Order(3)
    void givenOddNumber_whenCheckingIsNumberEven_thenFalse() {
        boolean result = isNumberEven(number-1);
        Assertions.assertFalse(result);
    }

    @Test
    @Order(3)
    void givenMinusOddNumber_whenCheckingIsNumberEven_thenFalse() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            isNumberEven(number/0);
        });

        String expectedMessage = "/ by zero";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));}


	@AfterAll
	public static void tearDown() {
		log.info("Finished");
	}

    public boolean isNumberEven(Integer number) {
        return number % 2 == 0;
    }


}
