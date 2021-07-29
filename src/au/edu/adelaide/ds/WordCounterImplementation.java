package au.edu.adelaide.ds;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCounterImplementation implements WordCounter {
    @Override
    public Map<String, Integer> count(String line) throws RemoteException {
        Map<String, Integer> stats = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            stats.put(token, stats.getOrDefault(token, 0) + 1);
        }
        return stats;
    }

    @Override
    public Map<String, Integer> count(String[] strings) throws RemoteException {
        Map<String, Integer> stats = new HashMap<>();
        for (String line: strings ) {
            Map<String, Integer> ret = count(line);
            for (Map.Entry<String, Integer> entry : ret.entrySet()) {
                String key = entry.getKey();
                stats.put(key, stats.getOrDefault(key, 0) + entry.getValue());
            }
        }
        return stats;
    }

    public static void main(String[] args) throws RemoteException {
        WordCounterImplementation counter = new WordCounterImplementation();
        String line  = "Hello wordcount MapReduce Hadoop program. This is my first MapReduce program.";
        System.out.println(counter.count(line));

        System.out.println(counter.count(new String[]{line}));
    }
}
