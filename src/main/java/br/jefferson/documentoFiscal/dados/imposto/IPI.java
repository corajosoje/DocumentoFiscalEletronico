/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.imposto;

import br.jefferson.documentoFiscal.util.Util;
import br.jefferson.notafiscal4.TIpi;

/**
 *
 * @author jeffersonsvo
 */
public class IPI implements Imposto {

    private final br.jefferson.notafiscal4.TIpi ipi;

    public IPI(TIpi ipi) {
        this.ipi = ipi;
    }

    @Override
    public String getCST() {
        if (ipi == null) {
            return "";
        } else {
            if (ipi.getIPITrib() != null) {
                return ipi.getIPITrib().getCST();
            } else if (ipi.getIPINT() != null) {
                return ipi.getIPINT().getCST();
            } else {
                return "";
            }
        }
    }

    @Override
    public String getBase() {
        if (ipi == null) {
            return "0";
        } else {
            if (ipi.getIPITrib() != null) {
                return ipi.getIPITrib().getVBC();
            } else {
                return "0";
            }
        }
    }

    @Override
    public String getAliquota() {
        if (ipi == null) {
            return "0";
        } else {
            if (ipi.getIPITrib() != null) {
                return ipi.getIPITrib().getPIPI();
            } else {
                return "0";
            }
        }
    }

    @Override
    public String getValor() {
        if (ipi == null) {
            return "0";
        } else {
            if (ipi.getIPITrib() != null) {
                try {
                    return Util.notNull(ipi.getIPITrib().getVIPI());
                } catch (NullPointerException ex) {
                    return "0";
                }
            } else {
                return "0";
            }
        }
    }

}
