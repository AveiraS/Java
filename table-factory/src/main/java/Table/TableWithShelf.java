package Table;

import Table.components.Legs;
import Table.components.Shelf;
import Table.components.Top;

import static Table.TableType.TABLE_WITH_SHELF;

public class TableWithShelf implements Table {
    private final TableType tableType;
    private final Legs leg;
    private final Top top;
    private final Shelf shelf;

    /**
     * Создаёт объект класса TableWithShelf
     * tableType TABLE_WITH_SHELF - должны быть переданы аргументы Leg, Top, Shelf
     *
     * @param leg не может быть null, экземпляр Leg
     * @param top не может быть null, экземпляр Top
     * @param shelf не может быть null, экземпляр Shelf
     * @throws IllegalArgumentException
     */
    public TableWithShelf(Legs leg, Top top, Shelf shelf)
            throws IllegalArgumentException {
        if (top == null)
            throw new IllegalArgumentException("Передан пустой объект Top");
        if (leg == null)
            throw new IllegalArgumentException("Передан пустой объект Legs");
        if (shelf == null)
            throw new IllegalArgumentException("Передан пустой объект Shelf");
        this.tableType = TABLE_WITH_SHELF;
        this.leg = leg;
        this.top = top;
        this.shelf = shelf;
    }

    @Override
    public TableType getTableType() {
        return tableType;
    }

    public Legs getLeg() {
        return leg;
    }

    public Top getTop() {
        return top;
    }

    public Shelf getShelf() {
        return shelf;
    }
}
