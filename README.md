# Cidadão Conectado

**Cidadão Conectado** é uma plataforma digital que permite aos cidadãos de Ananindeua participar ativamente em propostas e decisões que impactem a qualidade de vida urbana. A plataforma oferece um espaço para submissão de propostas, votação e acompanhamento das ideias mais discutidas pela comunidade.

## Checklist do MVP - Cidadão Conectado

### 1. Cadastro e Login de Usuários
- [ ] Implementar o sistema de autenticação para criação de contas e login.
- [ ] Configurar autenticação com JSON Web Tokens (JWT).

### 2. Submissão de Propostas
- [ ] Desenvolver o formulário para submissão de propostas.
- [ ] Implementar categorias predefinidas (transporte, segurança, meio ambiente, etc.).
- [ ] Salvar as propostas no banco de dados.

### 3. Votação nas Propostas
- [ ] Exibir uma lista de propostas para votação.
- [ ] Implementar restrição para que cada usuário possa votar apenas uma vez por proposta.
- [ ] Salvar os votos no banco de dados.

### 4. Painel de Transparência
- [ ] Desenvolver o dashboard básico para exibir as propostas mais votadas.
- [ ] Garantir que o painel esteja acessível a todos os usuários.

### 5. Feedback Simples
- [ ] Implementar sistema de comentários nas propostas.
- [ ] Criar um sistema básico de moderação de comentários.

### 6. Testes e Feedback
- [ ] Realizar testes funcionais para verificar o funcionamento de cada módulo.
- [ ] Coletar feedback de um pequeno grupo de usuários.
- [ ] Implementar ajustes baseados no feedback recebido.

## Tecnologias Utilizadas

- **Frontend:**
    - React.js para construção da interface do usuário.
    - Design responsivo para garantir acessibilidade em dispositivos móveis e desktops.

- **Backend:**
    - Spring Boot (Java) para desenvolvimento da API RESTful.
    - Spring Security para autenticação e autorização.
    - JPA/Hibernate para persistência de dados.
    - Banco de dados MySQL ou PostgreSQL para armazenamento de dados.

## Configuração do Ambiente de Desenvolvimento

### Pré-requisitos

- **Java 17**
- **Maven**
- **MySQL ou PostgreSQL**
