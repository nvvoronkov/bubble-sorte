package com.gosniias.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "arrays")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Array {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Array(String name) {
        this.name = name;
    }
}
