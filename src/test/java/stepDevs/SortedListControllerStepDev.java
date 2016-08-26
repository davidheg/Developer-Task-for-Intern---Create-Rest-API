
package stepDevs;

import com.david.project1.SortedList;
import com.david.project1.SortedListController;
import com.david.project1.Storage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class SortedListControllerStepDev {

    public Exception e;
    Storage storage = Mockito.mock(Storage.class);
    SortedListController control = new SortedListController(storage);

    @When("Invalid List")
    public void invalidList(List<Integer> invalid) {
        try {
            invalid = new ArrayList<>(invalid);
            SortedList input = new SortedList("select", invalid);
            control.acceptList(input);
        } catch (Exception exception) {
            e = exception;
        }
    }

    @Then("expect exception")
    public void it_fails() {
        System.out.println(e +"\n");
        assertNotNull(e);
    }
}

