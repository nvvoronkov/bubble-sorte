package com.gosniias.controller;

import com.gosniias.dto.ArrayDtoInput;
import com.gosniias.exception.ArrayIsEmptyException;
import com.gosniias.model.Array;
import com.gosniias.model.Sort;
import com.gosniias.service.ArrayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ArrayController {

    private final ArrayService arrayService;

    @GetMapping
    public String getHomepage(Model model) {
        log.info("Calling GET: /");

        addAttributes(model);

        return "index";
    }

    @PostMapping(path = "/array")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String sendArray(@Valid @ModelAttribute("arrayDto") ArrayDtoInput arrayDto, Model model) {
        log.info("Calling POST: /array with 'arrayDto': {}", arrayDto.toString());

        if (arrayDto.getArray().isEmpty()) {
            throw new ArrayIsEmptyException("Array must not be empty.");
        }

        arrayService.add(arrayDto.getArray(), arrayDto.getArrayName(), Sort.valueOf(arrayDto.getSort()));

        addAttributes(model);

        return "index";
    }

    @GetMapping(path = "/array")
    public String getArray(@RequestParam Integer arrayId, Model model) {
        log.info("Calling GET: /array with 'arrayId': {}", arrayId);

        addAttributes(model);

        String result = arrayService.getArrayById(arrayId);
        model.addAttribute("result", result);

        return "index";
    }

    private void addAttributes(Model model) {
        ArrayDtoInput arrayDtoInput = new ArrayDtoInput();
        model.addAttribute("arrayDtoInput", arrayDtoInput);

        List<Array> savedArrays = arrayService.getAllArrays();
        model.addAttribute("selectArrayOptions", savedArrays);
    }
}
