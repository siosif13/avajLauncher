package AvajLauncher.Airships;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    static private long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {

        this.id = nextID();
        this.name = "#" + name;
        this.coordinates = coordinates;
    }

    private long nextID() {
        return ++idCounter;
    }

}
