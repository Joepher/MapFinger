
package com.mapfinger.server.impl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "parseData", namespace = "http://impl.server.mapfinger.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parseData", namespace = "http://impl.server.mapfinger.com/")
public class ParseData {

    @XmlElement(name = "arg0", namespace = "")
    private com.mapfinger.server.bean.LocationData arg0;

    /**
     * 
     * @return
     *     returns LocationData
     */
    public com.mapfinger.server.bean.LocationData getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.mapfinger.server.bean.LocationData arg0) {
        this.arg0 = arg0;
    }

}
