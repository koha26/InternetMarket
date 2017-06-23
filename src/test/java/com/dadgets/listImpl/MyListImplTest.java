package com.dadgets.listImpl;

import com.gadgets.entity.*;
import com.gadgets.listImpl.MyListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author Kostiantyn_Diachenk1
 */

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
    public void testConstructor4(){
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(new SmartWatch());
        this.list.add(new Headphone());
        this.list.add(null);

        SellableProduct[] arr = list.toArray(new SellableProduct[]{});

        this.list = new MyListImpl<>(arr);

        Assert.assertEquals(6, list.size());

    }

    @Test
    public void testAddOneElement() {
        boolean res =  this.list.add(new Conditioner());
        Assert.assertEquals(true, res);
        Assert.assertEquals(1, this.list.size());
    }

    @Test
    public void testAddNullElement() {
        boolean res = this.list.add(null);
        Assert.assertEquals(true, res);
        Assert.assertEquals(1, this.list.size());
    }

    @Test
    public void testAddThreeElement() {
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());

        Assert.assertEquals(3, this.list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtMinusOnePosition() {
        list.add(-1, null);
    }

    @Test
    public void testAddSixElement() {
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(new SmartWatch());
        this.list.add(new Headphone());
        this.list.add(null);

        Assert.assertEquals(6, this.list.size());
    }

    @Test
    public void testRemoveNullElement() {
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);

        this.list.remove(null);

        Assert.assertEquals(3, this.list.size());
    }

    @Test
    public void testRemoveElementByObject(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        boolean actual = list.remove(product);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveElementByIndex(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        SellableProduct actual = list.remove(1);
        SellableProduct expected = null;

        Assert.assertNull(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveElementByOutOfCountPosition(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        list.remove(6);
    }

    @Test
    public void testRemoveAllNull() {
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
    public void testRemoveAllElement() {
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
    public void testRemoveAllBothElementAndNull() {
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
    public void testContainsElement() {
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
    public void testContainsNull() {
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
    public void testContainsAllBothElementAndNull() {
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
    public void testContainsAllElementsAndNull() {
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
        Assert.assertEquals(true, actual);
    }

    @Test
    public void testContainsAllInEmptyList() {
        Collection<SellableProduct> l = new ArrayList<>();
        l.add(null);
        l.add(new Conditioner());

        boolean actual = this.list.containsAll(l);
        Assert.assertEquals(false, actual);
    }


    @Test
    public void testAddAllWithCheckingAddingAndSize() {
        SellableProduct product = new Fridge();

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(product);
        l.add(null);

        boolean actual = this.list.addAll(l);
        Assert.assertEquals(true, actual);
        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void testAddAllWithCheckingAddingAndSizeAndElementInPos() {
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
    public void testRetainAllBothElementAndNull() {
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
    public void testRetainAllNull() {
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
    public void testRetainAllElement() {
        SellableProduct product = new Fridge();
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Collection<SellableProduct> l = new ArrayList<>();
        l.add(new Conditioner());

        boolean actual = this.list.retainAll(l);
        Assert.assertEquals(true , actual);
        Assert.assertEquals(4, this.list.size());
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

    @Test
    public void testIteratorWithoutCondition(){
        MyListImpl<String> l = new MyListImpl<>();
        l.add("1");
        l.add("2222");
        l.add("22");
        l.add(null);

        String actual = "";
        String expected = "1 2222 22 null";
        for (String st :l) {
            actual += st + " ";
        }

        Assert.assertEquals(expected, actual.trim());
    }

    @Test
    public void testIteratorWithLengthCondition(){
        MyListImpl<String> l = new MyListImpl<>();
        l.add("1");
        l.add("2222");
        l.add("22");
        l.add(null);

        String actual = "";
        String expected = "1 2222 22 null";
        l.setCondition(t -> t!= null && t.length() > 1);
        for (String st :l) {
            actual += st + " ";
        }

        Assert.assertEquals(expected, actual.trim());
    }

    @Test
    public void testIteratorWithContainsCondition(){
        MyListImpl<String> l = new MyListImpl<>();
        l.add("1");
        l.add("2222");
        l.add("22");
        l.add(null);

        String actual = "";
        String expected = "2222 22";
        Predicate<String> predicate = t -> t!= null && t.contains("2");
        Iterator<String> it = l.iterator(predicate);
        while (it.hasNext()){
            actual += it.next()+" ";
        }

        Assert.assertEquals(expected, actual.trim());
    }

    @Test
    public void testIteratorWithPriceCondition(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        int actual = 0;
        int expected = 2;

        Predicate<SellableProduct> predicate = t -> t!=null && t.getPrice() > 0;
        Iterator<SellableProduct> it = list.iterator(predicate);
        while (it.hasNext()){
            it.next();
            actual++;
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSize(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        int actual = list.size();
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsEmptyIfIsNotEmpty(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        boolean actual = list.isEmpty();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testIsEmptyIfIsEmpty(){
        boolean actual = list.isEmpty();
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToArrayToObjects(){
        MyListImpl<String> l = new MyListImpl<>();
        l.add("1");
        l.add("2222");
        l.add("22");
        l.add(null);

        Object[] mas = l.toArray();
        boolean actual = mas instanceof Object[];
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToArrayWithParamToStrings(){
        MyListImpl<String> l = new MyListImpl<>();
        l.add("1");
        l.add("2222");
        l.add("22");
        l.add(null);

        boolean actual = l.toArray(new String[]{}) instanceof String[];
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToArrayWithParamToObjects(){
        MyListImpl<String> l = new MyListImpl<>();
        l.add("1");
        l.add("2222");
        l.add("22");
        l.add(null);

        boolean actual = l.toArray(new Object[]{}) instanceof Object[];
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToArrayWithParamToT(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Appliance[] arr = list.toArray(new Appliance[]{});

        Assert.assertNotNull(arr);
        Assert.assertEquals(true, arr.length > 0);
        boolean actual = arr instanceof Appliance[];
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToArrayCheck2Objs(){
        MyListImpl<String> l = new MyListImpl<>();
        l.add("1");
        l.add("2222");
        l.add("22");
        l.add(null);

        Object[] objs1 = {"1","2222","22",null};
        Object[] objs2 = l.toArray();

        Assert.assertArrayEquals(objs1, objs2);
    }

    @Test
    public void testToArrayCheck2ObjsType(){
        MyListImpl<String> l = new MyListImpl<>();
        l.add("1");
        l.add("2222");
        l.add("22");
        l.add(null);

        Object[] objs1 = {"1","2222","22",null};
        Object[] objs2 = l.toArray();

        Assert.assertEquals(objs1.getClass(), objs2.getClass());
    }

    @Test
    public void testToArrayWithParCheck2ObjsType(){
        MyListImpl<String> l = new MyListImpl<>();
        l.add("1");
        l.add("2222");
        l.add("22");
        l.add(null);

        Object[] objs1 = {"1","2222","22",null};
        Object[] objs2 = l.toArray(objs1);

        Assert.assertEquals(objs1.getClass(), objs2.getClass());
    }
    @Test
    public void testToArrayWithParCheck2StringsType(){
        MyListImpl<String> l = new MyListImpl<>();
        l.add("1");
        l.add("2222");
        l.add("22");
        l.add(null);

        Object[] objs2 = l.toArray();

        Assert.assertEquals(Object[].class, objs2.getClass());
    }

    @Test
    public void testToArrayWithParCheck2StringsType2(){
        MyListImpl<String> l = new MyListImpl<>();
        l.add("1");
        l.add("2222");
        l.add("22");
        l.add(null);

        String[] objs1 = {"1","2222","22",null};
        String[] objs2 = l.toArray(objs1);

        Assert.assertEquals(String[].class, objs2.getClass());
    }

    @Test
    public void testToArrayWithParamToUncastType(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(product);
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Fridge[] arr = list.toArray(new Fridge[]{});
        Assert.assertNull(arr);

        boolean actual = arr instanceof Fridge[];
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSet(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        SellableProduct retVal = list.set(1, product);

        Assert.assertNull(retVal);
        Assert.assertEquals(product, list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetInOutOfBoundPosition(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        SellableProduct retVal = list.set(6, product);
    }

    @Test
    public void testSetInFirstPosition(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        SellableProduct retVal = list.set(0, product);

        Assert.assertNotNull(retVal);
        Assert.assertEquals(product, list.get(0));
    }

    @Test
    public void testIndexOf(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        int actual = list.indexOf(null);

        Assert.assertEquals(1,actual);
    }

    @Test
    public void testIndexOfOutOfBoundPosition(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        int actual = list.indexOf(new SmartWatch());

        Assert.assertEquals(-1,actual);
    }

    @Test
    public void testLastIndexOf(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        int actual = list.lastIndexOf(null);

        Assert.assertEquals(3,actual);
    }

    @Test
    public void testLastIndexOfOutOfBoundPosition(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        int actual = list.lastIndexOf(new SmartWatch());

        Assert.assertEquals(-1,actual);
    }

    @Test
    public void testLastIndexOfFirstPosition(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        int actual = list.lastIndexOf(new Fridge());

        Assert.assertEquals(0,actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testListIterator(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        ListIterator<SellableProduct> listIterator = list.listIterator();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testListIteratorWithParam(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        ListIterator<SellableProduct> listIterator = list.listIterator(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSubList(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        List<SellableProduct> l = list.subList(0,1);
    }

    @Test
    public void testIteratorRemove(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Iterator<SellableProduct> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next() == null){
                iterator.remove();
            }
        }

        Assert.assertEquals(3, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testIteratorRemoveWithoutNext(){
        SellableProduct product = new Fridge();
        product.setPrice(10);
        this.list.add(new Fridge());
        this.list.add(null);
        this.list.add(new Conditioner());
        this.list.add(null);
        this.list.add(product);

        Iterator<SellableProduct> iterator = list.iterator();
        while (iterator.hasNext()){
           iterator.remove();
        }

        Assert.assertEquals(3, list.size());
    }

}
