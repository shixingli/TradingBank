package Model;

public class Trader {

    private String firstName;
    private String lastName;
    private String id;
    private String password;

	public Trader(String firstName, String lastName, String id, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getID() {
		return id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPassword() {
		return password;
	}
}
