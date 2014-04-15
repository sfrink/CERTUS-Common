package rmi;

import java.io.InputStream;
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

    // Users
    public Validator registerNewUser (UserDto userDto) throws RemoteException;
    public Validator selectUser(int userId, String sessionID) throws RemoteException;
    public Validator selectAllUsers(String sessionID) throws RemoteException ;
    public Validator editUser(UserDto userDto, String sessionID) throws RemoteException ;
    public Validator editUserStatus(int userId, UserStatus userStatus, String sessionID) throws RemoteException;
    public Validator generateNewKeys(int userID, String newKeyPass, String sessionID) throws RemoteException;
    public Validator logOut(String sessionID) throws RemoteException;
    public Validator updateUser(UserDto userDto, String sessionID) throws RemoteException;
    public Validator updateUserPassword(UserDto userDto, String sessionID) throws RemoteException;
    public Validator uploadPubKey(byte[] keyBytes, String sessionID) throws RemoteException;
    public Validator checkIfUsernameTempPasswordMatch(String email, String plainPass)
    		throws RemoteException;
    
    // Elections
    public Validator selectElectionForVoter(int electionId, String sessionID) throws RemoteException;
    public Validator selectElectionsForVoter(int user_id, String sessionID) throws RemoteException;    
    public Validator selectElectionForOwner(int electionId, String sessionID) throws RemoteException; 
    public Validator selectElectionsForOwner(int electionOwnerId, String sessionID) throws RemoteException;
    public Validator selectElectionFullDetail (int electionId, String sessionID) throws RemoteException;
    public Validator selectElectionsForAdmin(String sessionID) throws RemoteException;
    public Validator selectElectionsForResults(int userId, String sessionID) throws RemoteException;
    public Validator addElection(ElectionDto electionDto, String sessionID)throws RemoteException;
    public Validator addAdditionalUsersToElection(ElectionDto electionDto, String sessionID) throws RemoteException;
    public Validator addUserInvitations(ElectionDto electionDto, String sessionID) throws RemoteException ;
    public Validator editElection(ElectionDto electionDto, String sessionID)throws RemoteException;
    public Validator editElectionStatus(int electionId, ElectionStatus electionStatus, String sessionID) throws RemoteException;
    public Validator openElectionAndPopulateCandidates(int electionId, String sessionID) throws RemoteException;
    public Validator publishResults(int electionId, String password, String sessionID) throws RemoteException;    
    public Validator deleteElection(int electionId, String sessionID) throws RemoteException;
    
    //Vote
    public Validator vote(VoteDto v, String sessionID) throws RemoteException;
    public Validator getTallierPublicKey(int electionId, String sessionID) throws RemoteException;
    public Validator voteProgressStatusForElection(int electionId, String sessionID) throws RemoteException;
    public Validator selectResults(int electionId, String sessionID) throws RemoteException;
    
    public Validator sendTempPassword(UserDto u, String sessionID) throws RemoteException;
}
