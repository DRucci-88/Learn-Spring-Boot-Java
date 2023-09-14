User and Role

## Spring Security Model
- Spring security defines a framework for security
- Implemented using Servlet filters in the background
- Securing an app : declarative and programmatic

### Servlet Filters
- Used to pre-process / post-process web requests
- Can route web requests based on security logic
- Bluk of security functionality with servlet filters

## Concepts
- Authentication
	- Check user id and password with credentials stored in app / db
- Authorization
	- Check to see if user has an authorized role
	- 2 levels

## Declarative Security
- Define applications`s security constraints in configuration
- Provides separation of concerns between application code and security 

## Programmatic Security
- Spring security provides an API for custom application coding
- Provides greater customization for spcific app requirements

## Basic Configuration
1. Create spring security configuration (`@Configuration`)
2. Add users, passwords and roles
	- 

## Pasword Storage
Passwords are soted using a specific format
`{id}encodedPassword`
Id :
- noop = Plain text passwords
- bcrypt = BCrypt password hashing

## Retrict URL based on Roles

General syntax :
- Restrict access to a given path / endpoint
- Only Single Role :
```java
requestMatchers(<< add path to match on >>)
	.hasRole(<< authorized role >>)
```
- Specify HTTP method :
```java
requestMatchers(<< add HTTP METHOD to match on >>, << add path to match on >>)
	.hasRole(<< authorized role >>)
```
- Any role with comma-delimited list
```java
requestMatchers(<< add HTTP METHOD to match on >>, << add path to match on >>)
	.hasAnyRole(<< list of authorized role >>)
```

## Cross-Site Request Forgery (CSRF)
- Spring security can protect againts CSRF attacks
- Embed additional authentication data / token into all HTML forms
- On subsequent requests, web app will verify token before processing
- Primary use case is traditional web applications (HTML forms etc ...)

When to use CSRF Protection :
- Spring security team recommends
	- Use CSRF protection for any normal browser web requests
	- Traditional web apps with HTML forms to add / modify data
- If you are building a REST API for non-browser clients
	- You may want to disable CSRF protection
- In general, not required for stateless REST APIs
	- That use POST, PUT, DELETE and PATCH

## JDBC Authentication
- Spring security can read user account info from database
- By defaults, you have to follow Spring's Security predefined table schemas
- Following their schemas and will include JDBC code to actually read information from the database
	- Minimaze java code
- Just set up configuration, create appropiate table and voillaa
- Still can be customized the table schemas
	- You will responsible for developing the code to access the data

Development Process
1. Develop SQL scripts to set up database
2. Add database support to Maven POM file
3. Create JDBC properties file
4. Update spring security configuration to use JDBC

Default Spring Security Database Schemas
- Table `users` 
	- username
	- password
	- enable
- Table `authorities`
	- username
	- authority

Internally Spring Security uses `ROLE_` prefix

## Password Storage
- Best practice is store passwords in an encrypted format
- Spring team recommendeds using `bcrypt` algorithm
- `bcrypt`
	- Perform one-way encrypted hashing
	- Adds a random salt to the password for additional protection
	- Includes support to defeat brute force attacks

### Login Process
REST Client <--> Spring Security Filters <--> Database
1. Retrieve password from db for the user
2. Read the encoding algorithm id (bcrypt etc)
3. For case of bcrypt, encrypt plaintext password from login form (using salt from db password)
4. Compare encrypted passowrd from Client with encrypted password from db
5. If match => successful

## Custom Tables for JDBC Authentications
Create security schema customization
- Tell spring how to query your custom tables
- Provide query to find user by user name
- Provide query to find authorities / roles by user name
