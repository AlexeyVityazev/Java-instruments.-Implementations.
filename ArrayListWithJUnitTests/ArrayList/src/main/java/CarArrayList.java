import java.util.Arrays;

public class CarArrayList implements CarList {
    private Car[] carsArray = new Car[10];
    private int size;


    public void add(Car car) {//Сложность алгоритма О(1). Алгоритм выполняется каждый раз за одно и то же время.
        increaseArray();
        carsArray[size] = car;
        size++;
    }

    public void add(Car car, int index) { //Сложность алгоритма O(N). Время выполнения алгоритма зависит от кол-ва элементов в массиве.
        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(carsArray, index, carsArray, index + 1, size - index);
        carsArray[index] = car;
        size++;
    }

    public Car get(int index) {
        checkIndex(index);
        return carsArray[index];
    }

    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (carsArray[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(carsArray, index + 1, carsArray, index, size - index - 1);
        size--;
        return true;
    }


    public int size() {
        return size;
    }

    public void clear() {
        carsArray = new Car[10];
        size = 0;

    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void increaseArray() {
        if (size >= carsArray.length) {
            carsArray = Arrays.copyOf(carsArray, carsArray.length * 2);
        }
    }


}
