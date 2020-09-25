/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados;

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
            return det.getProd().getNCM();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getCodigo() {
        try {
            return det.getProd().getCProd();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getDescricao() {
        try {
            return det.getProd().getXProd();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getNCM() {
        try {
            return det.getProd().getNCM();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getUnidadeMedida() {
        try {
            return det.getProd().getUTrib();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getFCI() {
        try {
            return det.getProd().getNFCI();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

}
