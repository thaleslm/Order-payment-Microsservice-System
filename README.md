


# Order Payment Microservice System

Um microsserviço simples de pedidos, feito com **Java 21 + Spring Boot**, que simula o envio e o processamento de pedidos usando **RabbitMQ** como fila de mensagens e **H2** como banco de dados em memória.

---

##  Visão Geral

Este projeto demonstra a arquitetura de microsserviço baseada em mensageria.  
Aqui, um pedido (`Order`) é recebido via REST, armazenado no banco de dados e enviado para uma fila no **RabbitMQ**.  
Outro componente (consumer) escuta essa fila e atualiza o pedido como `COMPLETED`.

---

## Tecnologias

- Java 21
- Spring Boot 3.5.3
- Spring Web
- Spring Data JPA
- Spring AMQP (RabbitMQ)
- H2 Database
- Docker & Docker Compose
- Lombok

---

## Estrutura do Projeto

```

Order-payment-Microsservice-System
├── docker/                       # Docker Compose para o RabbitMQ
├── src/
│   └── main/
│       ├── java/
│       │   └── com.dev.Order\_payment\_Microsservice\_System/
│       │       ├── config/          # Configuração do RabbitMQ
│       │       ├── controller/      # REST controller
│       │       ├── domain/
│       │       │   └── order/       # Entidade Order + Enum StatusType
│       │       ├── dto/             # DTOs (ex: OrderDTO)
│       │       ├── messaging/
│       │       │   ├── consumer/    # RabbitMQ Consumer
│       │       │   └── producer/    # RabbitMQ Producer
│       │       ├── repositories/    # Spring Data JPA
│       │       └── service/         # Lógica de negócio
│       └── resources/
│           └── application.properties
└── README.md

````

---

## Como executar

### 1. Clonar o projeto

```bash
git clone https://github.com/thaleslm/Order-payment-Microsservice-System.git
cd Order-payment-Microsservice-System
````

### 2. Subir RabbitMQ via Docker

```bash
cd docker/rabbitmq
docker-compose up -d
```

RabbitMQ estará disponível em:

* **RabbitMQ (fila):** `amqp://localhost:5672`
* **Painel de controle:** [http://localhost:15672](http://localhost:15672)

    * usuário: `guest`
    * senha: `guest`

### 3. Executar a aplicação

Use sua IDE ou rode via terminal:

```bash
./mvnw spring-boot:run
```

A API estará disponível em:

```
http://localhost:2020/order
```

---

## Exemplos de Uso

### Criar novo pedido (POST `/order`)

```http
POST /order
Content-Type: application/json

{
  "description": "Compra de carros"
}
```

Resposta:

```http
200 OK
Order created successfully
```

---

## Configurações principais (`application.properties`)

```properties
spring.application.name=Order-payment-Microsservice-System

# H2 database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true

# RabbitMQ
queue.name.order=order.queue
queue.exchange.order=exchange.order
queue.routing.key.order=new.queue

# Porta
server.port=2020
```

---

## O que você vai encontrar nesse projeto

* Estruturação de microsserviço em Java
* Integração com mensageria RabbitMQ
* Produção e consumo de eventos
* Simulação de processamento assíncrono
* Boas práticas de organização com Spring Boot

---

## Autor

Feito por **Thales Moreira** — Desenvolvedor.
Conecte-se no [LinkedIn](https://www.linkedin.com/in/thales-henrique-7827ba227/)!

---

##  Gostou?

Se este projeto te ajudou, deixe uma ⭐ no repositório e compartilhe!
Isso ajuda muito a dar visibilidade ao portfólio 🙏



