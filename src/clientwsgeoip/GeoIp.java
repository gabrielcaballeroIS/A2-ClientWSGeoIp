
package clientwsgeoip;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class GeoIp {
    
    @Element
    private String ReturnCode;
    @Element
    private String IP;
    @Element
    private String ReturnCodeDetails;
    @Element
    private String CountryName;
    @Element
    private String CountryCode;

    public String getReturnCode() {
        return ReturnCode;
    }

    public String getIp() {
        return IP;
    }

    public String getReturnCodeDetails() {
        return ReturnCodeDetails;
    }

    public String getCountryName() {
        return CountryName;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setReturnCode(String ReturnCode) {
        this.ReturnCode = ReturnCode;
    }

    public void setIp(String IP) {
        this.IP = IP;
    }

    public void setReturnCodeDetails(String ReturnCodeDetails) {
        this.ReturnCodeDetails = ReturnCodeDetails;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }
    
    
}
