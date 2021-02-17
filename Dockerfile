
#FROM apache-tomcat-9.0.43
#VOLUME /tmp
#ADD target/JEE_Project*.jar /app.jar
#CMD ["sh","startup.sh","/app.jar"]
#EXPOSE 8080


FROM tomcat:9.0-alpine
VOLUME /tmp
ADD target/JEE_Project*.war  /usr/webapps/
EXPOSE 8080
CMD ["catalina.sh","run"]

