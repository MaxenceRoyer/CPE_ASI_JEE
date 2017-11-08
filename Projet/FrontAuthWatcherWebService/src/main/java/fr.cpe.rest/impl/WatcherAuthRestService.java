package fr.cpe.rest;
import javax.inject.Inject;

public class WatcherAuthRestService implements IWatcherAuthRestService{
	@Inject
	UserModel usermodel;
	
	@Override
	public void doPost(String login, String password){
		usermodel.authenticate(login, password);
	}

}
