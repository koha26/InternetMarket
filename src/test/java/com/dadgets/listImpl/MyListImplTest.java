package com.dadgets.listImpl;

import com.gadgets.entity.Conditioner;
import com.gadgets.entity.Fridge;
import com.gadgets.entity.SellableProduct;
import com.gadgets.entity.SmartWatch;
import com.gadgets.listImpl.MyListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class MyListImplTest {
    protected MyListImpl<SellableProduct> list;

    public MyListImplTest() {
    }

    @Before
    public void initBeforeTestCase() {
        this.list = new MyListImpl<>();
    }

    @Test
    public void testConstructor1() {
        new MyListImpl();
    }

    @Test
    public void testConstructor2() {
        Assert.assertEquals(0, this.list.size());
    }

    @Test
    public void testConstructor3() {
        new MyListImpl(5);
        Assert.assertEquals(0, this.list.size());
    }

    @Test
    public void testAdd1() {
        this.list.add(new Conditioner());
        Assert.assertEquals(1, this.list.size());
    }

    @Test
    public void testAdd2() {
        this.list.add(null);
        Assert.assertEquals(1, this.list.size());
    }

    @Test
    public void testAdd3() {
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());

        Assert.assertEquals(3, this.list.size());
    }

    @Test
    public void testRemove1() {
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);

        this.list.remove(null);

        Assert.assertEquals(3, this.list.size());
    }

    @Test
    public void testRemove2() {
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(null);

        this.list.removeAll(l);
        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void testRemove3() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(product);

        this.list.removeAll(l);
        Assert.assertEquals(3, this.list.size());
    }

    @Test
    public void testRemove4() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(product);
        l.add(null);

        this.list.removeAll(l);
        Assert.assertEquals(1, this.list.size());
    }

    @Test
    public void testContains1() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        boolean actual = this.list.contains(product);
        Assert.assertEquals(true, actual);
    }

    @Test
    public void testContains2() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        boolean actual = this.list.contains(null);
        Assert.assertEquals(true, actual);
    }

    @Test
    public void testContainsAll1() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(product);
        l.add(null);

        boolean actual = this.list.containsAll(l);
        Assert.assertEquals(true, actual);
    }

    @Test
    public void testContainsAll2() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(product);
        l.add(null);
        l.add(new Conditioner());

        boolean actual = this.list.containsAll(l);
        Assert.assertEquals(false, actual);
    }

    @Test
    public void testAddAll1() {
        SellableProduct product = new Fridge();

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(product);
        l.add(null);

        boolean actual = this.list.addAll(l);
        Assert.assertEquals(true, actual);
        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void testAddAll2() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(product);
        l.add(null);

        boolean actual = this.list.addAll(2, l);
        Assert.assertEquals(true, actual);
        Assert.assertEquals(7, this.list.size());
        Assert.assertEquals(null, this.list.get(4));
    }

    @Test
    public void testRetainAll1() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(product);
        l.add(null);

        boolean actual = this.list.retainAll(l);
        Assert.assertEquals(true, actual);
        Assert.assertEquals(1, this.list.size());
    }

    @Test
    public void testRetainAll2() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(null);

        boolean actual = this.list.retainAll(l);

        Assert.assertEquals(true, actual);
        Assert.assertEquals(3, this.list.size());
    }

    @Test
    public void testRetainAll3() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(new Conditioner());

        boolean actual = this.list.retainAll(l);
        Assert.assertEquals(false , actual);
        Assert.assertEquals(5, this.list.size());
    }

    @Test
    public void testClear() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        this.list.clear();
        Assert.assertEquals(0, this.list.size());
    }

}
