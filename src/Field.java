public class Field {

    private final Point point;
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

    public boolean isAllowed(Color color) {
        return (condition == Color.NONE || condition == color) && /*noch kein anderes Teil*/ this.color == Color.NONE;
    }

    public void setCondition(Color color) {
        this.condition = condition;
    }

    public Color getCondition() {
        return condition;
    }

    public Color getColor() {
        return color;
    }

    public void reset() {
        this.color = Color.NONE;
    }

    public boolean hasTile() {
        return this.color != Color.NONE;
    }
}
