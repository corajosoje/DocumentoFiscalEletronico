/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.util;

import java.text.Normalizer;

/**
 *
 * @author jeffersonsvo
 */
public class Util {

    public static String notNull(String retorno) {
        if (retorno == null) {
            throw new NullPointerException();
        } else {
            if (isNumber(retorno)) {
                return retorno;
            } else {
                return removerCaracteresEspeciais(retorno);
            }
        }
    }

    private static boolean isNumber(String s) {
        try {
            double valor = (Double.parseDouble(s));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String removerCaracteresEspeciais(String string) {
        try {
            string = Normalizer.normalize(string, Normalizer.Form.NFD);
            string = string.replaceAll("[^\\p{ASCII}]", "");

            return string;
        } catch (java.lang.NullPointerException e) {
            return "";
        }
    }

}
