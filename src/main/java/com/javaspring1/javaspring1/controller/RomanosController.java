package com.javaspring1.javaspring1.controller;

import com.javaspring1.javaspring1.model.Numero;
import com.javaspring1.javaspring1.service.INumeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numero")
public class RomanosController {

    @Autowired
    private INumeroService service;

    @GetMapping("/decimal/{numero}")
    public ResponseEntity<Numero> romano(@PathVariable String numero) {
        return new ResponseEntity<>(service.paraRomano(numero), HttpStatus.OK);
    }

}
