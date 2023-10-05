### 목적
- kafka에 익숙해지고 유용하게 사용해보기

### 해볼거 
- [x] producer, consumer 설정 및 helloWorld
- [x] 같은 메시지를 여러 곳에서 소비할 수 있도록 해보기 (groupId 설정)
- [x] 커스텀 serialization/deserialization 설정해보기
  - [String이 아닌 DTO에 적용](https://www.baeldung.com/kafka-custom-serializer) 
  - [Avro?](https://docs.confluent.io/platform/current/schema-registry/fundamentals/serdes-develop/serdes-avro.html) 
- [ ] producer 추가 설정
  - acknowledgment 
  - batch size?
- [ ] 에러 핸들링?
- [ ] 메시지 헤더로 부가정보 전달해보기?
- [ ] topic partitioning?, message keying?
- [ ] offset 관리?
- [ ] Producer and Consumer Interceptors?
- [ ] Error 시나리오?
- [ ] testing
- [ ] 모니터링?
- [ ] 프로듀서, 컨슈머 수평확장?
- [ ] transactional messaging?
- [ ] 실제 사용 예시 알아보기


### 로컬에서 카프카 실행
- 카프카 설치 디렉토리로 이동해서 아래 명령 실행
  ```bash
  $ bin/zookeeper-server-start.sh config/zookeeper.properties # 주키퍼 실행
  $ bin/kafka-server-start.sh config/server.properties # 카프카 브로커 실행
  ```  
  또는 docker-compose나 testcontainers 이용

- 샘플 요청: `curl -X POST localhost:12345/kafka-sample -d '{"message":"test"}'`


### reference
- [spring for apache kafka](https://docs.spring.io/spring-kafka/reference/html/#preface)
