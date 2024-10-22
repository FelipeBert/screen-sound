# Screen Sound Music

**Screen Sound Music** é uma aplicação simples para gerenciar artistas e suas músicas. Ela permite cadastrar cantores, suas músicas e listar informações sobre eles, utilizando Spring Boot, JPA, e PostgreSQL como banco de dados.

## Funcionalidades

- **Cadastro de Artistas**: Registre artistas com nome, nacionalidade, gênero musical e tipo de artista.
- **Cadastro de Músicas**: Associe músicas a artistas, incluindo nome da música, avaliação e número de visualizações.
- **Listagem de Artistas**: Visualize todos os artistas cadastrados no sistema com suas respectivas informações.
- **Listagem de Músicas por Artista**: Consulte todas as músicas associadas a um artista específico.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Jakarta Persistence API (JPA)**

## Estrutura do Projeto

- `Cantor`: Entidade que representa o artista com informações como nome, nacionalidade, gênero musical e tipo de artista.
- `Musica`: Entidade que representa a música, contendo o nome da música, avaliação, visualizações e a relação com o artista.
- `GeneroMusical` e `TipoArtista`: Enumerações usadas para definir o gênero musical e o tipo de artista (ex: solo, dupla, banda).
- `CantorRepository`: Repositório responsável pelas operações de banco de dados relacionadas ao cantor.
- `ICantorService`: Interface que define os serviços para gerenciar artistas e músicas.
- `CantorServiceImpl`: Implementação da interface de serviço.
- `Principal`: Classe principal que exibe o menu para interação com o usuário.

## Configuração do Banco de Dados

Certifique-se de configurar corretamente o banco de dados PostgreSQL nas variáveis de ambiente ou no arquivo `application.properties`.

```properties
spring.application.name=screen-Music
spring.datasource.url=jdbc:postgresql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.datasource.driver-class-name=org.postgresql.Driver
hibernate.dialect=org.hibernate.dialect.HSQLDialect

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true

```

Substitua as variáveis ${DB_HOST}, ${DB_NAME}, ${DB_USERNAME}, ${DB_PASSWORD} com as suas respectivas configurações de ambiente.

## Como Executar

1. Clone o repositório.
2. Configure as variáveis de ambiente para o banco de dados.
3. Execute o comando:
   ```bash
   ./mvnw spring-boot:run
    ```

4. Ao iniciar a aplicação, você verá um menu de interação no terminal, onde poderá cadastrar artistas e músicas, e listar as informações.

## Exemplo de Uso

***Screen Sound Music***

1. Cadastrar Artista
2. Cadastrar Música
3. Listar Artistas
4. Buscar Músicas por Artista 

9. Sair

Selecione uma das opções e siga as instruções para gerenciar artistas e músicas.

## Contribuição
Sinta-se à vontade para abrir issues ou enviar pull requests.
