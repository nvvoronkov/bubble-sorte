package com.gosniias.service;

import com.gosniias.ArrayDto;
import com.gosniias.model.Array;
import com.gosniias.model.Sort;

import java.util.List;

public interface ArrayService {

    void add(ArrayDto arrayDto, String arrayName, Sort sort);

    ArrayDto get(String arrayName);

    void add(String arrayString, String arrayName, Sort sort);

    List<Array> getAllArrays();

    String getArrayById(Integer id);
}

