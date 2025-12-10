FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/erp_three_tier_service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 4000

ENTRYPOINT ["java", "-jar", "app.jar"]
