package com.nd705.phonebook.controller;

import com.nd705.phonebook.DTO.UserDTO;
import com.nd705.phonebook.entity.User;
import com.nd705.phonebook.repository.UserRepository;
import com.nd705.phonebook.service.PhoneBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * REST-контроллер
 */
@RestController
@RequestMapping("/contacts")
public class PhoneBookController {
    @Autowired
    PhoneBookServiceImpl phoneBookServiceImpl;

    /**
     * Сохранение нового пользователя
     */
    @PostMapping("/user")
    public UserDTO addNewUser(@RequestBody UserDTO userReq) {
        UserDTO user = phoneBookServiceImpl.saveNewUser(userReq);
        return user;
    }

    /**
     * Сохранение пользователя/обновление данных
     */
    @PutMapping("/user")
    public UserDTO updateUser(@RequestBody UserDTO user) {
        phoneBookServiceImpl.saveUser(user);
        return user;
    }

    /**
     * Получение всех контаков
     */
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        List<User> allUsers = phoneBookServiceImpl.getAllUsers();
        return allUsers;
    }

    /**
     * Получение контака по id
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        User user = phoneBookServiceImpl.getUser(id);
        return user;
    }

    /**
     * Получение всех контаков по указанной дате рождения
     */
    @GetMapping("/getAllByBirth/{dateOfBirth}")
    public List<User> getAllByBirth(@PathVariable LocalDate dateOfBirth) {

        return phoneBookServiceImpl.getAllByDateOfBirth(dateOfBirth);
    }

    /**
     * Получение всех контаков отсортированных по дате рождения
     */
    @GetMapping("/getAllSortedByDateOfBirth")
    public List<User> getAllSortedByDateOfBirth() {
        return phoneBookServiceImpl.getAllSortedByDateOfBirth();
    }

    /**
     * Получение всех контаков по ФИО
     */
    @GetMapping("/getAllFilteredByName")
    public List<User> getAllFilteredByName(@RequestParam(name = "firstName") String firstName,
                                           @RequestParam(name = "lastName") String lastName,
                                           @RequestParam(name = "patronymic") String patronymic) {
        return phoneBookServiceImpl.findByFirstNameAndLastNameAndPatronymic(firstName, lastName, patronymic);
    }

    /**
     * Получение всех контаков отсортированных по ФИО
     */
    @GetMapping("/getAllSortedByName")
    public List<User> getAllSortedByName() {
        return phoneBookServiceImpl.getAllSortedByName();
    }


}
