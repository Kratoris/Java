/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionModelo;

/**
 *
 * @author Frank E Gil M
 */
public class Encriptacion {

    private static final String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

    public String codificar(String texto) {
        String textoCodificado = "";

        texto = texto.toUpperCase();

        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);

            int pos = letras.indexOf(caracter);

            if (pos == -1) {
                textoCodificado += caracter;
            } else {
                textoCodificado += letras.charAt((pos + 3) % letras.length());
            }
        }
        return textoCodificado;
    }

    public String descodificar(String texto) {
        String textoDescodificado = "";

        texto = texto.toUpperCase();

        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);

            int pos = letras.indexOf(caracter);

            if (pos == -1) {
                textoDescodificado += caracter;
            } else {
                if (pos - 3 < 0) {
                    textoDescodificado += letras.charAt(letras.length() + (pos - 3));
                } else {
                    textoDescodificado += letras.charAt((pos - 3) % letras.length());
                }
            }
        }
        return textoDescodificado;
    }
}
