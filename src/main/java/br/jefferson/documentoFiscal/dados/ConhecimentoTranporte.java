/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados;

import br.jefferson.documentoFiscal.dados.transporte.DadosTransporte;
import br.jefferson.conhecimento3a.CteProc;
import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.dados.cadastro.Destinatario;
import br.jefferson.documentoFiscal.dados.cadastro.Emitente;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffe
 */
public class ConhecimentoTranporte implements DocumentoFiscal {

    private static CteProc CTe;

    public ConhecimentoTranporte() {
        if (GeradorDocumentoFiscal.xml instanceof CteProc) {
            CTe = (CteProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new IllegalStateException("Documento Inválido");
        }
    }

    @Override
    public Date getDataEmissao() {
        try {
            return GeradorDocumentoFiscal.FORMAT.parse(CTe.getCTe().getInfCte().getIde().getDhEmi().substring(0, 10));
        } catch (NullPointerException | ParseException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getChave() {
        try {
            return CTe.getProtCTe().getInfProt().getChCTe();
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public int getModelo() {
        return 57;
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
    public List<Item> getItens() {
        throw new UnsupportedOperationException("Metodo não suportado");
    }

    @Override
    public String getNumero() {
        try {
            return CTe.getCTe().getInfCte().getIde().getNCT();
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public String getSerie() {
        try {
            return CTe.getCTe().getInfCte().getIde().getSerie();
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public Totais getTotais() {
        throw new UnsupportedOperationException("Metodo não suportado");
    }

    @Override
    public String getSituacaoDestinatario() {
        throw new UnsupportedOperationException("Metodo não suportado");
    }

    @Override
    public String getFinalidadeNFe() {
        try {
            switch (CTe.getCTe().getInfCte().getIde().getTpCTe()) {
                case "0":
                    return "Normal";
                case "1":
                    return "Complementar";
                case "2":
                    return "Anulação";
                case "3":
                    return "Substituto";
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
        throw new UnsupportedOperationException("Metodo não suportado");
    }

    @Override
    public String getNaturezaOperacao() {
        return "Conhecimento de transporte";
    }

    @Override
    public String getInfoAdicionais() {
        try {
            throw new UnsupportedOperationException("Metodo não suportado");
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public String getInfoFisco() {
        try {
            throw new UnsupportedOperationException("Metodo não suportado");
        } catch (NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public DadosTransporte getDadosTransporte() {
        return new DadosTransporte();
    }
}
