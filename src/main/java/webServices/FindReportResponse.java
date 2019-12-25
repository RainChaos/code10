
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
 *         &lt;element name="FindReportResult" type="{http://www.139130.net}ArrayOfMTReport" minOccurs="0"/>
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
    "findReportResult"
})
@XmlRootElement(name = "FindReportResponse")
public class FindReportResponse {

    @XmlElement(name = "FindReportResult")
    protected ArrayOfMTReport findReportResult;

    /**
     * ��ȡfindReportResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMTReport }
     *     
     */
    public ArrayOfMTReport getFindReportResult() {
        return findReportResult;
    }

    /**
     * ����findReportResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMTReport }
     *     
     */
    public void setFindReportResult(ArrayOfMTReport value) {
        this.findReportResult = value;
    }

}
