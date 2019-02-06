package com.homeworks.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayListApp {
    public static void main(String[] args) {
        Object o = new Integer("3");
        System.out.println(o.getClass());
        System.out.println(o instanceof Number);
        List<Integer> list = new ArrayList<>();
        System.out.println(list.getClass());
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(System.out::println);
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list.get(1));


        List<Integer> i = new ArrayList<>(list);
        i.addAll(list);

        Integer remove = i.remove(4);
        HashMap<String, Integer> companyDetails = new HashMap<>();

        // create hashmap with keys and values (CompanyName, #Employees)
        companyDetails.put("eBay", 4444);
        companyDetails.put("Paypal", 5555);
        companyDetails.put("IBM", 6666);
        companyDetails.put("Google", 7777);
        companyDetails.put("Yahoo", 8888);
        List<Map.Entry<String, Integer>> collect = companyDetails.entrySet().stream().filter((x) -> x.getValue() == 4444).collect(Collectors.toList());
    }
}