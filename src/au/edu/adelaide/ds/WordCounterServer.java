package au.edu.adelaide.ds;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class WordCounterServer {

    public static void main(String[] args) {

        try {
            WordCounterImplementation counter = new WordCounterImplementation();
            WordCounter stub = (WordCounter) UnicastRemoteObject.exportObject(counter, 0);

            // Create a new registry and bind the remote object's stub in it
            Registry registry = LocateRegistry.createRegistry(1099);
            ((Registry) registry).bind("WordCounter", stub);

            System.out.println("WordCounterServer ready");
        } catch (Exception e) {
            System.err.println("WordCounterServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}