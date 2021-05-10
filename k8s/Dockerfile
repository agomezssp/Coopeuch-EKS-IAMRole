FROM lramirezq/base:ms-jre-8
USER root
RUN adduser --disabled-password --gecos '' newuser \
    && adduser newuser sudo \
    && echo '%sudo ALL=(ALL:ALL) ALL' >> /etc/sudoers

RUN mkdir -p /app

RUN chown newuser /app
USER newuser
WORKDIR /app

COPY ./iamrole-sqs-0.0.1.jar /app

ENTRYPOINT ["tail","-f","/dev/null"]
EXPOSE 8080