/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados;

import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.dados.cadastro.Destinatario;
import br.jefferson.documentoFiscal.dados.cadastro.Emitente;
import br.jefferson.documentoFiscal.exception.GeradorDocumentoFiscalException;
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

    @Override
    public Date getDataEmissao() {
        try {
            return GeradorDocumentoFiscal.FORMAT.parse(GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getDhEmi().substring(0, 10));
        } catch (GeradorDocumentoFiscalException | NullPointerException | ParseException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getChave() {
        try {
            return GeradorDocumentoFiscal.getConhecimentoTransporte().getProtCTe().getInfProt().getChCTe();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
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
            return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getNCT();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public String getSerie() {
        try {
            return GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getSerie();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
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
            switch (GeradorDocumentoFiscal.getConhecimentoTransporte().getCTe().getInfCte().getIde().getTpCTe()) {
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
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public String getTipoOperacao() {
        throw new UnsupportedOperationException("Metodo não suportado"); 
    }

}
