# Ecommerce — Spring Boot + MySQL (Docker)

Spring Boot 4.1.2 / Java 21 e-commerce project with a shared MySQL database via Docker Compose.

## Getting started (shared workflow)

**Prerequisites:** Java 21, Docker running.

Start everything with one command (MySQL container + Spring Boot app):

```bash
./scripts/run.sh
```

Stop only the database (data persists in the named volume `mysql-course-data`):

```bash
./scripts/stop.sh
```

## Details

- The database is a `mysql:8.0` Docker container defined in `docker-compose.yml`.
- Data lives in the **named volume** `mysql-course-data`, so it is portable on any machine with Docker and survives `docker compose down`.
- The Spring Boot app connects to `jdbc:mysql://localhost:3306/ecommercedb` (see `src/main/resources/application.properties`).
- `--lower-case-table-names=1` in the container resolves the case-sensitivity mismatch between macOS (case-insensitive) and the Linux-based volume.

## First run on a fresh machine

The named volume starts empty; on first boot, JPA/Hibernate creates the schema. The databases that existed on the original machine were migrated with:

```bash
docker exec mysql-shared mysqldump -u root -psegreta --databases ecommercedb orders products utentidb > /tmp/all-user-dbs.sql
docker compose up -d --wait
docker exec -i mysql-shared mysql -u root -psegreta -h 127.0.0.1 < /tmp/all-user-dbs.sql
```

