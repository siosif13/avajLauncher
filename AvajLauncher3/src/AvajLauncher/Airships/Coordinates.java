package AvajLauncher.Airships;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {

        this.longitude = longitude;
        this.latitude = latitude;

        if (height > 100) {
            this.height = 100;
        } else {
            this.height = height;
        }
    }

    public int getLongitude() {
        return longitude;
    }
    public int getHeight() {
        return height;
    }
    public int getLatitude() {
        return latitude;
    }
}
