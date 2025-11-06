#!/usr/bin/env bash

set -e #se algum comando der errado, a execução do script será interrompida

# apt update # atualiza os pacotes linux
# apt install -y jq # instala o utilitário JSON jq

#CRIAR PACIENTE
HTTP_STATUS=$(
    curl -X 'POST' \
    'http://localhost:9000/api/v0.2.2/pacientes' \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -w "%{http_code}" \
    -o paciente_create.json \
    -d '{
    "nome": "Fulano"
    }'
)

echo "Status HTTP: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne 201 ]; then
    echo "Erro ao criar paciente"
    exit 1
fi

PACIENTE_ID=$(jq '.id' paciente_create.json)
echo "Paciente criado com o ID: $PACIENTE_ID"

#READ PACIENTE
HTTP_STATUS=$(
    curl -X 'GET' \
    "http://localhost:9000/api/v0.2.2/pacientes/$PACIENTE_ID" \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -w "%{http_code}" \
     -o paciente_read.json \
)

echo "Status HTTP: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne 200 ]; then
    echo "Erro ao procurar paciente"
    exit 1
fi

echo "Paciente ID: $PACIENTE_ID encontrado com sucesso"

#UPDATE PACIENTE
HTTP_STATUS=$(
    curl -X 'PUT' \
    "http://localhost:9000/api/v0.2.2/pacientes/$PACIENTE_ID" \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -w "%{http_code}" \
    -o paciente_update.json \
    -d '{
          "nome": "Gustavo Ressurreição Atualizado",
          "cpf": "12345678900",
          "email": "gustavo.atualizado@email.com"
        }'
)
echo "Status HTTP: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne 204 ]; then
    echo "Erro ao atualizar paciente"
    exit 1
fi

echo "Paciente ID: $PACIENTE_ID atualizado com sucesso"

#DELETE PACIENTE
HTTP_STATUS=$(
    curl -X 'DELETE' \
    "http://localhost:9000/api/v0.2.2/pacientes/$PACIENTE_ID" \
    -H 'accept: */*' \
    -w "%{http_code}" \
    -o paciente_delete.json \
)
echo "Status HTTP: $HTTP_STATUS"

if [ "$HTTP_STATUS" -ne 204 ]; then
    echo "Erro ao deletar paciente"
    exit 1
fi

echo "Paciente ID: $PACIENTE_ID deletado com sucesso"
