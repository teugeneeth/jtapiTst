package by.et.jtapi.tst;

import javax.telephony.CallEvent;
import javax.telephony.CallListener;
import javax.telephony.MetaEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/16/14
 * Time: 9:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class CallListenerEt implements CallListener
{
    @Override
    public void callActive(CallEvent callEvent)
    {
        System.out.println("callEvent " + callEvent);
    }

    @Override
    public void callInvalid(CallEvent callEvent)
    {
        System.out.println("callEvent " + callEvent);
    }

    @Override
    public void callEventTransmissionEnded(CallEvent callEvent)
    {
        System.out.println("callEvent " + callEvent);
    }

    @Override
    public void singleCallMetaProgressStarted(MetaEvent metaEvent)
    {
        System.out.println("MetaEvent " + metaEvent);
    }

    @Override
    public void singleCallMetaProgressEnded(MetaEvent metaEvent)
    {
        System.out.println("MetaEvent " + metaEvent);
    }

    @Override
    public void singleCallMetaSnapshotStarted(MetaEvent metaEvent)
    {
        System.out.println("MetaEvent " + metaEvent);
    }

    @Override
    public void singleCallMetaSnapshotEnded(MetaEvent metaEvent)
    {
        System.out.println("MetaEvent " + metaEvent);
    }

    @Override
    public void multiCallMetaMergeStarted(MetaEvent metaEvent)
    {
        System.out.println("MetaEvent " + metaEvent);
    }

    @Override
    public void multiCallMetaMergeEnded(MetaEvent metaEvent)
    {
        System.out.println("MetaEvent " + metaEvent);
    }

    @Override
    public void multiCallMetaTransferStarted(MetaEvent metaEvent)
    {
        System.out.println("MetaEvent " + metaEvent);
    }

    @Override
    public void multiCallMetaTransferEnded(MetaEvent metaEvent)
    {
        System.out.println("MetaEvent " + metaEvent);
    }
}
