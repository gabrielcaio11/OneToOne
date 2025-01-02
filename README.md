
# Cadastro de Clientes com Endereços - Relacionamento @OneToOne no JPA

## 📚 Introdução

Este projeto exemplifica o uso do relacionamento `@OneToOne` no JPA para modelar um sistema onde cada cliente possui um endereço associado. A relação `@OneToOne` foi escolhida por refletir a necessidade de uma correspondência única entre um cliente e seu endereço no contexto da aplicação. O projeto explora como realizar operações de CRUD (Criar, Ler, Atualizar, Excluir) com o relacionamento e utiliza operações em cascata para simplificar a gestão de dados relacionados.

---

## 💡 Descrição do Projeto

O sistema de cadastro de clientes permite:
1. **Criar um cliente com seu endereço associado.**
2. **Atualizar os dados do endereço de um cliente existente.**
3. **Remover um cliente e excluir automaticamente seu endereço relacionado.**

As operações são realizadas por meio de uma API RESTful, implementada com Spring Boot.

---

## 🛠️ Tecnologias e Dependências

### Tecnologias Utilizadas:
- **Java 21**
- **Spring Boot 3.4.1**
- **Spring Data JPA**
- **Banco de dados H2 (em memória)**
- **Spring Web**

### Dependências do Projeto:
1. **Spring Boot Starter Data JPA**
2. **Spring Boot Starter Web**
3. **H2 Database**

No arquivo `pom.xml`:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

## 🚀 Endpoints do ClienteController

### 1. **Criar Cliente e Endereço**
**URL:** `POST /clientes`  
**Descrição:** Adiciona um novo cliente com seu endereço.

**JSON de Requisição:**
```json
{
  "nome": "João Silva",
  "endereco": {
    "logradouro": "Rua das Flores",
    "bairro": "Jardim",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "12345-678"
  }
}
```

**JSON de Resposta:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "endereco": {
    "id": 1,
    "logradouro": "Rua das Flores",
    "bairro": "Jardim",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "12345-678"
  }
}
```

---

### 2. **Atualizar Endereço de um Cliente**
**URL:** `PUT /clientes/{id}/endereco`  
**Descrição:** Atualiza os dados do endereço de um cliente existente.

**JSON de Requisição:**
```json
{
  "logradouro": "Avenida Paulista",
  "bairro": "Centro",
  "cidade": "São Paulo",
  "uf": "SP",
  "cep": "87654-321"
}
```

**JSON de Resposta:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "endereco": {
    "id": 2,
    "logradouro": "Avenida Paulista",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "87654-321"
  }
}
```

---

### 3. **Buscar Cliente por ID**
**URL:** `GET /clientes/{id}`  
**Descrição:** Retorna os dados de um cliente pelo seu ID.

**JSON de Resposta (caso encontrado):**
```json
{
  "id": 1,
  "nome": "João Silva",
  "endereco": {
    "id": 1,
    "logradouro": "Rua das Flores",
    "bairro": "Jardim",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "12345-678"
  }
}
```

**Resposta (caso não encontrado):**
```json
{
  "error": "Cliente não encontrado"
}
```

---

### 4. **Remover Cliente**
**URL:** `DELETE /clientes/{id}`  
**Descrição:** Remove um cliente e exclui automaticamente o endereço associado.

**Resposta de Sucesso:**
```json
{
  "status": 204,
  "message": "Cliente removido com sucesso"
}
```

---

## 📋 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/projeto-clientes-enderecos.git
   cd projeto-clientes-enderecos
   ```

2. Configure o Maven:
   ```bash
   mvn clean install
   ```

3. Inicie o servidor:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a aplicação na URL: [http://localhost:8080](http://localhost:8080).

---

## 🧪 Testes

Os endpoints podem ser testados com ferramentas como **Postman**, **Insomnia** ou diretamente pelo terminal usando **cURL**.

Exemplo de teste com cURL:
```bash
curl -X POST http://localhost:8080/clientes \
-H "Content-Type: application/json" \
-d '{
  "nome": "João Silva",
  "endereco": {
    "logradouro": "Rua das Flores",
    "bairro": "Jardim",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "12345-678"
  }
}'
```

---

## 🤝 Contribuições

Contribuições são bem-vindas! Fique à vontade para abrir issues ou enviar pull requests.

---

## 📜 Licença

Este projeto é distribuído sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📬 Contatos
LinkedIn: [GabrielCaio](https://www.linkedin.com/in/gabriel-caio/)

