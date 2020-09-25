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
public class COFINS implements Imposto {

    private final TNFe.InfNFe.Det.Imposto.COFINS cofins;

    public COFINS(TNFe.InfNFe.Det.Imposto.COFINS cofins) {
        this.cofins = cofins;
    }

    @Override
    public String getCST() {
        if (cofins.getCOFINSAliq() != null) {
            return cofins.getCOFINSAliq().getCST();
        } else if (cofins.getCOFINSNT() != null) {
            return cofins.getCOFINSNT().getCST();
        } else if (cofins.getCOFINSOutr() != null) {
            return cofins.getCOFINSOutr().getCST();
        } else if (cofins.getCOFINSQtde() != null) {
            return cofins.getCOFINSQtde().getCST();
        } else {
            return null;
        }
    }

    @Override
    public String getBase() {
        if (cofins.getCOFINSAliq() != null) {
            return cofins.getCOFINSAliq().getVBC();
        } else if (cofins.getCOFINSNT() != null) {
            return "0";
        } else if (cofins.getCOFINSOutr() != null) {
            return cofins.getCOFINSOutr().getVBC();
        } else if (cofins.getCOFINSQtde() != null) {
            return cofins.getCOFINSQtde().getQBCProd();
        } else {
            return null;
        }
    }

    @Override
    public String getAliquota() {
        if (cofins.getCOFINSAliq() != null) {
            return cofins.getCOFINSAliq().getPCOFINS();
        } else if (cofins.getCOFINSNT() != null) {
            return "0";
        } else if (cofins.getCOFINSOutr() != null) {
            return cofins.getCOFINSOutr().getPCOFINS();
        } else if (cofins.getCOFINSQtde() != null) {
            return cofins.getCOFINSQtde().getVAliqProd();
        } else {
            return null;
        }
    }

    @Override
    public String getValor() {
        if (cofins.getCOFINSAliq() != null) {
            return cofins.getCOFINSAliq().getVCOFINS();
        } else if (cofins.getCOFINSNT() != null) {
            return "0";
        } else if (cofins.getCOFINSOutr() != null) {
            return cofins.getCOFINSOutr().getVCOFINS();
        } else if (cofins.getCOFINSQtde() != null) {
            return cofins.getCOFINSQtde().getVCOFINS();
        } else {
            return null;
        }
    }

}
