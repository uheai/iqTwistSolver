import java.util.Objects;

public class Point {

    public final int x;
    public final int y;
    private boolean isOpen;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        isOpen = true;
    }

    public Point(Point base, int deltaX, int deltaY) {
        this.x = base.x + deltaX;
        this.y = base.y + deltaY;
        isOpen = base.isOpen;
    }

    public Point(int x, int y, boolean isOpen) {
        this(x,y);
        this.isOpen = isOpen;
    }

    /**
     * Rotiere 90° gegen den Uhrzeigersinn
     * @return Punkt um 90° rotiert
     */
    public Point rotate() {
        return new Point(-y,x);
    }

    public Point mirrorX() {
        return new Point(x, -y);
    }

    public Point mirrorY() {
        return new Point(-x, y);
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

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean isWithinBounds(int width, int height) {
       return this.x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
