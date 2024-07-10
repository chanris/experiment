package com.chenyue.experiment.basic.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/1
 */
public class GenericMethodTest {
    public <R,T> Stream<R> map(Function<? super T, ? extends R> mapper) {
        List<Integer> list = new ArrayList<>();
        return null;
    }
}
