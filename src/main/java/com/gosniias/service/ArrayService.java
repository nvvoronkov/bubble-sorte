package com.gosniias.service;

import com.gosniias.model.Array;
import com.gosniias.model.Sort;

import java.util.List;

public interface ArrayService {

    void add(String arrayString, String arrayName, Sort sort);

    List<Array> getAllArrays();

    String getArrayById(Integer id);
}

