package com.david.project1;

import org.junit.*;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.Arrays;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;



public class SortedListResourceTest {

    Storage storage = Mockito.mock(Storage.class);
    SortedListController test = new SortedListController(storage);

    @Test
    public void CreateList(){
       assertNotNull(test);
    }

    @Test(expected = NullPointerException.class)
    public void CreateListWithVoidStorage() throws IOException {
        SortedListController VoidTest = new SortedListController(null);
        SortedList sortedListOfNumbers = new SortedList("naive",Arrays.asList(3,25,49,65));
        VoidTest.acceptList(sortedListOfNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void NullList() throws IOException {
        SortedList sortedListOfNumbers = new SortedList();
        test.acceptList(sortedListOfNumbers);
        Mockito.verify(storage,Mockito.never()).store( eq(sortedListOfNumbers.getSort()),Mockito.anyList());

   }
    @Test
    public void EmptyList() throws IOException {
        SortedList sortedListOfNumbers = new SortedList("insert",Arrays.asList());
        test.acceptList(sortedListOfNumbers);
        Mockito.verify(storage,Mockito.never()).store(eq(sortedListOfNumbers.getSort()),Mockito.anyList());
    }

    @Test
    public void SingleElement() throws IOException {
        SortedList sortedListOfNumbers = new SortedList("select",Arrays.asList(9));
        test.acceptList(sortedListOfNumbers);
        Mockito.verify(storage,Mockito.times(1)).store(eq(sortedListOfNumbers.getSort()),Mockito.anyList());
    }

    @Test(expected = Exception.class)
    public void sortedListFailsWhenListIsNotSorted() throws IOException {
        SortedList sortedListOfNumbers = new SortedList("merge", Arrays.asList(120, 3));
        test.acceptList(sortedListOfNumbers);
    }

    @Test
    public void sortedListPassesWhenListIsSorted() throws IOException {
        SortedList sortedListOfNumbers = new SortedList("select",Arrays.asList(1, 3, 5, 9, 10));
        test.acceptList(sortedListOfNumbers);
        SortedList sortedListOfNumbers2 = new SortedList("select",Arrays.asList(1, 2, 6, 7, 7, 11));
        test.acceptList(sortedListOfNumbers2);
        Mockito.verify(storage,Mockito.times(2)).store(eq("select"),Mockito.anyList());
    }
    @Test
    public void LargeSortedLists() throws IOException {
        SortedList sortedListOfNumbers =new SortedList("merge",Arrays.asList(100, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111,
                112, 113, 114, 115, 116, 117, 118,119) );
        test.acceptList(sortedListOfNumbers);
        SortedList sortedListOfNumbers2 =new SortedList("merge", Arrays.asList(300,301,302,305,1000,1001));
        test.acceptList(sortedListOfNumbers2);
        Mockito.verify(storage,Mockito.times(2)).store(eq("merge"),Mockito.anyList());
    }
}
