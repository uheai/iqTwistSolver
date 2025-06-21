import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tile {

    private Collection<TilePart> tileParts;
    private Color color;
    public final int size;

    public Tile(Collection<TilePart> tileParts, Color color) {
        this.tileParts = tileParts;
        this.color = color;
        this.size = tileParts.size();
    }

    public Tile makeConcrete(Point base) {
        Collection<TilePart> points = tileParts.stream().map(tp -> tp.makeConcrete(base)).collect(Collectors.toSet());
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


        //Berechne alle Spiegelungen an der X-Achse
        Collection<Tile> mirrorX = variations.stream().map(Tile::mirrorX).collect(Collectors.toSet());
        //Berechne alle Spiegelungen an der Y-Achse
        Collection<Tile> mirrorY = variations.stream().map(Tile::mirrorY).collect(Collectors.toSet());

        variations.addAll(mirrorX);
        variations.addAll(mirrorY);

        return variations;
    }

    public Tile rotate() {
        return transformTile(TilePart::rotate);
    }


    public Tile mirrorX() {
        return transformTile(TilePart::mirrorX);
    }

    public Tile mirrorY() {
        return transformTile(TilePart::mirrorY);
    }

    private Tile transformTile(Function<TilePart, TilePart> pointTransformation) {
        Collection<TilePart> transformedParts = new HashSet<>();
        for (TilePart part : tileParts) {
            transformedParts.add(pointTransformation.apply(part));
        }

        return new Tile(transformedParts, color);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (TilePart part : tileParts) {
            builder.append(part.toString());
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
        return tileParts.equals(tile.tileParts);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tileParts);
    }

    public Collection<TilePart> getTileParts() {
        return tileParts;
    }

    public Color getColor() {
        return color;
    }
}
