package Socialnetworksystem;

public class SocialTie {

	public User firstuser;
	public User seconduser;
	public double intimacy;
	
	public SocialTie(User firstuser, User seconduser, double intimacy) {
		
		this.firstuser = firstuser;
		this.seconduser = seconduser;
		this.intimacy = intimacy;
		
	}
	
	public User getFirstuser() {
		return firstuser;
	}
	
	public User getSeconduser() {
		return seconduser;
	}
	
	public double getIntimacy() {
		return intimacy;
	}
	
}
