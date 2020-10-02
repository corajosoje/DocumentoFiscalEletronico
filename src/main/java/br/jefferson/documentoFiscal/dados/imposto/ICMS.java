/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.imposto;

import br.jefferson.documentoFiscal.util.Util;
import br.jefferson.notafiscal4.TNFe;

/**
 * TODO AINDA fata metodos
 *
 * @author jeffe
 */
public class ICMS implements Imposto {

    public ICMS(TNFe.InfNFe.Det.Imposto.ICMS icms) {
        this.icms = icms;
    }
    private final TNFe.InfNFe.Det.Imposto.ICMS icms;

    public String getCSTOrigem() {
        try {
            String retorno = null;
            if (icms.getICMS00() != null) {
                retorno = icms.getICMS00().getOrig();
            } else if (icms.getICMS10() != null) {
                retorno = icms.getICMS10().getOrig();
            } else if (icms.getICMS20() != null) {
                retorno = icms.getICMS20().getOrig();
            } else if (icms.getICMS30() != null) {
                retorno = icms.getICMS30().getOrig();
            } else if (icms.getICMS40() != null) {
                retorno = icms.getICMS40().getOrig();
            } else if (icms.getICMS51() != null) {
                retorno = icms.getICMS51().getOrig();
            } else if (icms.getICMS60() != null) {
                retorno = icms.getICMS60().getOrig();
            } else if (icms.getICMS70() != null) {
                retorno = icms.getICMS70().getOrig();
            } else if (icms.getICMS90() != null) {
                retorno = icms.getICMS90().getOrig();
            } else if (icms.getICMSPart() != null) {
                retorno = icms.getICMSPart().getOrig();
            } else if (icms.getICMSSN101() != null) {
                retorno = icms.getICMSSN101().getOrig();
            } else if (icms.getICMSSN102() != null) {
                retorno = icms.getICMSSN102().getOrig();
            } else if (icms.getICMSSN201() != null) {
                retorno = icms.getICMSSN201().getOrig();
            } else if (icms.getICMSSN202() != null) {
                retorno = icms.getICMSSN202().getOrig();
            } else if (icms.getICMSSN500() != null) {
                retorno = icms.getICMSSN500().getOrig();
            } else if (icms.getICMSSN900() != null) {
                retorno = icms.getICMSSN900().getOrig();
            } else {
                retorno = "";
            }
            return Util.notNull(retorno);
        } catch (NullPointerException ex) {
            return "";
        }
    }

    @Override
    public String getCST() {
        try {
            String retorno = null;
            if (icms.getICMS00() != null) {
                retorno = icms.getICMS00().getCST();
            } else if (icms.getICMS10() != null) {
                retorno = icms.getICMS10().getCST();
            } else if (icms.getICMS20() != null) {
                retorno = icms.getICMS20().getCST();
            } else if (icms.getICMS30() != null) {
                retorno = icms.getICMS30().getCST();
            } else if (icms.getICMS40() != null) {
                retorno = icms.getICMS40().getCST();
            } else if (icms.getICMS51() != null) {
                retorno = icms.getICMS51().getCST();
            } else if (icms.getICMS60() != null) {
                retorno = icms.getICMS60().getCST();
            } else if (icms.getICMS70() != null) {
                retorno = icms.getICMS70().getCST();
            } else if (icms.getICMS90() != null) {
                retorno = icms.getICMS90().getCST();
            } else if (icms.getICMSPart() != null) {
                retorno = icms.getICMSPart().getCST();
            } else if (icms.getICMSSN101() != null) {
                retorno = icms.getICMSSN101().getCSOSN();
            } else if (icms.getICMSSN102() != null) {
                retorno = icms.getICMSSN102().getCSOSN();
            } else if (icms.getICMSSN201() != null) {
                retorno = icms.getICMSSN201().getCSOSN();
            } else if (icms.getICMSSN202() != null) {
                retorno = icms.getICMSSN202().getCSOSN();
            } else if (icms.getICMSSN500() != null) {
                retorno = icms.getICMSSN500().getCSOSN();
            } else if (icms.getICMSSN900() != null) {
                retorno = icms.getICMSSN900().getCSOSN();
            } else {
                retorno = "";
            }
            return Util.notNull(retorno);
        } catch (NullPointerException ex) {
            return "";
        }
    }

    @Override
    public String getBase() {
        try {
            String retorno = null;
            if (icms.getICMS00() != null) {
                retorno = icms.getICMS00().getVBC();
            } else if (icms.getICMS10() != null) {
                retorno = icms.getICMS10().getVBC();
            } else if (icms.getICMS20() != null) {
                retorno = icms.getICMS20().getVBC();
            } else if (icms.getICMS30() != null) {
                retorno = "0";
            } else if (icms.getICMS40() != null) {
                retorno = "0";
            } else if (icms.getICMS51() != null) {
                retorno = icms.getICMS51().getVBC();
            } else if (icms.getICMS60() != null) {
                retorno = "0";
            } else if (icms.getICMS70() != null) {
                retorno = icms.getICMS70().getVBC();
            } else if (icms.getICMS90() != null) {
                retorno = icms.getICMS90().getVBC();
            } else if (icms.getICMSPart() != null) {
                retorno = icms.getICMSPart().getVBC();
            } else if (icms.getICMSSN101() != null) {
                retorno = "0";
            } else if (icms.getICMSSN102() != null) {
                retorno = "0";
            } else if (icms.getICMSSN201() != null) {
                retorno = "0";
            } else if (icms.getICMSSN202() != null) {
                retorno = "0";
            } else if (icms.getICMSSN500() != null) {
                retorno = "0";
            } else if (icms.getICMSSN900() != null) {
                retorno = "0";
            } else {
                retorno = "0";
            }
            return Util.notNull(retorno);
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    @Override
    public String getAliquota() {
        try {
            String retorno = null;
            if (icms.getICMS00() != null) {
                retorno = icms.getICMS00().getPICMS();
            } else if (icms.getICMS10() != null) {
                retorno = icms.getICMS10().getPICMS();
            } else if (icms.getICMS20() != null) {
                retorno = icms.getICMS20().getPICMS();
            } else if (icms.getICMS30() != null) {
                retorno = "0";
            } else if (icms.getICMS40() != null) {
                retorno = "0";
            } else if (icms.getICMS51() != null) {
                retorno = icms.getICMS51().getPICMS();
            } else if (icms.getICMS60() != null) {
                retorno = "0";
            } else if (icms.getICMS70() != null) {
                retorno = icms.getICMS70().getPICMS();
            } else if (icms.getICMS90() != null) {
                retorno = icms.getICMS90().getPICMS();
            } else if (icms.getICMSPart() != null) {
                retorno = icms.getICMSPart().getPICMS();
            } else if (icms.getICMSSN101() != null) {
                retorno = icms.getICMSSN101().getPCredSN();
            } else if (icms.getICMSSN102() != null) {
                retorno = "0";
            } else if (icms.getICMSSN201() != null) {
                retorno = icms.getICMSSN201().getPCredSN();
            } else if (icms.getICMSSN202() != null) {
                retorno = "0";
            } else if (icms.getICMSSN500() != null) {
                retorno = "0";
            } else if (icms.getICMSSN900() != null) {
                retorno = icms.getICMSSN900().getPCredSN();
            } else {
                retorno = "0";
            }
            return Util.notNull(retorno);
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    @Override
    public String getValor() {
        try {
            String retorno = null;
            if (icms.getICMS00() != null) {
                retorno = icms.getICMS00().getVICMS();
            } else if (icms.getICMS10() != null) {
                retorno = icms.getICMS10().getVICMS();
            } else if (icms.getICMS20() != null) {
                retorno = icms.getICMS20().getVICMS();
            } else if (icms.getICMS30() != null) {
                retorno = "0";
            } else if (icms.getICMS40() != null) {
                retorno = "0";
            } else if (icms.getICMS51() != null) {
                retorno = icms.getICMS51().getVICMS();
            } else if (icms.getICMS60() != null) {
                retorno = "0";
            } else if (icms.getICMS70() != null) {
                retorno = icms.getICMS70().getVICMS();
            } else if (icms.getICMS90() != null) {
                retorno = icms.getICMS90().getVICMS();
            } else if (icms.getICMSPart() != null) {
                retorno = icms.getICMSPart().getVICMS();
            } else if (icms.getICMSSN101() != null) {
                retorno = icms.getICMSSN101().getVCredICMSSN();
            } else if (icms.getICMSSN102() != null) {
                retorno = "0";
            } else if (icms.getICMSSN201() != null) {
                retorno = icms.getICMSSN201().getVCredICMSSN();
            } else if (icms.getICMSSN202() != null) {
                retorno = "0";
            } else if (icms.getICMSSN500() != null) {
                retorno = "0";
            } else if (icms.getICMSSN900() != null) {
                retorno = icms.getICMSSN900().getVCredICMSSN();
            } else {
                retorno = "0";
            }
            return Util.notNull(retorno);
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getICMSDesonerado() {
        try {
            String retorno = null;
            if (icms.getICMS00() != null) {
                retorno = "0";
            } else if (icms.getICMS10() != null) {
                retorno = "0";
            } else if (icms.getICMS20() != null) {
                retorno = icms.getICMS20().getVICMSDeson();
            } else if (icms.getICMS30() != null) {
                retorno = icms.getICMS30().getVICMSDeson();
            } else if (icms.getICMS40() != null) {
                retorno = icms.getICMS40().getVICMSDeson();
            } else if (icms.getICMS51() != null) {
                retorno = "0";
            } else if (icms.getICMS60() != null) {
                retorno = "0";
            } else if (icms.getICMS70() != null) {
                retorno = icms.getICMS70().getVICMSDeson();
            } else if (icms.getICMS90() != null) {
                retorno = icms.getICMS90().getVICMSDeson();
            } else if (icms.getICMSPart() != null) {
                retorno = "0";
            } else if (icms.getICMSSN101() != null) {
                retorno = "0";
            } else if (icms.getICMSSN102() != null) {
                retorno = "0";
            } else if (icms.getICMSSN201() != null) {
                retorno = "0";
            } else if (icms.getICMSSN202() != null) {
                retorno = "0";
            } else if (icms.getICMSSN500() != null) {
                retorno = "0";
            } else if (icms.getICMSSN900() != null) {
                retorno = "0";
            } else {
                retorno = "0";
            }
            return Util.notNull(retorno);
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getAliquotaFCP() {
        try {
            String retorno = null;
            if (icms.getICMS00() != null) {
                retorno = icms.getICMS00().getPFCP();
            } else if (icms.getICMS10() != null) {
                retorno = icms.getICMS10().getPFCP();
            } else if (icms.getICMS20() != null) {
                retorno = icms.getICMS20().getPFCP();
            } else if (icms.getICMS30() != null) {
                retorno = "0";
            } else if (icms.getICMS40() != null) {
                retorno = "0";
            } else if (icms.getICMS51() != null) {
                retorno = icms.getICMS51().getPFCP();
            } else if (icms.getICMS60() != null) {
                retorno = "0";
            } else if (icms.getICMS70() != null) {
                retorno = icms.getICMS70().getPFCP();
            } else if (icms.getICMS90() != null) {
                retorno = icms.getICMS90().getPFCP();
            } else if (icms.getICMSPart() != null) {
                retorno = "0";
            } else if (icms.getICMSSN101() != null) {
                retorno = "0";
            } else if (icms.getICMSSN102() != null) {
                retorno = "0";
            } else if (icms.getICMSSN201() != null) {
                retorno = "0";
            } else if (icms.getICMSSN202() != null) {
                retorno = "0";
            } else if (icms.getICMSSN500() != null) {
                retorno = "0";
            } else if (icms.getICMSSN900() != null) {
                retorno = "0";
            } else {
                retorno = "0";
            }
            return Util.notNull(retorno);
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    public String getValorFCP() {
        try {
            String retorno = null;
            if (icms.getICMS00() != null) {
                retorno = icms.getICMS00().getVFCP();
            } else if (icms.getICMS10() != null) {
                retorno = icms.getICMS10().getVFCP();
            } else if (icms.getICMS20() != null) {
                retorno = icms.getICMS20().getVFCP();
            } else if (icms.getICMS30() != null) {
                retorno = "0";
            } else if (icms.getICMS40() != null) {
                retorno = "0";
            } else if (icms.getICMS51() != null) {
                retorno = icms.getICMS51().getVFCP();
            } else if (icms.getICMS60() != null) {
                retorno = "0";
            } else if (icms.getICMS70() != null) {
                retorno = icms.getICMS70().getVFCP();
            } else if (icms.getICMS90() != null) {
                retorno = icms.getICMS90().getVFCP();
            } else if (icms.getICMSPart() != null) {
                retorno = "0";
            } else if (icms.getICMSSN101() != null) {
                retorno = "0";
            } else if (icms.getICMSSN102() != null) {
                retorno = "0";
            } else if (icms.getICMSSN201() != null) {
                retorno = "0";
            } else if (icms.getICMSSN202() != null) {
                retorno = "0";
            } else if (icms.getICMSSN500() != null) {
                retorno = "0";
            } else if (icms.getICMSSN900() != null) {
                retorno = "0";
            } else {
                retorno = "0";
            }
            return Util.notNull(retorno);
        } catch (NullPointerException ex) {
            return "0";
        }
    }

}
