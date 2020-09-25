/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.imposto;

import br.jefferson.notafiscal4.TNFe;

/**
 *
 * @author jeffe
 */
public class ICMSST {


    public ICMSST(TNFe.InfNFe.Det.Imposto.ICMS icms) {
        this.icms = icms;
    }
    private final TNFe.InfNFe.Det.Imposto.ICMS icms;

    public String getBaseST() {
        if (icms.getICMS00() != null) {
            return "0";
        } else if (icms.getICMS10() != null) {
            return icms.getICMS10().getVBCST();
        } else if (icms.getICMS20() != null) {
            return "0";
        } else if (icms.getICMS30() != null) {
            return icms.getICMS30().getVBCST();
        } else if (icms.getICMS40() != null) {
            return "0";
        } else if (icms.getICMS51() != null) {
            return "0";
        } else if (icms.getICMS60() != null) {
            return "0";
        } else if (icms.getICMS70() != null) {
            return icms.getICMS70().getVBCST();
        } else if (icms.getICMS90() != null) {
            return icms.getICMS90().getVBCST();
        } else if (icms.getICMSPart() != null) {
            return icms.getICMSPart().getVBCST();
        } else if (icms.getICMSSN101() != null) {
            return "0";
        } else if (icms.getICMSSN102() != null) {
            return "0";
        } else if (icms.getICMSSN201() != null) {
            return icms.getICMSSN201().getVBCST();
        } else if (icms.getICMSSN202() != null) {
            return icms.getICMSSN202().getVBCST();
        } else if (icms.getICMSSN500() != null) {
            return "0";
        } else if (icms.getICMSSN900() != null) {
            return icms.getICMSSN900().getVBCST();
        } else {
            return "0";
        }
    }

    public String getICMSST() {
        if (icms.getICMS00() != null) {
            return "0";
        } else if (icms.getICMS10() != null) {
            return icms.getICMS10().getVICMSST();
        } else if (icms.getICMS20() != null) {
            return "0";
        } else if (icms.getICMS30() != null) {
            return icms.getICMS30().getVICMSST();
        } else if (icms.getICMS40() != null) {
            return "0";
        } else if (icms.getICMS51() != null) {
            return "0";
        } else if (icms.getICMS60() != null) {
            return "0";
        } else if (icms.getICMS70() != null) {
            return icms.getICMS70().getVICMSST();
        } else if (icms.getICMS90() != null) {
            return icms.getICMS90().getVICMSST();
        } else if (icms.getICMSPart() != null) {
            return icms.getICMSPart().getVICMSST();
        } else if (icms.getICMSSN101() != null) {
            return "0";
        } else if (icms.getICMSSN102() != null) {
            return "0";
        } else if (icms.getICMSSN201() != null) {
            return icms.getICMSSN201().getVICMSST();
        } else if (icms.getICMSSN202() != null) {
            return icms.getICMSSN202().getVICMSST();
        } else if (icms.getICMSSN500() != null) {
            return "0";
        } else if (icms.getICMSSN900() != null) {
            return icms.getICMSSN900().getVICMSST();
        } else {
            return "0";
        }
    }

    public String getMVAST() {
        if (icms.getICMS00() != null) {
            return "0";
        } else if (icms.getICMS10() != null) {
            return icms.getICMS10().getPMVAST();
        } else if (icms.getICMS20() != null) {
            return "0";
        } else if (icms.getICMS30() != null) {
            return icms.getICMS30().getPMVAST();
        } else if (icms.getICMS40() != null) {
            return "0";
        } else if (icms.getICMS51() != null) {
            return "0";
        } else if (icms.getICMS60() != null) {
            return "0";
        } else if (icms.getICMS70() != null) {
            return icms.getICMS70().getPMVAST();
        } else if (icms.getICMS90() != null) {
            return icms.getICMS90().getPMVAST();
        } else if (icms.getICMSPart() != null) {
            return icms.getICMSPart().getPMVAST();
        } else if (icms.getICMSSN101() != null) {
            return "0";
        } else if (icms.getICMSSN102() != null) {
            return "0";
        } else if (icms.getICMSSN201() != null) {
            return icms.getICMSSN201().getPMVAST();
        } else if (icms.getICMSSN202() != null) {
            return icms.getICMSSN202().getPMVAST();
        } else if (icms.getICMSSN500() != null) {
            return "0";
        } else if (icms.getICMSSN900() != null) {
            return icms.getICMSSN900().getPMVAST();
        } else {
            return "0";
        }
    }
    
    public String getBaseFcpST() {
        if (icms.getICMS00() != null) {
            return "0";
        } else if (icms.getICMS10() != null) {
            return icms.getICMS10().getVBCFCPST();
        } else if (icms.getICMS20() != null) {
            return "0";
        } else if (icms.getICMS30() != null) {
            return icms.getICMS30().getVBCFCPST();
        } else if (icms.getICMS40() != null) {
            return "0";
        } else if (icms.getICMS51() != null) {
            return "0";
        } else if (icms.getICMS60() != null) {
            return "0";
        } else if (icms.getICMS70() != null) {
            return icms.getICMS70().getVBCFCPST();
        } else if (icms.getICMS90() != null) {
            return icms.getICMS90().getVBCFCPST();
        } else if (icms.getICMSPart() != null) {
            return "0";
        } else if (icms.getICMSSN101() != null) {
            return "0";
        } else if (icms.getICMSSN102() != null) {
            return "0";
        } else if (icms.getICMSSN201() != null) {
            return icms.getICMSSN201().getVBCFCPST();
        } else if (icms.getICMSSN202() != null) {
            return icms.getICMSSN202().getVBCFCPST();
        } else if (icms.getICMSSN500() != null) {
            return "0";
        } else if (icms.getICMSSN900() != null) {
            return icms.getICMSSN900().getVBCFCPST();
        } else {
            return "0";
        }
    }public String getAliquotaFcpST() {
        if (icms.getICMS00() != null) {
            return "0";
        } else if (icms.getICMS10() != null) {
            return icms.getICMS10().getPFCPST();
        } else if (icms.getICMS20() != null) {
            return "0";
        } else if (icms.getICMS30() != null) {
            return icms.getICMS30().getPFCPST();
        } else if (icms.getICMS40() != null) {
            return "0";
        } else if (icms.getICMS51() != null) {
            return "0";
        } else if (icms.getICMS60() != null) {
            return "0";
        } else if (icms.getICMS70() != null) {
            return icms.getICMS70().getPFCPST();
        } else if (icms.getICMS90() != null) {
            return icms.getICMS90().getPFCPST();
        } else if (icms.getICMSPart() != null) {
            return "0";
        } else if (icms.getICMSSN101() != null) {
            return "0";
        } else if (icms.getICMSSN102() != null) {
            return "0";
        } else if (icms.getICMSSN201() != null) {
            return icms.getICMSSN201().getPFCPST();
        } else if (icms.getICMSSN202() != null) {
            return icms.getICMSSN202().getPFCPST();
        } else if (icms.getICMSSN500() != null) {
            return "0";
        } else if (icms.getICMSSN900() != null) {
            return icms.getICMSSN900().getPFCPST();
        } else {
            return "0";
        }
    }public String getValorFCPST() {
        if (icms.getICMS00() != null) {
            return "0";
        } else if (icms.getICMS10() != null) {
            return icms.getICMS10().getVFCPST();
        } else if (icms.getICMS20() != null) {
            return "0";
        } else if (icms.getICMS30() != null) {
            return icms.getICMS30().getVFCPST();
        } else if (icms.getICMS40() != null) {
            return "0";
        } else if (icms.getICMS51() != null) {
            return "0";
        } else if (icms.getICMS60() != null) {
            return "0";
        } else if (icms.getICMS70() != null) {
            return icms.getICMS70().getVFCPST();
        } else if (icms.getICMS90() != null) {
            return icms.getICMS90().getVFCPST();
        } else if (icms.getICMSPart() != null) {
            return "0";
        } else if (icms.getICMSSN101() != null) {
            return "0";
        } else if (icms.getICMSSN102() != null) {
            return "0";
        } else if (icms.getICMSSN201() != null) {
            return icms.getICMSSN201().getVFCPST();
        } else if (icms.getICMSSN202() != null) {
            return icms.getICMSSN202().getVFCPST();
        } else if (icms.getICMSSN500() != null) {
            return "0";
        } else if (icms.getICMSSN900() != null) {
            return icms.getICMSSN900().getVFCPST();
        } else {
            return "0";
        }
    }
}
