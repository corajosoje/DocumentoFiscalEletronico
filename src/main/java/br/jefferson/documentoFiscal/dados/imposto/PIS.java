/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.imposto;

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
        if (pis.getPISAliq() != null) {
            return pis.getPISAliq().getCST();
        } else if (pis.getPISNT() != null) {
            return pis.getPISNT().getCST();
        } else if (pis.getPISOutr() != null) {
            return pis.getPISOutr().getCST();
        } else if (pis.getPISQtde() != null) {
            return pis.getPISQtde().getCST();
        } else {
            return null;
        }
    }

    @Override
    public String getBase() {
        if (pis.getPISAliq() != null) {
            return pis.getPISAliq().getVBC();
        } else if (pis.getPISNT() != null) {
            return "0";
        } else if (pis.getPISOutr() != null) {
            return pis.getPISOutr().getVBC();
        } else if (pis.getPISQtde() != null) {
            return pis.getPISQtde().getQBCProd();
        } else {
            return null;
        }
    }

    @Override
    public String getAliquota() {
        if (pis.getPISAliq() != null) {
            return pis.getPISAliq().getPPIS();
        } else if (pis.getPISNT() != null) {
            return "0";
        } else if (pis.getPISOutr() != null) {
            return pis.getPISOutr().getPPIS();
        } else if (pis.getPISQtde() != null) {
            return pis.getPISQtde().getVAliqProd();
        } else {
            return null;
        }
    }

    @Override
    public String getValor() {
        if (pis.getPISAliq() != null) {
            return pis.getPISAliq().getVPIS();
        } else if (pis.getPISNT() != null) {
            return "0";
        } else if (pis.getPISOutr() != null) {
            return pis.getPISOutr().getVPIS();
        } else if (pis.getPISQtde() != null) {
            return pis.getPISQtde().getVPIS();
        } else {
            return null;
        }
    }

}
