package pl.todrzywolek.counting.ranges;

import java.util.ArrayList;
import java.util.List;

public class Ranges {

    public static List<FilterRange> calculateRanges(int min, int max) {
        final int NUMBER_OF_RANGES = 5;

        int roundedMin = round(min);
        int roundedMax = round(max);
        int rangeMin = (min / roundedMin) * roundedMin;
        int rangeMax = ((max + roundedMax - 1) / roundedMax) * roundedMax;
        int delta = (rangeMax - rangeMin) / NUMBER_OF_RANGES;
        delta = (delta / round(delta)) * round(delta);
        if (delta < 10) { delta = 10; }
        System.out.println(round(delta));
        System.out.println(delta);
        List<FilterRange> ranges = new ArrayList<>();

        for (int i=rangeMin; i <= rangeMax; i+=(delta)) {
            ranges.add(new FilterRange(i, i+ delta-1));
        }
        return ranges;
    }

    public static int round(int number) {
        String minStr = String.valueOf(number);
        String lowerBound = '1' + minStr.substring(1).replaceAll("\\d", "0");
        return Integer.parseInt(lowerBound);
    }
}
