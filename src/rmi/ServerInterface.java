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
    public ElectionDto getElection(int id) throws RemoteException;
    public ArrayList<ElectionDto> getElections(ElectionStatus electionStatus) throws RemoteException;
    public ArrayList<ElectionDto> getElections() throws RemoteException;
    public Validator addElection(String name, int owner_id) throws RemoteException;
    public Validator editElection(ElectionDto election) throws RemoteException;
    
    // Candidate
    public CandidateDto getCandidate(int id) throws RemoteException;
    public ArrayList<CandidateDto> getCandidatesOfElection(int election_id) throws RemoteException;
    public ArrayList<CandidateDto> getCandidatesOfElection(int election_id, Status candidateStatus) throws RemoteException;
    public Validator addCandidates(ArrayList<String> names, int election_id) throws RemoteException;
    public Validator editCandidate(CandidateDto candidate) throws RemoteException;
    
    //Vote
    public Validator vote(VoteDto v) throws RemoteException;



}
