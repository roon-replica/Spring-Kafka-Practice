### 목적
- kafka에 익숙해지기
  - spring에서 kafka 어케 쓰는지
  - 설정
- kafka 유용하게 사용해보기


### 로컬에서 카프카 실행
- 카프카 설치 디렉토리로 이동 (또는 docker-compose나 testcontainers 이용)
```bash
$ bin/zookeeper-server-start.sh config/zookeeper.properties # 주키퍼 실행
$ bin/kafka-server-start.sh config/server.properties # 카프카 브로커 실행
```

- 샘플 요청: `curl -X POST localhost:12345/kafka-sample -d '{"message":"test"}'`


### reference
- [spring for apache kafka](https://docs.spring.io/spring-kafka/reference/html/#preface)
