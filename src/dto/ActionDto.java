package dto;

import java.io.Serializable;

public class ActionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2737819190774052643L;
	
	private static final int maxLengthMethodName = 128;
	
	private int actionID;
	private String methodName;
	
	
	public int getActionID() {
		return actionID;
	}
	public void setActionID(int actionID) {
		this.actionID = actionID;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	
	public Validator validate(){
		Validator v = new Validator();
		
		InputValidation iv = new InputValidation();
		
		v = iv.validateString(this.getMethodName(), "Method Name", ActionDto.maxLengthMethodName);
	
		return v;
	}
	
	public String toString(){
		String out = "";
		String delimiter = "\n";
		String endOfString = "<<< end >>> \n";
		
		out += "Action id:\t " + this.getActionID() + delimiter;
		out += "method name:\t " + this.getMethodName() + delimiter;
		
		out+= endOfString;
		
		return out;
	}
	
}
