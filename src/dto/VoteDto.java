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

	private int user_id;		// required to get the corresponding  public key of the user
	private int election_id;
	private String vote_encrypted;
	private String vote_signature;
	private Timestamp timestamp;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getElection_id() {
		return election_id;
	}
	public void setElection_id(int election_id) {
		this.election_id = election_id;
	}
	public String getVote_encrypted() {
		return vote_encrypted;
	}
	public void setVote_encrypted(String vote_encrypted) {
		this.vote_encrypted = vote_encrypted;
	}
	public String getVote_signature() {
		return vote_signature;
	}
	public void setVote_signature(String vote_signature) {
		this.vote_signature = vote_signature;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	public String toString() {
		String out = "";
		String delimiter = "\n";
		String endOfString = "<<< end >>> \n";

		out += "Vote " + delimiter;

		out += "election id\t\t: " + this.getElection_id() + delimiter;
		out += "encrypted vote\t: " + this.getVote_encrypted() + delimiter;
		out += "signature of vote\t: " + this.getVote_signature() + delimiter;

		
		out += endOfString;

		return out;
	}
	
}
