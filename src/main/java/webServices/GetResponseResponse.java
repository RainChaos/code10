
package webServices;

import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetResponseResult" type="{http://www.139130.net}ArrayOfMTResponse" minOccurs="0"/>
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
    "getResponseResult"
})
@XmlRootElement(name = "GetResponseResponse")
public class GetResponseResponse {

    @XmlElement(name = "GetResponseResult")
    protected ArrayOfMTResponse getResponseResult;

    /**
     * ��ȡgetResponseResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMTResponse }
     *     
     */
    public ArrayOfMTResponse getGetResponseResult() {
        return getResponseResult;
    }

    /**
     * ����getResponseResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMTResponse }
     *     
     */
    public void setGetResponseResult(ArrayOfMTResponse value) {
        this.getResponseResult = value;
    }

}
