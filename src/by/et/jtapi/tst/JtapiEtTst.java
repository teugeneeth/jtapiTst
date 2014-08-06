package by.et.jtapi.tst;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/16/14
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.apache.log4j.Logger;

import java.text.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import javax.telephony.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class JtapiEtTst
{
    public static final Logger LOG = Logger.getLogger(JtapiEtTst.class);


    public static void main(String args[]) throws java.text.ParseException
    {
        LOG.info("version : 1");
        JtapiEtTst jtapiEtTst = new JtapiEtTst();

        try
        {
            jtapiEtTst.work();
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage(), e);
        }


    }

    private void work() throws Exception
    {

            LOG.info("Request to create Provider");
            Provider provider = ProviderService.getProvider();

            LOG.info("Adding a listener to the Provider " + provider.hashCode());
            provider.addProviderListener(new EtProviderListener(new BaseEventHandler()));

    }

    private void cctest(JAXBContext jc) throws JAXBException
    {
        ConfItem configuration = new ConfItem();
        configuration.setAgentID("22222");
        configuration.setPassword("ssss");
        configuration.setPhoneExt("4195");

        Configurations configurations = new Configurations();
        List<ConfItem> values = new ArrayList<ConfItem>();


        configurations.setItems(values);


        ConfItem configuration1 = new ConfItem();
        configuration1.setAgentID("22222");
        configuration1.setPassword("ssss");
        configuration1.setPhoneExt("4195");


        values.add(configuration);
        values.add(configuration1);

        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(configurations, System.out);
    }


}
