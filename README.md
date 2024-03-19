
# API de CRUD de Produtos

Este projeto é uma API CRUD para gerenciamento de produtos.
Foi desenvolvido seguindo os princípios do Desenvolvimento Guiado por Testes (TDD) e está estruturado usando a arquitetura de Design Dirigido pelo Domínio (DDD). O projeto utiliza o MapStruct para mapeamento de objetos, garantindo uma conversão perfeita entre entidades e DTOs. Além disso, impõe padrões de codificação através do uso do Checkstyle.

## Recursos

- Funcionalidade CRUD completa para produtos.
- Práticas de TDD.
- Arquitetura DDD.
- Mapeamento de objetos com MapStruct.
- Consistência de código com Checkstyle.
- Contêinerização com Docker.

## Pré-requisitos

Antes de executar este projeto, você precisará de:

- Docker
- Docker Compose

## Início Rápido

Para colocar o projeto em funcionamento na sua máquina local, siga estes passos:

1. Clone o repositório:

```bash
git clone [https://github.com/Marcos653/ProductCrud-TDD-DDD]
cd [ProductCrud-TDD-DDD]
```

2. Inicie a aplicação usando o Docker Compose:

```bash
docker-compose up --build
```

Este comando construirá a imagem Docker para o `products-service` e iniciará os serviços definidos no arquivo `docker-compose.yml`.

3. Acesse a aplicação em `http://localhost:8080`.

## Banco de Dados

A aplicação está configurada para usar o PostgreSQL. A configuração do Docker Compose inclui um serviço `postgre-db` que executa o PostgreSQL e inicializa o banco de dados `products`.

## Desenvolvimento

Para executar o Checkstyle para análise de código:

```bash
mvn checkstyle:check
```

Para executar testes e verificar a aplicação:

```bash
mvn clean test
```

Para informações detalhadas sobre os endpoints fornecidos e como usá-los, consulte a documentação da API em `http://localhost:8080/swagger-ui.html`.

## Contribuindo

Sinta-se à vontade para fazer fork do repositório, fazer alterações e enviar pull requests. Por favor, certifique-se de que seus commits seguem o formato convencional de commits e que todos os testes estão passando.

## Licença

Este projeto é de código aberto sob a [licença MIT](LICENSE).
