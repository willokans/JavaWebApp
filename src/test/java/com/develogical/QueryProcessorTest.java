package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void whatIsYourNameToReturnSomething() {
        assertThat(queryProcessor.process("what is your name"), containsString("Something!"));
    }

    @Test
    public void whichOfTheNumberIsTheLargest(){
        assertThat(queryProcessor.process("cf764c60: which of the following numbers is the largest: 857, 23, 80, 1000"), containsString("1000"));
    }

    @Test
    public void whatIsTheSum(){
        assertThat(queryProcessor.process("e2cc7c00: What is 10 plus 8"), containsString("18"));
    }


}
