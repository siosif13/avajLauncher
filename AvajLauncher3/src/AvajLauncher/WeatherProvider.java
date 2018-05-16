package AvajLauncher;

import AvajLauncher.Airships.Coordinates;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

        int total = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        return weather[total % 4];
    }
}
