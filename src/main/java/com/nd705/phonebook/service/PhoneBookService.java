package com.nd705.phonebook.service;

import com.nd705.phonebook.DTO.UserDTO;
import com.nd705.phonebook.entity.User;

import java.time.LocalDate;
import java.util.List;

/**
 * Интерфейс сервиса телефонного справочника
 */
public interface PhoneBookService {
    //Создание\изменение контакта;

    /**
     * Сохранение нового пользователя
     */
    public UserDTO saveNewUser(UserDTO user);

    /**
     * Сохранение пользователя/обновление данных
     */
    public UserDTO saveUser(UserDTO user);
    //Поиск и отображения списка контактов. Должна быть предусмотрена фильтрация и сортировка по ФИО и дате рождения;

    /**
     * Получение всех контаков
     */
    public List<User> getAllUsers();

    /**
     * Получение всех контаков в формате объекта UserDTO
     */
    public List<UserDTO> getAllUsersDTO();

    /**
     * Получение всех контаков по ФИО
     */
    public List<User> findByFirstNameAndLastNameAndPatronymic(String firstName, String lastName, String patronymic);

    /**
     * Получение всех контаков по указанной дате рождения
     */
    public List<User> getAllByDateOfBirth(LocalDate date);

    /**
     * Получение всех контаков отсортированных по ФИО
     */
    public List<User> getAllSortedByName();

    /**
     * Получение всех контаков отсортированных по дате рождения
     */
    public List<User> getAllSortedByDateOfBirth();

    //Поиск и отображение детальной информации по конкретному контакту;

    /**
     * Получение контака по id
     */
    public User getUser(long id);

    //
}
