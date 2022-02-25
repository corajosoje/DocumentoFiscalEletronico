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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author jeffe
 */
public class Destinatario {

    private static TNfeProc NFe;
    private static CteProc CTe;
    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(Destinatario.class.getName());

    public Destinatario() {
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

    public EnderecoDest getEndereco() {
        return new EnderecoDest();
    }

    public String getCnpj() {

        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    log.debug("Iniciando pegar CPF/CNPJ do xml");
                    log.debug("Cnpj = " + NFe.getNFe().getInfNFe().getDest().getCNPJ());
                    log.debug("Cpf = " + NFe.getNFe().getInfNFe().getDest().getCPF());

                    if (NFe.getNFe().getInfNFe().getDest().getCNPJ() != null) {
                        return NFe.getNFe().getInfNFe().getDest().getCNPJ();
                    } else if (NFe.getNFe().getInfNFe().getDest().getCPF() != null) {
                        return NFe.getNFe().getInfNFe().getDest().getCPF();
                    } else {
                        return "";
                    }
                case 57:
                    if (CTe.getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return CTe.getCTe().getInfCte().getIde().getToma4().getCNPJ();
                    } else {
                        switch (CTe.getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return CTe.getCTe().getInfCte().getRem().getCNPJ();
                            case "1"://Expedidor
                                return CTe.getCTe().getInfCte().getExped().getCNPJ();
                            case "2"://Recebedor
                                return CTe.getCTe().getInfCte().getReceb().getCNPJ();
                            case "3"://Destinatário
                                return CTe.getCTe().getInfCte().getDest().getCNPJ();
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

    public String getRazaoSocial() {
        try {
            switch (GeradorDocumentoFiscal.modelo) {
                case 55:
                    return NFe.getNFe().getInfNFe().getDest().getXNome();
                case 57:
                    if (CTe.getCTe().getInfCte().getIde().getToma3().getToma() == null) {
                        return CTe.getCTe().getInfCte().getIde().getToma4().getXNome();
                    } else {
                        switch (CTe.getCTe().getInfCte().getIde().getToma3().getToma()) {
                            case "0"://Remetente
                                return CTe.getCTe().getInfCte().getRem().getXNome();
                            case "1"://Expedidor
                                return CTe.getCTe().getInfCte().getExped().getXNome();
                            case "2"://Recebedor
                                return CTe.getCTe().getInfCte().getReceb().getXNome();
                            case "3"://Destinatário
                                return CTe.getCTe().getInfCte().getDest().getXNome();
                            default:
                                return "";
                        }
                    }
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(Destinatario.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
