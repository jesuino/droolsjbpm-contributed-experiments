//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.05.18 at 02:48:21 AM BST 
//


package mismo;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="FirstPaymentAdjustmentMonths" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="SubsequentPaymentAdjustmentMonths" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="_PeriodNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "PAYMENT_ADJUSTMENT")
public class PAYMENTADJUSTMENT {

    @XmlAttribute(name = "FirstPaymentAdjustmentMonths", required = true)
    protected BigInteger firstPaymentAdjustmentMonths;
    @XmlAttribute(name = "SubsequentPaymentAdjustmentMonths", required = true)
    protected BigInteger subsequentPaymentAdjustmentMonths;
    @XmlAttribute(name = "_PeriodNumber", required = true)
    protected BigInteger periodNumber;

    /**
     * Gets the value of the firstPaymentAdjustmentMonths property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFirstPaymentAdjustmentMonths() {
        return firstPaymentAdjustmentMonths;
    }

    /**
     * Sets the value of the firstPaymentAdjustmentMonths property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFirstPaymentAdjustmentMonths(BigInteger value) {
        this.firstPaymentAdjustmentMonths = value;
    }

    /**
     * Gets the value of the subsequentPaymentAdjustmentMonths property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSubsequentPaymentAdjustmentMonths() {
        return subsequentPaymentAdjustmentMonths;
    }

    /**
     * Sets the value of the subsequentPaymentAdjustmentMonths property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSubsequentPaymentAdjustmentMonths(BigInteger value) {
        this.subsequentPaymentAdjustmentMonths = value;
    }

    /**
     * Gets the value of the periodNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPeriodNumber() {
        return periodNumber;
    }

    /**
     * Sets the value of the periodNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPeriodNumber(BigInteger value) {
        this.periodNumber = value;
    }

}
