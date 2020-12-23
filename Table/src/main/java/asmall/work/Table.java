package asmall.work;

public class Table {
    private String tableTop;
    private Integer tableLegs;

    public Table() {
        this.tableLegs = 4;
        this.tableTop = "square";
    }

    public Table(Integer tableLegs, String tableTop) {
        this.tableLegs = tableLegs;
        this.tableTop = tableTop;
    }

    private void setTableLegs(Integer tableLegs) {
        this.tableLegs = tableLegs;
    }

    private void setTableTop(String tableTop) {
        this.tableTop = tableTop;
    }

    public Integer getTableLegs() {
        return tableLegs;
    }

    public String getTableTop() {
        return tableTop;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableTop='" + tableTop + '\'' +
                ", tableLegs=" + tableLegs +
                '}';
    }
}

