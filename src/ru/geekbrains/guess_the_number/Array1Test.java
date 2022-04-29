package ru.geekbrains.guess_the_number;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Array1Test {

    private Array1 array1;

    @BeforeEach
    void startUp() {
        System.out.println("начинается тест");
        array1 = new Array1();
    }

    @AfterEach
    void shutdown() {
        System.out.println("тест завершается");
    }

    @BeforeAll
    static void mainStart() {
        System.out.println("START");
    }

    @AfterAll
    static void mainEnd() {
        System.out.println("END");
    }

    @DisplayName("Проверка массива true")
    @Test
    void testAdd1() {
        Assertions.assertEquals(true, array1.checkArray(2,2,2,2,2,2,2));
    }

    @DisplayName("Проверка массива false")
    @Test
    void testAdd2() {
        Assertions.assertEquals(false, array1.checkArray(2,2,2,3,2,2,2));
    }

    @DisplayName("Проверка исключения")
    @Test
    void testException() {
        Assertions.assertThrows(ArithmeticException.class, () ->
                array1.shiftArray(10, 2,3,4,5));
    }

    @DisplayName("Проверка таймаута для сдвига")
    @Test
    void testTimeout() {
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            array1.shiftArray(10, 1,2,3,4,5,6,7,8,9,10,11);
            array1.shiftArray(-10, 1,2,3,4,5,6,7,8,9,10,11);
            Thread.sleep(500);
        });
    }

    @DisplayName("Параметризированный тест")
    @ParameterizedTest
    @MethodSource("data")
    void paramTest(int a, int b, int f, int y) {
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            Assertions.assertEquals(true, array1.checkArray(a,b,f,y));
        });
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(6, 2, 1,5),
                Arguments.arguments(6, 2, 4,4)

        );
    }


}