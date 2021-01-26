/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.multimodule.domain.User;
import sample.multimodule.dto.UserDto;
import sample.multimodule.repository.UserRepository;
import sample.multimodule.service.UserService;
import sample.multimodule.utilities.exceptions.AppException;

/**
 *
 * @author brijeshdhaker
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;
    
    public UserDto findOne(Long userid) {
        User user = userRepository.findById(userid).orElse(null);
        return user.toDTO();
    }

    public void createUser(UserDto userDto){
        User user = userDto.toEntity();
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getUsers() throws AppException {
        List<UserDto> dtos = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        for(User l : users){
            UserDto dto = l.toDTO();
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    
}
