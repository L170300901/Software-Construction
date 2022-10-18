package Socialnetworksystem;

public interface CircularOrbit<L,E> {

	void setCentralUser(User centraluser);
	
	void removeCentralUser();
	
	void setFriend(SocialTie tie);
	
	void removeFriend(User user);
	
	void setSocialTie(SocialTie tie);
	
	void removeSocialTie(SocialTie tie);
	
	
}
