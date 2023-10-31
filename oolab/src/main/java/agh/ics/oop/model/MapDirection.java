package agh.ics.oop.model;
public enum MapDirection {

    NORTH, EAST, SOUTH, WEST;

    private static final Vector2d NORTHVECTOR = new Vector2d(0, 1);
    private static final Vector2d EASTVECTOR = new Vector2d(1, 0);
    private static final Vector2d SOUTHVECTOR = new Vector2d(0, -1);
    private static final Vector2d WESTVECTOR = new Vector2d(-1, 0);

    public String toString() {
        String[] directions = {"Polnoc", "Wschod", "Poludnie", "Zachod"};
        return directions[(this.ordinal())%(directions.length)];
    }

    public MapDirection next() {
        MapDirection[] directions = MapDirection.values();
        return directions[(this.ordinal()+1)%(directions.length)];
    }

    public MapDirection previous() {
        MapDirection[] directions = MapDirection.values();
        return directions[(this.ordinal()+directions.length-1)%(directions.length)];
    }
    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> NORTHVECTOR;
            case SOUTH -> SOUTHVECTOR;
            case WEST -> WESTVECTOR;
            case EAST -> EASTVECTOR;
        };
    }
}
