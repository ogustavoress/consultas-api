# Checkpoint 3
API para sistema de agendamento de consulta criada para o 2º checkpoint de *Microsservice and Web Engineering* (continuação da API do Checkpoint 1 e Checkpoint 2).

## Informações
**Nome:** Gustavo de Carvalho Sena Ressurreição.

**RM** 550983.

**Turma:** 3SIR.

## Escopo do Projeto
O projeto consiste no desenvolvimento de uma API que responde a requisições HTTP, através da operação CRUD:

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

**Model:** Realiza o mapeamento das entidades utilizadas no banco de dados.

**Controller:** Responsável por gerenciar as requisições HTTP, encaminhando-as para os serviços correspondentes.

**DTO:** Facilita o transporte de dados entre as camadas aplicação.

**Service:** Concentra a lógica de negócio da API.

## Configuração e Execução

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
## Rodando a API
Use o *Maven* para iniciar a aplicação com o comando:
```
mvn spring-boot:run
```
Após a execução da aplicação, use a ferramenta **Swagger UI** para testar os endpoints diretamente:
http://localhost:8080/swagger-ui/index.html. 


## Referências
* [SpringDoc](https://springdoc.org/)
