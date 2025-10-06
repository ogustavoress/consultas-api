# Api de Consultas
API REST para sistema de agendamento de consultas, desenvolvida em **Spring Boot**, com integração ao **MySQL** e empacotada em **Docker**.
Este projeto faz parte dos checkpoints da disciplina de *Microsservice and Web Engineering*.

## Participante
* **Nome:** Gustavo Carvalho, **RM** 550983
* **Nome:** Leticia Vitalino, **RM** 552481
* **Nome:** Gabriel Valério, **RM** 552041
* **Turma:** 3SIR.

## Escopo do Projeto
O sistema permite o gerenciamento de **pacientes**, **profissionais** e **consultas**, através de operações CRUD expostas via endpoints REST.

### Rotas (endpoints)
* **POST /pacientes:** 
    * Cadastra um paciente.
* **PUT /pacientes/{id}:** 
    * Atualiza os dados do paciente.
* **DELETE /pacientes/{id}:** 
    * Exclui um paciente.
* **GET /pacientes/{id}:**
   * Busca um paciente pelo id.
* **GET /pacientes**
   * Retorna a lista de pacientes.    

* **POST /profissionais:** 
    * Cadastra um profissional.
* **PUT /pacientes/{id}:** 
    * Atualiza os dados do profissional.
* **DELETE /pacientes/{id}:** 
    * Exclui um profissional.
* **GET /pacientes/{id}:**
   * Busca um profissional pelo id.
* **GET /pacientes**
   * Retorna a lista de profissionais.

* **POST /pacientes:** 
    * Cadastra uma consulta.
* **PUT /pacientes/{id}:** 
    * Atualiza os dados da consulta.
* **DELETE /pacientes/{id}:** 
    * Exclui uma consulta.
* **GET /pacientes/{id}:**
   * Busca uma consulta pelo id.
* **GET /pacientes**
   * Retorna a lista de consultas. 
## Estrutura de Código
A aplicação foi estruturada em diferentes camadas, cada uma com suas responsabilidades: 

**Model:** Representa as entidades e tabelas do banco de dados.

**Controller:** Recebe e trata as requisições HTTP.

**DTO:** Transporte de dados entre as camadas.

**Service:** Contém as regras de negócio e manipulação dos dados.

**Repository:** Interfaces que estendem `JpaRepository` para operações CRUD.

## Configuração e Execução
### Executando com Docker (recomendado)
O projeto está totalmente containerizado e pode ser iniciado com o comando:
```
docker compose up
```
Esse comando sobe todos os seguintes serviços:
* **db:** container MySQL (porta 3306)
* **api:** aplicação Spring Boot (porta 9000) 
A aplicação utiliza MySQL, configurado via variáveis de ambiente
Após a inicialização, acesse a documentação da API em:
http://localhost:9000/swagger-ui/index.html
```
api.version=v2
server.port=9000
spring.application.name=checkpoint
sprindoc.swagger-ui.path=/

spring.datasource.url=jdbc:mysql://${DB_SERVER}:${DB_PORT}/${DB_DATABASE}?createDatabaseIfNotExist=true
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```
### Executando a imagem no Docker Hub
link da imagem:
https://hub.docker.com/repository/docker/ogustavoress/api-consultas/general

Caso queira rodar apenas a API usando a imagem publicada:
```
docker run -p 9000:9000 ogustavoress/api-consultas:0.0.2
```
### Executando manualmente
1. Certifique-se de ter o **MySQL** rodando e configure no `application.properties`:
```
server.port=9000
sprindoc.swagger-ui.path=/

spring.datasource.url=jdbc:mysql://localhost:3306/api?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root_pwd
```
2. Compile e inicie a aplicação com **Maven**
```
mvn spring-boot:run
```
3. A API ficará disponível em:
http://localhost:9000/swagger-ui/index.html

### Swagger para Documentação da API
Para configurar a documentação com Swagger, consulte a [documentação oficial](https://sprinhttps://springdoc.org/properties.html).

No arquivo `application.properties`, utilize as seguintes configurações:
```
properties
spring.application.name=checkpoint2
springdoc.swagger-ui.path=/

spring.datasource.url=jdbc:mysql://localhost:3306/api?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root_pwd

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

## Referências
* [SpringDoc](https://springdoc.org/)
