#!/usr/bin/env bash
# Avvio completo: DB condiviso (scripts/db-up.sh) + app Spring Boot.
set -euo pipefail

./scripts/db-up.sh
echo "DB pronto su localhost:3306 -> avvio Spring Boot..."
./mvnw spring-boot:run
