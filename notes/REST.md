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


