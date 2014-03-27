package dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	
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
	private int administratorFlag;
	private int status;
	
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
	public int getAdministratorFlag() {
		return administratorFlag;
	}
	public void setAdministratorFlag(int administratorFlag) {
		this.administratorFlag = administratorFlag;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Validator Validate()
	{
		boolean valid = true;
		String status = "";
		Validator v = new Validator();

		InputValidation iv=new InputValidation();
		
		v = iv.validateString(this.getFirstName(), "First Name");
	    
		
		v.setVerified(v.isVerified() && valid);
		v.setStatus(v.getStatus() + status);
		return v;
	}
	
	public String toString() {
		String out = "";
		String delimiter = "\n";
		String endOfString = "\n\n";

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
		out += "public key bytes: " + (new String(this.getPublicKeyBytes())) + delimiter;
		out += "admin_flag: " + this.getAdministratorFlag() + delimiter;
		out += "status: " + this.getStatus() + delimiter;

		out += endOfString;

		return out;
	}
}