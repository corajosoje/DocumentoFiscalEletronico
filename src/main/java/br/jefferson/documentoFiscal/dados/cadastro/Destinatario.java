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
public class Destinatario {

    public EnderecoDest getEndereco() {
        return new EnderecoDest();
    }

    public String getCnpj() {

        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getDest().getCNPJ();
                case 57:
                    if (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma4().getCNPJ();
                    } else {
                        switch (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getRem().getCNPJ();
                            case "1"://Expedidor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getExped().getCNPJ();
                            case "2"://Recebedor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getReceb().getCNPJ();
                            case "3"://Destinatário
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getDest().getCNPJ();
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Destinatario.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

    }

    public String getRazaoSocial() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getDest().getXNome();
                case 57:
                    if (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma4().getXNome();
                    } else {
                        switch (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getRem().getXNome();
                            case "1"://Expedidor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getExped().getXNome();
                            case "2"://Recebedor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getReceb().getXNome();
                            case "3"://Destinatário
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getDest().getXNome();
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Destinatario.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
