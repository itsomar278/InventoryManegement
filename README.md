# Inventory Management System

The Inventory Management System is a Java Spring Boot application designed to efficiently manage products, warehouses, orders, and customers for businesses of various scales. It provides functionalities to track inventory levels, process orders, and manage customer information.
## Swagger Hub:

Explore the API documentation on [Swagger Hub](https://app.swaggerhub.com/apis/itsomar278/Inventory_Managment_Project/1.0.0#/).

## Design Files:

### Customers:
- [Customers Design](https://github.com/itsomar278/InventoryManegement/blob/master/customers.md)

### Warehouses:
- [Warehouses Design](https://github.com/itsomar278/InventoryManegement/blob/master/warehouse.md)

### Orders:
- [Orders Design](https://github.com/itsomar278/InventoryManegement/blob/master/orders.md)

### Products:
- [Products Design](https://github.com/itsomar278/InventoryManegement/blob/master/products.md)

## Technologies Used:

- **Java**: The core programming language used for building the application logic.
- **Spring Boot**: Provides a robust framework for building enterprise-level Java applications with ease, offering features like dependency injection, MVC architecture, and auto-configuration.
- **Spring Data JPA**: Simplifies database operations by providing a high-level abstraction over JPA (Java Persistence API), enabling seamless interaction with the database.
- **Hibernate**: Acts as the JPA provider, handling object-relational mapping and database interactions.
- **MySQL**: A relational database management system used for storing and managing structured data. MySQL is utilized to persist application data efficiently.
- **Lombok**: Reduces boilerplate code by automatically generating getters, setters, constructors, and other repetitive code structures.
- **RESTful APIs**: Utilized for communication between the client-side and server-side components, facilitating the exchange of data in a standardized and stateless manner.
- **Git**: Version control system used for managing project source code, enabling collaboration among team members and maintaining code integrity.
- **Maven**: Dependency management tool used for building, packaging, and managing project dependencies, ensuring consistent and reproducible builds.
- **IDE**: Integrated Development Environment such as IntelliJ IDEA or Eclipse used for coding, debugging, and managing project files efficiently.

## Features:

- **Product Management**: Allows adding, updating, and deleting products, including attributes like name, category, price, and supplier.
- **Warehouse Management**: Facilitates management of warehouses, including name, location, and capacity.
- **Inventory Tracking**: Tracks inventory levels by associating products with warehouses and storing quantities.
- **Order Processing**: Enables creation, updating, and cancellation of orders, with functionalities for tracking order status and total amount.
- **Customer Management**: Manages customer information, including first name, last name, phone number, and address.

## Usage:

1. Clone the repository: `git clone https://github.com/itsomar278/InventoryManegement
2. Navigate to the project directory: `cd inventory-management-system`
3. Build the project: `mvn clean install`
4. Run the application: `java -jar target/inventory-management-system.jar`
5. Access the application via the provided base URL and explore the functionalities through the Swagger Hub.

## Contributors:

- [Omar Badawi](https://github.com/itsomar278)





