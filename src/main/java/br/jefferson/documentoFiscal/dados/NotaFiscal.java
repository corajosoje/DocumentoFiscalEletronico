/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados;

import br.jefferson.documentoFiscal.dados.cadastro.Emitente;
import br.jefferson.documentoFiscal.dados.cadastro.Destinatario;
import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.notafiscal4.TNFe;
import br.jefferson.notafiscal4.TNfeProc;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffe
 */
public class NotaFiscal implements DocumentoFiscal {

    private static TNfeProc NFe;

    public NotaFiscal() {
        if (GeradorDocumentoFiscal.xml instanceof TNfeProc) {
            NFe = (TNfeProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new IllegalStateException("Documento Inválido");
        }
    }

    @Override
    public String getChave() {
        try {
            return NFe.getProtNFe().getInfProt().getChNFe();
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public int getModelo() {
        return GeradorDocumentoFiscal.modelo;
    }

    @Override
    public Emitente getEmitente() {
        return new Emitente();
    }

    @Override
    public Destinatario getDestinatario() {
        return new Destinatario();
    }

    @Override
    public String getNumero() {
        try {
            return NFe.getNFe().getInfNFe().getIde().getNNF();
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public String getSerie() {
        try {
            return NFe.getNFe().getInfNFe().getIde().getSerie();
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public Totais getTotais() {
        return new Totais();
    }

    @Override
    public String getSituacaoDestinatario() {
        try {
            switch (NFe.getNFe().getInfNFe().getDest().getIndIEDest()) {
                case "1":
                    return "Contribuinte ICMS";
                case "2":
                    return "Contribuinte isento de IE";
                case "9":
                    return "Não Contribuinte";
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public String getFinalidadeNFe() {
        try {
            switch (NFe.getNFe().getInfNFe().getIde().getFinNFe()) {
                case "1":
                    return "NF-e normal";
                case "2":
                    return "NF-e complementar";
                case "3":
                    return "NF-e de ajuste";
                case "4":
                    return "NF-e Devolução";
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public String getTipoOperacao() {
        try {
            switch (NFe.getNFe().getInfNFe().getIde().getIndFinal()) {
                case "0":
                    return "Normal";
                case "1":
                    return "Consumidor Final";
                default:
                    return "";
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public java.util.Date getDataEmissao() {
        try {
            return GeradorDocumentoFiscal.FORMAT.parse(NFe.getNFe().getInfNFe().getIde().getDhEmi().substring(0, 10));
        } catch (NullPointerException | ParseException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public java.util.List<Item> getItens() {
        java.util.List<Item> itens = new java.util.ArrayList<>();
        try {
            NFe.getNFe().getInfNFe().getDet().forEach((TNFe.InfNFe.Det det) -> {
                itens.add(new Item(det));
            });
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return itens;
    }

    @Override
    public String getNaturezaOperacao() {
        try {
            return NFe.getNFe().getInfNFe().getIde().getNatOp();
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public String getInfoAdicionais() {
        try {
            return NFe.getNFe().getInfNFe().getInfAdic().getInfCpl();
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public String getInfoFisco() {
        try {
            return NFe.getNFe().getInfNFe().getInfAdic().getInfAdFisco();
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
}
