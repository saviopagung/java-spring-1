package com.javaspring1.javaspring1.service;

import com.javaspring1.javaspring1.model.Numero;
import org.springframework.stereotype.Service;

@Service
public class NumeroService implements INumeroService{

    private final int decimais[] =
            {
                    1000,
                    900,
                    500,
                    400,
                    100,
                    90,
                    50,
                    40,
                    10,
                    9,
                    5,
                    4,
                    1
            };

    private final String romanos[] =
            {
                    "M",  //1000
                    "CM", // 900
                    "D",  // 500
                    "CD", // 400
                    "C",  // 100
                    "XC", //  90
                    "L",  //  50
                    "XL", //  40
                    "X",  //  10
                    "IX", //   9
                    "V",  //   5
                    "IV", //   4
                    "I"   //   1
            };

    @Override
    public Numero paraRomano(String decimal) {
        return new Numero(decimalParaRomano(Integer.parseInt(decimal)), Integer.parseInt(decimal));
    }

    private String decimalParaRomano(int decimal) {
        String romano = "";
        int tam = romanos.length;
        int i;
        for (i = 0; i < tam; i ++) {
            int qtdRomanoAtual = decimal / decimais[i]; //quantidade de vezes que o romano de indice "i" ira repetir
            romano = concatenar(romano, romanos[i], qtdRomanoAtual);
            int atual = (decimais[i] * qtdRomanoAtual);
            decimal -= atual;
        }

        return romano;
    }

    //concatena x vezes o valor de b para dentro de a;
    private String concatenar(String a, String b, int x) {
        if (x == 0) {
            return a;
        }

        for (int i = 0; i < x; i ++) {
            a += b;
        }

        return a;
    }
}
