/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal;

import br.jefferson.conhecimento3a.CteProc;
import br.jefferson.documentoFiscal.dados.ConhecimentoTranporte;
import br.jefferson.documentoFiscal.dados.DocumentoFiscal;
import br.jefferson.documentoFiscal.dados.NotaFiscal;
import br.jefferson.documentoFiscal.exception.GeradorDocumentoFiscalException;
import br.jefferson.notafiscal4.TNfeProc;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author jeffe
 */
public class GeradorDocumentoFiscal {

    private static Object xml;
    public static int modelo;
    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Com base em um arquivo xml retorna a nota fiscal se corresponder
     *
     * @param arquivo arquivo xml de nota fiscal
     * @return Nota Fiscal eletronica versão 4
     * @throws GeradorDocumentoFiscalException
     */
    public static TNfeProc getNotaFiscal(File arquivo) throws GeradorDocumentoFiscalException {
        GeradorDocumentoFiscal.xml = null;
        try {
            GeradorDocumentoFiscal.xml = lerDocumento(arquivo);
        } catch (IOException | JAXBException ex) {
            throw new GeradorDocumentoFiscalException(ex);
        }

        if (xml instanceof TNfeProc) {
            return (TNfeProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new GeradorDocumentoFiscalException("Tipo de documento não é nota fiscal");
        }
    }

    public static TNfeProc getNotaFiscal() throws GeradorDocumentoFiscalException {
        if (xml instanceof TNfeProc) {
            return (TNfeProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new GeradorDocumentoFiscalException("Tipo de documento não é nota fiscal");
        }
    }

    public static CteProc getConhecimentoTransporte() throws GeradorDocumentoFiscalException {
        if (xml instanceof CteProc) {
            return (CteProc) GeradorDocumentoFiscal.xml;
        } else {
            throw new GeradorDocumentoFiscalException("Tipo de documento não é Conhecimento de Transporte");
        }
    }

    public static DocumentoFiscal novoDocumento(File arquivo) throws IOException, JAXBException, GeradorDocumentoFiscalException {
        GeradorDocumentoFiscal.xml = null;
        GeradorDocumentoFiscal.xml = lerDocumento(arquivo);
        switch (modelo) {
            case 55:
                return new NotaFiscal();
            case 57:
                return new ConhecimentoTranporte();
            default:
                throw new GeradorDocumentoFiscalException("Modelo desconhecido");
        }
    }

    private static Object lerDocumento(File file) throws IOException, JAXBException, GeradorDocumentoFiscalException {

        XMLStreamReader streamReader = null;
        Unmarshaller jaxbUnmarshaller;
        try (InputStream stream = new FileInputStream(file)) {
            streamReader = XMLInputFactory.newInstance().createXMLStreamReader(stream);

            while (streamReader.hasNext()) {
                streamReader.next();

                if (streamReader.getLocalName().equals("nfeProc")) {
                    if (!streamReader.getAttributeValue("", "versao").substring(0, 1).equals("4")) {
                        throw new GeradorDocumentoFiscalException("Versão do xml incompativel");
                    } else {
                        jaxbUnmarshaller = JAXBContext.newInstance(TNfeProc.class).createUnmarshaller();
                        GeradorDocumentoFiscal.modelo = 55;
                        return jaxbUnmarshaller.unmarshal(streamReader, TNfeProc.class).getValue();

                    }
                } else if (streamReader.getLocalName().equals("cteProc")) {
                    jaxbUnmarshaller = JAXBContext.newInstance(CteProc.class).createUnmarshaller();
                    GeradorDocumentoFiscal.modelo = 57;
                    return jaxbUnmarshaller.unmarshal(streamReader, CteProc.class).getValue();

                    //  jaxbUnmarshaller = JAXBContext.newInstance(CteProc.class).createUnmarshaller();
                    //  return (CteProc) jaxbUnmarshaller.unmarshal(file);
                    //  return null;
                } else {
                    break;
                }
            }
            return null;
        } catch (XMLStreamException ex) {
            // br.jefferson.log.fast.FastLog.setLog(ex);
            Logger.getLogger(GeradorDocumentoFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {

            try {
                streamReader.close();
            } catch (XMLStreamException | NullPointerException ex) {
                Logger.getLogger(GeradorDocumentoFiscal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
