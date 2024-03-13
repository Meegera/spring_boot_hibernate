package com.homework.hw_hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @EmbeddedId
    private UserInfo userInfo;
    @Column
    private String phoneNumber;
    @Column
    private String cityOfLiving;
}
