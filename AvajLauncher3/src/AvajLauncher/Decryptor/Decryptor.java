package AvajLauncher.Decryptor;

import java.io.*;

public class Decryptor {

    static int x = 0;
    String line;
    BufferedReader reader;

    private File output = new File("/home/iosif/IdeaProjects/AvajLauncher3/src/AvajLauncher/Decryptor/hash/simDecrypted.txt");
    private BufferedWriter writer = new BufferedWriter(new FileWriter(output));

    public Decryptor() throws IOException {
    }

    public File convertMD5(File input) {

        try {
            reader = new BufferedReader(new FileReader(input));
            while ((line = reader.readLine()) != null) {

                if (x == 0) {
                    writer.write(MD5.map.get(line) + "\n");
                    x++;
                    writer.flush();
                } else {
                    String[] tmp = line.split(" ");
                    String tmp1 = "";
                    for (int i = 0; i < tmp.length; i++) {
                        tmp1 = tmp1 + " " + MD5.map.get(tmp[i]);
                    }
                    writer.write(tmp1.trim());
                    writer.write("\n");
                    writer.flush();
                }
            }
        } catch (Exception ex) {ex.printStackTrace();}
        return (output);
    }
}

