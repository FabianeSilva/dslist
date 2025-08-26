# API (Interface de Programação de Aplicações) de uma Lista de Games
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)  ![Postman](https://img.shields.io/badge/Postman-FF6C37.svg?style=for-the-badge&logo=Postman&logoColor=white)

Este projeto é uma API (Interface de Programação de Aplicações) utilizando JAVA e Spring Boot, para criar uma listagem de games após cadastro com várias informações: título, gênero, descrição curta, descrição longa, etc, conforme elaborado no Intensivão Java Spring de Nelio Alves, desenvolvedor e professor Universitário, para obter maior conhecimento na linguagem.

## Modelo de Domínio

<img width="822" height="288" alt="image" src="https://github.com/user-attachments/assets/9aed552e-b08e-4a8c-8e6c-c713862f9e84" />

  
## Ferramenta utilizada para realização de testes
Para verificar se o código estava funcionando corretamente foi utilizada a Ferramenta POSTMAN, apresentando a mensagem abaixo relacionada no Body do GET - que lista a relação de jogos:

    {
        "id": 1,
        "title": "Mass Effect Trilogy",
        "year": 2012,
        "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png",
        "shortDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!"
    },
    {
        "id": 2,
        "title": "Red Dead Redemption 2",
        "year": 2018,
        "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/2.png",
        "shortDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!"
    },
    {
        "id": 3,
        "title": "The Witcher 3: Wild Hunt",
        "year": 2014,
        "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/3.png",
        "shortDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!"
    }

