FROM eclipse-temurin:17-jre
LABEL author=23skdu@users.noreply.github.com
RUN apt update && apt -y upgrade && apt clean
WORKDIR /app
COPY LogLLMSummary/target/*.jar app.jar
RUN useradd -m logllm 
RUN chown -R logllm:logllm /app
USER logllm 
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
