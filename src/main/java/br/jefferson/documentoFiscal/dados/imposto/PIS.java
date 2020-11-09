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
public class PIS implements Imposto {

    private final TNFe.InfNFe.Det.Imposto.PIS pis;

    public PIS(TNFe.InfNFe.Det.Imposto.PIS pis) {
        this.pis = pis;
    }

    @Override
    public String getCST() {
        try {
            if (pis.getPISAliq() != null) {
                return Util.notNull(pis.getPISAliq().getCST());
            } else if (pis.getPISNT() != null) {
                return Util.notNull(pis.getPISNT().getCST());
            } else if (pis.getPISOutr() != null) {
                return Util.notNull(pis.getPISOutr().getCST());
            } else if (pis.getPISQtde() != null) {
                return Util.notNull(pis.getPISQtde().getCST());
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
            if (pis.getPISAliq() != null) {
                return Util.notNull(pis.getPISAliq().getVBC());
            } else if (pis.getPISNT() != null) {
                return "0";
            } else if (pis.getPISOutr() != null) {
                return Util.notNull(pis.getPISOutr().getVBC());
            } else if (pis.getPISQtde() != null) {
                return Util.notNull(pis.getPISQtde().getQBCProd());
            } else {
                return null;
            }
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    @Override
    public String getAliquota() {
        try {
            if (pis.getPISAliq() != null) {
                return Util.notNull(pis.getPISAliq().getPPIS());
            } else if (pis.getPISNT() != null) {
                return "0";
            } else if (pis.getPISOutr() != null) {
                return Util.notNull(pis.getPISOutr().getPPIS());
            } else if (pis.getPISQtde() != null) {
                return Util.notNull(pis.getPISQtde().getVAliqProd());
            } else {
                return null;
            }
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    @Override
    public String getValor() {
        try {
            if (pis.getPISAliq() != null) {
                return Util.notNull(pis.getPISAliq().getVPIS());
            } else if (pis.getPISNT() != null) {
                return "0";
            } else if (pis.getPISOutr() != null) {
                return Util.notNull(pis.getPISOutr().getVPIS());
            } else if (pis.getPISQtde() != null) {
                return Util.notNull(pis.getPISQtde().getVPIS());
            } else {
                return null;
            }
        } catch (NullPointerException ex) {
            return "0";
        }
    }

}
