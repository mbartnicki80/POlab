package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d upperRight;
    private final Vector2d lowerLeft;

    public RectangularMap(int width, int height) {
        this.upperRight = new Vector2d(width-1, height-1);
        this.lowerLeft = new Vector2d(0, 0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (lowerLeft.precedes(position) && upperRight.follows(position)) && !isOccupied(position);
    }

    @Override
    public String toString() {
        return super.toString(lowerLeft, upperRight);
    }
}
