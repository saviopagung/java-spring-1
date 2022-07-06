package com.javaspring1.javaspring1.controller;

import com.javaspring1.javaspring1.model.Morse;
import com.javaspring1.javaspring1.model.Numero;
import com.javaspring1.javaspring1.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseController {
    @Autowired
    private IService servive;

    @GetMapping
    public ResponseEntity<Morse> morse(@RequestBody Morse morse) {
        return new ResponseEntity<>(servive.morse(morse), HttpStatus.OK);
    }
}
