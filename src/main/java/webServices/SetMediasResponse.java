
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
 *         &lt;element name="SetMediasResult" type="{http://www.139130.net}ArrayOfMediaItems" minOccurs="0"/>
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
    "setMediasResult"
})
@XmlRootElement(name = "SetMediasResponse")
public class SetMediasResponse {

    @XmlElement(name = "SetMediasResult")
    protected ArrayOfMediaItems setMediasResult;

    /**
     * ��ȡsetMediasResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMediaItems }
     *     
     */
    public ArrayOfMediaItems getSetMediasResult() {
        return setMediasResult;
    }

    /**
     * ����setMediasResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMediaItems }
     *     
     */
    public void setSetMediasResult(ArrayOfMediaItems value) {
        this.setMediasResult = value;
    }

}
