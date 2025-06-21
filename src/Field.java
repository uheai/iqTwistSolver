public class Field {

    private final Point point;
    private  TilePart part;
    private Color color;
    private Color condition;

    public Field(int x, int y) {
        point = new Point(x, y);
        color = Color.NONE;
        condition = Color.NONE;
    }

    public void setColor(Color color) throws ConditionFailedException {
        if (condition != Color.NONE && color != condition) {
            throw new ConditionFailedException(point.toString() + " muss " + condition.toString() + " sein (" + color.toString() + " erhalten)");
        }
        this.color = color;
    }

    public boolean isAllowed(TilePart part, Color color) {
        //Prüfe, ob Farbe Bedingung einhält (falls vorhanden) und der Punkt offen ist
        if (condition != Color.NONE && (condition != color || !part.hasHole())) {
            return false;
        }

        //Legen nur erlaubt, falls noch kein anderes Teil hier liegt
        if (this.color != Color.NONE) {
            return false;
        }

        return true;
    }

    public void setCondition(Color color) {
        this.condition = color;
    }

    public Color getCondition() {
        return condition;
    }

    public Color getColor() {
        return color;
    }

    public void reset() {
        this.color = Color.NONE;
        this.part = null;
    }

    public boolean hasTile() {
        return this.color != Color.NONE;
    }

    public void place(TilePart part, Color color) {
        if (condition != Color.NONE && !part.hasHole()) {
            throw new ConditionFailedException("Tilepart has no whole and cannot be placed at (" + point.x + "," + point.y + ")");
        }

        this.color = color;
        this.part = part;
    }
}
