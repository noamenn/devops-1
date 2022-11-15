FROM openjdk:8-jdk-alpine
COPY /var/lib/jenkins/workspace/devops/target/achat-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]
