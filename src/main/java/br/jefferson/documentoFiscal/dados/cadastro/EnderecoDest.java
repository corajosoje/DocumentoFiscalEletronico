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
public class EnderecoDest {

    public String getUf() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getDest().getEnderDest().getUF().value();
                case 57:
                    if (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma4().getEnderToma().getUF().value();
                    } else {
                        switch (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getRem().getEnderReme().getUF().value();
                            case "1"://Expedidor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getExped().getEnderExped().getUF().value();
                            case "2"://Recebedor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getReceb().getEnderReceb().getUF().value();
                            case "3"://Destinatário
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getDest().getEnderDest().getUF().value();
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoDest.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getLogradouro() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getDest().getEnderDest().getXLgr();
                case 57:
                    if (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma4().getEnderToma().getXLgr();
                    } else {
                        switch (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getRem().getEnderReme().getXLgr();
                            case "1"://Expedidor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getExped().getEnderExped().getXLgr();
                            case "2"://Recebedor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getReceb().getEnderReceb().getXLgr();
                            case "3"://Destinatário
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getDest().getEnderDest().getXLgr();
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoDest.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getNumero() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getDest().getEnderDest().getNro();
                case 57:
                    if (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma4().getEnderToma().getNro();
                    } else {
                        switch (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getRem().getEnderReme().getNro();
                            case "1"://Expedidor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getExped().getEnderExped().getNro();
                            case "2"://Recebedor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getReceb().getEnderReceb().getNro();
                            case "3"://Destinatário
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getDest().getEnderDest().getNro();
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoDest.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getIe() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getDest().getIE();
                case 57:
                    if (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma4().getIE();
                    } else {
                        switch (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getRem().getIE();
                            case "1"://Expedidor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getExped().getIE();
                            case "2"://Recebedor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getReceb().getIE();
                            case "3"://Destinatário
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getDest().getIE();
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }

        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoDest.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getBairro() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getDest().getEnderDest().getXBairro();
                case 57:
                    if (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma4().getEnderToma().getXBairro();
                    } else {
                        switch (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getRem().getEnderReme().getXBairro();
                            case "1"://Expedidor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getExped().getEnderExped().getXBairro();
                            case "2"://Recebedor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getReceb().getEnderReceb().getXBairro();
                            case "3"://Destinatário
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getDest().getEnderDest().getXBairro();
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoDest.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getComplemento() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getDest().getEnderDest().getXCpl();
                case 57:
                    if (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma4().getEnderToma().getXCpl();
                    } else {
                        switch (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getRem().getEnderReme().getXCpl();
                            case "1"://Expedidor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getExped().getEnderExped().getXCpl();
                            case "2"://Recebedor
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getReceb().getEnderReceb().getXCpl();
                            case "3"://Destinatário
                                return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getDest().getEnderDest().getXCpl();
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(EnderecoDest.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

}
