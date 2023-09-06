## Basic Understanding
### Spring Container
- Create and manage objects (Inversion of Control)
- Inject object's dependencies (Dependency Injection)

### @Component
- Marks the class as a Spring Bean
	- Spring bean = Regular java class that managed by Spring
- Also make the bean available for Dependency Injection.

### @Autowired
- Tells Spring to inject a dependency
- Sometimes `@Component` / Bean can be found multiple, so use `@Qualifiers("")` for given specific bean
- `@Primary` given on spesific bean but only one bean
- `@Qualifier` has a higher priority than `@Primary`

### Component Scanning
- Automatically scans component package and sub-packages (recursively)
- By default only component under same package / folder 
	- ex: `com.lerucco.springcoredemo`
	- How about other packages ? 
		- `com.luv2code.util`
		- `org.acme.cart`
### Injection
Inject dependencies by calling any method on your class, Simply give: `@Autowired`
1. Constrctor Injection
	- Using `@Component` as beans and `@Autowired` constructor
	- Use this when you have required dependencies
	- Generally recommended by the `spring.io` development team as first choice
1. Setter Injection
	- Injection dependencies by calling setter method on your class
	- Use this when you have optional dependencies
	- If dependency is not provided, your app can provider reasonable default logic
1. Field Injection
	- Not recommended by `spring.io` team
	- Legacy ways
	- Inject dependencies by setting field values on your class directly (event private fields)
	- Makes the code harder to unit test

### Lazy Initialization
Instead of creating all beans from begining. Use case :
1. It is needed for DI
1. Explicitily requested
1. Add the `@Lazy` annotation to given class
Definition:
- Once access REST endpoint
- Spring will determine dependencies for class `DemoController`
- Spring will create `CricketCoach` first 
- Then instances of `DemoController` and injects the `CricketCoach`
Global Configuration :
- Inside `application.properties` add `spring,main.lazy-initialization=true`
- All beans are lazy and no beans are created until needed

### Bean Scope
lifecycle of a bean
Additional Scopes :
- singleton = create a single shared instance of the bean (default)
- prototype = creates a new bean instance for each container req / each injection
- request = scope to an HTTP web req (web apps only)
- session = scope to an HTTP web session (web apps only)
- global-session = scope to a global http web session

### Bean Lifecycle
1. Container Started
2. Bean Instantiated
3. Dependencies Injected
4. Internal Spring Processing
5. Your custom init method
6. Bean is ready for use
7. Container is shutdown
8. Your custom destroy method
9. Stop Bean

What for :
- Custom code during Bean Initialization `@PostConstruct`
- Custom code during Bean Destruction `@PreDestroy`

### Java Config Bean
Making `@Component` using Java Code instead
1. Create `@Configuration` class
2. Define `@Bean` method to configure the bean
3. Inject the bean into controller

Why using `@Bean` instead `@Component` ?
Use case for `@Bean` :
- Make an existing third-party class available to Spring
- You may not have access to the source code of third-party class
- However, you would like to use the third-party class as a spring bean
- Consider only having a jar file and then leverage that as a spring bean

Real-World Project Example
- Our project used Amazon Web Service (AWS) to store documents
	- Amazon Simple Storage Service (Amazon S3)
	- Amazon S3 is a cloud based storage system
	- can store PDF, Excel, Images, etc
- We wanted to use the AWS S3 client as a Spring bean in our app
- Our code that can communicate with the cloud and store or retrieve documents
- AWS S3 client code is part of AWS SDK
	- We can't modify the AWS S3 source code cause it comes as a JAR file or Maven Dependency
	- We can't just add `@Component` to their code
- However, we can configure is as a Spring Bean using `@Bean`
- It is now we can inject it into other services / controllers of our application

> Make an existing third-party class available to Spring

