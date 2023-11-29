package com.gosniias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ArrayDtoInput {

    @NotNull
    @Length(min = 3)
    private String array;

    @NotNull
    private String arrayName;

    @NotNull
    private String sort;
}