package ejbModule;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.TextMessage;
import javax.jms.Topic;
import ejbModule.ejb.MessageSenderLocal;
import fr.cpe.model.UserModel;

@Stateless
public class MessageSender implements MessageSenderLocal {
	@Inject
	JMSContext context;
	
	@Resource(mappedName = "java:/jms/watcherAuthJMS")
	Topic topic;

	@Override
	public void sendMessage(String message) { 
		TextMessage textM = context.createTextMessage(message);
		JMSProducer producer = context.createProducer();
		producer.send(topic, textM);
		System.out.println("Message envoyé au topic");
	}

	@Override
	public void sendMessage(UserModel user) { 
		// TODO
		JMSProducer producer = context.createProducer();
		producer.send(topic, user);
		System.out.println("Message envoyé au topic");
	}
}