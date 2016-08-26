package com.david.project1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SortedList {

    public List<Integer> sortedList;
    public String sortMethod;

    public SortedList(String sortMethod, List<Integer> sortedList){
        this.sortedList = sortedList;
        this.sortMethod = sortMethod;
    }

    public SortedList(){
    }

    public List<Integer> getList() {
        return this.sortedList;
    }
    public String getSort() {
        return this.sortMethod;
    }
    public void setSortedList(List<Integer> sortedList) {
        this.sortedList = sortedList;
    }
    public void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }
}
