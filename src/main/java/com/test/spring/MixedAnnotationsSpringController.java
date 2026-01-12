package com.test.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * BAD PRACTICES: Spring controller with mixed and conflicting annotations
 */
@RestController
@RequestMapping("/spring/mixed")
public class MixedAnnotationsSpringController {
    
    @GetMapping
    @PostMapping
    // BAD: Multiple HTTP method annotations on same method
    public ResponseEntity<String> getOrPost() {
        return ResponseEntity.ok("{\"method\": \"GET or POST\", \"warning\": \"Ambiguous\"}");
    }
    
    @RequestMapping(value = "/conflict", method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    @RequestMapping(value = "/another", method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    // BAD: Multiple @RequestMapping annotations
    public ResponseEntity<String> conflictingPaths() {
        return ResponseEntity.ok("{\"path\": \"conflicting\", \"warning\": \"Multiple mappings\"}");
    }
    
    @GetMapping
    @PutMapping
    @DeleteMapping
    @PatchMapping
    // BAD: Four different HTTP methods on same method
    public ResponseEntity<String> multipleMethods() {
        return ResponseEntity.ok("{\"method\": \"GET, PUT, DELETE, or PATCH\", \"warning\": \"Too many methods\"}");
    }
    
    @RequestMapping(method = RequestMethod.OPTIONS)
    @GetMapping
    // BAD: OPTIONS and GET on same method
    public ResponseEntity<String> optionsAndGet() {
        return ResponseEntity.ok("{\"method\": \"OPTIONS or GET\", \"warning\": \"Conflicting methods\"}");
    }
    
    // BAD: Method without HTTP method annotation
    @RequestMapping("/broken")
    public ResponseEntity<String> brokenMethod() {
        return ResponseEntity.ok("{\"error\": \"No HTTP method specified\"}");
    }
    
    // BAD: Conflicting path variables
    @GetMapping("/{id}")
    @GetMapping("/{name}")
    public ResponseEntity<String> conflictingPathVars(@PathVariable String id, @PathVariable String name) {
        // BAD: This will cause issues - can't have two different path variables on same path
        return ResponseEntity.ok("{\"id\": \"" + id + "\", \"name\": \"" + name + "\"}");
    }
}

