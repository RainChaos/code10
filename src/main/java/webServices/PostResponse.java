
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
 *         &lt;element name="PostResult" type="{http://www.139130.net}GsmsResponse" minOccurs="0"/>
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
    "postResult"
})
@XmlRootElement(name = "PostResponse")
public class PostResponse {

    @XmlElement(name = "PostResult")
    protected GsmsResponse postResult;

    /**
     * ��ȡpostResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GsmsResponse }
     *     
     */
    public GsmsResponse getPostResult() {
        return postResult;
    }

    /**
     * ����postResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GsmsResponse }
     *     
     */
    public void setPostResult(GsmsResponse value) {
        this.postResult = value;
    }

}
