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

    public TilePart makeConcrete(Point base) {
        Point concrete = new Point(point, base.x, base.y);
        return new TilePart(concrete, hasHole);
    }

    public Point getPoint() {
        return point;
    }

    public boolean hasHole() {
        return hasHole;
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

    /**
     * Rotiere 90° gegen den Uhrzeigersinn
     * @return Punkt um 90° rotiert
     */
    public TilePart rotate() {
        Point rotated = point.rotate();
        return new TilePart(rotated, hasHole);
    }

    public TilePart mirrorX() {
        Point mirrored = point.mirrorX();
        return new TilePart(mirrored, hasHole);
    }

    public TilePart mirrorY() {
        Point mirrored = point.mirrorY();
        return new TilePart(mirrored, hasHole);
    }

    @Override
    public String toString() {
        return "[" + point + "," + (hasHole? "o" : "c") + "]";
    }
}
