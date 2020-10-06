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
public class Destinatario {

    private static CteProc CTe;

    public Destinatario() {
        if (GeradorDocumentoFiscal.xml instanceof CteProc) {
            CTe = (CteProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new IllegalStateException("Documento Inválido");
        }
    }

    public String getCNPJ() {
        try {
            if (CTe.getCTe().getInfCte().getDest().getCNPJ() == null) {
                return Util.notNull(CTe.getCTe().getInfCte().getDest().getCPF());
            } else {
                return Util.notNull(CTe.getCTe().getInfCte().getDest().getCNPJ());
            }
        } catch (NullPointerException e) {
            return "";
        }
    }

    public String getIE() {
        try {
            return Util.notNull(CTe.getCTe().getInfCte().getDest().getIE());
        } catch (NullPointerException e) {
            return "";
        }
    }

    public String getUF() {
        try {
            return Util.notNull(CTe.getCTe().getInfCte().getDest().getEnderDest().getUF().value());
        } catch (NullPointerException e) {
            return "";
        }
    }
}
