package AvajLauncher.Airships;

import AvajLauncher.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {

        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

        switch (weatherTower.getWeather(this.coordinates) ) {
            case "SUN":
                System.out.println("Helicopter" + this.name + "(" + this.id + ") says: This is hot.");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 10,
                        this.coordinates.getHeight() + 2);
                break;

            case "RAIN":
                System.out.println("Helicopter" + this.name + "(" + this.id + ") says: This rain gets me depressed.");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 5,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight());
                break;

            case "FOG":
                System.out.println("Helicopter" + this.name + "(" + this.id + ") says: Fog:(");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 1,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight());
                break;

            case "SNOW":
                System.out.println("Helicopter" + this.name + "(" + this.id + ") says: My rotor is going to freeze.");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 12);
                break;
        }
            if (this.coordinates.getHeight() <= 0) {
                System.out.println("Helicopter" + this.name + "(" + this.id + ") landing.");
                System.out.println("Tower says: Helicopter" + this.name + "(" + this.id + ") unregistered from the tower.");
                this.weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Helicopter" + this.name + "(" + this.id + ") registered to the tower.");
    }
}
