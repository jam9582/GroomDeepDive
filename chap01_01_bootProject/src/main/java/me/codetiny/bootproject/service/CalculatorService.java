package me.codetiny.bootproject.service;

import me.codetiny.bootproject.dto.CalculatorDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int plusTwoNumbers(CalculatorDTO calculatorDTO) {

        return calculatorDTO.getNum1() + calculatorDTO.getNum2(); // response dto 형태로 값을 전달 받을므로 이런 형식

    }
}
