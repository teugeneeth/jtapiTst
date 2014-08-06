package by.et.jtapi.tst;

import org.apache.log4j.Logger;

import javax.telephony.TerminalEvent;
import javax.telephony.TerminalListener;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/17/14
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class EtTerminalListener implements TerminalListener
{

    public static final Logger LOG = Logger.getLogger(EtTerminalListener.class);

    @Override
    public void terminalListenerEnded(TerminalEvent terminalEvent)
    {
        LOG.info("TerminalEvent recived: " + terminalEvent);
    }
}
