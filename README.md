# Sistema de Gestão Solidária para Associação de Moradores

MVP web que organiza o cadastro de famílias, o registro de atendimentos e o controle de estoque de uma associação de moradores.

## Problema
O controle manual em cadernos e planilhas gera cadastros duplicados, entregas repetidas e divergência de estoque.

## Público
Voluntários e coordenadores da associação (usuários diretos); famílias atendidas e doadores (beneficiados indiretos).

## ODS
ODS 2 – Fome Zero e Agricultura Sustentável (meta 2.1).

## Funcionalidades do MVP
- RF01 Buscar família por nome ou documento
- RF02 Cadastrar família com alerta de duplicidade
- RF03 Controlar itens e saldo de estoque
- RF04 Registrar atendimento com baixa de estoque
- RF05 Relatório mensal (desejável)

## Tecnologias
Java 21, Spring Boot 3, Spring Data JPA, Spring Security, PostgreSQL, Bootstrap, Maven.

## Estrutura
src/main/java ... código (controller, service, repository, model)
src/main/resources ... configurações e scripts SQL
docs ... prototipo, requisitos e plano de validação

## Como executar
(será preenchido durante o desenvolvimento)

## Status
Em desenvolvimento. Dados de demonstração fictícios.

## Como executar
Requisitos: Java 21 e Git.

    git clone https://github.com/lottarferk/sistema-gestao-solidaria-mvp.git
    cd sistema-gestao-solidaria-mvp
    mvnw.cmd spring-boot:run

No Linux ou Mac, use ./mvnw no lugar de mvnw.cmd.

A aplicação sobe em http://localhost:8080 com banco H2 em memória.
Usuário: user. A senha é gerada a cada execução e aparece no terminal,
na linha "Using generated security password".

## Testes

    mvnw.cmd test

## Endpoints disponíveis
- GET /api/familias?q=nome: busca famílias por nome ou documento
- POST /api/familias: cadastra uma família e devolve alerta de duplicidade
  (código 409) quando já existe cadastro com nome e telefone parecidos