<div align="center">
<img src="https://solutis.com.br/wp-content/uploads/2018/04/logo_solutis_401-2.png">
</div>
<h1 align="center">Desafio Estágio SOLUTIS - SQUAD 2<br>API Locadora de veículos</h1>

<div align="center">
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
    <img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white">
</div>
<p align="center"><br>
    <img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge">
</p>
<p>Este repositório contém o código-fonte e a implementação de um sistema de backend em Java para uma locadora de veículos. O objetivo deste projeto é fornecer uma plataforma para gerenciar o aluguel de veículos em uma locadora.</p>

Trello: https://trello.com/b/QvGBf6JC/desafio-locadora-solutis

<h2>Diagrama de classes:</h2> 

<div align="center">
<img width="576" alt="Captura de Tela 2023-08-21 às 19 19 46" src="https://github.com/ArthurLorenzzo/Desafio-LocadoraDeVeiculos-Squad2/assets/95923686/feb39195-a29a-4b2a-bf28-553575017e3d">
</div>

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
<table style="width:100%">
  <tr align=center>
    <th><strong>Arthur Lorenzzo</strong></th>
    <th><strong>Guilherme Vaccaro</strong></th>
    <th><strong>Gustavo Silva</strong></th>
    <th><strong>Isabelle Carvalho</strong></th>
    <th><strong>Matheus Araújo</strong></th>
  </tr>
  <tr align=center>
    <td>
      <a href="https://github.com/ArthurLorenzzo">
        <img width="200" height="180" src="https://avatars.githubusercontent.com/u/95923686?v=4">
      </a>
    </td>
    <td>
      <a href="https://github.com/guilhermevaccaro">
        <img width="200" height="180" src="https://avatars.githubusercontent.com/u/109315604?v=4">
      </a>
    </td>
    <td>
      <a href="https://github.com/GustavoSilvalgs">
        <img width="200" height="180" src="https://avatars.githubusercontent.com/u/111322525?v=4">
      </a>
    </td>
    <td>
      <a href="https://github.com/IsabelleCarvallho">
        <img width="200" height="180" src="https://avatars.githubusercontent.com/u/110946274?v=4">
      </a>
    </td>
    <td>
      <a href="https://github.com/mmatheusaraujoo">
        <img width="200" height="180" src="https://avatars.githubusercontent.com/u/106783873?v=4">
      </a>
    </td>
  </tr>
</table>
