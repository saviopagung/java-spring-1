package com.javaspring1.javaspring1.service;

import com.javaspring1.javaspring1.model.Morse;
import com.javaspring1.javaspring1.model.Numero;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ServiceImp implements IService {

    private final String rejaxPalavras = "   ";
    private final String rejaxCodigo = " ";

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

    @Override
    public Morse morse(Morse morse) {
        HashMap<String, String> morseMap = new HashMap<>();
        morseMap.put(".-", "a");
        morseMap.put("-...", "b");
        morseMap.put("-.-.", "c");
        morseMap.put("-..", "d");
        morseMap.put(".", "e");
        morseMap.put("..-.", "f");
        morseMap.put("--.", "g");
        morseMap.put("....", "h");
        morseMap.put("..", "i");
        morseMap.put(".---", "j");
        morseMap.put("-.-", "k");
        morseMap.put(".-..", "l");
        morseMap.put("--", "m");
        morseMap.put("-.", "n");
        morseMap.put("---", "o");
        morseMap.put(".--.", "p");
        morseMap.put("--.-", "q");
        morseMap.put(".-.", "r");
        morseMap.put("...", "s");
        morseMap.put("-", "t");
        morseMap.put("..-", "u");
        morseMap.put("...-", "v");
        morseMap.put(".--", "w");
        morseMap.put("-..-", "x");
        morseMap.put("-.--", "y");
        morseMap.put("--..", "z");

        morseMap.put(".----", "1");
        morseMap.put("..---", "2");
        morseMap.put("...--", "3");
        morseMap.put("....-", "4");
        morseMap.put(".....", "5");
        morseMap.put("-....", "6");
        morseMap.put("--...", "7");
        morseMap.put("----.", "8");
        morseMap.put("---..", "9");
        morseMap.put("-----", "0");

        morseMap.put("..--..", "?");
        morseMap.put("-.-.--", "!");
        morseMap.put(".-.-.-", ".");
        morseMap.put("--..--", ",");

        String split[] = morse.getMorse().split(rejaxPalavras);
        String traducao = "";
        int qtdPalavras = split.length;
        for (int i = 0; i < qtdPalavras; i++) {
            String splitPalavra[] = split[i].split(rejaxCodigo);
            int qtdLetras = splitPalavra.length;
            for (int j = 0; j < qtdLetras; j++) {
                traducao += morseMap.get(splitPalavra[j]);
            }
            if ((i+1) != qtdPalavras) traducao += " "; //remover o espaço no final

        }

        morse.setFrase(traducao);

        return morse;
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
