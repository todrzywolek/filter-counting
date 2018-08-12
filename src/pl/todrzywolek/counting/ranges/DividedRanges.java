package pl.todrzywolek.counting.ranges;

import java.util.List;

public class DividedRanges {
    private String key;
    private List<FilterRange> ranges;

    public DividedRanges(String key, List<FilterRange> ranges) {
        this.key = key;
        this.ranges = ranges;
    }

    public List<FilterRange> getRanges() {
        return ranges;
    }

    public void addToRange(int value) {
        for (FilterRange r : ranges) {
            if (value >= r.getMin() && value <= r.getMax()) {
                r.add();
                break;
            }
        }
    }
}
