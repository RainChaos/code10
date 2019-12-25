
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
 *         &lt;element name="ModifyPasswordResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "modifyPasswordResult"
})
@XmlRootElement(name = "ModifyPasswordResponse")
public class ModifyPasswordResponse {

    @XmlElement(name = "ModifyPasswordResult")
    protected int modifyPasswordResult;

    /**
     * ��ȡmodifyPasswordResult���Ե�ֵ��
     * 
     */
    public int getModifyPasswordResult() {
        return modifyPasswordResult;
    }

    /**
     * ����modifyPasswordResult���Ե�ֵ��
     * 
     */
    public void setModifyPasswordResult(int value) {
        this.modifyPasswordResult = value;
    }

}
