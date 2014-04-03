package dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import enumeration.ElectionStatus;

/**
 * @date : Mar 16, 2014
 * @author : Hirosh Wickramasuriya
 */


public class ElectionDto implements Serializable{

	private static final int maxLengthElectionName = 128;
	private static final int maxLengthElectionDescription = 1024;
	private static final int maxLengthCandidatesListString = 2048;
	private static final int maxLengthStartAndCloseDateTime = 128;
	
	private static final long serialVersionUID = -5229576755268759820L;
	
	private int electionId;
	private String electionName;
	private String electionDescription;
	private int ownerId;
	private int status;
	private String statusCode;
	private String statusDescription;
	private String startDatetime;
	private String closeDatetime;
	private ArrayList<CandidateDto> candidateList;
	private String candidatesListString;
	
	
	public int getElectionId() {
		return electionId;
	}
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	public String getElectionName() {
		return electionName;
	}
	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}
	public String getElectionDescription() {
		return electionDescription;
	}
	public void setElectionDescription(String electionDescription) {
		this.electionDescription = electionDescription;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStartDatetime() {
		return startDatetime;
	}
	public void setStartDatetime(String startDatetime) {
		this.startDatetime = startDatetime;
	}
	public String getCloseDatetime() {
		return closeDatetime;
	}
	public void setCloseDatetime(String closeDatetime) {
		this.closeDatetime = closeDatetime;
	}
	public ArrayList<CandidateDto> getCandidateList() {
		return candidateList;
	}
	public void setCandidateList(ArrayList<CandidateDto> candidateList) {
		this.candidateList = candidateList;
	}
	public String getCandidatesListString() {
		return candidatesListString;
	}
	public void setCandidatesListString(String candidateListString) {
		this.candidatesListString = candidateListString;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Validator Validate()
	{
		boolean valid;
		String status = "";
		Validator v = new Validator();

		InputValidation iv=new InputValidation();
		
		v = iv.validateString(this.getElectionName(), "Election Name", maxLengthElectionName);
		valid = v.isVerified();
		status += v.getStatus();
		
		v = iv.validateString(this.getElectionDescription(), "Election Description", maxLengthElectionDescription);
		valid &= v.isVerified();
		status += v.getStatus();
		
		v = iv.validateString(this.getElectionDescription(), "Candidates List (string)", maxLengthCandidatesListString);
		valid &= v.isVerified();
		status += v.getStatus();
		
		v = iv.validateStringAllowNull(this.getStartDatetime(), "Election Start time", maxLengthStartAndCloseDateTime);
		valid &= v.isVerified();
		status += v.getStatus();
		
		v = iv.validateStringAllowNull(this.getCloseDatetime(), "Election Close time", maxLengthStartAndCloseDateTime);
		valid &= v.isVerified();
		status += v.getStatus();
		
		if (this.getCandidateList() != null) {
			for (CandidateDto candidate : this.getCandidateList() ) {
				Validator vCandidate = candidate.Validate();
				valid &= vCandidate.isVerified();
				status += "\n" + vCandidate.getStatus();
			}
		}
		v.setVerified(v.isVerified() && valid);
		v.setStatus(v.getStatus() + status);
		return v;
	}
	
	public String toString() {
		String out = "";
		String delimiter = "\n";
		String endOfString = "<<< end >>> \n";

		out += "Election " + delimiter;
		out += "id\t\t: " + this.getElectionId() + delimiter;
		out += "election name\t: " + this.getElectionName() + delimiter;
		out += "election desc\t" + this.getElectionDescription() + delimiter;
		out += "election owner\t: " + this.getOwnerId() + delimiter;
		out += "status\t\t: " + this.getStatus() + delimiter;
		out += "statusCode\t: " + this.getStatusCode() + delimiter;
		out += "statusDesc\t: " + this.getStatusDescription() + delimiter;
		out += "start date_time	: " + this.getStartDatetime() + delimiter;
		out += "close date_time	: " + this.getCloseDatetime() + delimiter;
		out += "candidates String: " + this.getCandidatesListString() + delimiter;
		if (this.getCandidateList() != null) {
			out += "candidates\t:" + this.getCandidateList().toString() + delimiter;
		} else {
			out += "candidates\t:empty" + delimiter;
		}
		
		out += endOfString;

		return out;
	}
	
}
