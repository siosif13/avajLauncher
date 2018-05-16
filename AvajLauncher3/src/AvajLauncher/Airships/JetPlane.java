package AvajLauncher.Airships;

import AvajLauncher.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {

        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

        switch (weatherTower.getWeather(this.coordinates) ) {
            case "SUN":
                System.out.println("JetPlane" + this.name + "(" + this.id + ") says: This damn sun is getting into " +
                        "my eyes.");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 10,
                        this.coordinates.getHeight() + 2);
                break;

            case "RAIN":
                System.out.println("JetPlane" + this.name + "(" + this.id + ") says: It's raining, better" +
                        "watch out for the lightings.");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 5,
                        this.coordinates.getHeight());
                break;

            case "FOG":
                System.out.println("JetPlane" + this.name + "(" + this.id + ") says: WTF! I can't see a thing.");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 1,
                        this.coordinates.getHeight());
                break;

            case "SNOW":
                System.out.println("JetPlane" + this.name + "(" + this.id + ") says: OMG! Winter is coming!");
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 7);
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("JetPlane" + this.name + "(" + this.id + ") landing.");
            System.out.println("Tower says: JetPlane" + this.name + "(" + this.id + ") unregistered from the tower.");
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("JetPlane" + this.name + "(" + this.id + ") registered to the tower.");
    }
}
