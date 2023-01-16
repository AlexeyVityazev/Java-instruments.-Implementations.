import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {
    CarList carList;

    @Before
    public void setUp() throws Exception {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand " + i, i));
        }
    }
    @Test
    public void whenAdded100ElementThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }
    @Test
    public void methodGetReturnedRightValue() {
        Car car = new Car("Mercedes", 10);
        carList.add(car);
        assertEquals(car, carList.get(100));
    }
    @Test
    public void whenRemoveCarReturnTrueAndSizeDecreased() {
        Car car = new Car("Volvo", 4);
        carList.add(car);
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }
    @Test
    public void whenRemoveCarByIndexReturnTrueAndSizeDecreased() {
        Car car = new Car("Volvo", 4);
        carList.add(car);
        assertTrue(carList.removeAt(4));
        assertEquals(100, carList.size());

    }
    @Test
    public void sizeMustBe100() {
        assertEquals(100, carList.size());
    }
    @Test
    public void whenClearSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        carList.get(100);
    }
}
