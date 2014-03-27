package dto;

import java.io.Serializable;

/**
 * @date : Mar 25, 2014
 * @author : Hirosh Wickramasuriya
 */
public class ElectionProgressDto implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -6839751784456263064L;
	
	private int electionId;
	private int validVotes;
	private int rejectedVotes;
	private int totalVotes;
	
	public int getElectionId() {
		return electionId;
	}
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	public int getValidVotes() {
		return validVotes;
	}
	public void setValidVotes(int validVotes) {
		this.validVotes = validVotes;
	}
	public int getRejectedVotes() {
		return rejectedVotes;
	}
	public void setRejectedVotes(int rejectedVotes) {
		this.rejectedVotes = rejectedVotes;
	}
	
	public int getTotalVotes() {
		return totalVotes;
	}
	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}
	public void addValidVotes(int count){
		this.validVotes += count;
	}
	
	public void addRejectedVotes(int count){
		this.rejectedVotes += count;
	}
	public String toString() {
		String out = "";
		String delimiter = "\n";
		String endOfString = "<<< end >>> \n";

		out += "ElectionProgress " + delimiter;
		out += "id\t\t: " + this.getElectionId() + delimiter;
		out += "valid votes\t: " + this.getValidVotes() + delimiter;
		out += "rejected votes\t: " + this.getRejectedVotes() + delimiter;
		out += "total votes\t: " + this.getTotalVotes() + delimiter;
		
		out += endOfString;

		return out;
	}

}
