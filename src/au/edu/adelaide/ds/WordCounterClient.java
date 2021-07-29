package au.edu.adelaide.ds;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;

public class WordCounterClient {
    public static void main(String[] args) {

        String host = "localhost";
        Integer port = 1099;
        try {
            // Connect to the registry
            Registry registry = LocateRegistry.getRegistry(host, port);

            // Look up a stub with name "WordCounter"
            WordCounter stub = (WordCounter) registry.lookup("WordCounter");

            String line  = "Hello wordcount MapReduce Hadoop program. This is my first MapReduce program.";

            // Test count(String line)
            Map<String, Integer> res = stub.count(line);
            System.out.println("response (String line): " + res);

            // Test count(String[] line)
            res = stub.count(new String[]{line});
            System.out.println("response (String[] lines): " + res);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}