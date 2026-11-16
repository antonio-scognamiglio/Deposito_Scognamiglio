#!/usr/bin/env bash
# Arresta solo il database MySQL condiviso (i dati restano nel named volume).
set -euo pipefail

docker compose down
