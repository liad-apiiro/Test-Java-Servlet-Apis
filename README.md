# Test Java Servlet APIs

This project contains mock Java servlet APIs designed to challenge code detection and analysis tools. It includes various HTTP method implementations, non-standard methods, and intentionally problematic code patterns.

## Purpose

This project is specifically created to test tools that detect:
- HTTP method implementations
- Non-standard HTTP methods
- Missing method implementations
- Discouraged coding practices
- Security vulnerabilities
- Framework-specific patterns

## Project Structure

```
src/main/java/com/test/
├── servlet/          # Plain Java Servlet implementations
├── jaxrs/            # JAX-RS / Jersey implementations
└── spring/           # Spring MVC implementations
```

## Frameworks Used

1. **Plain Java Servlets** - Standard javax.servlet implementations
2. **JAX-RS / Jersey** - RESTful API framework
3. **Spring MVC** - Spring Web MVC framework

## API Endpoints

### Plain Servlets (`/servlet/*`)

- `/servlet/standard/*` - StandardMethodsServlet
  - GET, POST, PUT, DELETE
  
- `/servlet/multiple/*` - MultipleMethodsServlet
  - GET, POST, PUT, DELETE, PATCH (all handled identically - discouraged)
  
- `/servlet/custom/*` - CustomMethodServlet
  - GET, POST, FUNKYTOWN, DANCEPARTY, SUPERDUPER (non-standard methods)
  
- `/servlet/missing/*` - MissingMethodServlet
  - GET only (missing POST, PUT, DELETE - discouraged)
  
- `/servlet/unsafe/*` - UnsafeServlet
  - GET, POST (security issues: no validation, SQL injection risk, etc.)
  
- `/servlet/overloaded/*` - OverloadedServiceServlet
  - All methods via service() override (bypasses standard routing)
  
- `/servlet/empty/*` - EmptyResponseServlet
  - GET, POST, PUT, DELETE (methods implemented but produce no/empty responses)

### JAX-RS (`/jaxrs/*`)

- `/jaxrs/standard` - StandardJaxRsResource
  - GET, POST, PUT, DELETE, PATCH
  
- `/jaxrs/custom` - CustomMethodJaxRsResource
  - GET, POST, PUT, FUNKYTOWN, DANCEPARTY, SUPERDUPER (custom methods via @HttpMethod)
  
- `/jaxrs/problematic` - ProblematicJaxRsResource
  - GET, POST, PUT, DELETE (missing annotations, no validation)
  
- `/jaxrs/mixed` - MixedAnnotationsResource
  - Multiple conflicting annotations, ambiguous mappings

### Spring MVC (`/spring/*`)

- `/spring/standard` - StandardSpringController
  - GET, POST, PUT, DELETE, PATCH
  
- `/spring/custom` - CustomMethodSpringController
  - GET, FUNKYTOWN, DANCEPARTY, SUPERDUPER (custom methods)
  
- `/spring/problematic` - ProblematicSpringController
  - GET, POST, PUT, DELETE (missing annotations, no validation)
  
- `/spring/mixed` - MixedAnnotationsSpringController
  - Multiple conflicting annotations, ambiguous mappings

## Intentionally Problematic Patterns

### 1. Missing Method Implementations
- `MissingMethodServlet` - Only implements GET, missing POST/PUT/DELETE
- Methods will return 405 Method Not Allowed

### 2. Non-Standard HTTP Methods
- FUNKYTOWN
- DANCEPARTY
- SUPERDUPER
- Implemented via custom method handling

### 3. Multiple Methods on Same Endpoint
- `MultipleMethodsServlet` - All methods do the same thing
- `MixedAnnotationsResource` - Multiple HTTP method annotations on same method

### 4. Service Method Override
- `OverloadedServiceServlet` - Overrides service() without calling super, bypassing standard routing

### 5. Missing Annotations
- Missing @Consumes/@Produces in JAX-RS
- Missing @RequestBody in Spring MVC
- Missing @PathVariable annotations

### 6. Security Issues
- `UnsafeServlet` - No input validation, SQL injection risk, no authentication

### 7. Empty/Incomplete Responses
- `EmptyResponseServlet` - Methods implemented but don't write responses

### 8. Conflicting Mappings
- Duplicate servlet mappings in web.xml
- Multiple @Path annotations in JAX-RS
- Conflicting @RequestMapping in Spring MVC

### 9. Ambiguous Mappings
- Methods that handle multiple HTTP methods without clear distinction
- Path variables with conflicting names

## Building and Running

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- Servlet container (Tomcat, Jetty, etc.)

### Build
```bash
mvn clean package
```

### Deploy
Deploy the generated `test-servlet-apis.war` to your servlet container.

## Testing

You can test the endpoints using curl or any HTTP client:

```bash
# Standard GET
curl http://localhost:8080/test-servlet-apis/servlet/standard/test

# Custom method (requires custom HTTP client or curl with --request)
curl -X FUNKYTOWN http://localhost:8080/test-servlet-apis/servlet/custom/test

# JAX-RS endpoint
curl http://localhost:8080/test-servlet-apis/jaxrs/standard

# Spring MVC endpoint
curl http://localhost:8080/test-servlet-apis/spring/standard
```

## Notes

⚠️ **WARNING**: This project contains intentionally problematic code patterns and security vulnerabilities. It should NOT be used in production environments. It is designed solely for testing code analysis and detection tools.

## License

This is a test project for educational/testing purposes.

