# Sadece Runtime (çalışma) ortamı
FROM eclipse-temurin:17-jre
WORKDIR /app

# Senin terminalde mvn clean package ile oluşturduğun güncel dosyayı kopyalar
COPY target/*.jar app.jar

EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]