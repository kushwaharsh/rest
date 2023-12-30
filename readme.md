
# Bookstore REST API

This project implements a simple REST API using Apache Camel for managing a collection of books.This API provides CRUD (Create, Read, Update, Delete) operations for managing books. It allows users to perform actions such as adding a new book, retrieving book details, updating book information, and deleting books from the system.

## Prerequisites

- Java (JDK 8 or higher)
- Apache Maven

## Build

To build the project, navigate to the project root directory and run the following Maven command:

```bash
mvn clean install
```
## Run

To run the application:

```bash
mvn camel:run
```

The application will start on http://localhost:8080.

-API Endpoints
- GET /books: Retrieves a list of all books.
- GET /books/{id}: Retrieves details of a specific book.
- POST /books: Adds a new book.
- PUT /books/{id}: Updates an existing book.
- DELETE /books/{id}: Deletes a book.

## Example Requests

- GET /books
```bash
curl http://localhost:8080/books
```

- GET /books/{id}
```bash
curl http://localhost:8080/books/123
```

- POST /books
```bash
curl -X POST -H "Content-Type: application/json" -d '{"id": "123", "title": "New Book", "author": "John Doe", "publicationYear": 2023}' http://localhost:8080/books
```

- PUT /books/{id}
```bash
curl -X PUT -H "Content-Type: application/json" -d '{"title": "Updated Title", "author": "Jane Smith", "publicationYear": 2025}' http://localhost:8080/books/123
```

- DELETE /books/{id}
```bash
curl -X DELETE http://localhost:8080/books/123
```
## Testing

To run unit tests:

```bash
mvn test
```
## Project Structure

The project follows this structure:

- src/main/java/com/example/restAPI: Contains source code files.
   - model: Contains the Book class.
   - routes: Contains the BookstoreRoute defining API endpoints.
   - service: Contains the BookService handling CRUD operations.
- src/test/java/com/example/restAPI/routes: Contains unit tests for routes.
## Additional Information

- Error handling is implemented for various scenarios, providing appropriate HTTP status codes.
- Ensure proper data formats while making requests (e.g., publicationYear as an integer).