package asmall.work;

public class TestTable {
    public static void main(String[] args) {
        Table table1 = new Table();
        Table table2 = new Table(4, "circle");

        System.out.println(table1.toString());
        System.out.println(table2.toString());
    }
}
