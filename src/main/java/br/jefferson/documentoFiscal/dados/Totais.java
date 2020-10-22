/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados;

import br.jefferson.conhecimento3a.CteProc;
import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.util.Util;
import br.jefferson.notafiscal4.TNfeProc;

/**
 *
 * @author jeffersonsvo
 */
public class Totais {

    private static TNfeProc NFe;
    private static CteProc CTe;

    public Totais() {
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

    public String getTotalItens() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVProd());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getDespesasAcessorias() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVOutro());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getDesconto() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVDesc());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getFrete() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVFrete());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getSeguro() {
        try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVSeg();
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getBaseIcms() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVBC());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorIcms() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVICMS());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getBaseIcmsST() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVBCST());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorIcmsST() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVST());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorFcpST() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVFCPST());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorIpi() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVIPI());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorIpiDevolvido() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVIPIDevol());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorPis() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVPIS());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorCofins() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVCOFINS());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getTotal() {
        try {
            if (NFe == null) {
                return Util.notNull(CTe.getCTe().getInfCte().getVPrest().getVTPrest());
            } else {
                return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVNF());
            }
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorIcmsDesonerado() {
        try {
            return Util.notNull(NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVICMSDeson());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

}
