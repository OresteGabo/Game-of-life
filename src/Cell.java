import java.awt.*;

public class Cell {
    private boolean alive;
    private Color isAliveColor;
    private int surroundingAliveCount;
    private final Position position;

    public Position getPosition() {
        return position;
    }

    public Color getIsAliveColor() {
        return isAliveColor;
    }

    public void setIsAliveColor(Color isAliveColor) {
        this.isAliveColor = isAliveColor;
    }

    public int getSurroundingAliveCount() {
        return surroundingAliveCount;
    }

    public void setSurroundingAliveCount(int surroundingAliveCount) {
        this.surroundingAliveCount = surroundingAliveCount;
    }

    public Cell(Position position) {
        this.alive = false;
        this.isAliveColor = Color.WHITE;
        this.surroundingAliveCount=0;
        this.position=position;
    }

    public void toggle() {
        this.alive = !this.alive;
        this.isAliveColor = this.alive ? Color.BLACK : Color.WHITE;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean state) {
        this.alive = state;
        this.isAliveColor = state ? Color.BLACK : Color.WHITE;
    }

    @Override
    public String toString() {
        return "Cell{ alive : " + alive + "}";
    }
}