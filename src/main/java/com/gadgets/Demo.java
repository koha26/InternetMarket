package com.gadgets;

import com.gadgets.entity.*;
import com.gadgets.listImpl.MyListImpl;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        MyListImpl<SellableProduct> list = new MyListImpl<>();
        list.add(new Fridge());
        list.add(null);
        list.add(new Conditioner());
        list.add(new SmartWatch());
        list.add(new Headphone());
        list.add(null);

        SellableProduct el = list.get(2);

        System.out.println(el);
        System.out.println(list.contains(el));
        System.out.println(list.remove(el));
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.indexOf(null));
        System.out.println(list.lastIndexOf(null));
        System.out.println(list.toArray());
        System.out.println(list.set(1, new Fridge()));
        list.clear();
        System.out.println(list.isEmpty());
    }
}
