/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.imposto;

import br.jefferson.documentoFiscal.dados.Item;
import br.jefferson.notafiscal4.TNFe;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffe
 */
public class ICMSDest {

    private final TNFe.InfNFe.Det.Imposto.ICMSUFDest dest;

    public ICMSDest(TNFe.InfNFe.Det.Imposto.ICMSUFDest dest) {
        this.dest = dest;
    }

    public String getAliqICMSDest() {
        try {
            return dest.getPICMSUFDest();
        } catch (NullPointerException ex) {
            Logger.getLogger(ICMSDest.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getICMSUFDestino() {
        try {
            return dest.getVICMSUFDest();
        } catch (NullPointerException ex) {
            Logger.getLogger(ICMSDest.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getICMSUFRemetente() {
        try {
            return dest.getVICMSUFRemet();
        } catch (NullPointerException ex) {
            Logger.getLogger(ICMSDest.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }
}
