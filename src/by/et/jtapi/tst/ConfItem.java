package by.et.jtapi.tst;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConfItem
{
    private String agentID;
    private String password;
    private String phoneExt;

    public String getAgentID()
    {
        return agentID;
    }

    public void setAgentID(String agentID)
    {
        this.agentID = agentID;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPhoneExt()
    {
        return phoneExt;
    }

    public void setPhoneExt(String phoneExt)
    {
        this.phoneExt = phoneExt;
    }

    @Override
    public String toString()
    {
        return "ConfItem{" +
                "agentID='" + agentID + '\'' +
                ", password='" + password + '\'' +
                ", phoneExt='" + phoneExt + '\'' +
                '}';
    }
}