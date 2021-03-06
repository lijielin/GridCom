/**
 * Copyright 2005 Jasper Systems, Inc. All rights reserved.
 *
 * This software code is the confidential and proprietary information of
 * Jasper Systems, Inc. ("Confidential Information"). Any unauthorized
 * review, use, copy, disclosure or distribution of such Confidential
 * Information is strictly prohibited.
 */
package com.inc.gtc.sms.jasper;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.xml.wss.ProcessingContext;
import com.sun.xml.wss.XWSSProcessor;
import com.sun.xml.wss.XWSSProcessorFactory;
import com.sun.xml.wss.XWSSecurityException;
import com.sun.xml.wss.impl.callback.UsernameCallback;

/**
 * @author Sunil Sheshadri
 * @version $Id: //depot/jasper_dev/module/ProvisionApp/web/secure/apidoc/java/com/jasperwireless/ws/client/sample/GetSessionInfoClient.java#3 $
 */
public class GetSessionInfoClient implements ApiClientConstant {
    private SOAPConnectionFactory connectionFactory;
    private MessageFactory messageFactory;
    private URL url;
    private String licenseKey;

    private XWSSProcessorFactory processorFactory;

    /**
     * Constructor which initializes Soap Connection, messagefactory and ProcessorFactory
     *
     * @param url
     * @throws SOAPException
     * @throws MalformedURLException
     * @throws XWSSecurityException
     */
    public GetSessionInfoClient(String url, String licenseKey)
            throws SOAPException, MalformedURLException, XWSSecurityException {
        connectionFactory = SOAPConnectionFactory.newInstance();
        messageFactory = MessageFactory.newInstance();
        processorFactory = XWSSProcessorFactory.newInstance();
        this.url = new URL(url);
        this.licenseKey = licenseKey;
    }

    /**
     * This method creates a Terminal Request and sends back the SOAPMessage.
     * ICCID value is passed into this method
     *
     * @return SOAPMessage
     * @throws SOAPException
     */
    private SOAPMessage createTerminalRequest(String iccid) throws SOAPException {
        SOAPMessage message = messageFactory.createMessage();
        message.getMimeHeaders().addHeader("SOAPAction",
                "http://api.jasperwireless.com/ws/service/terminal/GetSessionInfo");
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        Name terminalRequestName = envelope.createName("GetSessionInfoRequest", PREFIX, NAMESPACE_URI);
        SOAPBodyElement terminalRequestElement = message.getSOAPBody()
                .addBodyElement(terminalRequestName);
        Name msgId = envelope.createName("messageId", PREFIX, NAMESPACE_URI);
        SOAPElement msgElement = terminalRequestElement.addChildElement(msgId);
        msgElement.setValue("TCE-100-ABC-34084");
        Name version = envelope.createName("version", PREFIX, NAMESPACE_URI);
        SOAPElement versionElement = terminalRequestElement.addChildElement(version);
        versionElement.setValue("1.0");
        Name license = envelope.createName("licenseKey", PREFIX, NAMESPACE_URI);
        SOAPElement licenseElement = terminalRequestElement.addChildElement(license);
        licenseElement.setValue(licenseKey);
        //Name iccids = envelope.createName("iccids", PREFIX, NAMESPACE_URI);
        //SOAPElement iccidsElement = terminalRequestElement.addChildElement(iccids);
        Name iccidName = envelope.createName("iccid", PREFIX, NAMESPACE_URI);
        SOAPElement iccidElement = terminalRequestElement.addChildElement(iccidName);
        iccidElement.setValue(iccid);
        return message;
    }

    public void callWebService(String username, String password, String iccid) throws SOAPException, IOException, XWSSecurityException, Exception {
        SOAPMessage request = createTerminalRequest(iccid);
        request = secureMessage(request, username, password);
        System.out.println("Request: ");
        request.writeTo(System.out);
        System.out.println("");
        SOAPConnection connection = connectionFactory.createConnection();
        SOAPMessage response = connection.call(request, url);
        System.out.println("Response: ");
        response.writeTo(System.out);
        System.out.println("");
        if (!response.getSOAPBody().hasFault()) {
            writeTerminalResponse(response);
        } else {
            SOAPFault fault = response.getSOAPBody().getFault();
            System.err.println("Received SOAP Fault");
            System.err.println("SOAP Fault Code :" + fault.getFaultCode());
            System.err.println("SOAP Fault String :" + fault.getFaultString());
        }
    }

    /**
     * Gets the terminal response.
     *
     * @param message
     * @throws SOAPException
     */
    private void writeTerminalResponse(SOAPMessage message) throws SOAPException {
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        Name terminalResponseName = envelope.createName("GetSessionInfoResponse", PREFIX, NAMESPACE_URI);
        SOAPBodyElement terminalResponseElement = (SOAPBodyElement) message
                .getSOAPBody().getChildElements(terminalResponseName).next();
        String terminalValue = terminalResponseElement.getTextContent();
        Name terminals = envelope.createName("sessionInfo", PREFIX, NAMESPACE_URI);
        Name terminal = envelope.createName("session", PREFIX, NAMESPACE_URI);
        SOAPBodyElement terminalsElement = (SOAPBodyElement) terminalResponseElement.getChildElements(terminals).next();
        boolean found = false;
        Iterator itr = terminalsElement.getChildElements(terminal);
        while ( itr.hasNext()) {
            SOAPBodyElement terminalElement = (SOAPBodyElement) itr.next();
            found = true;
            NodeList list = terminalElement.getChildNodes();
            Node n = null;
            System.out.println("SESSION INFORMATION");
            for (int i = 0; i < list.getLength(); i ++) {
                n = list.item(i);
                if ( n.getLocalName() != null && !"null".equals(n.getLocalName()))
                System.out.println( n.getLocalName() + "  is " + n.getTextContent());

            }
        }
        if (!found) {
            System.out.println("No session found for ICCID ");
        }

    }

    /**
     * This method is used to add the security. This uses xwss:UsernameToken configuration and expects
     * Username and Password to be passes. SecurityPolicy.xml file should be in classpath.
     *
     * @param message
     * @param username
     * @param password
     * @return
     * @throws IOException
     * @throws XWSSecurityException
     */
    private SOAPMessage secureMessage(SOAPMessage message,  String username,  String password)
            throws IOException, XWSSecurityException {
        CallbackHandler callbackHandler = new CallbackHandler() {
            public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
            	System.out.println("password0"+password);
                for (int i = 0; i < callbacks.length; i++) {
                    if (callbacks[i] instanceof UsernameCallback) {
                    	System.out.println("callbacks1"+callbacks[i].getClass().getName());
                        UsernameCallback callback = (UsernameCallback) callbacks[i];
                        callback.setUsername(username);
                    } else if (callbacks[i] instanceof PasswordCallback) {
                    	System.out.println("callbacks2"+callbacks[i].getClass().getName());
                    	 System.out.println("setpassword2"+password);
                        PasswordCallback callback = (PasswordCallback) callbacks[i];
                        char[] pw = password.toCharArray();
                        callback.setPassword(pw);
                    } else {
                        throw new UnsupportedCallbackException(callbacks[i]);
                    }
                }
            }
        };
        InputStream policyStream = null;
        XWSSProcessor processor = null;
        try {
            policyStream = getClass().getResourceAsStream("securityPolicy.xml");
            processor = processorFactory.createProcessorForSecurityConfiguration(policyStream, callbackHandler);
        }
        finally {
            if (policyStream != null) {
                policyStream.close();
            }
        }
        ProcessingContext context = processor.createProcessingContext(message);
        return processor.secureOutboundMessage(context);
    }

    /**
     * Main program. Usage : TerminalClient <username> <password>
     *
     * @param args
     * @throws Exception
     */
//    public static void main(String[] args) throws Exception {
//        // Apitest URL. See "Get WSDL Files" in the API documentation for Production URL.
//        String url = "https://apitest.jasperwireless.com/ws/service/terminal";
//        if (args.length != 4) {
//            System.out.println("usage: GetSessionInfoClient <license-key> <username> <password> <iccid>");
//            System.exit(-1);
//        }
//        GetSessionInfoClient terminalClient = new GetSessionInfoClient(url, args[0]);
//        terminalClient.callWebService(args[1], args[2], args[3]);
//    }
}

