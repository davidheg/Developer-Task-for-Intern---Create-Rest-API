package stepDevs;

import com.david.project1.Storage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class storageStepDev {

    Storage store = new Storage();

    @Given("Storage contains a list")
    public void setList(List<Integer> storageContains){
        storageContains = new ArrayList<>(storageContains);
        store.setStorage(storageContains);
    }
    @Given("Multiple lists")
    public void multipleLists(List<List<Integer>> lists){
        for (List<Integer> current : lists) {
            current = new ArrayList<>(current);
            store.store("merge", current);
        }
    }
    @And("a list is added")
    public void acceptingWildCard(List<Integer> wildCard) {
        wildCard = new ArrayList<>(wildCard);
        store.store("insert",wildCard);
    }

    @Then("return a sorted list")
    public void returnWildCard(List<Integer> expected){
        expected = new ArrayList<>(expected);
        assertEquals(expected,store.returnList());
    }
    @And("(.+) sort method")
    public void testSort(String sort, List<Integer> input){
        store.store(sort,input);
    }

}
