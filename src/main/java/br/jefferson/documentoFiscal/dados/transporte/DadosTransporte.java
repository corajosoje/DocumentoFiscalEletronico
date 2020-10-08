/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.transporte;

import br.jefferson.conhecimento3a.CteProc;
import br.jefferson.conhecimento3a.TCTe;
import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.util.Util;
import br.jefferson.notafiscal4.TNfeProc;
import java.util.HashSet;
import java.util.List;

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

    public ICMSTransporte getICMSTransporte() {
        return new ICMSTransporte();
    }

    public Remetente getRemetente() {
        return new Remetente();
    }

    public java.util.List<String> getNFTransportada() {
        java.util.List<String> notas = new java.util.ArrayList<>();
        switch (CTe.getCTe().getInfCte().getIde().getTpCTe()) {
            case "0":
                CTe.getCTe().getInfCte().getInfCTeNorm().getInfDoc().getInfNFe().forEach((infNFe) -> {
                    notas.add(Util.notNull(infNFe.getChave()));
                });
                CTe.getCTe().getInfCte().getInfCTeNorm().getInfDoc().getInfNF().forEach((infNFe) -> {
                    notas.add(Util.notNull(infNFe.getNDoc()));
                });
                CTe.getCTe().getInfCte().getInfCTeNorm().getInfDoc().getInfOutros().forEach((infNFe) -> {
                    notas.add(Util.notNull(infNFe.getNDoc()));
                });
                break;

            case "1":
                notas.add(Util.notNull(CTe.getCTe().getInfCte().getInfCteComp().getChCTe()));
                break;
            case "2":
                notas.add(Util.notNull(CTe.getCTe().getInfCte().getInfCteAnu().getChCte()));
                break;
            case "3":
                notas.add(Util.notNull(CTe.getCTe().getInfCte().getInfCTeNorm().getInfCteSub().getChCte()));
                break;
        }
        return notas;
    }

    public String getQtdeNfTransportada() {
        switch (CTe.getCTe().getInfCte().getIde().getTpCTe()) {
            case "0":
                int soma = 0;
                if (CTe.getCTe().getInfCte().getInfCTeNorm().getInfDoc().getInfNF() != null) {
                    soma = soma + CTe.getCTe().getInfCte().getInfCTeNorm().getInfDoc().getInfNF().size();
                }
                if (CTe.getCTe().getInfCte().getInfCTeNorm().getInfDoc().getInfNFe() != null) {
                    soma = soma + CTe.getCTe().getInfCte().getInfCTeNorm().getInfDoc().getInfNFe().size();
                }
                if (CTe.getCTe().getInfCte().getInfCTeNorm().getInfDoc().getInfOutros() != null) {
                    soma = soma + CTe.getCTe().getInfCte().getInfCTeNorm().getInfDoc().getInfOutros().size();
                }
                return String.valueOf(soma);
            case "1":
                if (CTe.getCTe().getInfCte().getInfCteComp().getChCTe() != null) {
                    return "1";
                } else {
                    return "0";
                }
            case "2":
                if (CTe.getCTe().getInfCte().getInfCteAnu().getChCte() != null) {
                    return "1";
                } else {
                    return "0";
                }
            case "3":
                if (CTe.getCTe().getInfCte().getInfCTeNorm().getInfCteSub().getChCte() != null) {
                    return "1";
                } else {
                    return "0";
                }
            default:
                return "0";
        }
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
