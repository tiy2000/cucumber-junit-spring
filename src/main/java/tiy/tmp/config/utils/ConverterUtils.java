package tiy.tmp.config.utils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConverterUtils {

    public static <T, K> Map<K, T> convertListToMap(List<T> list, Function<T, K> keyExtractor) {
        return list.stream()
                .collect(Collectors.toMap(keyExtractor, Function.identity()));
    }
}
