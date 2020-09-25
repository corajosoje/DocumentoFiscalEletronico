/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados;

import br.jefferson.documentoFiscal.dados.cadastro.Emitente;
import br.jefferson.documentoFiscal.dados.cadastro.Destinatario;

/**
 *
 * @author jeffe
 */
public interface DocumentoFiscal {

    public java.util.Date getDataEmissao();

    public String getChave();

    public int getModelo();

    public Emitente getEmitente();

    public Destinatario getDestinatario();
    
    public java.util.List<Item> getItens();// Ainda falta os impostos

    public String getNumero();

    public String getSerie();

    public Totais getTotais();

    public String getSituacaoDestinatario();

    public String getFinalidadeNFe();

    public String getTipoOperacao();
}
