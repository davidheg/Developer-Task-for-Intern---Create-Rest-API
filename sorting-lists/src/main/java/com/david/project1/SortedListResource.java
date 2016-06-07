package com.david.project1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.PostConstruct;
import java.util.List;

public class SortedListResource {

    private Storage storage;


    SortedListResource(Storage storage) {
        this.storage = storage;
    }
    @RequestMapping(method = RequestMethod.POST)
    public void acceptList(List<Integer> sortedListOfNumbers) {
        if (sortedListOfNumbers != null) {
            if (sortedListOfNumbers.size() != 0) {
                int prev = sortedListOfNumbers.get(0);
                for (Integer sortedListOfNumber : sortedListOfNumbers.subList(1, sortedListOfNumbers.size())) {
                    if (sortedListOfNumber < prev) {
                        throw new UnSortedException("This list is not sorted");
                    } else {
                        prev = sortedListOfNumber;
                    }
                }
                storage.store(sortedListOfNumbers);
            }
        }
    }
    public List<Integer> returnSingleSortedList() {
        return storage.returnList();
    }

}
