package  com.david.project1

import cucumber.api.DataTable
import cucumber.api.groovy.*
import cucumber.api.groovy.EN
import  cucumber.api.groovy.Hooks

import static org.junit.Assert.assertEquals

Storage store = new Storage();
this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

Given(~'Storage contains a list'){ DataTable table->
    List<Integer> storageContains = table.asList(Integer);
    storageContains = new ArrayList<>(storageContains);
    store.setStorage(storageContains);
}

And(~'a list is added') { DataTable table ->
    List<Integer> wildCard =  table.asList(Integer);
    wildCard = new ArrayList<>(wildCard);
    store.store("insert",wildCard);
}

Then (~'return a sorted list'){ DataTable table ->
    ArrayList<Integer> expected =  table.asList(Integer);
    assertEquals(expected,store.returnList());
    store.clearStorage()
}
Given(~'Multiple lists') { DataTable table ->
    List<List<Integer>> lists = table.asLists(Integer);
    for (List<Integer> current : lists) {
        current = new ArrayList<>(current);
        store.store("merge", current);
    }
}
When(~'(.+) sort method') { String sort, DataTable table ->
    ArrayList<Integer> input = table.asList(Integer);
    store.store(sort,input);
}