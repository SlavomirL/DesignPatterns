package sec06Singleton.lec37_singletonindependencyinjection;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

// we are introducing atraction here
interface Database {
    int getPopulation(String name);
}

/*
class SingletonDatabase implements Database {

    private Dictionary<String, Integer> capitals = new Hashtable<>();
    private static int instanceCount = 0;

    private static final SingletonDatabase INSTANCE = new SingletonDatabase();

    private SingletonDatabase() {
        instanceCount++;
        System.out.println("Initializing database");

        try {
            File f = new File(SingletonDatabase.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            System.out.println(f.getPath());
            Path fullPath = Paths.get(f.getPath(), "capitals.txt");
            List<String> lines = Files.readAllLines(fullPath);

            partition(lines, 2)
                    .forEach(kv -> capitals.put(
                            kv.get(0).trim(),
                            Integer.parseInt(kv.get(1))
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SingletonDatabase getInstance() {
        return INSTANCE;
    }

    public static int getCount() {
        return instanceCount;
    }

    public int getPopulation(String name) {
        return capitals.get(name);
    }


// Utility method in SingletonDatabase -
//quick&dirty partition without library and file load from project directory
// tuto metodu tu mam preto ze typek pouzival Iterables.partition ale Iterables som nevedel stiahnut a pouzit
        private List<List<String>> partition(List<String> list, int partSize)
    throws IllegalArgumentException {
            if (list.size() % partSize != 0) {
                throw new IllegalArgumentException("List must be a multiple of partSize");
            }
            int runner = 0;
            List<List<String>> res = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            for (String s : list) {
                temp.add(s);
                runner++;
                if (runner == partSize) {
                    res.add(temp);
                    temp = new ArrayList<>();
                    runner = 0;
                }
            }
            return res;
    }
}
*/

//
//class SingletonRecordFinder {
//    public int getTotalPopulation(List<String> names) {
//        int result = 0;
//        for(String name : names) {
//            result += SingletonDatabase.getInstance().getPopulation(name);
//        }
//        return result;
//    }
//}

// we are introducing abstraction here
class ConfigurableRecordFinder {
    private Database database;

    public ConfigurableRecordFinder(Database database) {
        this.database = database;
    }

    public int getTotalPopulation(List<String> names) {
        int result = 0;
        for(String name : names) {
            result += database.getPopulation(name);
        }
        return result;
    }
}

class DummyDatabase implements Database {

    private Dictionary<String, Integer> dummyData = new Hashtable<>();

    public DummyDatabase() {
        dummyData.put("alpha", 1);
        dummyData.put("beta", 2);
        dummyData.put("gamma", 3);
    }

    @Override
    public int getPopulation(String name) {
        return dummyData.get(name);
    }
}


