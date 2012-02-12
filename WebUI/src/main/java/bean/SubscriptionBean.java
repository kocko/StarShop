package bean;


import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import object.subscribtion.Subscription;

import manager.subscription.SubscriptionManager;

@ViewScoped
@ManagedBean
public class SubscriptionBean implements Serializable{
	
	private static final long serialVersionUID = -6239437588285327644L;
	
	@Inject
	private SubscriptionManager subscriptionManager;
	
	public void subscribe(){
		String email = (String)emailInput.getValue();
		subscriptionManager.subscribe(new Subscription(email));
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("page/subscription/subscribed.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	UIInput emailInput;

	public UIInput getEmailInput() {
		return emailInput;
	}

	public void setEmailInput(UIInput emailInput) {
		this.emailInput = emailInput;
	}
}
