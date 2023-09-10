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
-  