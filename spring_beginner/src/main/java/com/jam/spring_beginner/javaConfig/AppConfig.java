package com.jam.spring_beginner.javaConfig;

import com.jam.spring_beginner.javaConfig.model.Dog;
import com.jam.spring_beginner.javaConfig.model.Human;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration /* 스프링 설정용 클래스, xml 사용x 하기 위해 사용,
얘 바로 아래에 @Component 할 필요는 없는게 이미 @Configuration 내부에 이 기능을 포함하고 있음, 이걸 써도 오류는 안 남
*/
/* 이거랑 별개로 @Component 쓰기 위해선 .yml 같은 설정 파일이 필요한건 x, 이게 동작하기 위해선 @ComponentScan이 필요함, 이거 안하면 spring은 @Component가 존재하는지도 모름
@SpringBootApplication 얘 안에 @ComponentScan 이 들어있음
application.yml은 @Component 한 후에 내부 필드 선언에서 @Value("${내용}") 이거에서만 썼었음
 */
public class AppConfig {

    @Bean
    public Dog dog() {
        return new Dog(); // 스프링에게 내가 직접 Dog 객체 만들어줄테니까 dog라는 이름으로 bean으로 등록해달라고 말하는 것
    } // 이게 @Component없이 수동 등록하는 방식

    @Bean
    public Human human() {
        return new Human(dog());
    }

    /* 수동 등록을 쓰는 이유:
        1. 어떤 객체를 주이할지 내가 직접 지정 가능
        2. 외부 라이브러리 클래스는 @Component 못 붙여서 new 해서 수동으롣 등록해야 함
        3. 테스트나 설정 분리할 때 유리함(@Profile, 조건부 bean 설정 등에서 자주 씀)
     */
}
