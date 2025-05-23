FROM eclipse-temurin:17
# 베이스 이미지를 설정하는 명령어

COPY build/libs/*.jar app.jar
# lib 하위에 ~.jar로 끝나는 파일을 app.jar 라는 이름으로 복사하겠다.

ENTRYPOINT ["java", "-jar", "/app.jar"]
# 실제 실행 구문, cmd 창에 java -jar /app.jar을 입력한 것과 같음