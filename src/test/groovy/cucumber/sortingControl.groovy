package  com.david.project1

import cucumber.api.DataTable
import cucumber.api.groovy.*
import org.mockito.Mockito
import static org.junit.Assert.*

this.metaClass.mixin(EN);
this.metaClass.mixin(Hooks);

Exception e;
Storage storage = Mockito.mock(Storage.class);
SortedListController control = new SortedListController(storage);

When(~'Invalid List') { DataTable table->
List<Integer> invalid = table.asList(Integer);
    try {
        SortedList input = new SortedList("select", invalid);
        control.acceptList(input);
    } catch (Exception exception) {
        e = exception;
    }
}

Then(~'expect exception'){   ->
    System.out.println(e);
    assertNotNull(e);
    control.clear()
    System.out.println(control.entireSortedList());
}