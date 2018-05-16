package AvajLauncher;

import AvajLauncher.Airships.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {

        WeatherProvider weatherProvider = WeatherProvider.getProvider();
        return weatherProvider.getCurrentWeather(coordinates);
    }

    void changeWeather() {

        conditionsChanged();
    }
}
