O projeto consiste em uma concessionaria de carros onde é feito o gerenciamento de Marca, Modelo e Veiculo.

Foi usado o Java 17 com framework Spring boot para a construção do back-end;
Em conjunto com algumas bibliotecas para o gerenciamento do projeto, segue abaixo as bibliotecas usadas:
  
  Spring Boot Starter Validation: para validação de entrada de dados;
  Spring Boot Starter Data JPA: para a interação com o banco de dados;
  Spring Boot Starter Web: para a esposição dos end-points para a api rest-full;
  FlywayDB: para a construção das tabelas no banco de dados;
  Lombok: para produtividade na construção de codigos;
  SpringDoc OpenAPI Starter WebMVC UI: para a documentação da api;
  HSQLDB (HyperSQL Database): é um mecanismo de banco de dados relacional escrito em Java, versão da versão 2.7 oferece muitos recursos e adere de perto aos mais recentes padrões SQL e JDBC 4.
  Spring Boot Starter Test: Atividade para testar aplicações Spring Boot com bibliotecas incluindo JUnit Jupiter, Hamcrest e Mockito.

Disposição dos pacotes dentro da aplicação:
  /config: pacote responsavel pelas configurações do sistema;
  /domain: responsavel pelo dominio da aplicação, onde se concentra as representações das tabelas do sistemas;
  /exception: é responsável pelo tratamento de erros da api;
  /factory: responsavel pela conversão das entidade do dominio em DTO's para a exibição para o cliente;
  /gateway: é responsavel pela exposição dos end-points da api;
  /repository: é responsavel pela iteração com o banco de dados;
  /service: responsavél por toda a regra de negocio;
