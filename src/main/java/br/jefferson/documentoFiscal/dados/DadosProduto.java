/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados;

import br.jefferson.documentoFiscal.util.Util;
import br.jefferson.notafiscal4.TNFe;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffersonsvo
 */
public class DadosProduto {

    public DadosProduto(TNFe.InfNFe.Det det) {
        this.det = det;
    }
    private final TNFe.InfNFe.Det det;

    public String getCEST() {
        try {
            return Util.notNull(det.getProd().getNCM());
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getEAN() {
        try {
            return Util.notNull(det.getProd().getCEAN());
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getCodigo() {
        try {
            return Util.notNull(det.getProd().getCProd());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getDescricao() {
        try {
            return Util.notNull(det.getProd().getXProd());
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getNCM() {
        try {
            return Util.notNull(det.getProd().getNCM());
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getUnidadeMedida() {
        try {
            return Util.notNull(det.getProd().getUTrib());
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getFCI() {
        try {
            return Util.notNull(det.getProd().getNFCI());
        } catch (NullPointerException ex) {
            return "";
        }
    }

}
