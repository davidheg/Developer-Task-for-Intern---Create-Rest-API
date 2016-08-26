package com.david.project1;

import org.junit.*;
import java.util.List;
import java.util.ArrayList;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StorageTest {

    Storage st = new Storage();
    @Test
    public void doesNaiveSortWork(){
        st.store("naive",Arrays.asList(3,2,1));
        assertEquals(Arrays.asList(1,2,3),st.returnList());
    }
    @Test
    public void doesInsertSortWork(){
        st.store("insert",Arrays.asList(5,12,9,18,26));
        assertEquals(Arrays.asList(5,9,12,18,26),st.returnList());
    }
    @Test
    public void doesMergeSortWork(){
        st.store("merge",Arrays.asList(1,3,5,6));
        st.store("merge",Arrays.asList(2,4,7,9));
        assertEquals(Arrays.asList(1,2,3,4,5,6,7,9),st.returnList());
    }
    @Test
    public void doesSelectSortWork(){
        st.store("select",Arrays.asList(13,17,20,15,19,30));
        assertEquals(Arrays.asList(13,15,17,19,20,30),st.returnList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void NullList(){
        List<Integer> expectedOutput = null;
        st.store("naive",expectedOutput);
    }
    @Test
    public void EmptyList(){
        List<Integer> expectedOutput = new ArrayList<>();
        st.store("insert",expectedOutput);
    }
    @Test
    public void SingleElement(){
        List<Integer> expectedOutput = new ArrayList<>();
        expectedOutput.add(9);
        st.store("merge",expectedOutput);
        assertEquals(expectedOutput,st.returnList());
    }
    @Test
    public void AreListsStored(){
        List<Integer> expectedOutput = new ArrayList<>();
        expectedOutput.add(3);
        expectedOutput.add(120);
        st.store("select",expectedOutput);
        assertEquals(expectedOutput, st.returnList());
    }
    @Test
    public void AreListsStoredCorrectly(){
        List<Integer> expectedOutput = new ArrayList<>();
        expectedOutput.add(4);
        expectedOutput.add(120);
        st.store("naive",Arrays.asList(3, 120));
        assertNotEquals(expectedOutput, st.returnList());
    }


}
