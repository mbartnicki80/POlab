package agh.ics.oop.model;
public enum MapDirection {

    NORTH, EAST, SOUTH, WEST;

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
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            case EAST -> new Vector2d(1, 0);
        };
    }
}
