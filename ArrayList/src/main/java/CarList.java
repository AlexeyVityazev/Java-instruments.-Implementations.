public interface CarList {
    void add(Car car);

    void add(Car car, int index);

    Car get(int index);

    boolean remove(Car car);

    boolean removeAt(int index);

    int size();

    void clear();
}
