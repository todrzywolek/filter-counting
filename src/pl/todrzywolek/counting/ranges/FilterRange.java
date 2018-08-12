package pl.todrzywolek.counting.ranges;

public class FilterRange {
    private int min;
    private int max;
    private int numOfElements = 0;

    public FilterRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void add() {
        numOfElements++;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNumOfElements() {
        return numOfElements;
    }

    public void setNumOfElements(int numOfElements) {
        this.numOfElements = numOfElements;
    }

    @Override
    public String toString() {
        return "FilterRange{" +
                "min=" + min +
                ", max=" + max +
                ", numOfElements=" + numOfElements +
                '}';
    }
}
