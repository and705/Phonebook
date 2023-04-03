package com.nd705.phonebook.service;

import com.nd705.phonebook.DTO.UserDTO;
import com.nd705.phonebook.entity.PhoneNumber;
import com.nd705.phonebook.entity.User;
import com.nd705.phonebook.repository.PhoneNumberRepository;
import com.nd705.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Реализация интерфейса телефонного справочника
 */
@Service
public class PhoneBookServiceImpl implements PhoneBookService {
    @Autowired
    UserRepository userRepository;

    /**
     * Сохранение нового пользователя
     */
    @Override
    public UserDTO saveNewUser(UserDTO newUserDTO) {
        User user = new User(
                newUserDTO.getFirstName(),
                newUserDTO.getLastName(),
                newUserDTO.getPatronymic(),
                newUserDTO.getJobTitle(),
                newUserDTO.getDateOfBirth()
        );
        for (int i = 0; i < newUserDTO.getPhoneNumber().size(); i++) {
            user.addPhoneNumber(new PhoneNumber(newUserDTO.getPhoneNumber().get(i)));
        }
        userRepository.save(user);
        newUserDTO.setId(user.getId());
        return newUserDTO;
    }

    /**
     * Сохранение пользователя/обновление данных
     */
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getPatronymic(),
                userDTO.getJobTitle(),
                userDTO.getDateOfBirth()
        );
        user.setId(userDTO.getId());
        for (int i = 0; i < userDTO.getPhoneNumber().size(); i++) {
            user.addPhoneNumber(new PhoneNumber(userDTO.getPhoneNumber().get(i)));
        }
        userRepository.save(user);
        return userDTO;
    }

    /**
     * Получение всех контаков в формате объекта UserDTO
     */
    @Override
    public List<UserDTO> getAllUsersDTO() {
        List<User> user = userRepository.findAll();
        List<UserDTO> userDTO = new ArrayList<>();
        for (User k : user
        ) {
            List<String> phoneNumber = new ArrayList<>();
            for (PhoneNumber pn : k.getPhoneNumbers()
            ) {
                phoneNumber.add(pn.getPhoneNumber());
            }
            userDTO.add(new UserDTO(
                    k.getId(),
                    k.getFirstName(),
                    k.getLastName(),
                    k.getPatronymic(),
                    k.getJobTitle(),
                    k.getDateOfBirth(),
                    phoneNumber
            ));
        }
        return userDTO;
    }

    /**
     * Получение всех контаков
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Получение всех контаков по указанной дате рождения
     */
    @Override
    public List<User> findByFirstNameAndLastNameAndPatronymic(String firstName, String lastName, String patronymic) {
        return userRepository.findByFirstNameAndLastNameAndPatronymic(firstName, lastName, patronymic);
    }

    /**
     * Получение всех контаков по указанной дате рождения
     */
    @Override
    public List<User> getAllByDateOfBirth(LocalDate date) {
        return userRepository.findAllByDateOfBirth(date);
    }

    /**
     * Получение всех контаков отсортированных по ФИО
     */
    @Override
    public List<User> getAllSortedByName() {
        return userRepository.findAll(Sort.by("firstName").and(Sort.by("lastName")).and(Sort.by("patronymic")));
    }

    /**
     * Получение всех контаков отсортированных по дате рождения
     */
    @Override
    public List<User> getAllSortedByDateOfBirth() {
        return userRepository.findByOrderByDateOfBirth();
    }

    /**
     * Получение контака по id
     */
    @Override
    public User getUser(long id) {
        User user = null;
        Optional<User> usr = userRepository.findById(id);
        if (usr.isPresent()) {
            user = usr.get();
        }
        return user;
    }
}
