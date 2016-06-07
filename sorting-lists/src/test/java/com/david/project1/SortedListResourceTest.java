package com.david.project1;

import org.junit.*;

import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class SortedListResourceTest {

    Storage storage = Mockito.mock(Storage.class);
    SortedListResource test = new SortedListResource(storage);

    @Test
    public void CreateList(){
        assertNotNull(test);
    }

    @Test(expected = NullPointerException.class)
    public void CreateListWithVoidStorage(){
        SortedListResource VoidTest = new SortedListResource(null);
        VoidTest.acceptList(Arrays.asList(2,5,12));
    }

    @Test
    public void NullList(){
        List<Integer> sortedListOfNumbers = null;
        test.acceptList(sortedListOfNumbers);
        Mockito.verify(storage,Mockito.never()).store(Mockito.anyList());

    }
    @Test
    public void EmptyList(){
        List<Integer> sortedListOfNumbers = Arrays.asList();
        test.acceptList(sortedListOfNumbers);
        Mockito.verify(storage,Mockito.never()).store(Mockito.anyList());
    }
    @Test
    public void SingleElement(){
        List<Integer> sortedListOfNumbers = Arrays.asList(9);
        test.acceptList(sortedListOfNumbers);
        Mockito.verify(storage,Mockito.times(1)).store(Mockito.anyList());
    }

    @Test(expected = Exception.class)
    public void sortedListFailsWhenListIsNotSorted() {
        List<Integer> sortedListOfNumbers = Arrays.asList(120, 3);
        test.acceptList(sortedListOfNumbers);
    }

    @Test
    public void sortedListPassesWhenListIsSorted() {
        List<Integer> sortedListOfNumbers = Arrays.asList(1, 1, 3, 5, 9, 10);
        test.acceptList(sortedListOfNumbers);
        List<Integer> sortedListOfNumbers2 = Arrays.asList(1, 2, 6, 7, 7, 11);
        test.acceptList(sortedListOfNumbers2);
        Mockito.verify(storage,Mockito.times(2)).store(Mockito.anyList());
    }
    @Test
    public void LargeSortedLists() {
        List<Integer> sortedListOfNumbers = Arrays.asList(100, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111,
                112, 113, 114, 115, 116, 117, 118,119);
        test.acceptList(sortedListOfNumbers);
        List<Integer> sortedListOfNumbers2 = Arrays.asList(300,301,302,305,1000,1001);
        test.acceptList(sortedListOfNumbers2);
        Mockito.verify(storage,Mockito.times(2)).store(Mockito.anyList());
    }


}