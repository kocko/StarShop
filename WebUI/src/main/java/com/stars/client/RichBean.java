package com.stars.client;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

@ViewScoped
@ManagedBean
public class RichBean implements Serializable {

    private static final long serialVersionUID = -6239437588285327644L;

    private String name;

    @PostConstruct
    public void postContruct() {
        name = "John";
    }

    public String getName() {
    	test();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void test() {
    	/*Client client = Client.create();
    	WebResource r = null;
		String res = null;
		try {
			r = client.resource("http://78.90.148.47:7245/rest/hello/mongo");
			name = r.get(String.class);
			System.out.println(name);
		} catch (UniformInterfaceException ex) {
			FacesMessage fm = new FacesMessage("Can't connect to service :(...");
		}*/
    }
}