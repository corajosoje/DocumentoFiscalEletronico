/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.testes;

import br.jefferson.documentoFiscal.GeradorDocumentoFiscal;
import br.jefferson.documentoFiscal.dados.DocumentoFiscal;
import java.io.File;

/**
 *
 * @author jeffersonsvo
 */
public class PegarCampo {

    public static void main(String[] args) throws Exception {
        File in = new File("C:\\temp_nf-e\\Entradas\\35200844914992000138570010273184291273184290_72734627000187.xml");
        DocumentoFiscal documentoFiscal = GeradorDocumentoFiscal.novoDocumento(in);
        String valor = documentoFiscal.getDadosTransporte().getRecebedor().getUF();
        System.out.println(valor);
           
    }
}
