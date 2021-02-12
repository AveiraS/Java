package Table.components;

public class Legs {
    private int count;
    private final int weight = 1;

    public Legs(int count) {
        if (count <= 0)
            throw new IllegalArgumentException("Количество ножек не может быть отрицательным или нулевым");
        this.count = count;
    }
}
