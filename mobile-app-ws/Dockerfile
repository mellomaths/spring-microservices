FROM maven:3.6.3-jdk-8-slim as install

ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

RUN mkdir -p /application
WORKDIR /application
COPY src /application/src
COPY pom.xml /application
RUN mvn -f /application/pom.xml clean package

FROM adoptopenjdk:8-jre-hotspot as builder

WORKDIR /application
COPY --from=install /application/target/*.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk:8-jre-hotspot
WORKDIR /application
COPY --from=builder /application/dependencies/ ./
COPY --from=builder /application/snapshot-dependencies/ ./
COPY --from=builder /application/resources/ ./
COPY --from=builder /application/application/ ./

ENTRYPOINT [ "java", "org.springframework.boot.loader.JarLauncher" ]
