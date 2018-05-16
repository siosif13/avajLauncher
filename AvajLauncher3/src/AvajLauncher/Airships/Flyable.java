package AvajLauncher.Airships;
import AvajLauncher.WeatherTower;

public interface Flyable {

    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
