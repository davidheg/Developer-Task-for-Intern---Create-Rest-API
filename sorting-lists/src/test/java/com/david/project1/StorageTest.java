package com.david.project1;

import org.junit.*;
import java.util.List;
import java.util.ArrayList;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StorageTest {

    Storage st = new Storage();

    @Test
    public void NullList(){
        List<Integer> expectedOutput = null;
        st.store(expectedOutput);
    }
    @Test
    public void EmptyList(){
        List<Integer> expectedOutput = new ArrayList<>();
        st.store(expectedOutput);
    }
    @Test
    public void SingleElement(){
        List<Integer> expectedOutput = new ArrayList<>();
        expectedOutput.add(9);
        st.store(expectedOutput);
    }
    @Test
    public void AreListsStored(){
        List<Integer> expectedOutput = new ArrayList<>();
        expectedOutput.add(3);
        expectedOutput.add(120);
        st.store(expectedOutput);
        assertEquals(expectedOutput, st.returnList());
    }
    @Test
    public void AreListsStoredCorrectly(){
        List<Integer> expectedOutput = new ArrayList<>();
        expectedOutput.add(4);
        expectedOutput.add(120);
        st.store(Arrays.asList(3, 120));
        assertNotEquals(expectedOutput, st.returnList());
    }
}
