package agh.ics.oop.model;

public class Animal {
    private static final Vector2d UPPER_RIGHT = new Vector2d(4, 4);
    private static final Vector2d LOWER_LEFT = new Vector2d(0, 0);
    public MapDirection orientation;
    public Vector2d position;

    public Animal(Vector2d position) {
        this.orientation = MapDirection.NORTH;
        this.position = position;
    }

    public Animal() {
        this(new Vector2d(2, 2));
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        return position.toString() + " " + orientation;
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD, BACKWARD -> {
                Vector2d newPosition = direction == MoveDirection.FORWARD ? position.add(orientation.toUnitVector()) : position.subtract(orientation.toUnitVector());
                if ((newPosition.precedes(UPPER_RIGHT)) && (newPosition.follows(LOWER_LEFT)))
                    position = newPosition;
            }
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
        }
    }
}
