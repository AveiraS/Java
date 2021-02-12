package Table;

import Table.components.Legs;
import Table.components.Nightstand;
import Table.components.Top;

import static Table.TableType.TABLE_WITH_NIGHTSTAND;

public class TableWithNightstand implements Table {
    private final TableType tableType;
    private final Legs leg;
    private final Top top;
    private final Nightstand nightstand;


    /**
     * Создаёт объект класса TableWithNightstand
     * tableType TABLE_WITH_NIGHTSTAND - должны быть переданы аргументы Leg, Top, Nightstand
     *
     * @param leg не может быть null, экземпляр Leg
     * @param top не может быть null, экземпляр Top
     * @param nightstand не может быть null, экземпляр Nightstand
     * @throws IllegalArgumentException
     */
    public TableWithNightstand(Legs leg, Top top, Nightstand nightstand)
            throws IllegalArgumentException {
        if (top == null)
            throw new IllegalArgumentException("Передан пустой объект Top");
        if (leg == null)
            throw new IllegalArgumentException("Передан пустой объект Legs");
        if (nightstand == null)
            throw new IllegalArgumentException("Передан пустой объект Nightstand");
        this.tableType = TABLE_WITH_NIGHTSTAND;
        this.leg = leg;
        this.top = top;
        this.nightstand = nightstand;
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

    public Nightstand getNightstand() {
        return nightstand;
    }
}
