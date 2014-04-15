package dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	

	private static final long	serialVersionUID	= 5934601211073953131L;
	
	private static final int maxLengthUserFirstName = 256;
	private static final int maxLengthUserLastName = 256;
	
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String salt;
	private String tempPassword;
	private String tempSalt;
	private String activationCode;
	private String publicKey;
	private byte[] publicKeyBytes;
	private int type;
	private int status;
	private String statusDescription;
	private String sessionId;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getTempPassword() {
		return tempPassword;
	}
	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
	public String getTempSalt() {
		return tempSalt;
	}
	public void setTempSalt(String tempSalt) {
		this.tempSalt = tempSalt;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public byte[] getPublicKeyBytes() {
		return publicKeyBytes;
	}
	public void setPublicKeyBytes(byte[] publicKeyBytes) {
		this.publicKeyBytes = publicKeyBytes;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Validator Validate()
	{
		boolean valid = true;
		String status = "";
		Validator v = new Validator();

		InputValidation iv=new InputValidation();
		
		v = iv.validateString(this.getFirstName(), "First Name", maxLengthUserFirstName);
		valid = v.isVerified();
		status += v.getStatus();
		
		v = iv.validateString(this.getLastName(), "Last Name", maxLengthUserLastName);
		valid &= v.isVerified();
		status += v.getStatus();
		
		v = iv.validateEmail(this.getEmail(), "Email");
		valid &= v.isVerified();
		status += v.getStatus();
		
		v.setVerified(valid);
		v.setStatus(status);
		return v;
	}
	
	public String toString() {
		String out = "";
		String delimiter = "\n";
		String endOfString = "<<< end >>> \n";

		out += "User ";
		out += "id: " + this.getUserId() + delimiter;
		out += "first name: " + this.getFirstName() + delimiter;
		out += "last name: " + this.getLastName() + delimiter;
		out += "email: " + this.getEmail() + delimiter;
		out += "password: " + this.getPassword() + delimiter;
		out += "salt: " + this.getSalt() + delimiter;
		out += "temp_pass: " + this.getTempPassword() + delimiter;
		out += "temp_salt: " + this.getTempSalt() + delimiter;
		out += "activation_code: " + this.getActivationCode() + delimiter;
		out += "public key: " + this.getPublicKey() + delimiter;
		//out += "public key bytes: " + (new String(this.getPublicKeyBytes())) + delimiter;
		if (this.getPublicKeyBytes() != null) {
			out += "public key bytes\t:" + (new String(this.getPublicKeyBytes())) + delimiter;
		} else {
			out += "public key bytes\t:empty" + delimiter;
		}
		out += "admin_flag: " + this.getType() + delimiter;
		out += "status: " + this.getStatus() + delimiter;
		out += "session id: " + this.getSessionId() + delimiter;
		
		out += endOfString;

		return out;
	}
}