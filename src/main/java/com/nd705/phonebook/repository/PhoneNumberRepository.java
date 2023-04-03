package com.nd705.phonebook.repository;

import com.nd705.phonebook.entity.PhoneNumber;
import com.nd705.phonebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
}
