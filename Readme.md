- [Introducción](#introducción)
- [Prerequisito(s)](#prerequisitos)
- [Docker](#docker)

# Introducción

El repositorio contiene 1 proyecto, el cual incluye el consumidor y el productor. Por medio del productor se envía un mensaje al topic y el procesado por el consumidor de forma asíncrona.

# Prerequisito(s)

- Docker
- Docker compose
- Kafka
- Zookeeper

# Docker

El archivo `docker-compose.yml` continene la configuración para levantar Zookeeper y Kafka.

```
    version: '2'
    services:
    zookeeper:
        image: confluentinc/cp-zookeeper:latest
        environment:
        ZOOKEEPER_CLIENT_PORT: 2181
        ZOOKEEPER_TICK_TIME: 2000
        ports:
        - 22181:2181
    
    kafka:
        image: confluentinc/cp-kafka:latest
        depends_on:
        - zookeeper
        ports:
        - 29092:29092
        environment:
        KAFKA_BROKER_ID: 1
        KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
        KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092,PLAINTEXT_HOST://localhost:29092
        KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
        KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
        KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
```

Colocarse en la carpeta del archivo y ejecutar el siguiente comand0:

```
    docker compose up
```
