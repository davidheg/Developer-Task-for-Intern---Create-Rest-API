package com.david.project1;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Integer> storedResults = new ArrayList<>();

    public void store(List<Integer> newValues){
        if(newValues  != null) {
            if (newValues.size() != 0) {
                //storedResults.addAll(newValues);
                for (int i = 0; i < newValues.size(); i++) {
                    if (storedResults.size() > 0) {
                        int current = newValues.get(i);
                        int j = 0;
                        boolean place = false;
                        while (!place && j < storedResults.size()) {
                            if (current <= storedResults.get(j)) {
                                storedResults.add(j, current);
                                place = true;
                            }
                            j++;
                        }
                        if (!place) {
                            storedResults.add(current);
                        }
                    } else {
                        storedResults.add(newValues.get(i));
                    }
                }
            }
        }
    }
    public List<Integer> returnList() {
        return storedResults;
    }

}

