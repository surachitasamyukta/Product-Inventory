FROM openjdk:17
EXPOSE 8082
ADD target/product-inventory.jar product-inventory.jar
ENTRYPOINT ["java", "-jar", "product-inventory.jar"]