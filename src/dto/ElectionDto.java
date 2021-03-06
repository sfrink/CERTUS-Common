package dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

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
	private boolean candidateListError = false;
	private String candidateListErrorMessage = "";
	private int electionType;

	private String emailList = "";
	private String registeredEmailList = "";
	private String unregisteredEmailList = "";
	private String currentEmailList = "";
	private boolean emailListError = false;
	private String emailListMessage = "";
	private String emailListInvited = "";
	
	private String password;
	private boolean passwordError = false;
	private String passwordErrorMessage = "";
	
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
	public boolean isCandidateListError() {
		return candidateListError;
	}
	public void setCandidateListError(boolean candidateListError) {
		this.candidateListError = candidateListError;
	}
	public String getCandidateListErrorMessage() {
		return candidateListErrorMessage;
	}
	public void setCandidateListErrorMessage(String candidateListMessage) {
		this.candidateListErrorMessage = candidateListMessage;
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
	public String getUnregisteredEmailList() {
		return unregisteredEmailList;
	}
	public void setUnregisteredEmailList(String emailList) {
		this.unregisteredEmailList = emailList;
	}
	public String getCurrentEmailList() {
		return currentEmailList;
	}
	public void setCurrentEmailList(String emailList) {
		this.currentEmailList = emailList;
	}
	public boolean isEmailListError() {
		return emailListError;
	}
	public void setEmailListError(boolean emailListError) {
		this.emailListError = emailListError;
	}
	public String getEmailListMessage() {
		return emailListMessage;
	}
	public void setEmailListMessage(String emailListMessage) {
		this.emailListMessage = emailListMessage;
	}
	public String getEmailListInvited() {
		return emailListInvited;
	}
	public void setEmailListInvited(String emailListInvited) {
		this.emailListInvited = emailListInvited;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordErrorMessage() {
		return passwordErrorMessage;
	}
	public void setPasswordErrorMessage(String passwordErrorMessage) {
		this.passwordErrorMessage = passwordErrorMessage;
	}
	public boolean isPasswordError() {
		return passwordError;
	}
	public void setPasswordError(boolean passwordError) {
		this.passwordError = passwordError;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Validator Validate()
	{
		boolean valid = true;
		String status = "";
		Validator v = new Validator();

		InputValidation iv=new InputValidation();
		
		v = iv.validateString(this.getElectionName(), "Election Name", maxLengthElectionName);
		valid = v.isVerified();
		status += v.getStatus();
		
		v = iv.validateString(this.getElectionDescription(), "Election Description", maxLengthElectionDescription);
		valid &= v.isVerified();
		status += v.getStatus();
		
		v = iv.validateString(this.getCandidatesListString(), "Candidates List (string)", maxLengthCandidatesListString);
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
		
		if (this.getElectionType() == ElectionType.PRIVATE.getCode()) {
			v = iv.validateStringAllowNull(this.getRegisteredEmailList(), "Allowed users email list", maxLengthAllowedVotersEmail);
			valid &= v.isVerified();
			status += v.getStatus();
			
			if ((this.getEmailList() != null) && (!this.getEmailList().trim().isEmpty() ) ){
				String[] voterEmails = this.getEmailList().split(newLine);
				for (String voterEmail : voterEmails) {
					if (!voterEmail.trim().isEmpty()) {
						Validator vEmail = iv.validateEmail(voterEmail.trim(), "Email address [" + voterEmail.trim() + "] ");
						valid &= vEmail.isVerified();
						status += vEmail.getStatus();
						if (!vEmail.isVerified()) {
							this.setEmailListError(true);
							this.setEmailListMessage(this.getEmailListMessage() + newLine +  vEmail.getStatus());
						}
					}
				}
			}
			
			if ((this.getRegisteredEmailList() != null) && (!this.getRegisteredEmailList().trim().isEmpty() ) ){
				String[] voterEmails = this.getRegisteredEmailList().split(newLine);
				for (String voterEmail : voterEmails) {
					if (!voterEmail.trim().isEmpty()) {
						Validator vEmail = iv.validateEmail(voterEmail.trim(), "Email address [" + voterEmail.trim() + "] ");
						valid &= vEmail.isVerified();
						status += vEmail.getStatus();
					}
				}
			}
			
			if ((this.getEmailListInvited() != null) && (!this.getEmailListInvited().trim().isEmpty() ) ){
				String[] inviteEmails = this.getEmailListInvited().split(newLine);
				for (String inviteEmail : inviteEmails) {
					if (!inviteEmail.trim().isEmpty()) {
						Validator vEmail = iv.validateEmail(inviteEmail.trim(), "Email address [" + inviteEmail.trim() + "] ");
						valid &= vEmail.isVerified();
						status += vEmail.getStatus();
					}
				}
			}
		}
		
		
		// checks whether there are redundant candidates
		if ((this.getCandidatesListString() != null) && (!this.getCandidatesListString().trim().isEmpty() ) ){
			HashMap<String, String> map = new HashMap<String, String>();
			String[] candidates = this.getCandidatesListString().trim().split(newLine);
			for (String candidate : candidates) {
				candidate = candidate.trim();
				if (candidate.isEmpty()){
					continue;
				} else {
					if (map.containsKey(candidate)) {
		                this.setCandidateListError(true);
		                this.setCandidateListErrorMessage("Duplicate candidates names detected");
						valid &= false;
						status += "Duplicate candidates names detected";
		                break;
		            }
		            else
		            {
		                map.put(candidate, candidate);
		            }
				}
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
		out += "Email Error : " + this.isEmailListError() + delimiter;
		out += "Email Error Message: " + this.getEmailListMessage() + delimiter;
		out += "Registered Voters Emails String : " + this.getRegisteredEmailList() + delimiter;
		out += "Unregistered Voters Emails String : " + this.getUnregisteredEmailList() + delimiter;
		out += "Invited Voters Emails String : " + this.getEmailListInvited() + delimiter;
		out += "Current Voters Emails String : " + this.getCurrentEmailList() + delimiter;
		out += "Password Error  : " + this.isPasswordError() + delimiter;
		out += "Password Error Message : " + this.getPasswordErrorMessage() + delimiter;
		
		out += endOfString;

		return out;
	}
	
	
}
