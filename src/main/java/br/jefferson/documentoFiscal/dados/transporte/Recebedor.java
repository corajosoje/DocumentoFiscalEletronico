/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.transporte;

import br.jefferson.conhecimento3a.CteProc;
import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author jeffe
 */
public class Recebedor {

    private static CteProc CTe;
    private static final Logger LOG = LogManager.getLogger(Recebedor.class.getName());

    public Recebedor() {
        if (GeradorDocumentoFiscal.xml instanceof CteProc) {
            CTe = (CteProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new IllegalStateException("Documento Inválido");
        }
    }

    public String getCNPJ() {
        LOG.debug("Utilizando metodo getCNPJ() do Recebedor");
        try {
            if (CTe.getCTe().getInfCte().getReceb() != null) {
                LOG.debug("Pegando dados do Recebedor");
                if (CTe.getCTe().getInfCte().getReceb().getCPF() != null) {
                    LOG.debug("Pegando CPF do Recebedor");
                    return Util.notNull(CTe.getCTe().getInfCte().getReceb().getCPF());
                } else if (CTe.getCTe().getInfCte().getReceb().getCNPJ() != null) {
                    LOG.debug("Pegando CNPJ do Recebedor");
                    return Util.notNull(CTe.getCTe().getInfCte().getReceb().getCNPJ());
                } else {
                    LOG.debug("Não foi possivel pegar nenhuma informação do Recebedor");
                    return "";
                }
            } else if (CTe.getCTe().getInfCte().getDest() != null) {
                LOG.debug("Recebedor não presente pegando dados do Destinatário");
                if (CTe.getCTe().getInfCte().getDest().getCPF() != null) {
                    LOG.debug("Pegando CPF do Destinatário");
                    return Util.notNull(CTe.getCTe().getInfCte().getDest().getCPF());
                } else if (CTe.getCTe().getInfCte().getDest().getCNPJ() != null) {
                    LOG.debug("Pegando CNPJ do Destinatário");
                    return Util.notNull(CTe.getCTe().getInfCte().getDest().getCNPJ());
                } else {
                    LOG.debug("Não foi possivel pegar nenhuma informação do Destinatário");
                    return "";
                }
            } else {
                LOG.debug("Não foi possivel pegar nenhuma informação do Recebedor");
                return "";
            }
        } catch (NullPointerException e) {
            LOG.error(e);
            return "";
        }
    }

    public String getIE() {
        LOG.debug("Utilizando metodo getIE() do Recebedor");
        try {
            if (CTe.getCTe().getInfCte().getReceb() != null) {
                LOG.debug("Pegando dados do Recebedor");
                return Util.notNull(CTe.getCTe().getInfCte().getReceb().getIE());
            } else if (CTe.getCTe().getInfCte().getDest() != null) {
                LOG.debug("Recebedor não presente pegando dados do Destinatário");
                return Util.notNull(CTe.getCTe().getInfCte().getDest().getIE());
            } else {
                return "";
            }
        } catch (NullPointerException e) {
            LOG.error(e);
            return "";
        }
    }

    public String getUF() {
        LOG.debug("Utilizando metodo getUF() do Recebedor");
        try {
            if (CTe.getCTe().getInfCte().getReceb() != null) {
                LOG.debug("Pegando dados do Recebedor");
                return Util.notNull(CTe.getCTe().getInfCte().getReceb().getEnderReceb().getUF().value());
            } else if (CTe.getCTe().getInfCte().getDest() != null) {
                LOG.debug("Recebedor não presente pegando dados do Destinatário");
                return Util.notNull(CTe.getCTe().getInfCte().getDest().getEnderDest().getUF().value());
            } else {
                LOG.debug("Não foi possivel pegar nenhuma informação do Recebedor");
                return "";
            }
        } catch (NullPointerException e) {
            LOG.error(e);
            return "";
        }
    }
}
