package org.savara.policyquote.policyquoteprocess;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2014-01-16T11:50:35.889+05:30
 * Generated source version: 2.7.0
 * 
 */
@XmlSeeAlso({org.example.policyquote.ObjectFactory.class})
public interface PolicyQuoteProcess {

    public org.example.policyquote.PolicyQuoteReply policyQuote(
        org.example.policyquote.PolicyQuote content
    ) throws TooManyAccidentsFault;
}