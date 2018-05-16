package AvajLauncher;

import AvajLauncher.avajExceptions.*;

public class Validator {

    private static Validator validator = new Validator();

    private Validator() {
    }

    public static String[] validateLine(String line) throws Exception {

        String[] lineArray = line.split(" ");

        if (lineArray.length != 5)
        {
            throw new InvalidLengthException("Invalid line length");
        }

        if (!lineArray[0].equals("Baloon") && !lineArray[0].equals("JetPlane")
                && !lineArray[0].equals("Helicopter")) {
            throw new InvalidTypeException("Invalid type");
        } else if (!lineArray[1].matches("^[BJH]\\d+")) {
            throw new InvalidNameException("Invalid name");
        }
        else if (!lineArray[2].matches("\\d+")) {
            throw new InvalidLongitudeException("Invalid longitude");
        }
        else if (!lineArray[3].matches("\\d+")) {
            throw new InvalidLatitudeException("Invalid latitude");
        }
        else if (!lineArray[4].matches("\\d+")) {
            throw new InvalidHeightException("Invalid height");
        }
        return (lineArray);
    }

    public static Validator getValidator() {
        return validator;
    }
}
