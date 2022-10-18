package Socialnetworksystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ConcreteCircularOrbit<L,E> implements CircularOrbit<L,E> {

	User center;
	Set<User> friends = new HashSet<>();
	List<SocialTie> relations = new ArrayList<>();
	Set<User> local = new HashSet<>();
	
	@Override
	public void setCentralUser(User centraluser) {
		// TODO Auto-generated method stub
		if(center == null) center = centraluser;	
	}



	@Override
	public void removeCentralUser() {
		// TODO Auto-generated method stub
		if(center != null) center = null;
	}

	@Override
	public void setFriend(SocialTie tie) {
		// TODO Auto-generated method stub
		if(tie.firstuser == center) friends.add(tie.seconduser);
		else if(tie.seconduser == center) friends.add(tie.firstuser);
		else {
			friends.add(tie.firstuser);
			friends.add(tie.seconduser);
		}
		
	}

	@Override
	public void removeFriend(User user) {
		// TODO Auto-generated method stub
	    if(friends.iterator().next() == user) {
			friends.remove(user);
			
			for(int i=0; i<relations.size(); i++) {
				if(relations.get(i).firstuser == user || relations.get(i).seconduser == user) {
					relations.remove(i);
				}
			}
		}
		
	}

	@Override
	public void setSocialTie(SocialTie tie) {
		// TODO Auto-generated method stub
		if(!relations.contains(tie)) {
			relations.add(tie);
			if(tie.seconduser == center || tie.firstuser == center) {
				setFriend(tie);
			}
			
		}
	}

	@Override
	public void removeSocialTie(SocialTie tie) {
		// TODO Auto-generated method stub
		if(relations.contains(tie)) {
			relations.remove(tie);
		}
	}

	

	

}
