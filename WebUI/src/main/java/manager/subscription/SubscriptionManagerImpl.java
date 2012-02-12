package manager.subscription;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

import object.subscribtion.Subscription;
import service.subscription.SubscribtionService;

@Named("subscriptionManager")
@RequestScoped
@Alternative
public class SubscriptionManagerImpl implements SubscriptionManager{
	public void subscribe(Subscription s){
		SubscribtionService.subscribe(s.getEmail());
	}
}
