package ru.job4j.chapter_005.DDD;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RulesTest {
    @Test
    public void getRulesForGame() {
        Rules rule = new RuleTicTacToe();
        String ruleTTT = rule.getRules();
        assertThat(ruleTTT, is("Some Rules..."));
    }
}