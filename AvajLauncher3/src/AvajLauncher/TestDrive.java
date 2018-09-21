package AvajLauncher;

import AvajLauncher.Decryptor.Decryptor;
import AvajLauncher.Decryptor.MD5;
import AvajLauncher.avajExceptions.*;

import AvajLauncher.Airships.AircraftFactory;
import AvajLauncher.Airships.Flyable;

import java.io.*;
import java.util.ArrayList;

public class TestDrive {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: Run the program with a valid .txt file as argument.");
            System.exit(0);
        }

        File output = new File("src/AvajLauncher/simulation.txt");
        try {
            PrintStream out = new PrintStream(new FileOutputStream(output));
            System.setOut(out);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        AircraftFactory factory = new AircraftFactory();
        WeatherTower weatherTower = new WeatherTower();
        ArrayList<Flyable> flyableList = new ArrayList<>();
        int cycles = 0;

        try {
            int first = 0;
            String[] split;
            BufferedReader reader;
            File file = new File(args[0]);
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            if (line.length() == 32) {
                try {
                    MD5.createMap();
                    Decryptor decryptor = new Decryptor();
                    file = decryptor.convertMD5(file);
                } catch (Exception ex) {ex.printStackTrace(); }
            }

            reader.close();
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                if (first == 0) {
                    try {
                        cycles = Integer.parseInt(line);
                    } catch (NumberFormatException ex) {
                        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
                        System.out.println("Invalid cycles (not a number)");
                        System.exit(0);
                    }

                    if (cycles < 0) {
                        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
                        System.out.println("Invalid cycles (<0)");
                        System.exit(0);
                    }
                    first++;
                } else {
                    try {
                        split = Validator.validateLine(line);
                        flyableList.add(factory.newAircraft(
                                split[0], split[1], Integer.parseInt(split[2]),
                                Integer.parseInt(split[3]), Integer.parseInt(split[4])));
                    } catch (InvalidTypeException | InvalidNameException | InvalidLatitudeException
                            | InvalidLongitudeException | InvalidHeightException | InvalidLengthException ex) {
                        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
                        System.out.println(ex.getMessage());
                        System.exit(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (Flyable fly : flyableList) {
            fly.registerTower(weatherTower);
        }

        for (int i = 0; i < cycles; i++) {
            weatherTower.changeWeather();
        }
    }
}
