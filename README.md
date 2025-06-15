# CrudApp - Sistema de Gerenciamento de Usuários

Este é um projeto Spring Boot que implementa um sistema de gerenciamento de usuários com autenticação JWT e controle de acesso baseado em roles.

## Requisitos

- Java 17 ou superior
- Maven
- PostgreSQL
- Plugin Lombok instalado

## Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL chamado `CrudApp`
2. Configure as credenciais do banco de dados no arquivo `application.properties`

## Instalação

1. Clone o repositório
2. Execute o comando para instalar as dependências:
```bash
mvn clean install
```

## Executando a Aplicação

Execute o comando:
```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## Endpoints da API

### Autenticação

- POST `/api/auth/register` - Registra um novo usuário
- POST `/api/auth/authenticate` - Autentica um usuário e retorna um token JWT

### Usuários

- GET `/api/users/me` - Retorna os dados do usuário atual
- PUT `/api/users/me` - Atualiza os dados do usuário atual
- GET `/api/users` - Lista todos os usuários (apenas admin)
- GET `/api/users/{id}` - Retorna um usuário específico (apenas admin)
- PUT `/api/users/{id}` - Atualiza um usuário específico (apenas admin)
- DELETE `/api/users/{id}` - Remove um usuário (apenas admin)

## Exemplos de Uso

### Registro de Usuário

```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Admin User",
    "email": "admin@example.com",
    "password": "password123",
    "role": "ADMIN"
  }'
```

### Autenticação

```bash
curl -X POST http://localhost:8080/api/auth/authenticate \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@example.com",
    "password": "password123"
  }'
```

### Acessando Endpoints Protegidos

```bash
curl -X GET http://localhost:8080/api/users \
  -H "Authorization: Bearer {seu_token_jwt}"
```