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
 * @author jeffe
 */
public class Emitente {

    public EnderecoEmit getEndereco() {
        return new EnderecoEmit();
    }

    public String getCnpj() {

        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getEmit().getCNPJ();
                case 57:
                    return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getEmit().getCNPJ();
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Emitente.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

    }

    public String getRazaoSocial() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getEmit().getXNome();
                case 57:
                   return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getEmit().getXNome();
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Emitente.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

}
