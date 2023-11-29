package com.gosniias.controller;

import com.gosniias.ArrayDto;
import com.gosniias.exception.ArrayIsEmptyException;
import com.gosniias.model.Sort;
import com.gosniias.service.ArrayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ArrayController {

    private final ArrayService arrayService;

    @PostMapping("/array")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@Valid @RequestBody ArrayDto arrayDto,
                    @RequestParam @NotNull String arrayName,
                    @RequestParam @NotNull Sort sort) throws ArrayIsEmptyException {
        log.info("Calling POST: /array with 'arrayDto': {}, 'arrayName: {}", arrayDto.toString(), arrayName);
        if (arrayDto.getArray().length == 0) {
            throw new ArrayIsEmptyException("Array must not be empty.");
        }
        arrayService.add(arrayDto, arrayName, sort);
    }

    @GetMapping("/array")
    public ArrayDto get(@RequestParam @NotNull String arrayName) {
        log.info("Calling GET: /array with 'arrayName': {}", arrayName);
        return arrayService.get(arrayName);
    }
}