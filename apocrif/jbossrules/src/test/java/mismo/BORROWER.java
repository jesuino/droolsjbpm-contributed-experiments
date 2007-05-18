//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.05.18 at 02:48:21 AM BST 
//


package mismo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}_RESIDENCE"/>
 *         &lt;element ref="{}CURRENT_INCOME"/>
 *         &lt;element ref="{}DECLARATION"/>
 *         &lt;element ref="{}EMPLOYER"/>
 *         &lt;element ref="{}GOVERNMENT_MONITORING"/>
 *         &lt;element ref="{}PRESENT_HOUSING_EXPENSE" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="BorrowerID" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="JointAssetLiabilityReportingType" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="MaritalStatusType" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="_ApplicationSignedDate" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="_BirthDate" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="_FirstName" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="_LastName" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="_PrintPositionType" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="_SSN" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "residence",
    "currentincome",
    "declaration",
    "employer",
    "governmentmonitoring",
    "presenthousingexpense"
})
@XmlRootElement(name = "BORROWER")
public class BORROWER {

    @XmlElement(name = "_RESIDENCE", required = true)
    protected RESIDENCE residence;
    @XmlElement(name = "CURRENT_INCOME", required = true)
    protected CURRENTINCOME currentincome;
    @XmlElement(name = "DECLARATION", required = true)
    protected DECLARATION declaration;
    @XmlElement(name = "EMPLOYER", required = true)
    protected EMPLOYER employer;
    @XmlElement(name = "GOVERNMENT_MONITORING", required = true)
    protected GOVERNMENTMONITORING governmentmonitoring;
    @XmlElement(name = "PRESENT_HOUSING_EXPENSE", required = true)
    protected List<PRESENTHOUSINGEXPENSE> presenthousingexpense;
    @XmlAttribute(name = "BorrowerID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String borrowerID;
    @XmlAttribute(name = "JointAssetLiabilityReportingType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String jointAssetLiabilityReportingType;
    @XmlAttribute(name = "MaritalStatusType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String maritalStatusType;
    @XmlAttribute(name = "_ApplicationSignedDate", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String applicationSignedDate;
    @XmlAttribute(name = "_BirthDate", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String birthDate;
    @XmlAttribute(name = "_FirstName", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String firstName;
    @XmlAttribute(name = "_LastName", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String lastName;
    @XmlAttribute(name = "_PrintPositionType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String printPositionType;
    @XmlAttribute(name = "_SSN", required = true)
    protected BigInteger ssn;

    /**
     * Gets the value of the residence property.
     * 
     * @return
     *     possible object is
     *     {@link RESIDENCE }
     *     
     */
    public RESIDENCE getRESIDENCE() {
        return residence;
    }

    /**
     * Sets the value of the residence property.
     * 
     * @param value
     *     allowed object is
     *     {@link RESIDENCE }
     *     
     */
    public void setRESIDENCE(RESIDENCE value) {
        this.residence = value;
    }

    /**
     * Gets the value of the currentincome property.
     * 
     * @return
     *     possible object is
     *     {@link CURRENTINCOME }
     *     
     */
    public CURRENTINCOME getCURRENTINCOME() {
        return currentincome;
    }

    /**
     * Sets the value of the currentincome property.
     * 
     * @param value
     *     allowed object is
     *     {@link CURRENTINCOME }
     *     
     */
    public void setCURRENTINCOME(CURRENTINCOME value) {
        this.currentincome = value;
    }

    /**
     * Gets the value of the declaration property.
     * 
     * @return
     *     possible object is
     *     {@link DECLARATION }
     *     
     */
    public DECLARATION getDECLARATION() {
        return declaration;
    }

    /**
     * Sets the value of the declaration property.
     * 
     * @param value
     *     allowed object is
     *     {@link DECLARATION }
     *     
     */
    public void setDECLARATION(DECLARATION value) {
        this.declaration = value;
    }

    /**
     * Gets the value of the employer property.
     * 
     * @return
     *     possible object is
     *     {@link EMPLOYER }
     *     
     */
    public EMPLOYER getEMPLOYER() {
        return employer;
    }

    /**
     * Sets the value of the employer property.
     * 
     * @param value
     *     allowed object is
     *     {@link EMPLOYER }
     *     
     */
    public void setEMPLOYER(EMPLOYER value) {
        this.employer = value;
    }

    /**
     * Gets the value of the governmentmonitoring property.
     * 
     * @return
     *     possible object is
     *     {@link GOVERNMENTMONITORING }
     *     
     */
    public GOVERNMENTMONITORING getGOVERNMENTMONITORING() {
        return governmentmonitoring;
    }

    /**
     * Sets the value of the governmentmonitoring property.
     * 
     * @param value
     *     allowed object is
     *     {@link GOVERNMENTMONITORING }
     *     
     */
    public void setGOVERNMENTMONITORING(GOVERNMENTMONITORING value) {
        this.governmentmonitoring = value;
    }

    /**
     * Gets the value of the presenthousingexpense property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the presenthousingexpense property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPRESENTHOUSINGEXPENSE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRESENTHOUSINGEXPENSE }
     * 
     * 
     */
    public List<PRESENTHOUSINGEXPENSE> getPRESENTHOUSINGEXPENSE() {
        if (presenthousingexpense == null) {
            presenthousingexpense = new ArrayList<PRESENTHOUSINGEXPENSE>();
        }
        return this.presenthousingexpense;
    }

    /**
     * Gets the value of the borrowerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerID() {
        return borrowerID;
    }

    /**
     * Sets the value of the borrowerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerID(String value) {
        this.borrowerID = value;
    }

    /**
     * Gets the value of the jointAssetLiabilityReportingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJointAssetLiabilityReportingType() {
        return jointAssetLiabilityReportingType;
    }

    /**
     * Sets the value of the jointAssetLiabilityReportingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJointAssetLiabilityReportingType(String value) {
        this.jointAssetLiabilityReportingType = value;
    }

    /**
     * Gets the value of the maritalStatusType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaritalStatusType() {
        return maritalStatusType;
    }

    /**
     * Sets the value of the maritalStatusType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaritalStatusType(String value) {
        this.maritalStatusType = value;
    }

    /**
     * Gets the value of the applicationSignedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationSignedDate() {
        return applicationSignedDate;
    }

    /**
     * Sets the value of the applicationSignedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationSignedDate(String value) {
        this.applicationSignedDate = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(String value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the printPositionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrintPositionType() {
        return printPositionType;
    }

    /**
     * Sets the value of the printPositionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrintPositionType(String value) {
        this.printPositionType = value;
    }

    /**
     * Gets the value of the ssn property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSSN() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSSN(BigInteger value) {
        this.ssn = value;
    }

}
