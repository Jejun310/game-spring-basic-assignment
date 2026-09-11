# 입문 주차 프로젝트
### 기술 스택
- Java 21
- Spring Boot (Web,Data JPA, Validation)
- MySQL 8 (Docker)
- Lombok
- Gradle

### 프로젝트 구조
```
src/main/java/com/gamebasic
├── common
│   ├── dto            # 공통 에러 응답 DTO
│   └── exception       # 커스텀 예외, 전역 예외 처리
├── game
│   ├── controller       # GameController
│   ├── dto              # 요청/응답 DTO
│   ├── entity           # Game, GamePhase, GameStatus
│   ├── repository       # GameRepository
│   └── service          # GameService
└── runcard
    ├── dto              # RunCardRequest, CardResponse
    ├── entity           # RunCard
    └── repository       # RunCardRepository
```
Controller → Service → Repository의 3계층 구조를 따르며, 엔티티 연관관계는 RunCard → Game 단방향으로만 구성되어 있다.

### 실행 방법
1. MySQL 컨테이너 실행
```
docker run --name game-mysql \
  -e MYSQL_ROOT_PASSWORD=12345678 \
  -e MYSQL_DATABASE=game \
  -p 3307:3306 \
  -d mysql:8.0
```
그 후
```
docker start game-mysql
```

2. application.properties 확인
src/main/resources/application.properties에 아래와 같이 설정되어 있다.
```
spring.datasource.url=jdbc:mysql://localhost:3307/game
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=12345678

spring.jpa.hibernate.ddl-auto=update
```

3. 애플리케이션 실행
```
./gradlew bootRun
```

4.플레이
브라우저에서 http://localhost:8080 접속 후 플레이한다.
### 구현한 API

|기능|메서드|경로|
|:---|:---|:---|
|게임 생성|POST|/games|
|게임 목록 조회|GET|/games|
|게임 상세 조회|GET|/games/{gameId}|
|진행/덱 저장|PUT|/games/{gameId}/progress|
|플레이어 이름 변경|PATCH|/games/{gameId}|
|게임 삭제|DELETE|/games/{gameId}|
