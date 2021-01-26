/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.service;

import java.util.List;
import sample.multimodule.dto.UserDto;
import sample.multimodule.utilities.exceptions.AppException;

/**
 *
 * @author brijeshdhaker
 */
public interface UserService {
    
    public List<UserDto> getUsers() throws AppException;
    
    public UserDto findOne(Long userid);
    
    void createUser(UserDto userDto);
    
    void deleteUserById(Long id);
}
