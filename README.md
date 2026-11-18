# Sistema de Gerenciamento de Biblioteca

Aplicação desenvolvida em Java para controle e gerenciamento dos registros de uma biblioteca, incluindo catálogo de livros, cadastro de usuários e operações de empréstimos e devoluções.

## 📚 Funcionalidades

- **Controle de Livros**:
  - Cadastro de novos livros com título, autor e ano de publicação.
  - Atualização dos dados do livro.
  - Consulta detalhada por identificador e listagem completa.
  - Remoção de livros (apenas permitida quando o livro estiver disponível).

- **Controle de Usuários**:
  - Cadastro de usuários com nome e e-mail.
  - Atualização de dados cadastrais.
  - Consulta e listagem dos usuários.
  - Remoção de usuários (apenas permitida se não houver empréstimos pendentes).

- **Empréstimos e Devoluções**:
  - Realização de empréstimo com vinculação do livro ao usuário e atualização do status de disponibilidade.
  - Bloqueio de empréstimo para livros já ocupados.
  - Devolução de livros com validação do usuário responsável e liberação do exemplar.
  - Controle da quantidade de empréstimos ativos por usuário.

## 📁 Estrutura do Projeto

```
sistema-biblioteca/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/lp2/biblioteca/
                ├── model/          # Classes de entidade (Livro, Usuario)
                ├── dto/            # Objetos de transferência de dados (UpdateLivroDTO, UpdateUsuarioDTO)
                ├── repository/     # Repositórios de dados em memória
                ├── service/        # Regras de negócio e operações de empréstimo/devolução
                └── Main.java       # Ponto de entrada e fluxo de demonstração
```

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 17 ou superior
- Apache Maven

### Compilação e Execução
Na raiz do projeto:

```bash
# Compilar o projeto
mvn clean compile

# Executar a classe principal
mvn exec:java -Dexec.mainClass="com.lp2.biblioteca.Main"
```
