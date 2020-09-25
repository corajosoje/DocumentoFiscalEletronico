/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados;

import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.exception.GeradorDocumentoFiscalException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffersonsvo
 */
public class Totais {
  
    public String getTotalItens() {
        try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVProd();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getDespesasAcessorias() {
        try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVOutro();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getDesconto() {
        try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVDesc();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getFrete() {
       try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVFrete();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getSeguro() {
        try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVSeg();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getBaseIcms() {
        try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVBC();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorIcms() {
        try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVICMS();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getBaseIcmsST() {
     try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVBCST();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorIcmsST() {
       try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVST();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorFcpST() {
         try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVFCPST();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorIpi() {
         try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVIPI();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorIpiDevolvido() {
        try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVIPIDevol();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorPis() {
         try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVPIS();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorCofins() {
         try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVCOFINS();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getTotal() {
        try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVNF();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorIcmsDesonerado() {
        try {
            return GeradorDocumentoFiscal.getNotaFiscal().getNFe().getInfNFe().getTotal().getICMSTot().getVICMSDeson();
        } catch (GeradorDocumentoFiscalException | NullPointerException ex) {
            Logger.getLogger(Totais.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }
    
    
}
