package com.nd705.phonebook.controller;

import com.nd705.phonebook.DTO.UserDTO;
import com.nd705.phonebook.entity.User;
import com.nd705.phonebook.repository.UserRepository;
import com.nd705.phonebook.service.PhoneBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class PhoneBookController {
    @Autowired
    PhoneBookServiceImpl phoneBookServiceImpl;

    @PostMapping("/user")
    public UserDTO addNewUser(@RequestBody UserDTO userReq){
        UserDTO user = phoneBookServiceImpl.saveNewUser(userReq);
        return user;
    }

    @PutMapping("/user")
    public UserDTO updateUser(@RequestBody UserDTO user){
        phoneBookServiceImpl.saveUser(user);
        return user;
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        List<User> allUsers = phoneBookServiceImpl.getAllUsers();
        return allUsers;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        User user = phoneBookServiceImpl.getUser(id);
        return user;
    }
    @GetMapping("/getAllByBirth/{dateOfBirth}")
    public List<User> getAllByBirth(@PathVariable LocalDate dateOfBirth) {

        return phoneBookServiceImpl.getAllByDateOfBirth(dateOfBirth);
    }
    @GetMapping("/getAllSortedByDateOfBirth")
    public List<User> getAllSortedByDateOfBirth() {
        return phoneBookServiceImpl.getAllSortedByDateOfBirth();
    }
    @GetMapping("/getAllFilteredByName")
    public List<User> getAllFilteredByName(@RequestParam(name = "firstName") String firstName,
                                         @RequestParam(name = "lastName") String lastName,
                                         @RequestParam(name = "patronymic") String patronymic) {
        return phoneBookServiceImpl.findByFirstNameAndLastNameAndPatronymic(firstName, lastName, patronymic);
    }
    @GetMapping("/getAllSortedByName")
    public List<User> getAllSortedByName() {
        return phoneBookServiceImpl.getAllSortedByName();
    }


}
