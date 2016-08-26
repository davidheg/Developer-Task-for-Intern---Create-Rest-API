
package com.david.project1;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Storage {

    enum sortingAlgorithms{
        select,
        insert,
        merge,
        naive
    }
    private List<Integer> storedResults = new ArrayList<>();

    public void store(String sortingMethod,List<Integer> newValues) {
        if (newValues == null) {
            throw new IllegalArgumentException("storage does not support null lists.");
        }
        storedResults.addAll(newValues);
        switch (sortingAlgorithms.valueOf(sortingMethod)) {
            case insert:
                insertSort();
                break;
            case merge:
                mergeSort();
                break;
            case select:
                selectionSort();
                break;
            case naive:
                naiveSort();
        }
    }

    public List<Integer> returnList() {
        return storedResults;
    }
    public void setStorage(List<Integer> set) {
        storedResults = set;
    }
    public void clearStorage(){ storedResults = new ArrayList<>(Arrays.asList());}
    public void naiveSort() {
        for (int i = 0; i < storedResults.size(); i++) {
            boolean swapped = false;
            for (int j = 0; j < storedResults.size() - 1; j++) {
                if (storedResults.get(j) > storedResults.get(j + 1)) {
                    int temp = storedResults.get(j + 1);
                    storedResults.set(j + 1, storedResults.get(j));
                    storedResults.set(j, temp);
                    swapped = true;
                }
                if (!swapped) {
                    break;
                }
            }
        }
    }

    public void insertSort(){
        for (int i = 0; i < storedResults.size(); i ++) {
            int current = storedResults.get(i);
            int j = i;
            while (j > 0 && storedResults.get(j - 1) > current) {
                storedResults.set(j,storedResults.get(j - 1));
                j --;
            }
            storedResults.set(j, current);
        }
    }

    public void selectionSort() {
        for (int i = 0; i < storedResults.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < storedResults.size(); j++) {
                if (storedResults.get(j) < storedResults.get(min)) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = storedResults.get(i);
                storedResults.set(i, storedResults.get(min));
                storedResults.set(min, temp);
            }
        }
    }

    public void mergeSort() {
        storedResults = merge(storedResults);
    }

    public List<Integer> merge( List<Integer> mergeList){
        if(mergeList.size() ==1) {
            return mergeList;
        }else{
            List<Integer> left = mergeList.subList(0,mergeList.size()/2);
            List<Integer> right = mergeList.subList(mergeList.size()/2,mergeList.size());

            left = merge(left);
            right = merge(right);
            List <Integer> merged = new ArrayList<>();

            int i= 0;
            int j = 0;
            int k = 0;

            while (i < left.size() && j < right.size()) {
                if ( (left.get(i).compareTo(right.get(j))) < 0) {
                    merged.add(k, left.get(i));
                    i++;
                } else {
                    merged.add(k, right.get(j));
                    j++;
                }
                k++;
            }

            List<Integer> rest;
            int restIndex;
            if (i >= left.size()) {
                rest = right;
                restIndex = j;
            } else {
                rest = left;
                restIndex = i;
            }

            for (int l=restIndex; l<rest.size(); l++) {
                merged.add(k, rest.get(l));
                k++;
            }
            return merged;
        }
    }
}
