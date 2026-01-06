package com.test.spring;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Spring MVC controller with standard HTTP methods
 */
@RestController
@RequestMapping("/spring/standard")
public class StandardSpringController {
    
    @GetMapping
    public ResponseEntity<String> getData() {
        return ResponseEntity.ok("{\"method\": \"GET\", \"framework\": \"Spring MVC\"}");
    }
    
    @PostMapping
    public ResponseEntity<String> createData(@RequestBody String body) {
        return ResponseEntity.ok("{\"method\": \"POST\", \"framework\": \"Spring MVC\", \"body\": " + body + "}");
    }
    
    @PutMapping
    public ResponseEntity<String> updateData(@RequestBody String body) {
        return ResponseEntity.ok("{\"method\": \"PUT\", \"framework\": \"Spring MVC\", \"body\": " + body + "}");
    }
    
    @DeleteMapping
    public ResponseEntity<String> deleteData() {
        return ResponseEntity.ok("{\"method\": \"DELETE\", \"framework\": \"Spring MVC\"}");
    }
    
    @PatchMapping
    public ResponseEntity<String> patchData(@RequestBody String body) {
        return ResponseEntity.ok("{\"method\": \"PATCH\", \"framework\": \"Spring MVC\", \"body\": " + body + "}");
    }
    
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<String> optionsData() {
        return ResponseEntity.ok()
                .header("Allow", "GET, POST, PUT, DELETE, PATCH, OPTIONS")
                .body("{\"method\": \"OPTIONS\", \"framework\": \"Spring MVC\", \"allowed\": [\"GET\", \"POST\", \"PUT\", \"DELETE\", \"PATCH\", \"OPTIONS\"]}");
    }
}

