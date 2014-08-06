package by.et.jtapi.tst;

import org.apache.log4j.Logger;

import javax.telephony.ProviderEvent;
import javax.telephony.ProviderListener;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/17/14
 * Time: 8:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class EtProviderListener implements ProviderListener
{
    public static final Logger LOG = Logger.getLogger(EtProviderListener.class);
    private final BaseEventHandler baseEventHandler;

    public EtProviderListener(BaseEventHandler baseEventHandler)
    {

        this.baseEventHandler = baseEventHandler;
    }


    @Override
    public void providerInService(ProviderEvent providerEvent)
    {

        LOG.info("providerInService Event has been retrieved");
        baseEventHandler.handleProviderInServiceIvent(providerEvent);
    }

    @Override
    public void providerEventTransmissionEnded(ProviderEvent providerEvent)
    {
        LOG.info("providerEventTransmissionEnded Event has been retrieved");
    }

    @Override
    public void providerOutOfService(ProviderEvent providerEvent)
    {
        LOG.info("providerOutOfService Event has been retrieved");
    }

    @Override
    public void providerShutdown(ProviderEvent providerEvent)
    {
        LOG.info("providerShutdown Event has been retrieved");
        providerEvent.getProvider().shutdown();
    }
}
