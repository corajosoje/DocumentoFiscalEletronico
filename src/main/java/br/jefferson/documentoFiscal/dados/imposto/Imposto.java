/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.dados.imposto;

/**
 *
 * @author jeffersonsvo
 */
public interface Imposto {

    public String getCST();
    public String getBase();
    public String getAliquota();
    public String getValor();
}
