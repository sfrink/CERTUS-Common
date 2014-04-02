package dto;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import enumeration.Status;


/**
 * @date : Mar 16, 2014
 * @author : Hirosh Wickramasuriya
 */

public class CandidateDto implements Serializable{

	private static final long serialVersionUID = 8249581055443866282L;
	
	private static final int maxLengthCandidateName = 128;
	
	private int candidateId;
	private String candidateName;
	private int electionId;
	private int status;
	private int displayOrder;
	private int voteCount;
	private boolean winner;
	
	
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public int getElectionId() {
		return electionId;
	}
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	public int getStatus() {
		return status;
	}
	public String getStatusLabel()
	{
		return Status.getStatus(this.status).getLabel();
	}
	public String getStatusDesc()
	{
		return Status.getStatus(this.status).getDescription();
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public void addVoteCount() {
		this.voteCount++;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public boolean isWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	public Validator Validate()
	{
		Validator v = new Validator();
		
		boolean verified;
		String status ;
		String header = "";
		
		InputValidation iv=new InputValidation();
		
		v = iv.validateString(this.getCandidateName(), "Candidate Name", maxLengthCandidateName);
		verified = v.isVerified();
		status = v.getStatus();
		
/*		v = iv.validateInt(this.getDisplayOrder(), "Display Order");
		verified &= v.isVerified();
		status += v.getStatus();
		
		v = iv.validateInt(this.getElectionId(), "Election Id");
		verified &= v.isVerified();
		status += v.getStatus();*/
		
		v.setStatus(header + status);
		v.setVerified(verified);
		return v;
	}
	@Override
    public String toString() {
		String out = "";
		String delimiter = "\n";
		String endOfString = "<<< end >>> \n";

		out += "Candidate " + delimiter;
		out += "id\t\t: " + this.getCandidateId() + delimiter;
		out += "candidate name\t: " + this.getCandidateName() + delimiter;
		out += "status\t\t: " + this.getStatus() + delimiter;
		out += "statusText\t: " + this.getStatusLabel() + delimiter;
		out += "statusDesc\t: " + this.getStatusDesc() + delimiter;
		out += "election_id\t: " + this.getElectionId() + delimiter;
		out += "display_order\t: " + this.getDisplayOrder() + delimiter;
		out += "count of votes\t:" + this.getVoteCount() + delimiter;
		out += "winner\t:" + this.isWinner() + delimiter;
		
		out += endOfString;

		return out;
	 }
}
