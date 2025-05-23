package me.codetiny.bootproject.service;

import me.codetiny.bootproject.dto.CalculatorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    private static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of(new CalculatorDTO(1, 2)),
                Arguments.of(new CalculatorDTO(20, 50)),
                Arguments.of(new CalculatorDTO(10, -2))
        );
    }

    @DisplayName("두 수의 합을 구하는 메소드 테스트")
    @ParameterizedTest
    @MethodSource("provide")
    void testSumTwoNumbers(CalculatorDTO input) {

        int expected = input.getNum1() + input.getNum2();
        int actual = calculatorService.plusTwoNumbers(input);

        Assertions.assertEquals(expected, actual); // 기대하는 값과 실제 값이 일치한지 확인

    }

}