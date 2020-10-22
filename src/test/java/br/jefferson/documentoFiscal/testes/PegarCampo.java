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
        File in = new File("C:\\blibliotecas\\Exemplo de Arquivos\\Exemplos xml documentos fiscais\\NF-e\\Entrada\\"
                + "Premier\\35181208614279000105550010000535281010535282_5640d784d9a84ec1856b854c31be71df708492c2.xml");
        DocumentoFiscal documentoFiscal = GeradorDocumentoFiscal.novoDocumento(in);
        String valor = documentoFiscal.getTotais().getFrete();
        System.out.println(valor);
           
    }
}
