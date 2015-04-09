package org.acme.insurance.policyquote.test;

import org.xml.sax.SAXException;
import org.acme.insurance.policyquote.domain.PolicyQuote;
import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.payload.JavaResult;
import org.milyn.io.StreamUtils;
import org.milyn.container.ExecutionContext;

import javax.xml.transform.stream.StreamSource;

import java.io.*;

public class SmooksTest {

	private static byte[] messageIn = readInputMessage();

	protected static PolicyQuote runSmooks() throws IOException, SAXException,
			SmooksException {
		
		Smooks smooks = new Smooks("PolicyQuoteConfigSmooks.xml");
		
		try {
			ExecutionContext executionContext = smooks.createExecutionContext();
			JavaResult result = new JavaResult();
			smooks.filterSource(executionContext, new StreamSource(
					new ByteArrayInputStream(messageIn)), result);
			return (PolicyQuote) result.getBean("policyquote");
		} finally {
			smooks.close();
		}
	}

	public static void main(String[] args) throws IOException, SAXException,
			SmooksException {
		System.out.println("\n\n");
		System.out.println("==============Message In==============");
		System.out.println(new String(messageIn));
		System.out.println("======================================\n");
		PolicyQuote result = SmooksTest.runSmooks();
		System.out.println("============PolicyQuote Javabeans===========");
		System.out.println(result.toString());
		System.out.println("======================================");
		System.out.println("\n\n");
	}

	private static byte[] readInputMessage() {
		try {
			return StreamUtils
					.readStream(new FileInputStream(
							"src/test/resources/soap-request.xml"));
		} catch (IOException e) {
			e.printStackTrace();
			return "<no-message/>".getBytes();
		}
	}

}
