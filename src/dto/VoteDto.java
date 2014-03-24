package dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @date : Mar 21, 2014
 * @author : Hirosh Wickramasuriya
 */

public class VoteDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6647026320380230760L;

	private int userId;		// required to get the corresponding  public key of the user
	private int electionId;
	private String voteEncrypted;
	private String voteSignature;
	private Timestamp timestamp;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getElectionId() {
		return electionId;
	}
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	public String getVoteEncrypted() {
		return voteEncrypted;
	}
	public void setVoteEncrypted(String voteEncrypted) {
		this.voteEncrypted = voteEncrypted;
	}
	public String getVoteSignature() {
		return voteSignature;
	}
	public void setVoteSignature(String voteSignature) {
		this.voteSignature = voteSignature;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	public Validator Validate(){
		boolean valid = true;
		String status = "";
		Validator v = new Validator();
		InputValidation iv = new InputValidation();
		
		v = iv.validateInt(this.getUserId(), "User ID");
		valid &= v.isVerified();
		status += v.getStatus();
		
		v = iv.validateInt(this.getElectionId(), "Election ID");
		valid &= v.isVerified();
		status += v.getStatus();
		
		v = iv.validateString(this.getVoteEncrypted(), "Encrypted Vote");
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

		out += "Vote " + delimiter;

		out += "election id\t\t: " + this.getElectionId() + delimiter;
		out += "encrypted vote\t: " + this.getVoteEncrypted() + delimiter;
		out += "signature of vote\t: " + this.getVoteSignature() + delimiter;

		
		out += endOfString;

		return out;
	}
	
}
