
package com.david.project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.List;

@EnableWebMvc
@RestController("/sortedLists")
public class SortedListController {

    private Storage storage;

    @Autowired
    public SortedListController(Storage storage) {
        this.storage = storage;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void acceptList(@RequestBody SortedList list) throws IOException {
        List<Integer> sortedListOfNumbers = list.getList();
        if (sortedListOfNumbers == null) {
            throw new IllegalArgumentException("Does not accept null values");
        }
        if (sortedListOfNumbers.size() != 0) {
            int prev = sortedListOfNumbers.get(0);
            for (Integer sortedListOfNumber : sortedListOfNumbers.subList(1, sortedListOfNumbers.size())) {
                if (sortedListOfNumber < prev) {
                    throw new UnSortedException("This list is not sorted");
                } else {
                    prev = sortedListOfNumber;
                }
            }
            storage.store(list.getSort(),sortedListOfNumbers);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Integer> entireSortedList(){
        return storage.returnList();
    }
    public void clear(){storage.clearStorage();}

    @ExceptionHandler(UnSortedException.class)
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), "Please try again with a sorted list");
    }

}


