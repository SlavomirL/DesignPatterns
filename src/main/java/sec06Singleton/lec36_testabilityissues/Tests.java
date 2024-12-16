package sec06Singleton.lec36_testabilityissues;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {

    // problem with this test is that it tests against the real database (in this case file)
    @Test // this is in fact an integration test, not a unit test
    public void singletonTotalPopulationTest() {
        SingletonRecordFinder rf = new SingletonRecordFinder();
        List<String> names = List.of("Seoul", "Mexico City");
        int tp = rf.getTotalPopulation(names);
        assertEquals(17500000+17400000, tp);
    }

}
