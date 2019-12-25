
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
 *         &lt;element name="GetAccountInfoResult" type="{http://www.139130.net}AccountInfo" minOccurs="0"/>
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
    "getAccountInfoResult"
})
@XmlRootElement(name = "GetAccountInfoResponse")
public class GetAccountInfoResponse {

    @XmlElement(name = "GetAccountInfoResult")
    protected AccountInfo getAccountInfoResult;

    /**
     * ��ȡgetAccountInfoResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AccountInfo }
     *     
     */
    public AccountInfo getGetAccountInfoResult() {
        return getAccountInfoResult;
    }

    /**
     * ����getAccountInfoResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AccountInfo }
     *     
     */
    public void setGetAccountInfoResult(AccountInfo value) {
        this.getAccountInfoResult = value;
    }

}
