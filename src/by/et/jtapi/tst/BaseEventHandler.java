package by.et.jtapi.tst;

import org.apache.log4j.Logger;

import javax.telephony.Provider;
import javax.telephony.ProviderEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/17/14
 * Time: 8:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class BaseEventHandler
{
    public static final Logger LOG = Logger.getLogger(BaseEventHandler.class);


    public void handleProviderInServiceIvent(ProviderEvent providerEvent)
    {

        try
        {

            Provider provider = providerEvent.getProvider();
            loggingProviderState(provider);

            Configurations configurations = getConfiguration();


            Collection<JTapiWorker<String>> callables = new ArrayList<JTapiWorker<String>>();

            for (ConfItem item : configurations.getItems())
            {
                if (item == null)
                {
                    throw new IllegalArgumentException("Configuration item must not be null.");
                }

                callables.add(new JTapiWorker(item, provider));
            }

            ExecutorService executorService = Executors.newFixedThreadPool(callables.size());

            executorService.invokeAll(callables);


        }
        catch (Exception e)
        {
            LOG.error(e.getMessage(), e);
            throw new IllegalArgumentException(e.getMessage(), e);
        }

    }

    private Configurations getConfiguration()
    {
        Configurations configurations = ConfigurationService.getInstance().getConfiguration();

        if (configurations == null)
        {
            throw new IllegalArgumentException("Configuration  must not be null. Please check vo.XML ");
        }
        return configurations;
    }


    private void loggingProviderState(Provider provider)
    {
        if (Provider.IN_SERVICE != provider.getState())
        {
            throw new IllegalArgumentException("Provider must be in state == IN_SERVICE; actual state is: " + provider.getState() + " OUT_OF_SERVICE = 17; " +
                    "SHUTDOWN = 18;");
        }
        else
        {
            LOG.info("Provider state is: " + provider.getState());
        }
    }

}
