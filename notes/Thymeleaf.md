Java Templating Engine

- Commonly used to generate HTML views for web apps
- However it is a general purpose templating engine
- Separate project to spring.io and can create apps with thymeleaf without spring

## Thymeleaf Template
- Can be an HTML page with some thymeleaf expressions
- Include dynamic content from Thymeleaf expressions

![[MVC.png]]
- In a web app, thymeleaf is processed on the server
- Results included in HTML returned to browser
- Server Side Rendering (SSR)

Additional Features
- Looping and conditionals
- CSS and Javascript integration
- Template layouts and fragments

### Using CSS
- Local CSS Fiels as part of your project
- Referencing remote CSS files using CDN
- Spring will look for static resources in the directory
- `src/main/resources/static`

### Other Search Directories
- Spring boot will search following directories for static resources
- `/src/main/resources`
![[Static Resources Search.png]]

## Components of a Spring MVC Application
- A set of web pages to layout UI components
- A collection of Spring beans (Controllers, Services, etc)
- Spring configuration (XML, Annotations or Java)

## Spring MVC Front Controller

![[MVC Front Controller.png]]

Front Controller known as `DispatcherServlet`
- Part of the Spring Framework
- Already develop by Spring Dev Team
- Delegate request to some other objects or items in our system

### Controller
- Code created by developer
- Contains your business logic
	- Handle the request
	- Store / retrieve data (db, web service)
	- Place data in model
- Send appropriate view template

### Model
- Contains your data
- Store / retrieve data via backend systems
	- Database, web service etc
	- Use a spring bean if you like
- Place your data in the model
	- Data can be any Java Object / Collection
- Contrainer for your application data
- In your controller
	- You can put anything in the `model`
	- String, objects, info from database etc ...

### View Template
- Spring MCV is flexible
	- Supports many view template
- Recommended: Thymeleaf
- Developer creates a page
		- Displays data
- Other view template: Groovy, Velocity, Freemarker, etc ...

## Data Binding
- Spring MVC forms can make use of data binding
- Automatically setting / retrieving data from a Java Object / bean

### Showing Form
![[Data Binding Form.png]]
![[Data Binding HTML.png]]

- Before you show, you must add a `model attribute`
- This is a bean that will hold form data for the `data binding`
- `th:object="${student}"` is a name of model attribute
- `th:field="*{firstName}"` equavalent to `th:field="{student.firstName}"`
- When form is loaded, Spring MVC will read student from the model, then call:
	- `student.getFirstName()`
	- `student.getLastName()`
- When form is submitted, Spring MVC will create a new Student instance and add to the model then call:
	- `student.setFirstName()`
	- `student.setLastName()`
- Handling form Submission in the Controller
	- `@ModalAttribute("student") Student student`

## Validation
- Check the user input form
- Custom business rule

### Java's Standard Bean Validation API
- Java has a standart Bean Validation API
- Defined a metadata model and API for entity validation
- Spring Boot and Thymeleaf also support the Bean Validation API

Bean Validation Features
- required
- validate length
- validate numbers
- validate with regular expressions
- custom validation

![[Validation.png]]

### @InitBinder
- `@InitBinder` annotation works as pre-processor
- It will pre-process each web request to our controller
- Method annotated with `@InitBinder` is executed

Problem with White Space
- We will use this to trim Strings
	- Remove leading and trailing white space
- If string only has white spaces ... trim it to null
- Will resolve our validation problem

![[Init Binder.png]]

### Regular Expressions (Regex)
- A sequence of characters that define a search pattern
	- This pattern is used to find or match strings
- Reqex is like its own language

![[Type Mismatch Message.png]]

### Custom Validation
- Perform custom validation based on your business rules
- Spring MVC calls our custom validation
- Custom validation returns boolean valur for pass / fail (true / false)
- Create a custom Java Annotation

Some explanation
- `@Contraint(validatedBy = CourseCodeContraintValidator.class)`
	- Helper class that contains business rules / validation logic
- `@Target( { ElementType.METHOD, ElementType.FIELD } )`
	- Where can you apply this annotation = method or field
- `@Retention(RetentionPolicy.RUNTIME)`
	- Retain this annotation in the Java class file
	- Process it at runtime
	- 