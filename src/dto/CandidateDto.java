package dto;

import java.io.Serializable;
import enumeration.Status;


/**
 * @date : Mar 16, 2014
 * @author : Hirosh Wickramasuriya
 */

public class CandidateDto implements Serializable{

	private static final long serialVersionUID = 8249581055443866282L;
	
	
	private int candidateId;
	private String candidateName;
	private int electionId;
	private int status;
	private int displayOrder;
	
	
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
		
		out += endOfString;

		return out;
	 }
}
