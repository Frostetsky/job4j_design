package ru.job4j.chapter_001.sort;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class DepartmentsTest {
    @Test
    public void whenDescendingSort() {
        Department departments = new Department();
        departments.addDep("K1\\SK1\\SSK2");
        departments.addDep("K2\\SK1\\SSK2");
        departments.addDep("K3");

        departments.descSort();

        StringBuilder firstAndLast = new StringBuilder();
        departments.getDepartments().keySet().forEach(firstAndLast::append);

        Assert.assertThat(firstAndLast.toString(), Is.is("K3K2K1"));
    }

    @Test
    public void whenDescendingSortMore() {
        Department departments = new Department();
        departments.addDep("K2\\SK1\\SSK2");
        departments.addDep("K1\\SK1\\SSK2");
        departments.addDep("K1\\SK2\\SSK1");
        departments.addDep("K3\\SK2");

        departments.descSort();


        TreeSet<String> k1Dep = departments.getDepartments().get("K1");
        Assert.assertThat(k1Dep, Is.is(Set.of("K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK2", "K1\\SK2\\SSK1")));
    }
}