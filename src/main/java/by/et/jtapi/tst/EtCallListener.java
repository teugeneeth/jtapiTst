package by.et.jtapi.tst;

import org.apache.log4j.Logger;

import javax.telephony.CallEvent;
import javax.telephony.CallListener;
import javax.telephony.MetaEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/17/14
 * Time: 5:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class EtCallListener implements CallListener
{
    public static final Logger LOG = Logger.getLogger(EtCallListener.class);

    @Override
    public void callActive(CallEvent callEvent)
    {
        LOG.info("CallEvent recived: " + callEvent);
    }

    @Override
    public void callInvalid(CallEvent callEvent)
    {
        LOG.info("CallEvent recived: " + callEvent);
    }

    @Override
    public void callEventTransmissionEnded(CallEvent callEvent)
    {
        LOG.info("CallEvent recived: " + callEvent);
    }

    @Override
    public void singleCallMetaProgressStarted(MetaEvent metaEvent)
    {
        LOG.info("metaEvent recived: " + metaEvent);
    }

    @Override
    public void singleCallMetaProgressEnded(MetaEvent metaEvent)
    {
        LOG.info("metaEvent recived: " + metaEvent);
    }

    @Override
    public void singleCallMetaSnapshotStarted(MetaEvent metaEvent)
    {
        LOG.info("metaEvent recived: " + metaEvent);
    }

    @Override
    public void singleCallMetaSnapshotEnded(MetaEvent metaEvent)
    {
        LOG.info("metaEvent recived: " + metaEvent);
    }

    @Override
    public void multiCallMetaMergeStarted(MetaEvent metaEvent)
    {
        LOG.info("metaEvent recived: " + metaEvent);
    }

    @Override
    public void multiCallMetaMergeEnded(MetaEvent metaEvent)
    {
        LOG.info("metaEvent recived: " + metaEvent);
    }

    @Override
    public void multiCallMetaTransferStarted(MetaEvent metaEvent)
    {
        LOG.info("metaEvent recived: " + metaEvent);
    }

    @Override
    public void multiCallMetaTransferEnded(MetaEvent metaEvent)
    {
        LOG.info("metaEvent recived: " + metaEvent);
    }
}
