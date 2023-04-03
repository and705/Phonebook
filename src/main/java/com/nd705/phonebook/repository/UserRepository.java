package com.nd705.phonebook.repository;

import com.nd705.phonebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Репозиторий контактов
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        List<User> findAllByDateOfBirth(LocalDate dateOfBirth);

    List<User> findByOrderByDateOfBirth();

    List<User> findByFirstNameAndLastNameAndPatronymic(String firstName, String lastName, String patronymic);
}
