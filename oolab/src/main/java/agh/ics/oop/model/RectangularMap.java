package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {
    private final Boundary bounds;
    private final int ID = ++super.ID;

    public RectangularMap(int width, int height) {
        this.bounds = new Boundary(new Vector2d(0, 0), new Vector2d(width-1, height-1));
        //this.ID = ++super.ID;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (bounds.lowerLeft().precedes(position) && bounds.upperRight().follows(position)) && !isOccupied(position);
    }

    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Boundary getCurrentBounds() {
        return bounds;
    }
}
