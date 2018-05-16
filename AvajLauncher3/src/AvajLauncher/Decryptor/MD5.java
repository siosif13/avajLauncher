package AvajLauncher.Decryptor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class MD5 {

    public static Map<String, String> map = new HashMap<String, String>();


    public static void createMap() {

        try {
            BufferedReader in = new BufferedReader(new FileReader("/home/iosif/IdeaProjects/AvajLauncher3/src/AvajLauncher/Decryptor/hash/hashMap.txt"));
            String line = "";
            while ((line = in.readLine()) != null) {
                String parts[] = line.split(" ");
                map.put(parts[0], parts[1]);
            }
            in.close();
        } catch (Exception ex) {ex.printStackTrace(); }
    }

}