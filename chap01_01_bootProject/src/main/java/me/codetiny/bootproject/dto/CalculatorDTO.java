package me.codetiny.bootproject.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CalculatorDTO {

    // response 와 request 를 둘 다 처리하는 DTO
    private int num1; // 요청 된 숫자
    private int num2; // 요청 된 숫자
    private int sum; // 응답 할 합계

    public CalculatorDTO(int num1, int num2) { // 생성자 만들어서 값 초기화
        this.num1 = num1;
        this.num2 = num2;
    }

}
