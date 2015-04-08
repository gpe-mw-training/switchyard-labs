package mortgages;

import org.switchyard.component.test.mixins.http.HTTPMixIn;

/**
 * Simple client to send a SOAP message.
 */
public final class CreditServiceClient {

    private static final String XML = "src/test/resources/xml/credit-no-income.xml";

    private static String serverUrl = "fsw1-bpmstraining.apps.lab2.opentlc.com";


    /**
     * Only execution point for this application.
     * @param ignored not used.
     * @throws Exception if something goes wrong.
     */
    public static void main(final String[] ignored) throws Exception {

        HTTPMixIn soapMixIn = new HTTPMixIn();
        soapMixIn.initialize();

        //serverUrl = System.getProperty("serverUrl", serverUrl);
        String creditServiceUrl = "http://"+serverUrl+"/CreditProxy/CreditService";
        System.out.println("main() about to invoke:  "+creditServiceUrl);

        try {
        	soapMixIn.setDumpMessages(true);
            soapMixIn.postFile(creditServiceUrl, XML);
        } finally {
            soapMixIn.uninitialize();
        }
    }
}
