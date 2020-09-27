/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados;

import br.jefferson.conhecimento3a.CteProc;
import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.notafiscal4.TNfeProc;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVProd();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getDespesasAcessorias() {
        try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVOutro();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getDesconto() {
        try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVDesc();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getFrete() {
       try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVFrete();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getSeguro() {
        try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVSeg();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getBaseIcms() {
        try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVBC();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorIcms() {
        try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVICMS();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getBaseIcmsST() {
     try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVBCST();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorIcmsST() {
       try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVST();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorFcpST() {
         try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVFCPST();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorIpi() {
         try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVIPI();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorIpiDevolvido() {
        try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVIPIDevol();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorPis() {
         try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVPIS();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorCofins() {
         try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVCOFINS();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getTotal() {
        try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVNF();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorIcmsDesonerado() {
        try {
            return NFe.getNFe().getInfNFe().getTotal().getICMSTot().getVICMSDeson();
        } catch (NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }
    
    
}
