package com.nd705.phonebook.service;

import com.nd705.phonebook.DTO.UserDTO;
import com.nd705.phonebook.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface PhoneBookService {
    //Создание\изменение контакта;
    public UserDTO saveNewUser (UserDTO user);
    public UserDTO saveUser (UserDTO user);
    //Поиск и отображения списка контактов. Должна быть предусмотрена фильтрация и сортировка по ФИО и дате рождения;
    public List<User> getAllUsers ();
    public List<UserDTO> getAllUsersDTO ();
    public List<User> findByFirstNameAndLastNameAndPatronymic (String firstName, String lastName, String patronymic);
    public List<User> getAllByDateOfBirth (LocalDate date);
    public List<User> getAllSortedByName ();
    public List<User> getAllSortedByDateOfBirth ();

    //Поиск и отображение детальной информации по конкретному контакту;
    public User getUser(long id);

    //
}
