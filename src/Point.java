import java.util.Objects;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point base, int deltaX, int deltaY) {
        this.x = base.x + deltaX;
        this.y = base.y + deltaY;
    }

    /**
     * Rotiere 90° gegen den Uhrzeigersinn
     * @return Punkt um 90° rotiert
     */
    public Point rotate() {
        return new Point(-y,x);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point point)) return false;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
