# integrationIA

Finch - Solução Integração API IA

 * Devido ao fato de não ter conseguido acessar as APIs de Ata e Publicação, eu recriei elas para poder desenvolver a integração.

A arquitetura desenvolvida para esse desafio é a arquitetura de microserviços que está dividida em:

service-Wrapper: API responsável por receber as requisições externas a aplicação ou até mesmo de front-end, gerindo todas as requisições para os serviços que possuem a regra de negócio;

service-Security: API responsável pela segurança da aplicação onde possui os usuários, domínios e regras de acesso (Estrutura pronta para tal). Quando o Wrapper solicita o login, é gerado um token (JWT) para dar acesso aos outros microserviços;

service-ExternalApi: API contendo a regra de negócio responsável por persistir os dados das Urls em questão. Nessa API foi simulado os conteudos das Atas e Publicação com os verbos https requisitados.



Itens contemplados:

Restfull, RestTemplate, API Rest)

Spring boot (Data, Web, Starter)

UML - Diagramas de Pacotes e Componentes apenas

Logging in Spring Boot - Utilizado o próprio log do Spring, onde foi realizado exemplos básicos de utilização dentro do service-ExternalApi.

Database (H2, MYSQL, Liquibase)

Docker (Criado script para containers de banco e microserviço, desenvolvido em um servidor Ubuntu-Server (simulado ambiente de produção)

Security (JWT, AuthenticationFilter nas API's)

Swagger (Documentação realizada apenas na API Wrapper, única API externa)

Clean Code

WireMockServer (Configurado no wrapper para simular as requisições aos microserviços)

Groovy (Teste funcional de exemplo, apenas realizado no microservice service-ExternalApi.(Rest asurred, Framework spock)

Gradle (Gerenciamento de pacotes) - Linguem Groovy ao invés de XML, e dá suporte a repositórios maven com uma linguagem mais flexível através de scripts, permitindo que você customize seu arquivo de configuração	

Item não contemplado: Front-end, foquei o desenvolvimento na estrutura e APIs para integração apenas. Devido ao tempo não realizado o desenvolvimento do front.
