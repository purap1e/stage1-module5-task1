package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().allMatch(s -> Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> x.addAll(x.stream().filter(n -> n % 2 == 0).collect(Collectors.toList()));
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(n -> Character.isUpperCase(n.charAt(0)) && n.endsWith("."))
                .filter(s -> s.split("\\s+").length > 3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> resultMap = new HashMap<>();
            list.forEach(str -> resultMap.put(str, str.length()));
            return resultMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
          list1.addAll(list2);
          return list1;
        };
    }
}
