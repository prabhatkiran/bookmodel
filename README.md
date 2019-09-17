# bookmodel
spring boot REST API for bookmodel. i.e a book a catalog


To run the application, clone this repository into and IDE(i have used Eclipse version 2018-12 (4.10.0)) or download the repository as .zip --> extract the project and import it in your IDE.

browse through com.sap.book, select Application.java class, right click and select run as --> Java Application.

once the application is successfully started. The spring boot application will be running on "locahost:8080" and can be accessed by hitting the endpoint "localhost:8080/books" on a browser or via POSTMAN.

You can test the API via the  POSTMAN Client by sending GET, PUT, POST, DELETE request to validate the CRUD scenarios supported by the API.

Please refer to the file "Books inventory.postman_collection.json" for sample request formats and required payloads in order to execute PUT, POST and other requests.

The Rest API is running on an in-memory version of H2 database to store book information. P.S- as the database used is a local one, therefore the db gets initialized every time the service is being started.

In order to run test cases for the given application, right click on the project --> Coverage as --> JUnit tests.
