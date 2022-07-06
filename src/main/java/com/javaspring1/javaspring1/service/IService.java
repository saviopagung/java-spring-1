package com.javaspring1.javaspring1.service;

import com.javaspring1.javaspring1.model.Morse;
import com.javaspring1.javaspring1.model.Numero;

public interface IService {
    Numero paraRomano(String decimal);
    Morse morse(Morse morse);
}
