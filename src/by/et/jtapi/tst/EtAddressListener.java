package by.et.jtapi.tst;

import org.apache.log4j.Logger;

import javax.telephony.AddressEvent;
import javax.telephony.AddressListener;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/19/14
 * Time: 6:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class EtAddressListener implements AddressListener
{

    public static final Logger LOG = Logger.getLogger(EtTerminalListener.class);

    @Override
    public void addressListenerEnded(AddressEvent addressEvent)
    {
        LOG.info("AddressEvent recived: " + addressEvent);
    }
}
