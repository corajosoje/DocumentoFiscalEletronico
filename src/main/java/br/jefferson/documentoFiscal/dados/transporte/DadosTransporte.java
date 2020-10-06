/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.transporte;

import br.jefferson.conhecimento3a.CteProc;
import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.util.Util;
import br.jefferson.notafiscal4.TNfeProc;

/**
 *
 * @author jeffe
 */
public class DadosTransporte {

    private static CteProc CTe;

    public DadosTransporte() {
        if (GeradorDocumentoFiscal.xml instanceof CteProc) {
            CTe = (CteProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new IllegalStateException("Documento Inválido");
        }
    }

    public Remetente getRemetente() {
        return new Remetente();
    }

    public Destinatario getDestinatario() {
        return new Destinatario();
    }

    public Recebedor getRecebedor() {
        return new Recebedor();
    }

    public String getIBGEInicio() {
        try {
            return Util.notNull(CTe.getCTe().getInfCte().getIde().getCMunIni());
        } catch (NullPointerException e) {
            return "";
        }
    }

    public String getIBGEFim() {
        try {
            return Util.notNull(CTe.getCTe().getInfCte().getIde().getCMunFim());
        } catch (NullPointerException e) {
            return "";
        }
    }

    public String getMunFim() {
        try {
            return Util.notNull(CTe.getCTe().getInfCte().getIde().getXMunFim());
        } catch (NullPointerException e) {
            return "";
        }
    }

    public String getMunInicio() {
        try {
            return Util.notNull(CTe.getCTe().getInfCte().getIde().getXMunIni());
        } catch (NullPointerException e) {
            return "";
        }
    }
}
