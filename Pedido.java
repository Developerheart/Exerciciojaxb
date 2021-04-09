import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java de anonymous complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="produto" type="{}typeProduto" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "produto"
})
@XmlRootElement(name = "pedido")
public class Pedido {

    @XmlElement(required = true)
    protected List<TypeProduto> produto;

    /**
     * Gets the value of the produto property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the produto property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProduto().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeProduto }
     *
     *
     */
    public List<TypeProduto> getProduto() {
        if (produto == null) {
            produto = new ArrayList<TypeProduto>();
        }
        return this.produto;
    }

    public void setProduto(List<TypeProduto> produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "produto=" + produto +
                '}';
    }
}
