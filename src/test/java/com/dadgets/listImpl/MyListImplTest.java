package com.dadgets.listImpl;

import com.gadgets.entity.SmartWatch;
import com.gadgets.listImpl.MyListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyListImplTest {
    protected MyListImpl list;

    @Before
    public void initBeforeTestCase(){
        list = new MyListImpl();
    }

    @Test
    public void testConstructor1(){
        new MyListImpl();
    }
    @Test
    public void testConstructor2(){
        Assert.assertEquals(0, list.size());
    }
    @Test
    public void testConstructor3(){
        MyListImpl list2 = new MyListImpl(5);
        Assert.assertEquals(list.size(), 0);
    }
    @Test
    public void testAdd1(){
        list.add(new SmartWatch());

        Assert.assertEquals(1, list.size());
    }

}
