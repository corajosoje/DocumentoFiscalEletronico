/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jefferson.documentoFiscal.testes;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author jeffersonsvo
 */
public class TesteStreamVersão {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\jeffersonsvo\\Documents\\35201145360419000192550010000192231000384461.xml");
        XMLStreamReader streamReader = null;
        Unmarshaller jaxbUnmarshaller;
        try (InputStream stream = new FileInputStream(file)) {
            streamReader = XMLInputFactory.newInstance().createXMLStreamReader(stream);
            
            while (streamReader.hasNext()) {
                streamReader.next();
                System.out.println(streamReader.getLocalName());
                if (streamReader.getLocalName().equals("nfeProc")) {
                    
                }
            }
        }
    }
}
