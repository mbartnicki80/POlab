package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    public Animal(Vector2d position) {
        this.orientation = MapDirection.NORTH;
        this.position = position;
    }
    public Animal() {
        this(new Vector2d(2, 2));
    }
    public String toString() {
        return position.toString() + " " + orientation;
    }
    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }
    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD -> {
                Vector2d newPosition = position.add(orientation.toUnitVector());
                if ((newPosition.getXValue() < 5 && newPosition.getXValue() >= 0) && (newPosition.getYValue() < 5 && newPosition.getYValue() >= 0))
                    position = position.add(orientation.toUnitVector());
            }
            case BACKWARD -> {
                Vector2d newPosition = position.subtract(orientation.toUnitVector());
                if ((newPosition.getXValue() < 5 && newPosition.getXValue() >= 0) && (newPosition.getYValue() < 5 && newPosition.getYValue() >= 0))
                    position = position.subtract(orientation.toUnitVector());
            }
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
        }
    }
}
