package by.et.jtapi.tst;


import org.apache.log4j.Logger;

import javax.telephony.JtapiPeer;
import javax.telephony.JtapiPeerFactory;
import javax.telephony.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/17/14
 * Time: 5:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProviderService
{
    public static final Logger LOG = Logger.getLogger(JtapiEtTst.class);

    private static ProviderService instance;
    private static Provider provider;

    private ProviderService()
    {
        bootStrap();
    }


    private void bootStrap()
    {

        JtapiPeer peer = createJtapiPeer();

        if (peer != null)
        {
            String tlink = buildAESTlink();
            if (tlink == null || tlink.length() < 1)
            {
                throw new IllegalArgumentException("tlink for getting provider must not be null or empty");
            }

            provider = createPrivider(peer, tlink);
        }

    }

    private Provider createPrivider(JtapiPeer peer, String resourceString)
    {
        LOG.info("Attempting to create Provider by:  " + resourceString);
        final Provider provider = peer.getProvider(resourceString);

        if (provider != null)
        {
            LOG.info("Provider was created with name [ " + provider.getName() + " ]");
        }
        else
        {
            LOG.error("Provider could not be created");
        }
        return provider;
    }

    /*
   The string provided by JtapiPeer/getProvider must contain a AE Services tlink name
   as well as login and password for user authentication.
   The format of the String must be:<tlink>;login=<loginID>;passwd=<pw>
    */
    private String buildAESTlink()
    {
        String serviceID = "AVAYA#CM6#CSTA#AESTEST01";
        String thisMiddlewareID = "callcrmtst";
        String thisMiddlewarePwd = "Callcrmtst1!";

        final String tlink = serviceID + ";loginID=" + thisMiddlewareID + ";passwd=" + thisMiddlewarePwd;

        LOG.info("AE Services tlink is: " + tlink);

        return tlink;
    }

    /*
   Obtain a JtapiPeer object using the JtapiPeerFactory class. The TsapiPeer class represents
   this implementation of the JtapiPeer. To obtain TsapiPeer,
   do:JtapiPeerFactory.getJtapiPeer(com.avaya.jtapi.tsapi.TsapiPeer)
    */
    private JtapiPeer createJtapiPeer()
    {
        try
        {
            LOG.info("Attempting to create JtapiPeer type of <com.avaya.jtapi.tsapi.TsapiPeer> ");
            final JtapiPeer jtapiPeer = JtapiPeerFactory.getJtapiPeer("com.avaya.jtapi.tsapi.TsapiPeer");

            if (jtapiPeer != null)
            {
                LOG.info("JtapiPeer was created with name [ " + jtapiPeer.getName() + " ]");
            }
            else
            {
                LOG.error("JtapiPeer could not be created");
            }

            return jtapiPeer;

        }
        catch (Exception e)
        {
            LOG.error("Error: " + e.getMessage(), e);
        }
        return null;
    }

    public static Provider getProvider()
    {

        if (instance == null)
        {

            instance = new ProviderService();

        }

        return provider;

    }


    public static Provider getNewProvider()
    {


        new ProviderService();


        return provider;

    }


}
