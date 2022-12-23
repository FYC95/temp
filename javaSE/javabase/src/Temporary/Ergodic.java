package Temporary;

import java.util.*;

public class Ergodic {
    public static void main(String[] args) {
        List<Integer> arrs = new ArrayList<>();
        arrs.add(1);arrs.add(2);arrs.add(3);
        Iterator i = arrs.iterator();//迭代器
        while (i.hasNext()){
            System.out.println(i.next());
        }
        for (int j = 0; j < arrs.size(); j++) {
            System.out.println(arrs.get(j));
        }
        for (Integer j:arrs){
            System.out.println(j);
        }


        Set<Integer> s = new HashSet<>();
        s.add(4);s.add(5);s.add(6);
        Object[] o = s.toArray();
        for (int j = 0; j < o.length; j++) {
            System.out.println(o[j]);
        }
        Iterator is = s.iterator();
        while (is.hasNext()){
            System.out.println(is.next());
        }
        for (Integer j:s){
            System.out.println(j);
        }


        Map<String, Integer> map = new HashMap<>();
        map.put("one",7);map.put("two",8);map.put("three",9);
        /*for (int j = 0; j < map.size(); j++) {
            System.out.println(map.get(j));
        }*/
        Set sm = map.keySet();
        /*for (Object j:sm) {
            System.out.println(j);
        }*/
        Iterator ism = sm.iterator();
        while (ism.hasNext()){
            System.out.println(map.get(ism.next()));
        }
    }
}
