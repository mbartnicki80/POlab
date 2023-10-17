package agh.ics.oop.model;

public class Vector2d {
    private final int x;
    private final int y;
    public Vector2d(int x, int y) { //czy musi być public?
        this.x = x;
        this.y = y;
    }

    public int getXValue() {
        return this.x;
    }
    public int getYValue() {
        return this.y;
    }

    public String toString() {
        return "(%d, %d)".formatted(this.x, this.y);
    }

    public boolean precedes(Vector2d other) {
        return (this.x<=other.x) && (this.y<=other.y); //czy w dobra strone porownanie
    }

    public boolean follows(Vector2d other) {
        return (this.x>=other.x) && (this.y>=other.y);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x+other.x, this.y+other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x-other.x, this.y-other.y);
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }

    public Vector2d opposite() {
        return new Vector2d(this.x*(-1), this.y*(-1));
    }

    public boolean equals(Object other) { //hash code i czy mozna poprawic tworzenie nowego vectora

        if (other == this)
            return true;

        if (!(other instanceof Vector2d))
            return false;

        Vector2d castedOther = (Vector2d) other;
        return (this.x == castedOther.x) && (this.y == castedOther.y);
    }
}
