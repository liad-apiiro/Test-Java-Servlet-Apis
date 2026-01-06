package com.test.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Spring MVC controller with custom HTTP methods
 * Note: Spring doesn't natively support custom HTTP methods via annotations,
 * so we use a catch-all and check the method manually
 */
@RestController
@RequestMapping("/spring/custom")
public class CustomMethodSpringController {
    
    @GetMapping
    public ResponseEntity<String> getData() {
        return ResponseEntity.ok("{\"method\": \"GET\", \"framework\": \"Spring MVC\"}");
    }
    
    // Custom HTTP method - Spring doesn't support custom methods in enum,
    // so we use a catch-all and check manually
    @RequestMapping(value = "/funkytown", method = {})
    public ResponseEntity<String> funkyTown(HttpServletRequest request) {
        if ("FUNKYTOWN".equalsIgnoreCase(request.getMethod())) {
            return ResponseEntity.ok("{\"method\": \"FUNKYTOWN\", \"framework\": \"Spring MVC\", \"message\": \"Custom method via manual check\"}");
        }
        return ResponseEntity.badRequest().build();
    }
    
    @RequestMapping(value = "/danceparty", method = {})
    public ResponseEntity<String> danceParty(HttpServletRequest request) {
        if ("DANCEPARTY".equalsIgnoreCase(request.getMethod())) {
            return ResponseEntity.ok("{\"method\": \"DANCEPARTY\", \"framework\": \"Spring MVC\"}");
        }
        return ResponseEntity.badRequest().build();
    }
    
    // Alternative: Catch-all that handles multiple custom methods
    @RequestMapping(value = "/superduper", method = {})
    public ResponseEntity<String> superDuper(HttpServletRequest request, @RequestBody(required = false) String body) {
        if ("SUPERDUPER".equalsIgnoreCase(request.getMethod())) {
            return ResponseEntity.ok("{\"method\": \"SUPERDUPER\", \"framework\": \"Spring MVC\", \"body\": " + (body != null ? body : "null") + "}");
        }
        return ResponseEntity.badRequest().build();
    }
    
    // Multiple methods on same mapping - discouraged
    @PostMapping
    @PutMapping
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<String> multipleMethods(@RequestBody String body) {
        return ResponseEntity.ok("{\"method\": \"POST or PUT\", \"framework\": \"Spring MVC\", \"body\": " + body + "}");
    }
    
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<String> optionsData() {
        return ResponseEntity.ok()
                .header("Allow", "GET, POST, PUT, OPTIONS, FUNKYTOWN, DANCEPARTY, SUPERDUPER")
                .body("{\"method\": \"OPTIONS\", \"framework\": \"Spring MVC\", \"allowed\": [\"GET\", \"POST\", \"PUT\", \"OPTIONS\", \"FUNKYTOWN\", \"DANCEPARTY\", \"SUPERDUPER\"]}");
    }
}

