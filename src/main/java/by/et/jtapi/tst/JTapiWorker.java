package by.et.jtapi.tst;

import com.avaya.jtapi.tsapi.LucentV6Agent;
import com.avaya.jtapi.tsapi.LucentV6AgentStateInfoEx;
import org.apache.log4j.Logger;

import javax.telephony.*;
import javax.telephony.callcenter.Agent;
import javax.telephony.callcenter.AgentTerminal;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/18/14
 * Time: 8:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class JTapiWorker<T> implements Callable<T>
{
    public static final Logger LOG = Logger.getLogger(JTapiWorker.class);
    private final ConfItem item;
    private final Provider provider;

    public JTapiWorker(ConfItem item, Provider provider)
    {
        this.item = item;
        this.provider = provider;
    }


    @Override
    public T call() throws Exception
    {
        try
        {
            LOG.info("connecting to Phone...");
            connectToPhone();
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage(), e);

            throw e;
        }


        return null;
    }


    private void connectToPhone() throws InvalidArgumentException, ResourceUnavailableException, MethodNotSupportedException, InvalidStateException
    {
        LOG.info("Creating Terminal!");
        Terminal terminal = getTerminal(provider, item.getPhoneExt());

        LOG.info("Creating Address!");
        Address address = getAddress(provider, item.getPhoneExt());

        address.addAddressListener(new EtAddressListener());

        terminal.addTerminalListener(new EtTerminalListener());

        LOG.info("Adding AgentTerminal!");

        addAgentTerminal(provider, item.getPhoneExt(), address);


    }

    private Address getAddress(Provider provider, String stationNumber) throws InvalidArgumentException
    {
        Address address;
        LOG.info("Attempting to create Address by stationNumber:  " + stationNumber);
        address = provider.getAddress(stationNumber);
        LOG.info("Address was created success:  " + address);
        return address;
    }

    private Terminal getTerminal(Provider provider, String stationNumber) throws InvalidArgumentException
    {
        Terminal terminal;
        LOG.info("Attempting to create Terminal by stationNumber:  " + stationNumber);
        terminal = provider.getTerminal(stationNumber);
        LOG.info("Address was created success:  " + terminal);
        return terminal;
    }

    private void addAgentTerminal(Provider provider, String stationNumber, Address address) throws InvalidArgumentException, InvalidStateException, ResourceUnavailableException, MethodNotSupportedException
    {
        AgentTerminal agentTerminal = (AgentTerminal) provider.getTerminal(stationNumber);
        LucentV6Agent thisAgent = (LucentV6Agent) agentTerminal.addAgent(address, null, Agent.LOG_IN, item.getAgentID(), item.getPassword());


        thisAgent.setState(LucentV6Agent.READY);


        LucentV6AgentStateInfoEx currentAgentState = (LucentV6AgentStateInfoEx) thisAgent.getStateInfo();
        logAgentState(currentAgentState);

        thisAgent.getAgentTerminal().addTerminalListener(new EtTerminalListener());

    }

    private void logAgentState(LucentV6AgentStateInfoEx currentAgentState)
    {
        String agentState = "";
        switch (currentAgentState.state)
        {
            case LucentV6Agent.READY:
                agentState = "Agent is in Ready state";
                break;
            case LucentV6Agent.LOG_IN:
                agentState = "Agent is in Logged In state";
                break;
            case LucentV6Agent.LOG_OUT:
                agentState = "Agent is in Logged Out state";
                break;
            case LucentV6Agent.BUSY:
                agentState = "Agent is in Busy state";
                break;
            case LucentV6Agent.NOT_READY:
                agentState = "Agent is in Not Ready state";
                break;
            case LucentV6Agent.WORK_NOT_READY:
                agentState = "Agent is in Work Not Ready state";
                break;
            case LucentV6Agent.WORK_READY:
                agentState = "Agent is in Work Ready state";
                break;
            case LucentV6Agent.UNKNOWN:
                agentState = "Agent is in Unknown state";
                break;
            default:
                agentState = "Cannot determine the Agent's state";
                break;
        }

        LOG.info("AgentState is : " + agentState);
    }


}
