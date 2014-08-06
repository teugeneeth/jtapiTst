package by.et.jtapi.tst;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/19/14
 * Time: 9:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConfigurationService
{

    public static final Logger LOG = Logger.getLogger(ConfigurationService.class);
    private static ConfigurationService ourInstance = new ConfigurationService();

    public static ConfigurationService getInstance()
    {
        return ourInstance;
    }

    private ConfigurationService()
    {
    }


    public Configurations getConfiguration() throws RuntimeException
    {

        try
        {
            JAXBContext jc = JAXBContext.newInstance(Configurations.class);

            Unmarshaller un = jc.createUnmarshaller();
            final Configurations configurations = (Configurations) un.unmarshal(this.getClass().getResourceAsStream("vo.xml"));
            if (configurations == null)
            {
                throw new RuntimeException(" Configurations must not be is undefined");
            }

            if (configurations.getItems() == null || configurations.getItems().isEmpty())
            {
                throw new RuntimeException(" Configurations must not be empty");
            }

            LOG.info("Phone configuration is: " + configurations);
            return configurations;
        }
        catch (JAXBException e)
        {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }


    }
}
