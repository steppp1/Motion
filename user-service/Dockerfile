# 使用 JDK 构建应用
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 运行阶段：使用 JDK 运行打包后的 JAR
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 15000
ENTRYPOINT ["java", "-jar", "app.jar"]