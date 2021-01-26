/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.dto;

import sample.multimodule.domain.User;

/**
 *
 * @author brijeshdhaker
 */
public class UserDto {
    
    private Long id;
    private String name;
    private String email;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    public User toEntity(){
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setStatus(this.status);
        return  user;
    }
}
