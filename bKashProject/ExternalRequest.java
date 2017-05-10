/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkash.bso.dni.solarsystemmiddleware.tethysexternalreportinterfacewebservice.service.entity;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ExternalRequest implements  Serializable{

    private String user;
    
    List<QueryParameterWS> params;

    public List<QueryParameterWS> getParams() {
        return params;
    }

    public void setParams(List<QueryParameterWS> params) {
        this.params = params;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
