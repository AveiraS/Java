package Factory;

import Table.TableWithNightstand;
import Table.components.Legs;
import Table.components.Nightstand;
import Table.components.Top;

public class TableNightstandFactory implements TableFactory{
    @Override
    public TableWithNightstand makeTable() {
        return new TableWithNightstand(new Legs(4), new Top(), new Nightstand());
    }
}
