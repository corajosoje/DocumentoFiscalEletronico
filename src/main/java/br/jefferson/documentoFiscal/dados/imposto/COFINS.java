/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.imposto;

import br.jefferson.documentoFiscal.util.Util;
import br.jefferson.notafiscal4.TNFe;

/**
 *
 * @author jeffersonsvo
 */
public class COFINS implements Imposto {

    private final TNFe.InfNFe.Det.Imposto.COFINS cofins;

    public COFINS(TNFe.InfNFe.Det.Imposto.COFINS cofins) {
        this.cofins = cofins;
    }

    @Override
    public String getCST() {
        try {
            if (cofins.getCOFINSAliq() != null) {
                return Util.notNull(cofins.getCOFINSAliq().getCST());
            } else if (cofins.getCOFINSNT() != null) {
                return Util.notNull(cofins.getCOFINSNT().getCST());
            } else if (cofins.getCOFINSOutr() != null) {
                return Util.notNull(cofins.getCOFINSOutr().getCST());
            } else if (cofins.getCOFINSQtde() != null) {
                return Util.notNull(cofins.getCOFINSQtde().getCST());
            } else {
                return "";
            }
        } catch (NullPointerException ex) {
            return "";
        }
    }

    @Override
    public String getBase() {
        try {
            if (cofins.getCOFINSAliq() != null) {
                return Util.notNull(cofins.getCOFINSAliq().getVBC());
            } else if (cofins.getCOFINSNT() != null) {
                return "0";
            } else if (cofins.getCOFINSOutr() != null) {
                return Util.notNull(cofins.getCOFINSOutr().getVBC());
            } else if (cofins.getCOFINSQtde() != null) {
                return Util.notNull(cofins.getCOFINSQtde().getQBCProd());
            } else {
                return "0";
            }
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    @Override
    public String getAliquota() {
        try {
            if (cofins.getCOFINSAliq() != null) {
                return Util.notNull(cofins.getCOFINSAliq().getPCOFINS());
            } else if (cofins.getCOFINSNT() != null) {
                return "0";
            } else if (cofins.getCOFINSOutr() != null) {
                return Util.notNull(cofins.getCOFINSOutr().getPCOFINS());
            } else if (cofins.getCOFINSQtde() != null) {
                return Util.notNull(cofins.getCOFINSQtde().getVAliqProd());
            } else {
                return "0";
            }
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    @Override
    public String getValor() {
        try {
            if (cofins.getCOFINSAliq() != null) {
                return Util.notNull(cofins.getCOFINSAliq().getVCOFINS());
            } else if (cofins.getCOFINSNT() != null) {
                return "0";
            } else if (cofins.getCOFINSOutr() != null) {
                return Util.notNull(cofins.getCOFINSOutr().getVCOFINS());
            } else if (cofins.getCOFINSQtde() != null) {
                return Util.notNull(cofins.getCOFINSQtde().getVCOFINS());
            } else {
                return "0";
            }
        } catch (NullPointerException ex) {
            return "0";
        }
    }

}
