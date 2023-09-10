Representational State Transfer

openweahermap.org

## MIME Content Types
The message format is described by MIME content type

## Java JSON Data Binding with Jackson
Data binding is process converting JSON data to a Java POJO dan sebaliknya
- Spring uses the Jackson Project behind the scenes
- Jackson handles data binding between and Java POKO
- By default, Jackson will call appropriate getter / setter method

### Spring and Jackson Support
- Automatically handle Jackson integration
- JSON data being passed to REST controller is converted to POJO
- Java object being returned from REST controller is converted to JSON


## Exception Handler
- Define exception handler methods with `@ExceptionHandler` annotation
- Exception handler will return a ResponseEntity
- ResponseEntity is a wrapper for the HTTP response object
- ResponseEntity provides fine-grained control to specify
	- HTTP status code
	- HTTP headers
	- HTTP Response body
- It only happens for the specific REST controller

## Global Exception Handler
- Promotes reuse
- Centralize exception handling

`@ControllerAdvice`
- Similar to an interceptor / filter
- Pre-process request to controllers
- Post-process responses to handle exceptions
- Perfect for global exception handling

## REST API Design
- For real-time, who will use your API
- Also, how will they use your API
- Design the API based on requirements

Process :
1. Review API requirements
	- Example Create a REST API for the Employee Directory :
		- Get a list of employee
		- Get a single employee by id
		- Add a new employee
		- Update an employee
		- Delete an employee
1. Identify main resource / entity
	- To identify main resource / entity, look for the most prominent "noun"
	- For our project, it is "employee"
	- Convention is to use plural form of resource / entity: `employees`
	- Endpoint : `/api/employees`
1. Use HTTP methods to assign action on resource
	- Full CRUD


## Service Layer
Employee Rest Controller - Employee Service - Employee DAO - Database
- `Service Facade` design pattern
- Intermediate layer for custom business logic
- Integrate data from multiple sources (DAO / repositories)
	- Employee Services can integrate to many DAO ex: Employee, Skills, Payrol DAO
	- Provide controller with a single view of the data that we integrated from multiple backend datasources

### @Service
```
@Component = {@RestController , @Repository, @Service}
Component annotation has many subset annotation
```
- Applied to service implementations
- Spring will automatically register the service implementation
	- Thanks to component-scanning

Best Practice :
- Apply transactional boundaries at the service layer
- It is the service layer's responsibility to manage transaction boundaries
- For Implementation code
	- Apply `@Transactional` on service methods
	- Remove `@Transactional` on DAO methods if they already exist

## Spring Data JPA
- Automatically create a DAO based on Entity
- Plug my entity type and primary key
- Basic CRUD features for free 
- No necessery code for other entity
	- Help to minimize boiler-plate DAO code
- Advanced features available for
	- Extending and adding custom queries with JPQL
	- Query Domain Specific Language (Query DSL)
	- Defining custom methods (low-level coding)

### Jpa Repository
- Spring Data JPA provides the interface `JpaRepository`
- Expose methods (some by inheritance from parents)

## Spring Data REST
- Automatically create a REST API based on JpaRepository
- Use existing JpaRepository (entity, primary key)
- Basic CRUD REST API for free
- Leverages your existing JpaRepsoturo
	- Help to minimaze boiler-plate REST code

How dose it work ? 
1. Spring Data REST will scan your project for `JpaRepository`
2. Expose REST APIs for each entity type for your JpaRepository

Advanced Features :
- Pagination, Sorting and Searching
- Extending and adding custom queries with JPQL
- Query Domain Specific Language (Query DSL)

### REST Endpoints
- By default, Spring Data REST will create endpoints based on entity type
- Simple pluralized form
	- First character of entity type is lowercase
	- Then just adds an "s" to the entity
	- Example
		- Entity : Employee
		- Endpoints generated : "/employees"
		- mirip laravel
	- But english language are very COMPLEX
		- Goose - Geese
		- Person - People
		- Syllabus - Syllabi
	-  spring data rest cannot handle problem of complex pluralized
	- Solution : expose a different resource name or specify plural name / path with an annotation
	- `@RepositoryRestResource(path = "members")` annotation on its class repository
- Pagination
	- By default page size = 20
	- Navigate to the different pages of data using query param
		- `http://localhost:8080/employees?page=0`
		- `http://localhost:8080/employees?page=1`
- Configuration
	- `spring.data.rest.*`
	- `spring.data.rest.base-path=/api`
	- `spring.data.rest-default-page-size=50`
	- `spring.data.rest-max-page-size`
- Sorting
	- Sort by the property names of entity
	- Ascending is default
	- Example :
		- Given entity properties : firstName, lastName, email
		- Sort by last name
			- `http://localhost:8080/employees?sort=lastName`
		- Sort by first name, descending
			- `http://localhost:8080/employees?sort=firstName,desc`
		- Sort by last name, then first name, ascending (to be explicit)
			- `http://localhost:8080/employees?sort=lastname,firstName,asc`

### HATEOAS
Hypermedia as the Engine of Application State
- Spring Data REST endpoints are HATEOAS compliant
- Hypermedia-driven sites provide information to access REST interfaces
	- Think of it as meta-data for REST data
	- Consider given a links to the actual entry or the data
- For a collection, meta-data includes page size, total elements, pages etc
- Uses Hypertext Application Language (HAL) data format



```JSON
// Single
{
	"firstName": "Le",
	"lastName": "Rucco",
	"email": "rucco@gmail.com",
	"_links": {
		"self": {
			"href": "http://localhost:8080/employees/3"
		},
		"employee": {
			"href": "http://localhost:8080/employees/3"
		}
	}
}

// Collection
{
	"_embedded": {
		"employees": [
			{
				"firstName": "Le",
				"lastName": "Rucco",
				...
			},
			...
		]
	},
	"page": {
		"size": 20,
		"totalElements": 5,
		"totalPages": 1,
		"number": 0
	}
}
```
