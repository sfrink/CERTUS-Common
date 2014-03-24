package dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	
	private int user_id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String salt;
	private String temp_password;
	private String temp_salt;
	private String activation_code;
	private String public_key;
	private int administrator_flag;
	private int status;
	
	public int getUserId() {
		return user_id;
	}
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String last_name) {
		this.last_name = last_name;
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
		return temp_password;
	}
	public void setTempPassword(String temp_password) {
		this.temp_password = temp_password;
	}
	public String getTempSalt() {
		return temp_salt;
	}
	public void setTempSalt(String temp_salt) {
		this.temp_salt = temp_salt;
	}
	public String getActivationCode() {
		return activation_code;
	}
	public void setActivationCode(String activation_code) {
		this.activation_code = activation_code;
	}
	public String getPublicKey() {
		return public_key;
	}
	public void setPublicKey(String public_key) {
		this.public_key = public_key;
	}
	public int getAdministratorFlag() {
		return administrator_flag;
	}
	public void setAdministratorFlag(int administrator_flag) {
		this.administrator_flag = administrator_flag;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
		out += "admin_flag: " + this.getAdministratorFlag() + delimiter;
		out += "status: " + this.getStatus() + delimiter;

		out += endOfString;

		return out;
	}
}