package AvajLauncher.Airships;

import AvajLauncher.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {

        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

        switch (weatherTower.getWeather(this.coordinates) ) {
            case "SUN":
                System.out.println("Baloon" + this.name + "(" + this.id + ") says: Let's enjoy the good weather " +
                        "and take some pics.");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 2,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() + 4);
                break;

            case "RAIN":
                System.out.println("Baloon" + this.name + "(" + this.id + ") says: Damn you rain! You messed up " +
                        "my baloon.");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 5);
                break;

            case "FOG":
                System.out.println("Baloon" + this.name + "(" + this.id + ") says: Fuck, I hate fog!");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 3);
                break;

            case "SNOW":
                System.out.println("Baloon" + this.name + "(" + this.id + ") says: It's snowing! We're" +
                        "gonna crash.");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 15);
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("Baloon" + this.name + "(" + this.id + ") landing.");
            System.out.println("Tower says: Baloon" + this.name + "(" + this.id + ") unregistered from the tower.");
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Baloon" + this.name + "(" + this.id + ") registered to the tower.");
    }
}
