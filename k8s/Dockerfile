FROM lramirezq/base:ms-jre-8
RUN sudo adduser --disabled-password --gecos '' newuser \
    && adduser newuser sudo \
    && echo '%sudo ALL=(ALL:ALL) ALL' >> /etc/sudoers

RUN sudo mkdir -p /app

RUN sudo chown newuser /app
USER newuser
WORKDIR /app

COPY ./iamrole-sqs-0.0.1.jar /app

ENTRYPOINT ["tail","-f","/dev/null"]
EXPOSE 8080