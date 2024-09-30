# JDBC User Authentication System

## Overview

This project is a simple user authentication system built using Java and JDBC, with MySQL as the database. Users can register with a username and password, and later log in to validate their credentials. The system is designed to be secure against SQL injection attacks and handles various scenarios like empty input fields and duplicate usernames.

## Features

- **User Registration**: Allows new users to create an account by providing a username and password.
- **User Login**: Enables existing users to log in using their credentials.
- **Input Validation**: Checks for empty username or password fields and provides appropriate feedback.
- **Duplicate Username Handling**: Prevents users from registering with an already existing username.
- **Secure Password Handling**: Uses prepared statements to prevent SQL injection attacks.

## Technologies Used

- **Java**: The programming language used to implement the authentication system.
- **JDBC**: Java Database Connectivity for interacting with the MySQL database.
- **MySQL**: The database used to store user credentials.


## Prerequisites

- Java Development Kit (JDK) installed (version 8 or above).
- MySQL server installed and running.
- MySQL JDBC driver (included in the `lib` directory).

## Database Setup

1. Open the MySQL command line or any MySQL client.
2. Create a new database (if you haven't already):

## Compile

javac -cp .;lib/mysql-connector-java-9.0.0.jar UserAuthentication.java DatabaseConnection.java

## Run 

java -cp .;lib/mysql-connector-java-9.0.9.jar UserAuthentication



