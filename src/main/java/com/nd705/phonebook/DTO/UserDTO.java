package com.nd705.phonebook.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDTO (номера телефонов в списке)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String jobTitle;
    private LocalDate dateOfBirth;
    private List<String> phoneNumber;

    public UserDTO(Long id, String firstName, String lastName, String patronymic, String jobTitle, LocalDate dateOfBirth) {
    }
}
