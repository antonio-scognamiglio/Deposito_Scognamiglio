# Getting Started

## Come avviare il progetto (shared workflow)

**Prerequisiti:** Java 21, Docker attivo.

Un solo comando avvia tutto (database MySQL condiviso + app Spring Boot):

```bash
./scripts/run.sh
```

Per fermare solo il database (i dati restano nel named volume `mysql-course-data`):

```bash
./scripts/stop.sh
```

Dettagli:

- Il database è un container Docker `mysql:8.0` definito in `docker-compose.yml`.
- I dati persistono nel **named volume** `mysql-course-data`, quindi sono portabili su qualsiasi macchina con Docker e sopravvivono a `docker compose down`.
- L'app Spring Boot si connette a `jdbc:mysql://localhost:3306/ecommercedb` (config in `src/main/resources/application.properties`).
- Il flag `--lower-case-table-names=1` nel container risolve la discrepanza di capitalizzazione tra macOS (case-insensitive) e il volume su base Linux.

### Nota per chi clona la repo (primo avvio)

Il named volume parte vuoto su una macchina nuova; al primo boot l'app creerà lo schema tramite JPA/Hibernate (`ddl-auto`). I dati esistenti nel tuo ambiente sono stati migrati con:

```bash
docker exec mysql-shared mysqldump -u root -psegreta --databases ecommercedb orders products utentidb > /tmp/all-user-dbs.sql
docker compose up -d --wait
docker exec -i mysql-shared mysql -u root -psegreta -h 127.0.0.1 < /tmp/all-user-dbs.sql
```

## VS Code (solo locale, non condivisa)

La configurazione `.vscode/` (tasks + launch con preLaunchTask) è ignorata da git e quindi personale: il bottone **Play** di VS Code avvia lo stesso flusso (`docker compose up -d --wait` poi `spring-boot:run`) ma chi clona la repo deve usare `scripts/run.sh`.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.1.2/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.1.2/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.1.2/reference/web/servlet.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/4.1.2/reference/using/devtools.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.1.2/reference/data/sql.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

