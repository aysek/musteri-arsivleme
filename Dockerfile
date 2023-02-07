
FROM adoptopenjdk/openjdk11

COPY ./target/musteri-1.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch musteri-1.0-SNAPSHOT.jar'

ARG JAR_FILE=target/musteri-1.0-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","musteri-1.0-SNAPSHOT.jar"]