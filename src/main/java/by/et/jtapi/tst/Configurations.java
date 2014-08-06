package by.et.jtapi.tst;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/19/14
 * Time: 8:41 AM
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement
public class Configurations
{

    private List<ConfItem> items;

    @XmlElement(name = "ConfItem")
    public List<ConfItem> getItems()
    {
        return items;
    }

    public void setItems(List<ConfItem> items)
    {
        this.items = items;
    }

    @Override
    public String toString()
    {
        return "Configurations{" +
                "items=" + items +
                '}';
    }

}