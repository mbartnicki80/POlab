package agh.ics.oop.model;

public class Vector2d {
    private final int x;
    private final int y;
    public Vector2d(int x, int y) { //czy musi być public?
        this.x = x;
        this.y = y;
    }

    public int getXValue() {
        return x;
    }
    public int getYValue() {
        return y;
    }

    public String toString() {
        return "(%d, %d)".formatted(x, y);
    }

    public boolean precedes(Vector2d other) {
        return (x<=other.x) && (y<=other.y); //czy w dobra strone porownanie
    }

    public boolean follows(Vector2d other) {
        return (x>=other.x) && (y>=other.y);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(x+other.x, y+other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(x-other.x, y-other.y);
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(x, other.x), Math.max(y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(x, other.x), Math.min(y, other.y));
    }

    public Vector2d opposite() {
        return new Vector2d(x*(-1), y*(-1));
    }

    public boolean equals(Object other) { //hash code i czy mozna poprawic tworzenie nowego vectora

        if (other == this)
            return true;

        if (!(other instanceof Vector2d))
            return false;

        Vector2d castedOther = (Vector2d) other;
        return (x == castedOther.x) && (y == castedOther.y);
    }
}
