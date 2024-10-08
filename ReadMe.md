# Microsserviço de Proposta de Análise de Crédito

## Marcelo Lopez Rodriguez Filho RM 94592

## Visão Geral
Este projeto consiste em um microsserviço para o gerenciamento de propostas de análise de crédito para uma financeira. A aplicação permite o cadastro de usuários e a criação de propostas de crédito, que posteriormente serão analisadas para aprovação. O sistema realiza as operações CRUD para as entidades User e Proposta, armazenando os dados em um banco de dados H2.

## Arquitetura do Projeto
O projeto foi desenvolvido em Java utilizando o Spring Boot e segue uma arquitetura em camadas com os seguintes módulos:
- **Model**: Define as classes de domínio do sistema (User e Proposta).
- **DTO** (Data Transfer Object): Contém as classes de transferência de dados que facilitam a comunicação entre as camadas.
- **Repository**: Interfaces que fornecem acesso aos dados utilizando o Spring Data JPA.
- **Service**: Implementa a lógica de negócios e realiza operações de CRUD através dos repositórios.
- **Controller**: Exponha os endpoints REST para manipulação das entidades User e Proposta.

## Tecnologias Utilizadas
- **Java 17**: Linguagem de programação principal.
- **Spring Boot 3.2.X**: Framework para construção do microsserviço.
- **Spring Data JPA**: Abstração de persistência para trabalhar com bancos de dados relacionais.
- **H2 Database**: Banco de dados em memória utilizado para testes e desenvolvimento.
- **Lombok**: Biblioteca para reduzir a verbosidade do código, gerando automaticamente getters, setters, e outras funcionalidades.
- **ModelMapper**: Biblioteca para facilitar o mapeamento de objetos entre as camadas.
- **Maven**: Ferramenta de gerenciamento de dependências e construção do projeto.

## Funcionabilidades
### CRUD de Usuários
- Create: Permite a criação de novos usuários no sistema.
- Read: Consulta usuários cadastrados, com operações de listagem (findAll) e busca por ID (findById).
- Update: Permite a atualização dos dados de um usuário existente.
- Delete: Exclui um usuário do sistema.

## Cadastro de Propostas
- **Create**: Criação de novas propostas de crédito associadas a um usuário.
- **Read**: Listagem de todas as propostas cadastradas e busca por ID.
- **Proposta Inicial**: Ao ser criada, a proposta é marcada como não aprovada. A análise será realizada em outro microsserviço.
