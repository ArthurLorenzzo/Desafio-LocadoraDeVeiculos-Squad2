<h1>Desafio Locadora de Veículos - SQUAD 2</h1>

<h1 align="center"> API Locadora de veículos</h1>

<div align="center">
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
    <img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white">
</div>

Este repositório contém o código-fonte e a implementação de um sistema de backend em Java para uma locadora de veículos. O objetivo deste projeto é fornecer uma plataforma para gerenciar o aluguel de veículos em uma locadora.

Trello: https://trello.com/b/QvGBf6JC/desafio-locadora-solutis

Diagrama de classes: 

<img width="576" alt="Captura de Tela 2023-08-21 às 19 19 46" src="https://github.com/ArthurLorenzzo/Desafio-LocadoraDeVeiculos-Squad2/assets/95923686/feb39195-a29a-4b2a-bf28-553575017e3d">

## Funcionalidades Principais

- **Gestão de Veículos:** Cadastro, atualização e remoção de veículos no sistema. Cada veículo possui informações como marca, modelo, ano de fabricação, disponibilidade e categoria.

- **Gestão de Clientes:** Registro e manutenção de dados dos clientes da locadora. Cada cliente é identificado por informações pessoais e de contato.

- **Reservas e Aluguéis:** Os clientes podem realizar reservas para aluguel de veículos, especificando datas de início e término. O sistema verifica a disponibilidade dos veículos e processa as reservas confirmadas em aluguéis.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação principal para a lógica de negócios e manipulação de dados.

- **Spring Framework:** Utilizado para a criação de APIs RESTful, gerenciamento de dependências e injeção de dependências.

- **Spring Boot:** Facilita a configuração e criação de aplicações Spring, reduzindo a necessidade de configurações manuais.

- **Spring Data JPA:** Abstração para o acesso e manipulação de dados no banco de dados, facilitando a persistência dos objetos Java.

- **Banco de Dados MySql:** Utilizado para armazenar informações sobre veículos, clientes, reservas e aluguéis.

## Configuração e Uso

1. Clone este repositório.

2. Configure as informações do banco de dados no arquivo `application.properties`.

3. Execute a aplicação Spring Boot.

5. Acesse a API REST em `http://localhost:8080` e utilize as rotas para interagir com o sistema.

6. Verifique também a documentação swagger da aplicação `http://localhost:8080/swagger-ui/index.html#` para ter acesso às rotas.

## Links

- Repositório: https://github.com/ArthurLorenzzo/Desafio-LocadoraDeVeiculos-Squad2

<h2>Desenvolvedores do projeto</h2> 

<img src="https://www.linkedin.com/in/arthur-lorenzzo-42465a213/overlay/photo/" width=115> <h5><b>Arthur Lorenzzo<b></h5>

<img src="https://avatars.githubusercontent.com/u/106783873?v=4" width=115> <h5><b>Matheus Araújo<b></h5>

<img src="https://avatars.githubusercontent.com/u/111322525?v=4" width=115> <h5><b>Gustavo Silva<b></h5>

<img src="https://www.linkedin.com/in/isabelle-lopez-b95470238/" width=115> <h5><b>Isabelle Carvalho<b></h5>

<img src="https://www.linkedin.com/in/guilhermevaccaro/" width=115>
<h5><b>Guilherme Vaccaro<b></h5>
