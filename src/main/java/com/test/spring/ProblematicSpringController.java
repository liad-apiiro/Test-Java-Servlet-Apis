package com.test.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * BAD PRACTICES: Spring MVC controller with various issues
 * - Missing @RequestBody annotations
 * - No input validation
 * - Inconsistent response types
 * - Missing error handling
 */
@RestController
@RequestMapping("/spring/problematic")
public class ProblematicSpringController {
    
    @GetMapping
    // BAD: Missing produces/consumes specification
    public ResponseEntity<String> getData() {
        return ResponseEntity.ok("{\"method\": \"GET\"}");
    }
    
    @PostMapping
    // BAD: Missing @RequestBody annotation - won't work correctly
    public ResponseEntity<String> createData(String body) {
        // BAD: No validation
        return ResponseEntity.ok("{\"method\": \"POST\", \"body\": \"" + body + "\"}");
    }
    
    @PutMapping("/{id}")
    // BAD: Missing @RequestBody, missing @PathVariable validation
    public ResponseEntity<String> updateData(String id, String body) {
        // BAD: Parameter order might be wrong, no validation
        return ResponseEntity.ok("{\"method\": \"PUT\", \"id\": \"" + id + "\", \"body\": \"" + body + "\"}");
    }
    
    @DeleteMapping("/{id}")
    // BAD: No authorization check
    public ResponseEntity<String> deleteData(@PathVariable String id) {
        // BAD: No validation, no authorization
        return ResponseEntity.ok("{\"method\": \"DELETE\", \"id\": \"" + id + "\"}");
    }
    
    // BAD: Ambiguous mapping - multiple methods without clear distinction
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> ambiguousMapping() {
        return ResponseEntity.ok("{\"method\": \"GET or POST\", \"warning\": \"Ambiguous\"}");
    }
    
    // BAD: Method without proper HTTP method mapping
    @RequestMapping("/broken")
    public ResponseEntity<String> brokenMethod() {
        return ResponseEntity.ok("{\"error\": \"Missing HTTP method specification\"}");
    }
}

