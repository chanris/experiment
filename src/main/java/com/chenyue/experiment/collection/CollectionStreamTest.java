package com.chenyue.experiment.collection;



import com.alibaba.fastjson2.JSON;
import com.chenyue.experiment.collection.entity.Person;
import com.chenyue.experiment.collection.entity.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/20
 * 测试集合类型的stream操作
 * <a href="https://blog.csdn.net/bitcarmanlee/article/details/88199262">? super T 与 ? extends T 的区别</a>
 */
public class CollectionStreamTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"jack", 20));
        list.add(new Person(2,"mike", 25));
        list.add(new Person(3,"tom", 30));
        Stream<Person> stream = list.stream(); // Stream<E>
        //stream.forEach(item->item.setName("xxxxx")); /*foreach操作后流就直接关闭了*/
        //stream = list.stream();
        //stream.map(item->{item.setName("====="); return item;});
        /**
         * map
         * peek
         * filter 都会产生新Stream<T>对象以便使用collect操作。
         * 而foreach不会，foreach是直接操作原对象
         *
         */
        //stream.peek(item->item.setName("====="));
        Stream<Person> stream1 = stream.filter( item-> !item.getId().equals(1));
        System.out.println(stream1 == stream);
        list.forEach(System.out::println);
    }


    public static void repeat() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"jack", 20));
        list.add(new Person(2,"mike", 25));
        list.add(new Person(3,"tom", 30));
        Stream<Person> stream = list.stream(); // Stream<E>
        //保留年龄为20的person元素
        //list = list.stream().filter(item -> item.getAge() == 20).collect(Collectors.toList());
        //System.out.println(Arrays.toString(list.toArray()));
        list.forEach(item -> {
            System.out.println(item);
        });
        Map<Integer, List<Person>> map = new HashMap<>();
        map.put(1, list);
//        map.forEach((k,v)->{
//            System.out.println("Key:"+k+",value:"+v);
//        });
        System.out.println(JSON.toJSONString(map));
        list.stream().peek(item->item.setName("*****")).collect(Collectors.toList());
        System.out.println(Arrays.toString(list.toArray()));
       /* List<String> jsonList =list.stream().map(JSON::toJSONString)
                .collect(Collectors.toList());*/

        // Function<T,V> 需要两个泛型，第一个T由原始list确定，第二个泛型由Function返回的结果决定。
        List<Student> students  = list.stream().map(person -> new Student(person.getId(),person.getName(),person.getAge(), "5120184891")).collect(Collectors.toList());
        students.forEach(System.out::println);

        // list转map 最佳实践，转换的关键在于收集collect(Collectors.toMap(Student::getId,v -> v, (k1,k2)->k2))需要解决三点
        // 第一点: 确定key的Function参数是map处理后的Stream<T>流中的T， 类型T需要根据结果确定。
        // 第二点: 确定value的Function参数是也是T,和key一样
        // 第三点: 确定键冲突策略，需要传两个参数k1,k2, 返回一个处理后的k值 一般：(k1,k2)->k2 处理，具体得看业务需求
        Map<Integer, Student> map1 = list.stream()
                .map(person -> new Student(person.getId(), person.getName(), person.getAge(), "5120184891"))
                .collect(Collectors.toMap(Student::getId, v->v, (k1,k2)->k2));
        map1.forEach((k,v)-> System.out.println("key:"+k+","+"value:"+v));

        //list.stream().peek(person -> person.setName(person.getName()+"__update")).collect(Student::new,); // 会产生新流的foreach
    }
}
