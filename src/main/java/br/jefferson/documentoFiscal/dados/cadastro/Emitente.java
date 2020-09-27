/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.cadastro;

import br.jefferson.conhecimento3a.CteProc;
import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.exception.GeradorDocumentoFiscalException;
import br.jefferson.notafiscal4.TNfeProc;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffe
 */
public class Emitente {

    private static TNfeProc NFe;
    private static CteProc CTe;

    public Emitente() {
        if (GeradorDocumentoFiscal.xml instanceof TNfeProc) {
            NFe = (TNfeProc) GeradorDocumentoFiscal.xml;
            CTe = null;
        } else if (GeradorDocumentoFiscal.xml instanceof CteProc) {
            NFe = null;
            CTe = (CteProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new IllegalStateException("Documento Inválido");
        }
    }

    public EnderecoEmit getEndereco() {
        return new EnderecoEmit();
    }

    public String getCnpj() {

        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return NFe.getNFe().getInfNFe().getEmit().getCNPJ();
                case 57:
                    return CTe.getCTe().getInfCte().getEmit().getCNPJ();
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(Emitente.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

    }

    public String getRazaoSocial() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return NFe.getNFe().getInfNFe().getEmit().getXNome();
                case 57:
                    return CTe.getCTe().getInfCte().getEmit().getXNome();
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(Emitente.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

}
