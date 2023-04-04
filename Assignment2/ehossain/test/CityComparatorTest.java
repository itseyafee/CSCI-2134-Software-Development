import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityComparatorTest {

  @Test
  void compare() {
    City city1 = new City("Halifax");
    City city2 = new City("Dartmouth");
    City city3 = new City("Saint John");

    city1.distance = 10;
    city2.distance = 20;
    city3.distance = 30;

    CityComparator city=new CityComparator();

    assertEquals(-10,city.compare(city1,city2),"Wrong distance returned");

    assertTrue(city.compare(city3,city1) > 0, "Wrong distance returned");
    assertTrue(city.compare(city2,city2) == 0,"Wrong distance returned");
  }
}