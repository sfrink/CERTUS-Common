package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.CandidateDto;
import dto.ElectionDto;
import dto.Validator;
import dto.VoteDto;
import enumeration.Status;
import enumeration.ElectionStatus;

public interface ServerInterface extends Remote {
    public String sayHello(String name) throws RemoteException;   
    
    public Validator checkIfUsernamePasswordMatch(String email, String plainPass)
    		throws RemoteException;
    
 // Election
    public Validator selectElection(int id) throws RemoteException;
    public Validator selectElections(ElectionStatus electionStatus) throws RemoteException;
    public Validator selectElections() throws RemoteException;
    public Validator selectElectionsOwnedByUser(int electionOwnerId, ElectionStatus electionStatus) throws RemoteException;
    public Validator selectElectionsOwnedByUser(int electionOwnerId) throws RemoteException;
    public Validator addElectionWithCandidates(ElectionDto electionDto)throws RemoteException;
    //public Validator editElection(ElectionDto election) throws RemoteException;
    public Validator editElectionStatus(int electionId, ElectionStatus electionStatus) throws RemoteException;
    public Validator editElectionWithCandidates(ElectionDto electionDto) throws RemoteException;
    public Validator selectAllElectionsForVoter(int user_id) throws RemoteException;
    
    // Candidate
    public Validator selectCandidate(int id) throws RemoteException;
    public Validator selectCandidatesOfElection(int electionId) throws RemoteException;
    public Validator selectCandidatesOfElection(int electionId, Status candidateStatus) throws RemoteException;
   // public Validator addCandidatesNamesToElection(ArrayList<String> names, int electionId) throws RemoteException;
   // public Validator addCandidatesToElection(ArrayList<CandidateDto> candidateList, int electionId) throws RemoteException;
   // public Validator editCandidate(CandidateDto candidate) throws RemoteException;
    public Validator editCandidateStatus(int candidateId, Status status) throws RemoteException;
    
    
    //Vote
    public Validator vote(VoteDto v) throws RemoteException;
    public Validator getTallierPublicKey() throws RemoteException;


    public String byteArraytoHex(byte[] arr) throws RemoteException;
}
