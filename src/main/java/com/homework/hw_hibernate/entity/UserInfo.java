package com.homework.hw_hibernate.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserInfo implements Serializable {
    private String name;
    private String surname;
    private Long age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo userInfo)) return false;
        return Objects.equals(name, userInfo.name) && Objects.equals(surname, userInfo.surname) && Objects.equals(age, userInfo.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
