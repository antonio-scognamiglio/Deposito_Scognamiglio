#!/usr/bin/env bash
# Solo DB: porta il container MySQL su localhost:3306 in stato healthy.
# Usato sia da VS Code (preLaunchTask) sia da scripts/run.sh.
set -euo pipefail

# macOS: avvia Docker Desktop se non è aperto; su altre piattaforme basta che il daemon sia attivo.
if [[ "$(uname -s)" == "Darwin" ]]; then
  open -a Docker || true
fi

while ! docker info >/dev/null 2>&1; do
  sleep 2
done

docker compose up -d --wait
