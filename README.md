# 📚Stack Literária 
> Sistema de catálogo de livros desenvolvido em Java + Spring Boot, com integração a API externa para busca de obras e persistência em banco de dados utilizando JPA/Hibernate.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) 
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
### 🚀 Sobre o Projeto

O Stack Literária é uma aplicação backend desenvolvida durante o curso de Java & Spring Boot da Alura, com o objetivo de consolidar conhecimentos em:

<ul>
 <li>Java</li>
  
  <li>Programação Orientada a Objetos</li>
  
  <li>Spring Boot</li>
  
  <li>Spring Data JPA</li>
  
  <li>Hibernate</li>
  
  <li>Consumo de API externa</li>
  
  <li>Persistência em banco de dados relacional</li>
  
  <li>Manipulação de Streams</li>
  
  <li>Modelagem de entidades e relacionamentos</li>
</ul>
<hr>

### 🛠 Tecnologias Utilizadas
<ul>
 <li>Java 17</li>
  
  <li>Spring Boot</li>
  
  <li>Spring Data JPA</li>
  
  <li>Hibernate</li>
  
  <li>Maven</li>
  
  <li>Banco de dados relacional (PostgreSQL)</li>
  
 <li>API Gutendex</li>
</ul>


<hr>

### 🗂️ Estrutura do projeto

com.devraaf.stackLiteraria <br>
│ <br>
├── model        → Entidades e records (Autor, Livro, DTOs)<br>
├── repository   → Interfaces JPA<br>
├── service      → Regras de negócio<br>
└── main         → Classe principal da aplicação<br>

<hr>

### ⚙️ Funcionalidades e demonstração 

<table>
  <tr>
    <td valign="top">
<br>
🔎 Buscar livro por nome (consumindo API externa) <br>
     <br>
🗃️ Registrar livro no banco de dados<br>
      <br>
👤 Registrar autor automaticamente<br>
      <br>
📚 Listar livros cadastrados<br>
      <br>
👨🏽‍🏫 Listar autores cadastrados<br>
      <br>
📅 Listar autores vivos em um determinado ano<br>
      <br>
🌐 Filtrar livros por idioma<br>
</td>

<td>

![stack-literaria](https://github.com/user-attachments/assets/f53088e1-c881-4bf5-a585-88a3a1555755)

</td>
  </tr>
</table>

### ▶️ Como executar
1. Clone o repositório <br>
   `git clone https://github.com/devraaf/stack-literaria.git`
2. Entre na pasta <br>
  `cd stack-literaria`
3. Execute a aplicação <br>
  `./mvnw spring-boot:run`


<hr>

#### 👩🏽‍💻 Desenvolvido por Rafaela
Projeto educacional para fins de aprendizado.
