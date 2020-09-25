/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.cadastro;

import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.exception.GeradorDocumentoFiscalException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffersonsvo
 */
public class EnderecoEmit {

    public String getUf() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getEmit().getEnderEmit().getUF().value();
                case 57:
                    return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getEmit().getEnderEmit().getUF().value();
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getLogradouro() {
        try {

            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getEmit().getEnderEmit().getXLgr();
                case 57:
                    return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getEmit().getEnderEmit().getXLgr();
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getNumero() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getEmit().getEnderEmit().getNro();
                case 57:
                    return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getEmit().getEnderEmit().getNro();
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getIe() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getEmit().getIE();
                case 57:
                    return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getEmit().getIE();
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getBairro() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getEmit().getEnderEmit().getXBairro();
                case 57:
                    return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getEmit().getEnderEmit().getXBairro();
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getComplemento() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getEmit().getEnderEmit().getXCpl();
                case 57:
                    return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getEmit().getEnderEmit().getXCpl();
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoEmit.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

}
