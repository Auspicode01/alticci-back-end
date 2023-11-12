FROM eclipse-temurin:17-jdk-alpine
LABEL name="alticcibe"
EXPOSE 8080
COPY target/alticci-0.0.1.jar .
ENTRYPOINT java -jar ./alticci-0.0.1.jar