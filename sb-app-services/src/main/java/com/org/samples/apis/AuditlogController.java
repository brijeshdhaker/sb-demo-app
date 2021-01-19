/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.samples.apis;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.org.samples.dto.AuditlogDto;
import com.org.samples.models.AppRestResponse;
import com.org.samples.services.AuditlogService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author brijeshdhaker
 */
@CrossOrigin(origins = {"*localhost*"})
@RestController
@RequestMapping(path ="api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuditlogController {
    
    private static final Logger log = LoggerFactory.getLogger(AuditlogController.class);
    
    @Autowired
    AuditlogService auditlogService;
    
    @GetMapping()
    public List<Object> list() {
        return null;
    }
    
    @GetMapping("/auditlog/{logid}")
    public ResponseEntity<?> get(@PathVariable Integer logid) {
        AppRestResponse appResponse = null;
        ResponseEntity<AppRestResponse> response = null;
        try {
            
            AuditlogDto dto =  auditlogService.getAuditlog(logid);
            appResponse = new AppRestResponse(dto);
            response = new ResponseEntity<>(appResponse,HttpStatus.OK);
            
        } catch (Exception e) {
            
            appResponse = new AppRestResponse(e, "Error out while processing.");
            response = new ResponseEntity<>(appResponse,HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return  response;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public Object handleError(HttpServletRequest req, Exception ex) {
        Object errorObject = new Object();
        return errorObject;
    }
    
    
    
    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    @RequestMapping(value = "/hystrix")
    public String hello() throws InterruptedException {
       Thread.sleep(3000);
       return "{\"message\": \"Welcome Hystrix\" }";
    }
    
    private String fallback_hello() {
        log.info("Request fails. It takes long time to response");
        return "{\"message\": \"Request fails. It takes long time to response\" }";
    }
}
