import java.util.Objects;

public class TilePart {

    private Point point;
    private boolean hasHole;

    public TilePart(int x, int y, boolean hasHole) {
        point = new Point(x, y);
        this.hasHole = hasHole;
    }

    public TilePart(Point point, boolean hasHole) {
        this.point = point;
        this.hasHole = hasHole;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TilePart tilePart)) return false;
        return hasHole == tilePart.hasHole && point.equals(tilePart.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, hasHole);
    }
}
