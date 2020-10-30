/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.transporte;

import br.jefferson.conhecimento3a.CteProc;
import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.dados.imposto.Imposto;
import br.jefferson.documentoFiscal.util.Util;

/**
 *
 * @author jeffersonsvo
 */
public class ICMSTransporte implements Imposto {

    private static CteProc CTe;

    public ICMSTransporte() {
        if (GeradorDocumentoFiscal.xml instanceof CteProc) {
            CTe = (CteProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new IllegalStateException("Documento Inválido");
        }
    }

    @Override
    public String getCST() {
        try {
            if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS00() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS00().getCST());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS20() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS20().getCST());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS45() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS45().getCST());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS60() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS60().getCST());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS90() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS90().getCST());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMSOutraUF() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMSOutraUF().getCST());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMSSN() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMSSN().getCST());
            } else {
                return "";
            }
        } catch (NullPointerException ex) {
            return "";
        }
    }

    @Override
    public String getBase() {
        try {
            if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS00() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS00().getVBC());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS20() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS20().getVBC());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS45() != null) {
                return "0";
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS60() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS60().getVBCSTRet());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS90() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS90().getVBC());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMSOutraUF() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMSOutraUF().getVBCOutraUF());
            } else {
                return "0";
            }
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    @Override
    public String getAliquota() {
        try {
            if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS00() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS00().getPICMS());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS20() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS20().getPICMS());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS45() != null) {
                return "0";
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS60() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS60().getPICMSSTRet());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS90() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS90().getPICMS());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMSOutraUF() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMSOutraUF().getPICMSOutraUF());
            } else {
                return "0";
            }
        } catch (NullPointerException ex) {
            return "0";
        }
    }

    @Override
    public String getValor() {
        try {
            if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS00() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS00().getVICMS());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS20() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS20().getVICMS());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS45() != null) {
                return "0";
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS60() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS60().getVICMSSTRet());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMS90() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMS90().getVICMS());
            } else if (CTe.getCTe().getInfCte().getImp().getICMS().getICMSOutraUF() != null) {
                return Util.notNull(CTe.getCTe().getInfCte().getImp().getICMS().getICMSOutraUF().getVICMSOutraUF());
            } else {
                return "0";
            }
        } catch (NullPointerException ex) {
            return "0";
        }
    }

}
