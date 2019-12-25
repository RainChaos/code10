
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
 *         &lt;element name="PostSingleResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "postSingleResult"
})
@XmlRootElement(name = "PostSingleResponse")
public class PostSingleResponse {

    @XmlElement(name = "PostSingleResult")
    protected int postSingleResult;

    /**
     * ��ȡpostSingleResult���Ե�ֵ��
     * 
     */
    public int getPostSingleResult() {
        return postSingleResult;
    }

    /**
     * ����postSingleResult���Ե�ֵ��
     * 
     */
    public void setPostSingleResult(int value) {
        this.postSingleResult = value;
    }

}
