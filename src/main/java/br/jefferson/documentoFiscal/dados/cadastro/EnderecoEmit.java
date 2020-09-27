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
 * @author jeffersonsvo
 */
public class EnderecoEmit {
private static TNfeProc NFe;
    private static CteProc CTe;

    public EnderecoEmit() {
        if (GeradorDocumentoFiscal.xml instanceof TNfeProc) {
            NFe = (TNfeProc)GeradorDocumentoFiscal.xml;
            CTe = null;
        } else if (GeradorDocumentoFiscal.xml instanceof CteProc) {
            NFe = null;
            CTe = (CteProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new IllegalStateException("Documento Inválido");
        }
    }
    public String getUf() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return NFe.getNFe().getInfNFe().getEmit().getEnderEmit().getUF().value();
                case 57:
                    return CTe.getCTe().getInfCte().getEmit().getEnderEmit().getUF().value();
                default:
                    return "";
            }
        } catch ( NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getLogradouro() {
        try {

            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return NFe.getNFe().getInfNFe().getEmit().getEnderEmit().getXLgr();
                case 57:
                    return CTe.getCTe().getInfCte().getEmit().getEnderEmit().getXLgr();
                default:
                    return "";
            }
        } catch ( NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getNumero() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return NFe.getNFe().getInfNFe().getEmit().getEnderEmit().getNro();
                case 57:
                    return CTe.getCTe().getInfCte().getEmit().getEnderEmit().getNro();
                default:
                    return "";
            }
        } catch ( NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getIe() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return NFe.getNFe().getInfNFe().getEmit().getIE();
                case 57:
                    return CTe.getCTe().getInfCte().getEmit().getIE();
                default:
                    return "";
            }
        } catch ( NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getBairro() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return NFe.getNFe().getInfNFe().getEmit().getEnderEmit().getXBairro();
                case 57:
                    return CTe.getCTe().getInfCte().getEmit().getEnderEmit().getXBairro();
                default:
                    return "";
            }
        } catch ( NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getComplemento() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return NFe.getNFe().getInfNFe().getEmit().getEnderEmit().getXCpl();
                case 57:
                    return CTe.getCTe().getInfCte().getEmit().getEnderEmit().getXCpl();
                default:
                    return "";
            }
        } catch ( NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

}
