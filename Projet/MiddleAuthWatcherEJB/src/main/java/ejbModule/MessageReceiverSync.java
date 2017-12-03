package ejbModule;

import ejbModule.ejb.MessageReceiverSyncLocal;
import fr.cpe.model.UserModel;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;


@Stateless
@LocalBean
public class MessageReceiverSync implements MessageReceiverSyncLocal {
	// TODO get jms context
	
	@Inject
	JMSContext context;
	
	// TODO associate queue from "java:/jms/queue/watcherqueue"
	@Resource(mappedName = "java:/jms/queue/watcherqueue")
							
	Queue queue;
	
	@Override
	public UserModel receiveMessage() {
		// TODO create a consumer
		JMSConsumer consumer = context.createConsumer(queue);

		UserModel m = consumer.receiveBody(UserModel.class, 1000);
		System.out.println("On a reçu  un message !! :D");	
		//System.out.println(m);	
		return m ;
	}
}