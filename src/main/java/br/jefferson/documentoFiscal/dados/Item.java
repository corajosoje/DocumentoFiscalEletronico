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
import br.jefferson.documentoFiscal.dados.imposto.ICMSDest;
import br.jefferson.documentoFiscal.dados.imposto.Imposto;
import br.jefferson.documentoFiscal.dados.imposto.ICMSST;
import br.jefferson.documentoFiscal.util.Util;
import br.jefferson.notafiscal4.TIpi;
import br.jefferson.notafiscal4.TNFe;
import br.jefferson.notafiscal4.TNFe.InfNFe.Det.Imposto.ICMSUFDest;

/**
 *
 * @author jeffersonsvo
 */
public class Item {

    private TNFe.InfNFe.Det.Imposto.ICMS icms = null;
    private TNFe.InfNFe.Det.Imposto.COFINS cofins = null;
    private TNFe.InfNFe.Det.Imposto.PIS pis = null;
    private TNFe.InfNFe.Det.Imposto.ICMSUFDest dest = null;
    private TIpi ipi = null;
    private final TNFe.InfNFe.Det det;

    public Item(TNFe.InfNFe.Det det) {
        this.det = det;
        getImposto();
    }

    public String getNumeroItem() {
        try {
            return Util.notNull(det.getNItem());
        } catch (NullPointerException ex) {
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
            return Util.notNull(det.getProd().getCFOP());
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getValorUnitario() {
        try {
            return Util.notNull(det.getProd().getVUnTrib());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getQuantidade() {
        try {
            return Util.notNull(det.getProd().getQTrib());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorTotal() {
        try {
            return Util.notNull(det.getProd().getVProd());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorUnit() {
        try {
            return Util.notNull(det.getProd().getVUnTrib());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorDesconto() {
        try {
            return Util.notNull(det.getProd().getVDesc());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getDespesasAcessorias() {
        try {
            return Util.notNull(det.getProd().getVOutro());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorfrete() {
        try {
            return Util.notNull(det.getProd().getVFrete());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorSeguro() {
        try {
            return Util.notNull(det.getProd().getVSeg());
        } catch (NullPointerException ex) {
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
            } else if (element.getValue() instanceof ICMSUFDest) {
                this.dest = (ICMSUFDest) element.getValue();
            }
        });
    }

    public ICMS getICMS() {
        return new ICMS(icms);
    }

    public ICMSDest getICMSDest() {
        return new ICMSDest(dest);
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
            return Util.notNull(det.getProd().getVDesc());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getIPIDevolvido() {
        try {
            return Util.notNull(det.getImpostoDevol().getIPI().getVIPIDevol());
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getInfoAdc() {
        try {
            return Util.notNull(det.getInfAdProd());
        } catch (NullPointerException ex) {
            return "";
        }
    }

    public String getFCI() {
        try {
            return Util.notNull(det.getProd().getNFCI());
        } catch (NullPointerException ex) {
            return "";
        }
    }
}
