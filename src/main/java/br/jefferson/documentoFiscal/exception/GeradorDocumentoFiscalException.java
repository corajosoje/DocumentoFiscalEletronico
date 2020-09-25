/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.exception;

/**
 *
 * @author jeffersonsvo
 */
public class GeradorDocumentoFiscalException extends Exception {

    public GeradorDocumentoFiscalException(String message) {
        super(message);
    }

    public GeradorDocumentoFiscalException(Throwable ex) {
        super(ex);
    }

}
