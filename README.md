Delivery application
Description
The delivery application of the project is a web application for managing parcel shipments. Users can create orders for sending parcels and manage their profile.

Main functions
User management: Create new users, view and edit existing users.
Order management: Create new orders, view and edit existing orders.
Parcel management: Create new parcels, view and edit existing parcels, as well as the ability to register parcels.

Project structure
The project consists of three main entities:
Users: Stores information about registered users.
Orders: Contains data about orders for sending parcels, including information about the recipient, sender and order status.
Parcels: Contains information about each package created.

Technologies
Java Spring Boot: Used to develop the backend of the application.
Spring Data JPA: For database interaction and entity management.
FeignClient: For creating REST API clients and interacting with other microservices.
JPAQueryFactory: Provides a convenient way to create and run database queries using JPQL

