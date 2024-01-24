package com.company.controller;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resume/")
public class UserRestController {
    @Autowired
//    @Qualifier("userDao1")
//    private UserRepositoryCustom userRepo;
    private UserServiceInter userService;
    @GetMapping("users")
    public ResponseEntity<ResponseDTO> getUsers(@RequestParam(name = "name",required = false) String name,
                                                @RequestParam(name = "surname",required = false) String surname,
                                                @RequestParam(name = "age",required = false) Integer age){
       List<User> users= userService.getAll(name,surname,age);
        System.out.println(name);
       List<UserDTO> userDTOS=new ArrayList<>();
       for (int i=0;i<users.size();i++){
           User u=users.get(i);
           userDTOS.add(new UserDTO(u));
       }
       return  ResponseEntity.ok(ResponseDTO.of(userDTOS));
//        return ResponseEntity.status(HttpStatus.OK).body("users  ");
//   return new ResponseEntity<String>("", HttpStatus.OK).toString();
    }


    @GetMapping("user/{id}")
    public ResponseEntity<ResponseDTO> getUsers(@PathVariable("id") int id){
        User user= userService.getById(id);

        return  ResponseEntity.ok(ResponseDTO.of(new UserDTO(user)));
//        return ResponseEntity.status(HttpStatus.OK).body("users  ");
//   return new ResponseEntity<String>("", HttpStatus.OK).toString();
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id){
        User u=userService.getById(id);
        userService.removeUser(id);


        return  ResponseEntity.ok(ResponseDTO.of(new UserDTO(u),"Succesfully deleted"));
//        return ResponseEntity.status(HttpStatus.OK).body("users  ");
//   return new ResponseEntity<String>("", HttpStatus.OK).toString();
    }

    @PostMapping("users")
    public ResponseEntity<ResponseDTO> insertUser(@RequestBody UserDTO userDto){
        User u=new User();
       u.setName(userDto.getName());
       u.setSurname(userDto.getSurname());
       u.setPassword(userDto.getPassword());
       userService.addUser(u);
    UserDTO userDTO =new UserDTO();
    userDTO.setId(u.getId());
    userDTO.setName(u.getName());
    userDTO.setSurname(u.getSurname());

        return  ResponseEntity.ok(ResponseDTO.of(userDTO,"Succesfully added"));
//        return ResponseEntity.status(HttpStatus.OK).body("users  ");
//   return new ResponseEntity<String>("", HttpStatus.OK).toString();
    }

}






