FROM ubuntu
RUN apt-get update &&\
    apt install default-jre -y &&\
    apt install curl -y &&\
    apt-get install vim -y
RUN mkdir  /app
COPY porvenir-sqs-0.0.5-SNAPSHOT.jar /app
ENTRYPOINT ["tail","-f","/dev/null"]
EXPOSE 8080