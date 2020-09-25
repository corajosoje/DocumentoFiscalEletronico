/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados;

import br.jefferson.documentoFiscal.dados.imposto.COFINS;
import br.jefferson.documentoFiscal.dados.imposto.IPI;
import br.jefferson.documentoFiscal.dados.imposto.PIS;
import br.jefferson.documentoFiscal.dados.imposto.ICMS;
import br.jefferson.documentoFiscal.dados.imposto.Imposto;
import br.jefferson.notafiscal4.TIpi;
import br.jefferson.notafiscal4.TNFe;
import br.jefferson.documentoFiscal.dados.imposto.ICMSST;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffersonsvo
 */
public class Item {

    private TNFe.InfNFe.Det.Imposto.ICMS icms = null;
    private TNFe.InfNFe.Det.Imposto.COFINS cofins = null;
    private TNFe.InfNFe.Det.Imposto.PIS pis = null;
    private TIpi ipi = null;
    private final TNFe.InfNFe.Det det;

    public Item(TNFe.InfNFe.Det det) {
        this.det = det;
        getImposto();
    }

    public String getNumeroItem() {
        try {
            return det.getNItem();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorContabil() {
        double total = Double.parseDouble(getICMSST().getICMSST())
                + Double.parseDouble(getValorTotal())
                + Double.parseDouble(getValorfrete())
                + Double.parseDouble(getValorSeguro())
                - Double.parseDouble(getDesconto());

        return String.valueOf(total);
    }

    public String getCfop() {
        try {
            return det.getProd().getCFOP();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String getValorUnitario() {
        try {
            return det.getProd().getVUnTrib();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getQuantidade() {
        try {
            return det.getProd().getQTrib();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorTotal() {
        try {
            return det.getProd().getVProd();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorUnit() {
        try {
            return det.getProd().getVUnTrib();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorDesconto() {
        try {
            return det.getProd().getVDesc();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getDespesasAcessorias() {
        try {
            return det.getProd().getVOutro();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorfrete() {
        try {
            return det.getProd().getVFrete();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getValorSeguro() {
        try {
            return det.getProd().getVSeg();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public DadosProduto getDados() {
        return new DadosProduto(det);
    }

    private void getImposto() {
        det.getImposto().getContent().forEach((element) -> {
            if (element.getValue() instanceof TNFe.InfNFe.Det.Imposto.ICMS) {
                this.icms = (TNFe.InfNFe.Det.Imposto.ICMS) element.getValue();
            } else if (element.getValue() instanceof TNFe.InfNFe.Det.Imposto.COFINS) {
                this.cofins = (TNFe.InfNFe.Det.Imposto.COFINS) element.getValue();
            } else if (element.getValue() instanceof TNFe.InfNFe.Det.Imposto.PIS) {
                this.pis = (TNFe.InfNFe.Det.Imposto.PIS) element.getValue();
            } else if (element.getValue() instanceof TIpi) {
                this.ipi = (TIpi) element.getValue();
            }
        });
    }

    public ICMS getICMS() {
        return new ICMS(icms);
    }

    public ICMSST getICMSST() {
        return new ICMSST(icms);
    }

    public Imposto getIPI() {
        return new IPI(ipi);
    }

    public Imposto getPIS() {
        return new PIS(pis);
    }

    public Imposto getCOFINS() {
        return new COFINS(cofins);
    }

    public String getDesconto() {
        try {
            return det.getProd().getVDesc();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }

    public String getIPIDevolvido() {
        try {
            return det.getImpostoDevol().getIPI().getVIPIDevol();
        } catch (NullPointerException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }
}
