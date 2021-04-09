
import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Classe Java de typeProduto complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="typeProduto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descricao" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *       &lt;attribute name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typeProduto", propOrder = {
        "nome",
        "descricao"
})
public class TypeProduto {

    @XmlElement(required = true)
    protected String nome;
    @XmlElement(required = true)
    protected String descricao;
    @XmlAttribute(name = "codigo")
    protected String codigo;

    /**
     * Obtém o valor da propriedade nome.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o valor da propriedade nome.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Obtém o valor da propriedade descricao.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define o valor da propriedade descricao.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setDescricao(String value) {
        this.descricao = value;
    }

    /**
     * Obtém o valor da propriedade codigo.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o valor da propriedade codigo.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    @Override
    public String toString() {
        return "TypeProduto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
