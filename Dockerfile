FROM openjdk:17
LABEL authors="nikitavoronkov"

ADD /target/bubble-sort.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
