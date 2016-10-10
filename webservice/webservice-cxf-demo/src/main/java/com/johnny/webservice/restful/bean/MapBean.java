package com.johnny.webservice.restful.bean;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class MapBean {
    private Map<String, User> map;
    
    //@XmlElement(type = User.class)
    public Map<String, User> getMap() {
        return map;
    }
    public void setMap(Map<String, User> map) {
        this.map = map;
    }
}