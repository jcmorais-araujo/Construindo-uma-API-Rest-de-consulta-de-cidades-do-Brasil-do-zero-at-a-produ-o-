# Digital Innovation One

## Construindo uma API Rest de consulta de cidades do Brasil do zero até a produção

Neste projeto foi desenvolvida uma API REST para a consulta de países, cidades e estados brasileiros, além de um *endpoint* para o cálculo de distância entre duas cidades. 

O projeto foi desenvolvido utilizando **Java** com **Spring Boot** e o banco de dados **PostgreSQL**, além do deploy na nuvem do Heroku.

---

### 📝 Instruções

Para executar o projeto são necessários os seguintes pré-requisitos:

- Java 11 ou versões superiores.
- Docker

1 — Crie o banco de dados *PostgreSQL* no **docker**, digitando seguinte comando no terminal:

```shell
docker run --name dio-cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

2 — Execute um dos comando abaixo para se conectar ao terminal do container **docker**, mapeando a pasta **sql** do projeto para a pasta **/tmp** do container:

> Windows:
>
> ```shell
> docker run -it --rm --net=host -v %CD%\sql:/tmp postgres /bin/bash
> ```

> Linux:
>
> ```shell
> docker run -it --rm --net=host -v $PWD/sql:/tmp postgres /bin/bash
> ```

3 — Para popular a base de dados e ativar as extensões necessárias, execute todos os comandos abaixo:

```shell
psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

---

### ⚙ Endpoints - Deployed to Heroku


- [/countries - Países](https://dio-cities-distance-api.herokuapp.com/api/v1/countries)
- [/states - Estados](https://dio-cities-distance-api.herokuapp.com/api/v1/states)
- [/cities - Cidades](https://dio-cities-distance-api.herokuapp.com/api/v1/cities)


- [/distance/by-points - Distância entre pontos (milhas)](https://dio-cities-distance-api.herokuapp.com/api/v1/distance/by-points?from=4929&to=5254)
- [/distance/by-cube - Distância entre pontos (metros)](https://dio-cities-distance-api.herokuapp.com/api/v1/distance/by-cube?from=4929&to=5254)

---

### 📚 Referências
 
- [Java JDK 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Initializr](https://start.spring.io/)
- [PostgreSQL](https://www.postgresql.org/)


- [Andre Gomes - Cities API GitHub](https://github.com/andrelugomes/digital-innovation-one/tree/master/cities-api)
- [SQL data files - chinnonsantos GitHub](https://github.com/chinnonsantos/sql-paises-estados-cidades)
