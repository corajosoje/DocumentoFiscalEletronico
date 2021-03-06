/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.cadastro;

import br.jefferson.conhecimento3a.CteProc;
import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.util.Util;
import br.jefferson.notafiscal4.TNfeProc;

/**
 *
 * @author jeffersonsvo
 */
public class EnderecoDest {

    private static TNfeProc NFe;
    private static CteProc CTe;

    public EnderecoDest() {
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

    public String getUf() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return Util.notNull(NFe.getNFe().getInfNFe().getDest().getEnderDest().getUF().value());
                case 57:
                    if (CTe.getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return Util.notNull(CTe.getCTe().getInfCte().getIde().getToma4().getEnderToma().getUF().value());
                    } else {
                        switch (CTe.getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return Util.notNull(CTe.getCTe().getInfCte().getRem().getEnderReme().getUF().value());
                            case "1"://Expedidor
                                return Util.notNull(CTe.getCTe().getInfCte().getExped().getEnderExped().getUF().value());
                            case "2"://Recebedor
                                return Util.notNull(CTe.getCTe().getInfCte().getReceb().getEnderReceb().getUF().value());
                            case "3"://Destinatário
                                return Util.notNull(CTe.getCTe().getInfCte().getDest().getEnderDest().getUF().value());
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getLogradouro() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return Util.notNull(NFe.getNFe().getInfNFe().getDest().getEnderDest().getXLgr());
                case 57:
                    if (CTe.getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return Util.notNull(CTe.getCTe().getInfCte().getIde().getToma4().getEnderToma().getXLgr());
                    } else {
                        switch (CTe.getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return Util.notNull(CTe.getCTe().getInfCte().getRem().getEnderReme().getXLgr());
                            case "1"://Expedidor
                                return Util.notNull(CTe.getCTe().getInfCte().getExped().getEnderExped().getXLgr());
                            case "2"://Recebedor
                                return Util.notNull(CTe.getCTe().getInfCte().getReceb().getEnderReceb().getXLgr());
                            case "3"://Destinatário
                                return Util.notNull(CTe.getCTe().getInfCte().getDest().getEnderDest().getXLgr());
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getNumero() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return Util.notNull(NFe.getNFe().getInfNFe().getDest().getEnderDest().getNro());
                case 57:
                    if (CTe.getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return Util.notNull(CTe.getCTe().getInfCte().getIde().getToma4().getEnderToma().getNro());
                    } else {
                        switch (CTe.getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return Util.notNull(CTe.getCTe().getInfCte().getRem().getEnderReme().getNro());
                            case "1"://Expedidor
                                return Util.notNull(CTe.getCTe().getInfCte().getExped().getEnderExped().getNro());
                            case "2"://Recebedor
                                return Util.notNull(CTe.getCTe().getInfCte().getReceb().getEnderReceb().getNro());
                            case "3"://Destinatário
                                return Util.notNull(CTe.getCTe().getInfCte().getDest().getEnderDest().getNro());
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getIe() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return Util.notNull(NFe.getNFe().getInfNFe().getDest().getIE());
                case 57:
                    if (CTe.getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return Util.notNull(CTe.getCTe().getInfCte().getIde().getToma4().getIE());
                    } else {
                        switch (CTe.getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return Util.notNull(CTe.getCTe().getInfCte().getRem().getIE());
                            case "1"://Expedidor
                                return Util.notNull(CTe.getCTe().getInfCte().getExped().getIE());
                            case "2"://Recebedor
                                return Util.notNull(CTe.getCTe().getInfCte().getReceb().getIE());
                            case "3"://Destinatário
                                return Util.notNull(CTe.getCTe().getInfCte().getDest().getIE());
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }

        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getBairro() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return Util.notNull(NFe.getNFe().getInfNFe().getDest().getEnderDest().getXBairro());
                case 57:
                    if (CTe.getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return Util.notNull(CTe.getCTe().getInfCte().getIde().getToma4().getEnderToma().getXBairro());
                    } else {
                        switch (CTe.getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return Util.notNull(CTe.getCTe().getInfCte().getRem().getEnderReme().getXBairro());
                            case "1"://Expedidor
                                return Util.notNull(CTe.getCTe().getInfCte().getExped().getEnderExped().getXBairro());
                            case "2"://Recebedor
                                return Util.notNull(CTe.getCTe().getInfCte().getReceb().getEnderReceb().getXBairro());
                            case "3"://Destinatário
                                return Util.notNull(CTe.getCTe().getInfCte().getDest().getEnderDest().getXBairro());
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getComplemento() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return Util.notNull(NFe.getNFe().getInfNFe().getDest().getEnderDest().getXCpl());
                case 57:
                    if (CTe.getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return Util.notNull(CTe.getCTe().getInfCte().getIde().getToma4().getEnderToma().getXCpl());
                    } else {
                        switch (CTe.getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return Util.notNull(CTe.getCTe().getInfCte().getRem().getEnderReme().getXCpl());
                            case "1"://Expedidor
                                return Util.notNull(CTe.getCTe().getInfCte().getExped().getEnderExped().getXCpl());
                            case "2"://Recebedor
                                return Util.notNull(CTe.getCTe().getInfCte().getReceb().getEnderReceb().getXCpl());
                            case "3"://Destinatário
                                return Util.notNull(CTe.getCTe().getInfCte().getDest().getEnderDest().getXCpl());
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getIBGE() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return Util.notNull(NFe.getNFe().getInfNFe().getDest().getEnderDest().getCMun());
                case 57:
                    if (CTe.getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return Util.notNull(CTe.getCTe().getInfCte().getIde().getToma4().getEnderToma().getCMun());
                    } else {
                        switch (CTe.getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return Util.notNull(CTe.getCTe().getInfCte().getRem().getEnderReme().getCMun());
                            case "1"://Expedidor
                                return Util.notNull(CTe.getCTe().getInfCte().getExped().getEnderExped().getCMun());
                            case "2"://Recebedor
                                return Util.notNull(CTe.getCTe().getInfCte().getReceb().getEnderReceb().getCMun());
                            case "3"://Destinatário
                                return Util.notNull(CTe.getCTe().getInfCte().getDest().getEnderDest().getCMun());
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getCEP() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return Util.notNull(NFe.getNFe().getInfNFe().getDest().getEnderDest().getCEP());
                case 57:
                    if (CTe.getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return Util.notNull(CTe.getCTe().getInfCte().getIde().getToma4().getEnderToma().getCEP());
                    } else {
                        switch (CTe.getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return Util.notNull(CTe.getCTe().getInfCte().getRem().getEnderReme().getCEP());
                            case "1"://Expedidor
                                return Util.notNull(CTe.getCTe().getInfCte().getExped().getEnderExped().getCEP());
                            case "2"://Recebedor
                                return Util.notNull(CTe.getCTe().getInfCte().getReceb().getEnderReceb().getCEP());
                            case "3"://Destinatário
                                return Util.notNull(CTe.getCTe().getInfCte().getDest().getEnderDest().getCEP());
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            return "";
        }
    }

}
