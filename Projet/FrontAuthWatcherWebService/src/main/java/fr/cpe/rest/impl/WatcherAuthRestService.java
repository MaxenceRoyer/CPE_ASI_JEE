package fr.cpe.rest.impl;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ejbModule.ejb.MessageReceiverSyncLocal;
import ejbModule.ejb.MessageSenderLocal;
import fr.cpe.model.Role;
import fr.cpe.model.UserModel;
import fr.cpe.rest.IWatcherAuthRestService;
import fr.cpe.rest.dto.UserAuth;
import fr.cpe.rest.dto.UserAuthResult;

@Stateless
@LocalBean
public class WatcherAuthRestService implements IWatcherAuthRestService{
	

	private static final long serialVersionUID = 1L; // private JmsSender sender;

	@EJB 
	MessageSenderLocal sender;
	
	@EJB 
	MessageReceiverSyncLocal receiver;
	
	@Override
	public UserAuthResult doPost(UserAuth userAuth){
		UserAuthResult userRes = new UserAuthResult();
		userRes.setLogin(userAuth.getLogin());
		userRes.setValidAuth(true);
		userRes.setRole("ADMIN");
		
		
		System.out.println(userRes.getLogin());
		UserModel m = new UserModel(userAuth.getLogin(), userAuth.getPassword(), "Richard", "David", Role.ADMIN);
		sender.sendMessage(m);
		receiver.receiveMessage();
		return userRes;
	}

}
