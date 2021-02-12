import Factory.TableFactory;
import Factory.TableNightstandFactory;
import Factory.TableShelfFactory;

public class Main {
    public static void main(String[] args) {
        TableFactory table = new TableNightstandFactory();
        TableFactory table1 = new TableShelfFactory();

        System.out.println(table.makeTable().getTableType());
        System.out.println(table1.makeTable().getTableType());
    }
}
