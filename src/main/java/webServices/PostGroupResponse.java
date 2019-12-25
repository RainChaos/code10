
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
 *         &lt;element name="PostGroupResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "postGroupResult"
})
@XmlRootElement(name = "PostGroupResponse")
public class PostGroupResponse {

    @XmlElement(name = "PostGroupResult")
    protected int postGroupResult;

    /**
     * ��ȡpostGroupResult���Ե�ֵ��
     * 
     */
    public int getPostGroupResult() {
        return postGroupResult;
    }

    /**
     * ����postGroupResult���Ե�ֵ��
     * 
     */
    public void setPostGroupResult(int value) {
        this.postGroupResult = value;
    }

}
