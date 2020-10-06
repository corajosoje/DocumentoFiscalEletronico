/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.transporte;

import br.jefferson.conhecimento3a.CteProc;
import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.util.Util;

/**
 *
 * @author jeffe
 */
public class Remetente {

    private static CteProc CTe;

    public Remetente() {
        if (GeradorDocumentoFiscal.xml instanceof CteProc) {
            CTe = (CteProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new IllegalStateException("Documento Inválido");
        }
    }

    public String getCNPJ() {
        try {
            if (CTe.getCTe().getInfCte().getRem().getCNPJ() == null) {
                return Util.notNull(CTe.getCTe().getInfCte().getRem().getCPF());
            } else {
                return Util.notNull(CTe.getCTe().getInfCte().getRem().getCNPJ());
            }
        } catch (NullPointerException e) {
            return "";
        }
    }

    public String getIE() {
        try {
            return Util.notNull(CTe.getCTe().getInfCte().getRem().getIE());
        } catch (NullPointerException e) {
            return "";
        }
    }

    public String getUF() {
        try {
            return Util.notNull(CTe.getCTe().getInfCte().getRem().getEnderReme().getUF().value());
        } catch (NullPointerException e) {
            return "";
        }
    }
}
