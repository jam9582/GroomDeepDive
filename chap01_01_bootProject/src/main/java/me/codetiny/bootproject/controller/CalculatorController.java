package me.codetiny.bootproject.controller;

import lombok.extern.slf4j.Slf4j;
import me.codetiny.bootproject.dto.CalculatorDTO;
import me.codetiny.bootproject.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // 롬복의 로깅용 라이브러리
@RestController
public class CalculatorController {

    private CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    // application 상태 확인용 health 체크용 메소드
    @GetMapping("/health")
    public String health() {
        return "it's OK";
    }

    // 프론트 서버에서 넘어오는 num1, num2 를 받기 위한 메소드
    @GetMapping("/plus")
    public ResponseEntity<CalculatorDTO> plusTwoNumbers(CalculatorDTO calculatorDTO) {

        log.info("plus 핸들러에 전달 되는 값 확인: " + calculatorDTO);

        int result = calculatorService.plusTwoNumbers(calculatorDTO);

        calculatorDTO.setSum(result);

        return ResponseEntity.ok().body(calculatorDTO);
    }

}
