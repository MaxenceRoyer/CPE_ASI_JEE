package ejbModule.ejb;

import javax.ejb.Local;

import fr.cpe.model.UserModel;

@Local
public interface MessageSenderQueueLocal {

	/**
	 * SendMessage
	 * @param user
	 */
	void sendMessage(UserModel user);

}
