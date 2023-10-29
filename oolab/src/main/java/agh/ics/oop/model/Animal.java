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
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if ((Math.abs(newPosition.getXValue()) < 5) && (Math.abs(newPosition.getYValue()) < 5))
                    this.position = this.position.add(this.orientation.toUnitVector());
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.orientation.toUnitVector());
                if ((Math.abs(newPosition.getXValue()) < 5) && (Math.abs(newPosition.getYValue()) < 5))
                    this.position = this.position.subtract(this.orientation.toUnitVector());
            }
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
        }
    }
}
