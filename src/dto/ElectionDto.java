package dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import enumeration.ElectionStatus;
import enumeration.ElectionType;

/**
 * @date : Mar 16, 2014
 * @author : Hirosh Wickramasuriya
 */


public class ElectionDto implements Serializable{

	private static final int maxLengthElectionName = 128;
	private static final int maxLengthElectionDescription = 1024;
	private static final int maxLengthCandidatesListString = 2048;
	private static final int maxLengthStartAndCloseDateTime = 128;
	private static final int maxLengthAllowedVotersEmail = 4096;
	
	private static String 	newLine = System.getProperty("line.separator");
	
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
	private int electionType;
	private String emailList;
	private String registeredEmailList;
	private String unregisteredEmailList;
	private boolean emailListError = false;
	private String emailListMessage = "";
	
	
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
	public int getElectionType() {
		return electionType;
	}
	public void setElectionType(int electionType) {
		this.electionType = electionType;
	}
	public String getEmailList() {
		return emailList;
	}
	public void setEmailList(String emailList) {
		this.emailList = emailList;
	}
	public String getRegisteredEmailList() {
		return registeredEmailList;
	}
	public void setRegisteredEmailList(String registeredVotersEmailList) {
		this.registeredEmailList = registeredVotersEmailList;
	}
	public void setVotersEmailList(String emailList) {
		this.registeredEmailList = emailList;
	}
	public String getUnregisteredEmailList() {
		return unregisteredEmailList;
	}
	public void setUnregisteredEmailList(String emailList) {
		this.unregisteredEmailList = emailList;
	}
	public boolean isVotersEmailListError() {
		return emailListError;
	}
	public void setVotersEmailListError(boolean emailListError) {
		this.emailListError = emailListError;
	}
	public String getVotersEmailListMessage() {
		return emailListMessage;
	}
	public void setVotersEmailListMessage(String emailListMessage) {
		this.emailListMessage = emailListMessage;
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
		
		int[] allowedTypes = {ElectionType.PUBLIC.getCode(), ElectionType.PRIVATE.getCode()};
		v = iv.validateInt(this.getElectionType(), "Election Type", allowedTypes);
		valid &= v.isVerified();
		status += v.getStatus();
		
		v = iv.validateStringAllowNull(this.getRegisteredEmailList(), "Allowed users email list", maxLengthAllowedVotersEmail);
		valid &= v.isVerified();
		status += v.getStatus();
		
		if (this.getEmailList() != null) {
			String[] voterEmails = this.getEmailList().split(newLine);
			for (String voterEmail : voterEmails) {
				Validator vEmail = iv.validateEmail(voterEmail, "Email address [" + voterEmail + "] ");
				valid &= vEmail.isVerified();
				status += vEmail.getStatus();
			}
		}
		
		
		if (this.getCandidateList() != null) {
			for (CandidateDto candidate : this.getCandidateList() ) {
				Validator vCandidate = candidate.Validate();
				valid &= vCandidate.isVerified();
				status += vCandidate.getStatus();
			}
		}
		
		v.setVerified(v.isVerified() && valid);
		v.setStatus(v.getStatus() + status);

		return v;
	}
	
	public String toString() {
		String out = "";
		String delimiter = newLine;
		String endOfString = "<<< end >>>"+ newLine;

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
		out += "Election Type : " + this.getElectionType() + delimiter;
		out += "Emails String : " + this.getEmailList() + delimiter;
		out += "Registered Voters Emails String : " + this.getRegisteredEmailList() + delimiter;
		out += "Unregistered Voters Emails String : " + this.getUnregisteredEmailList() + delimiter;
		out += endOfString;

		return out;
	}
	
}
