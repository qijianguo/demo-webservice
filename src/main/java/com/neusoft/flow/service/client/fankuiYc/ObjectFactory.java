
package com.neusoft.flow.service.client.fankuiYc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.neusoft.flow.service.client.fankuiYc package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Feedback_QNAME = new QName("http://www.WebService.hb110.landfun.cn", "feedback");
    private final static QName _FeedbackResponse_QNAME = new QName("http://www.WebService.hb110.landfun.cn", "feedbackResponse");
    private final static QName _String_QNAME = new QName("feedback", "String");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.neusoft.flow.service.client.fankuiYc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Feedback }
     * 
     */
    public Feedback createFeedback() {
        return new Feedback();
    }

    /**
     * Create an instance of {@link FeedbackResponse }
     * 
     */
    public FeedbackResponse createFeedbackResponse() {
        return new FeedbackResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Feedback }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.WebService.hb110.landfun.cn", name = "feedback")
    public JAXBElement<Feedback> createFeedback(Feedback value) {
        return new JAXBElement<Feedback>(_Feedback_QNAME, Feedback.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeedbackResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.WebService.hb110.landfun.cn", name = "feedbackResponse")
    public JAXBElement<FeedbackResponse> createFeedbackResponse(FeedbackResponse value) {
        return new JAXBElement<FeedbackResponse>(_FeedbackResponse_QNAME, FeedbackResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "feedback", name = "String")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

}
