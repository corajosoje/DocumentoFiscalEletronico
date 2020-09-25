/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.imposto;

import br.jefferson.documentoFiscal.dados.imposto.Imposto;
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
        if (ipi.getIPITrib() != null) {
            return ipi.getIPINT().getCST();
        } else if (ipi.getIPINT() != null) {
            return ipi.getIPINT().getCST();
        } else {
            return "";
        }

    }

    @Override
    public String getBase() {
        if (ipi.getIPITrib() != null) {
            return ipi.getIPITrib().getVBC();
        } else {
            return "";
        }

    }

    @Override
    public String getAliquota() {
        if (ipi.getIPITrib() != null) {
            return ipi.getIPITrib().getPIPI();
        } else {
            return "";
        }
    }

    @Override
    public String getValor() {
        if (ipi.getIPITrib() != null) {
            return ipi.getIPITrib().getVIPI();
        } else {
            return "";
        }
    }
    

}
