/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.apis;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import sample.multimodule.dto.AppRestResponse;
import sample.multimodule.dto.UserDto;
import sample.multimodule.service.UserService;

/**
 *
 * @author brijeshdhaker
 */
@CrossOrigin(origins = {"*localhost*"})
@RestController
@RequestMapping(path ="apis/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    
    @Autowired
    UserService userService;
    
    
    @GetMapping()
    public ResponseEntity<?> list() {
        AppRestResponse appResponse = null;
        ResponseEntity<AppRestResponse> response = null;
        try {
            List<UserDto> dtos = userService.getUsers();
            appResponse = new AppRestResponse(dtos);
            appResponse.setMessage("All Users successfully retrived.");
            response = new ResponseEntity<>(appResponse,HttpStatus.OK);
        } catch (Exception e) {
            appResponse = new AppRestResponse(e, "Error out while processing.");
            response = new ResponseEntity<>(appResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  response;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        AppRestResponse appResponse = null;
        ResponseEntity<AppRestResponse> response = null;
        try {
            UserDto dto =  userService.findOne(Long.parseLong(id));
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
    
    @PostMapping(path="/add")
    public ResponseEntity<?> addNewUser(@RequestBody UserDto user) {
        UserDto n = new UserDto();
        n.setName(user.getName());
        n.setEmail(user.getEmail());
        n.setStatus(user.getStatus());
        userService.createUser(user);
        return new ResponseEntity<String>("Saved",HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        userService.deleteUserById(Long.parseLong(id));
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
