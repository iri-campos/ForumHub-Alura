# Fórum Hub

[![Java Version](https://img.shields.io/badge/Java-17%2B-%23ED8B00?style=for-the-badge&logo=openjdk)](https://openjdk.java.net/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)


Fórum Hub é uma API RESTful desenvolvida em **Java com Spring Boot**, que simula a estrutura básica de um fórum de discussões. A aplicação permite o cadastro de usuários, cursos, tópicos de discussão e respostas, incluindo funcionalidades como autenticação com JWT, validação de dados e controle de erros.

## 🌐 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security**
- **Spring Boot DevTools**
- **Validation (Jakarta Bean Validation)**
- **Flyway (para versionamento do banco de dados)**
- **MySQL Driver**
- **Lombok**
- **Maven**


## 🚀 Funcionalidades

- Cadastro, listagem, atualização e exclusão de tópicos

- Evita duplicidade de título e mensagem

- Valida existência do curso e autor

- Soft delete com campo ativo

- Validações com retorno customizado de erros


## 🔐 Segurança

A aplicação implementa autenticação com **Spring Security** e **JWT**. Todas as rotas são protegidas, exceto a de login.

### Exemplo de autenticação:
```http
POST /login
{
  "login": "usuario@email.com",
  "senha": "123456"
}
```
A resposta conterá o token JWT, que deve ser enviado nas próximas requisições:
```http
Authorization: Bearer SEU_TOKEN_JWT
```


## 🧑‍💻 Autor
</p>
<p align="center">
Desenvolvido com 💙 por <strong>Iridiana Campos</strong>
</p>
<p align="center">
