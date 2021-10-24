FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.6_10

#Zona horaria
RUN apk add --no-cache tzdata
ENV TZ='America/Lima'
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8080
CMD ["java","-jar","/app/app.jar"]
