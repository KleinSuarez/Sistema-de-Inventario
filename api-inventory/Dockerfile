FROM openjdk:8
EXPOSE 8083
ADD ./target/api-inventory-0.0.1-SNAPSHOT.jar api-inventory.jar
ENTRYPOINT ["java","-jar", "api-inventory.jar"]