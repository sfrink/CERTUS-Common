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
    public Validator selectUser(int userId) throws RemoteException;
    public Validator selectAllUsers() throws RemoteException ;
    public Validator editUser(UserDto userDto) throws RemoteException ;
    public Validator editUserStatus(int userId, UserStatus userStatus) throws RemoteException;
    
 // Election
    public Validator selectElection(int id) throws RemoteException;
    public Validator selectElections(ElectionStatus electionStatus) throws RemoteException;
    public Validator selectElectionsNotInStatus(ElectionStatus electionStatus) throws RemoteException;
    public Validator selectElections() throws RemoteException;
    public Validator selectElectionsOwnedByUser(int electionOwnerId, ElectionStatus electionStatus) throws RemoteException;
    public Validator selectElectionsOwnedByUser(int electionOwnerId) throws RemoteException;
    public Validator addElection(ElectionDto electionDto)throws RemoteException;
    public Validator editElection(ElectionDto electionDto)throws RemoteException;
    public Validator editElectionStatus(int electionId, ElectionStatus electionStatus) throws RemoteException;
    public Validator openElectionAndPopulateCandidates(int electionId) throws RemoteException;
    public Validator selectAllElectionsForVoter(int user_id) throws RemoteException;
    public Validator publishResults(int electionId) throws RemoteException;
    
    // Candidate
    public Validator selectCandidate(int id) throws RemoteException;
    public Validator selectCandidatesOfElection(int electionId) throws RemoteException;
    public Validator selectCandidatesOfElection(int electionId, Status candidateStatus) throws RemoteException;
    public Validator editCandidateStatus(int candidateId, Status status) throws RemoteException;
    
    
    //Vote
    public Validator vote(VoteDto v) throws RemoteException;
    public Validator getTallierPublicKey() throws RemoteException;
    public Validator voteProgressStatusForElection(int electionId) throws RemoteException;
    public Validator selectResults(int electionId) throws RemoteException;
}
