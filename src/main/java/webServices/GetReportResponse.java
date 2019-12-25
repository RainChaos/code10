
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
 *         &lt;element name="GetReportResult" type="{http://www.139130.net}ArrayOfMTReport" minOccurs="0"/>
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
    "getReportResult"
})
@XmlRootElement(name = "GetReportResponse")
public class GetReportResponse {

    @XmlElement(name = "GetReportResult")
    protected ArrayOfMTReport getReportResult;

    /**
     * ��ȡgetReportResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMTReport }
     *     
     */
    public ArrayOfMTReport getGetReportResult() {
        return getReportResult;
    }

    /**
     * ����getReportResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMTReport }
     *     
     */
    public void setGetReportResult(ArrayOfMTReport value) {
        this.getReportResult = value;
    }

}
