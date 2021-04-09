import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program{

    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        List<TypeProduto> tipos = new ArrayList<>();


        TypeProduto tipo1 = new TypeProduto();
        tipo1.setCodigo("01");
        tipo1.setDescricao("teste");
        tipo1.setNome("testenome");




        tipos.add(tipo1);

        pedido.setProduto(tipos);

        // MARSHALL -> OBJETO -> STRING XML
       // System.out.println(pedido.toString());
        String xml =  new Program().marshal(pedido);
      //  System.out.println(xml);


        // UNMARSHALL -> String XML -> OBJETO
        Pedido pe  = (Pedido) new Program().unmarshal(Pedido.class, xml);
        //System.out.println(pe.toString());



        // MARSHALLTOFILE -> OBJETO -> ARQUIVO.XML

        new Program().marshalToFile(pe, "pe.xml");


        // UNMARSHALLFROMFILE -> ARQUIVO.XML -> OBJETO
        Pedido pro = (Pedido) new Program().unmarshalFromFile(Pedido.class, "pe.xml");
        System.out.println(pro.toString());
        System.out.println("CRIADO COM SUCESSO");


        //System.out.println(new Program().marshal(pedido));
        //new Validator().validator("C:\\Users\\Leonardo.SFZ-C88VBS2\\IdeaProjects\\Tesgte\\src\\main\\java\\pedido.xsd", pedido);
    }

    public String marshal(Object object) {
        final StringWriter out = new StringWriter();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE
            );
            marshaller.marshal(object, new StreamResult(out));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return out.toString();
    }


    /**
     * Converte o objeto em uma estrutura XML.
     * @param object objeto a ser convertido em XML.
     * @param fileName nome do arquivo XML a ser gerado.
     * @return uma string com o conteudo do XML gerado.
     */
    public String marshalToFile(Object object, String fileName) {
        final StringWriter out = new StringWriter();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller;
            marshaller = context.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE
            );
            marshaller.marshal(object, new StreamResult(out));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Writer writer = null;
        try {
            writer = new FileWriter(fileName);
            assert context != null;
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(object, writer);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }

        return out.toString();
    }



    /**
     * Realiza a conversao (unmarshal) de um arquivo XML em um objeto do seu tipo.
     * @param clazz classe referente ao objeto a ser criado a partir do XML.
     * @param fileXml nome do arquivo XML a ser convertido em objeto.
     * @return novo objeto.
     */
    public Object unmarshalFromFile(Class clazz, String fileXml) {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(
                    new FileInputStream(fileXml)
            );
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Converte um string com estrutura XML em um objeto.
     * @param clazz classe referente ao tipo do objeto a ser retornado.
     * @param stringXml string com o conteudo XML a ser convertido em objeto.
     * @return retorna um novo objeto de clazz.
     */
    public Object unmarshal(Class clazz, String stringXml) {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(new StreamSource(new StringReader(stringXml))
            );
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
