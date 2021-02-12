package Factory;

import Table.TableWithShelf;
import Table.components.Legs;
import Table.components.Shelf;
import Table.components.Top;


public class TableShelfFactory implements TableFactory{
    @Override
    public TableWithShelf makeTable() {
        return new TableWithShelf(new Legs(4), new Top(), new Shelf());
    }
}
