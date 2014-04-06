package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.CandidateDto;
import dto.ElectionDto;
import dto.UserDto;
import dto.Validator;
import dto.VoteDto;
import enumeration.Status;
import enumeration.ElectionStatus;
import enumeration.UserStatus;

public interface ServerInterface extends Remote {
    public String sayHello(String name) throws RemoteException;   
    
    public Validator checkIfUsernamePasswordMatch(String email, String plainPass)
    		throws RemoteException;
    
    public Validator addUser(UserDto userDto) throws RemoteException ;
    public Validator selectUser(int userId, String sessionID) throws RemoteException;
    public Validator selectAllUsers(String sessionID) throws RemoteException ;
    public Validator editUser(UserDto userDto, String sessionID) throws RemoteException ;
    public Validator editUserStatus(int userId, UserStatus userStatus, String sessionID) throws RemoteException;
    public boolean isAllowed(String sessionID, String method) throws RemoteException;
    
    // Election
    public Validator selectElection(int id, String sessionID) throws RemoteException;
    public Validator selectElections(ElectionStatus electionStatus, String sessionID) throws RemoteException;
    public Validator selectElectionsNotInStatus(ElectionStatus electionStatus, String sessionID) throws RemoteException;
    public Validator selectElections(String sessionID) throws RemoteException;
    public Validator selectElectionsOwnedByUser(int electionOwnerId, ElectionStatus electionStatus, String sessionID) throws RemoteException;
    public Validator selectElectionsOwnedByUser(int electionOwnerId, String sessionID) throws RemoteException;
    public Validator addElection(ElectionDto electionDto, String sessionID)throws RemoteException;
    public Validator editElection(ElectionDto electionDto, String sessionID)throws RemoteException;
    public Validator editElectionStatus(int electionId, ElectionStatus electionStatus, String sessionID) throws RemoteException;
    public Validator openElectionAndPopulateCandidates(int electionId, String sessionID) throws RemoteException;
    public Validator selectAllElectionsForVoter(int user_id, String sessionID) throws RemoteException;
    public Validator publishResults(int electionId, String sessionID) throws RemoteException;
    
    // Candidate
    public Validator selectCandidate(int id, String sessionID) throws RemoteException;
    public Validator selectCandidatesOfElection(int electionId, String sessionID) throws RemoteException;
    public Validator selectCandidatesOfElection(int electionId, Status candidateStatus, String sessionID) throws RemoteException;
    public Validator editCandidateStatus(int candidateId, Status status, String sessionID) throws RemoteException;
    
    
    //Vote
    public Validator vote(VoteDto v, String sessionID) throws RemoteException;
    public Validator getTallierPublicKey() throws RemoteException;
    public Validator voteProgressStatusForElection(int electionId, String sessionID) throws RemoteException;
    public Validator selectResults(int electionId, String sessionID) throws RemoteException;
}
