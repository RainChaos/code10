
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
 *         &lt;element name="GetBusinessTypeResult" type="{http://www.139130.net}ArrayOfBusinessType" minOccurs="0"/>
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
    "getBusinessTypeResult"
})
@XmlRootElement(name = "GetBusinessTypeResponse")
public class GetBusinessTypeResponse {

    @XmlElement(name = "GetBusinessTypeResult")
    protected ArrayOfBusinessType getBusinessTypeResult;

    /**
     * ��ȡgetBusinessTypeResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBusinessType }
     *     
     */
    public ArrayOfBusinessType getGetBusinessTypeResult() {
        return getBusinessTypeResult;
    }

    /**
     * ����getBusinessTypeResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBusinessType }
     *     
     */
    public void setGetBusinessTypeResult(ArrayOfBusinessType value) {
        this.getBusinessTypeResult = value;
    }

}
