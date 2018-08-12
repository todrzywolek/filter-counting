package pl.todrzywolek.counting;

import pl.todrzywolek.counting.ranges.DividedRanges;
import pl.todrzywolek.counting.ranges.FilterRange;
import pl.todrzywolek.counting.ranges.Ranges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        List<Person> people = initPersons();
        Supplier<Stream<Person>> streamSupplier = () -> people.stream();
        Stream<Integer> ageStream = streamSupplier.get().map(Person::getAge);
        Map<Integer, Long> countedAge = count(ageStream);
        Integer min = streamSupplier.get().map(Person::getAge).min(Integer::compareTo).get();
        Integer max = streamSupplier.get().map(Person::getAge).max(Integer::compareTo).get();
        List<FilterRange> filterRanges = Ranges.calculateRanges(min, max);
        DividedRanges ranges = new DividedRanges("ageRange", filterRanges);
        streamSupplier.get().map(Person::getAge).forEach(age -> ranges.addToRange(age));

        for(FilterRange r : ranges.getRanges()) {
            System.out.println(r.toString());
        }








        Map<String, Long> countedName = count(streamSupplier.get().map(Person::getName));
        Map<String, Long> countedLastName = count(streamSupplier.get().map(Person::getLastName));

        System.out.println(countedAge);
        System.out.println(countedName);
        System.out.println(countedLastName);


    }

//    public static

    public static <T> Map<T, Long> count(Stream<T> mappedValue) {
        return mappedValue.collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));
    }



    public static List<Person> initPersons() {
        Person p1 = new Person("Tomek", "Odrzywolek", 26);
        Person p2 = new Person("Tomek", "Friqs", 25);
        Person p3 = new Person("Romek", "Odrzywolek", 21);
        Person p4 = new Person("Tomek", "Boomek", 45);
        Person p5 = new Person("Edek", "Stoud", 12);

        ArrayList<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);

        return people;
    }
}
