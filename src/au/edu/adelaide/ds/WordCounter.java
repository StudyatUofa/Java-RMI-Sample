package au.edu.adelaide.ds;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface WordCounter extends Remote {
    Map<String, Integer> count(String name) throws RemoteException;
    Map<String, Integer> count(String[] name) throws RemoteException;
}