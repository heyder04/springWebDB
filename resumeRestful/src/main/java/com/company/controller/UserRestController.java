package com.company.controller;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.dto.UserDTO;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userController/")
public class UserRestController {
    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userRepo;
    @GetMapping("users")
    public ResponseEntity<List> getUsers(){
       List<User> users= userRepo.getAll(null,null,null);
       List<UserDTO> userDTOS=new ArrayList<>();
       for (int i=0;i<users.size();i++){
           User u=users.get(i);
           userDTOS.add(new UserDTO(u));
       }
       return  ResponseEntity.ok(userDTOS);
//        return ResponseEntity.status(HttpStatus.OK).body("users  ");
//   return new ResponseEntity<String>("", HttpStatus.OK).toString();
    }

}






