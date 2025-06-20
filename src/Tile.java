import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tile {

    private Collection<Point> relativePoints;
    private Color color;
    public final int size;

    public Tile(Collection<Point> relativePoints, Color color) {
        this.relativePoints = relativePoints;
        this.color = color;
        this.size = relativePoints.size();
    }

    public Tile makeConcrete(Point base) {
        Collection<Point> points = relativePoints.stream().map(p -> new Point(base, p.x, p.y)).collect(Collectors.toSet());
        return new Tile(points, color);
    }

    public Collection<Tile> getAllVariations() {
        Collection<Tile> variations = new HashSet<>();
        variations.add(this); //ursprüngliches Tile
        //Berechne alle Rotationen
        Tile ref = this;
        for (int i = 0; i < 3; i++) {
            ref = ref.rotate();
            variations.add(ref);
        }

        //TODO: Koordinaten müssen nach Spiegelung noch verschoben werden bzw. Spiegelung um Mittelpunkt des Teils nicht Achse

        //Berechne alle Spiegelungen an der X-Achse
        Collection<Tile> mirrorX = variations.stream().map(Tile::mirrorX).collect(Collectors.toSet());
        //Berechne alle Spiegelungen an der Y-Achse
        Collection<Tile> mirrorY = variations.stream().map(Tile::mirrorY).collect(Collectors.toSet());

        variations.addAll(mirrorX);
        variations.addAll(mirrorY);

        return variations;
    }

    public Tile rotate() {
        return transformTile(Point::rotate);
    }


    public Tile mirrorX() {
        return transformTile(Point::mirrorX);
    }

    public Tile mirrorY() {
        return transformTile(Point::mirrorY);
    }

    private Tile transformTile(Function<Point, Point> pointTransformation) {
        Collection<Point> transformedPoints = new HashSet<>();
        for (Point point : relativePoints) {
            transformedPoints.add(pointTransformation.apply(point));
        }

        return new Tile(transformedPoints, color);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (Point point : relativePoints) {
            builder.append(point.toString());
            builder.append(",");
        }
        //lösche letztes Komma
        builder.deleteCharAt(builder.length() - 1);
        builder.append("] ");

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tile tile)) return false;
        return relativePoints.equals(tile.relativePoints);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(relativePoints);
    }

    public Collection<Point> getPoints() {
        return relativePoints;
    }

    public Color getColor() {
        return color;
    }
}
