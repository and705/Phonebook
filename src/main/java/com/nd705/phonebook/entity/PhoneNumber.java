package com.nd705.phonebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Таблица номеров телефенов
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phone_numbers")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
        private String phoneNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
