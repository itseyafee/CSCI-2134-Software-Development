import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {
  HashSet<Link> linkset = new HashSet<Link>();
  public static City city1= new City("Halifax");
  public static  City city2= new City("Dartmouth");

  City city3= new City("Saint John");
  City city4= new City("Toronto");
  City city5= new City("Niagra");

  Link link1= new Link(city1,city2,10);
  Link link2= new Link(city2,city5,20);
  Link link3= new Link(city1,city3,30);
  Link link4= new Link(city3,city4,40);
  Link link5= new Link(city4,city5,50);
  Link link6= new Link(city4,city2,60);

  @Test
  void find() {
    City halifax = new City("Halifax");
    City.cities.put("Halifax", halifax);

    City foundCity = City.find("Halifax");
    assertEquals(halifax, foundCity);

    City notFoundCity = City.find("Dartmouth");
    assertNull(notFoundCity);
  }

  @Test
  void addLink() {
    city1.addLink(link1);
    city1.addLink(link2);
    assertTrue(city1.links.contains(link1), "Link has not been made successfully");
    assertTrue(city1.links.contains(link2), "Link has not been made successfully");
  }

  @Test
  void compareTo() {
    //Error Detected
    //In the Java  compare method is comparing the same values.

    int compare1 = city3.compareTo(city3);
    assertTrue(compare1==0,"The city name should be equal");

    int compare2 = city3.compareTo(city1);
    assertTrue(compare2 < 0, "City 3 should be alphanumerically smaller");

    int compare3 = city1.compareTo(city3);
    assertTrue(compare3 > 0, "City 3 should be alphanumerically smaller");
  }

  @Test
  void testToString() {
    assertEquals("Halifax",city1.toString(), "Return correct name of the city.");
    }

  @Test
    void compare() {
      city1.distance=10;
      city2.distance=20;
      city3.distance=30;
      Comparator<City> comparator = new Comparator<City>() {

        @Override
        public int compare(City city1, City city2) {
          return city1.distance - city2.distance;
        }
      };

      int actualResult = comparator.compare(city1, city2);
      assertTrue(actualResult < 0, "The result should be negative");

    }

  @Test
  void getLinksTo() {
      //Error Detected
      //It never reached in the getLinksTo() method, and it always returned true.
      city1.addLink(link2);
      assertTrue(city1.getLinksTo(city2, linkset)==false,"Incorrect boolean expression");

    }
}