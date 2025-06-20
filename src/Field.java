public class Field {

    private Point point;
    private Color condition;

    public Field(int x, int y) {
        point = new Point(x, y);
        condition = Color.NONE;
    }

    public void setCondition(Color color) {
        this.condition = color;
    }
}
