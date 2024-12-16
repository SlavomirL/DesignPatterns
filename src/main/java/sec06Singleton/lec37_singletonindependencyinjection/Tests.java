package sec06Singleton.lec37_singletonindependencyinjection;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {


    @Test
    public void dependentPopulatioNTest() {
        DummyDatabase db = new DummyDatabase();
        ConfigurableRecordFinder crf = new ConfigurableRecordFinder(db);
        assertEquals(4, crf.getTotalPopulation(
                List.of("alpha", "gamma")
        ));
    }
}
