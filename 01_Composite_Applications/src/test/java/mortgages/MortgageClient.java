package mortgages;

import org.switchyard.component.test.mixins.http.HTTPMixIn;

/**
 * Simple client to send a SOAP message.
 * invoke via the command-line as follows:
 *  mvn clean test exec:java -Dexec.mainClass="mortgages.MortgageClient" -Dexec.classpathScope="test" -DskipTests -DserverUrl="<your.openshift.fsw.url>"
 */
public final class MortgageClient {

    private static final String SERVER_URL = "serverUrl";
    private static final String XML = "src/test/resources/xml/loan-request-normal.xml";

    private static String url = "nanfswapp-nandomain.apps.ose.opentlc.com:8080";

    /**
     * Only execution point for this application.
     * @param ignored not used.
     * @throws Exception if something goes wrong.
     */
    public static void main(final String[] ignored) throws Exception {

        url = System.getProperty(SERVER_URL, url);
        String cServiceUrl = "http://"+url+"/loans/LoanProcessing";
        

        HTTPMixIn soapMixIn = new HTTPMixIn();
        soapMixIn.initialize();

        try {
        	soapMixIn.setDumpMessages(true);
            soapMixIn.postFile(cServiceUrl, XML);
        } finally {
            soapMixIn.uninitialize();
        }
    }
}
