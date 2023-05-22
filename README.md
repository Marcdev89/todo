# To-Do application

To-Do application is an app where users can create, edit and search tasks. 

### Technologies and tools

- Maven project
- Java (v17)
- Spring Boot (v3.0.6)
- Dependencies:
  - Spring Web
  - Spring Data JPA
  - MySQL Database
  - Thymeleaf. 
  - JUnit (v4.13.2)
  - Mockito (v5.3.1)

## Installation/Config

1 - Clone the repository in your localhost.

2- Create "env.properties" file.

3- Add in this file your database name, user and password as follows:

```bash
DB_DATABASE=yourdbname
DB_USER=yourdbusername
DB_PASSWORD=yourdbpassword
```
4- Execute the file "todo.sql" to fill the database in MySQL (this file is in "sql dump" folder).

5- This app is executed by default in port: 8080 (you can change it in "application.properties")
## Usage

```
1. Open your browser.
2. Enter the URL: http://localhost:8080
3. Use the UI to search, create and edit tasks.
```




