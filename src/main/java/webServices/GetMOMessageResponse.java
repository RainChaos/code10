
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
 *         &lt;element name="GetMOMessageResult" type="{http://www.139130.net}ArrayOfMOMsg" minOccurs="0"/>
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
    "getMOMessageResult"
})
@XmlRootElement(name = "GetMOMessageResponse")
public class GetMOMessageResponse {

    @XmlElement(name = "GetMOMessageResult")
    protected ArrayOfMOMsg getMOMessageResult;

    /**
     * ��ȡgetMOMessageResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMOMsg }
     *     
     */
    public ArrayOfMOMsg getGetMOMessageResult() {
        return getMOMessageResult;
    }

    /**
     * ����getMOMessageResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMOMsg }
     *     
     */
    public void setGetMOMessageResult(ArrayOfMOMsg value) {
        this.getMOMessageResult = value;
    }

}
