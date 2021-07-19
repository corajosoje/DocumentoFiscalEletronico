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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author jeffe
 */
public class GeradorDocumentoFiscal {

    public static Object xml;
    public static int modelo;
    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final Logger LOG = LogManager.getLogger(GeradorDocumentoFiscal.class.getName());

    /**
     * Com base em um arquivo xml retorna o documento fiscal se corresponder
     *
     * @param arquivo arquivo xml de nota fiscal
     * @return DocumentoFiscal referente ao arquivo
     * @throws java.io.IOException se o arquivo não puder ser lido
     * @throws GeradorDocumentoFiscalException se o arquivo não corresponder aos
     * layouts oficiais
     */
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

    public static ConhecimentoTranporte novoDocumento(CteProc arquivo) throws GeradorDocumentoFiscalException {
        GeradorDocumentoFiscal.xml = null;
        GeradorDocumentoFiscal.xml = arquivo;
        GeradorDocumentoFiscal.modelo = 57;
        return new ConhecimentoTranporte();

    }

    public static NotaFiscal novoDocumento(TNfeProc arquivo) throws GeradorDocumentoFiscalException {
        GeradorDocumentoFiscal.xml = null;
        GeradorDocumentoFiscal.xml = arquivo;
        GeradorDocumentoFiscal.modelo = 55;
        return new NotaFiscal();
    }

    private static Object lerDocumento(File file) throws IOException, JAXBException, GeradorDocumentoFiscalException {

        XMLStreamReader streamReader = null;
        Unmarshaller jaxbUnmarshaller;
        try (InputStream stream = new FileInputStream(file)) {
            streamReader = XMLInputFactory.newInstance().createXMLStreamReader(stream);

            while (streamReader.hasNext()) {
                streamReader.next();

                if (streamReader.getLocalName().equals("nfeProc")) {
                    try {
                        jaxbUnmarshaller = JAXBContext.newInstance(TNfeProc.class).createUnmarshaller();
                        GeradorDocumentoFiscal.modelo = 55;
                        return jaxbUnmarshaller.unmarshal(streamReader, TNfeProc.class).getValue();
                    } catch (JAXBException ex) {
                        LOG.error(ex.getMessage(), ex);
                        throw new GeradorDocumentoFiscalException("Arquivo " + file.getName() + " NFE incompativel com XSD Mapeado no Projeto DocumentoFiscalEletronico");
                    }
                    /*
                    OLD
                    if (!streamReader.getAttributeValue("", "versao").substring(0, 1).equals("4")) {
                        throw new GeradorDocumentoFiscalException("Versão do xml incompativel");
                    } else {
                        jaxbUnmarshaller = JAXBContext.newInstance(TNfeProc.class).createUnmarshaller();
                        GeradorDocumentoFiscal.modelo = 55;
                        return jaxbUnmarshaller.unmarshal(streamReader, TNfeProc.class).getValue();

                    }
                     */
                } else if (streamReader.getLocalName().equals("cteProc")) {
                    try {
                        jaxbUnmarshaller = JAXBContext.newInstance(CteProc.class).createUnmarshaller();
                        GeradorDocumentoFiscal.modelo = 57;
                        return jaxbUnmarshaller.unmarshal(streamReader, CteProc.class).getValue();
                    } catch (JAXBException ex) {
                        LOG.error(ex.getMessage(), ex);
                        throw new GeradorDocumentoFiscalException("Arquivo " + file.getName() + " CTE incompativel com XSD Mapeado no Projeto DocumentoFiscalEletronico");
                    }
                } else {
                    throw new GeradorDocumentoFiscalException("Arquivo " + file.getName() + " Modelo XML não compativel");
                }
            }
            return null;
        } catch (XMLStreamException ex) {
            LOG.error(ex.getMessage(), ex);
            return null;
        } finally {

            try {
                streamReader.close();
            } catch (XMLStreamException | NullPointerException ex) {
                LOG.error(ex.getMessage(), ex);
            }
        }

    }
}
