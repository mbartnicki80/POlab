package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d upperRight;
    private final Vector2d lowerLeft;
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public RectangularMap(int width, int height) {
        this.upperRight = new Vector2d(width-1, height-1);
        this.lowerLeft = new Vector2d(0, 0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (lowerLeft.precedes(position) && upperRight.follows(position)) && !isOccupied(position);
    }

    public String toString() {
        return mapVisualizer.draw(lowerLeft, upperRight);
    }
}
