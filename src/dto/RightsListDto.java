package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class RightsListDto implements Serializable {

	private static final long serialVersionUID = 3743839109094210159L;

	private ArrayList<ActionDto> rightsList;

	public ArrayList<ActionDto> getRightsList() {
		return rightsList;
	}

	public void setRightsList(ArrayList<ActionDto> rightsList) {
		this.rightsList = rightsList;
	}

	public int getRightsCount() {
		return this.getRightsList().size();
	}
	
	public Validator validate(){
		boolean valid = false;
		String status = "";
		Validator v = new Validator();
		
		if (this.getRightsList() != null){
			for (ActionDto action : this.getRightsList()){
				Validator vAction = action.validate();
				valid &= vAction.isVerified();
				status += "\n" + vAction.getStatus();
			}
		}
		
		v.setVerified(valid);
		v.setStatus(status);
		
		return v;
	}
	
	public String toString(){
		String out = "";
		String delimiter = "\n";
		String endOfString = "<<< end >>> \n";
		
		out += "Total right(s): \t" + this.getRightsCount() + delimiter;
		
		out += "Action(s):" + delimiter;
		if (this.getRightsList() != null){
			out += this.getRightsList().toString() + delimiter;
		}else{
			out += "empty" + delimiter;
		}
		
		out += endOfString;
		
		return out;
	}
	
}
