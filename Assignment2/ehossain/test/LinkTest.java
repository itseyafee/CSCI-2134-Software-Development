import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

  public static final String city1Name = "City1";
  public static final String city2Name = "City2";
  public static final int distanceOfCity = 3;

  City city1 = new City(city1Name);
  City city2 = new City(city2Name);
  Link link_0 = new Link(city1, city2, distanceOfCity);
  Link link_1 = new Link(city1, city2,0);
  Link link_2 = new Link(city1, city2,-1);


  @Test
  void getLength() {
    assertEquals(distanceOfCity,link_0.getLength(),"Did not return the accurate length");
    assertEquals(0,link_1.getLength(),"Did not return the accurate length");
    assertEquals(-1,link_2.getLength(),"Did not return the accurate length");
  }

  @Test
  void getAdj() {
    //Error detected
    //Wrong city returned
    assertEquals(city1,link_0.getAdj(city2),"The correct city is not returned");
    assertEquals(city2,link_0.getAdj(city1),"The correct city is not returned");
  }

  @Test
  void isUsed() {
    //Error detected
    //Boolean expression is wrong
    assertTrue(link_1.isUsed(),"Wrong boolean expression");
    assertFalse(link_1.isUsed(),"Wrong boolean expression");
  }

  @Test
  void setUsed() {
    link_1.setUsed(true);
    assertTrue(link_1.used,"Wrong boolean expression");

    link_1.setUsed(false);
    assertFalse(link_1.used,"Wrong boolean expression");
  }

  @Test
  void testToString_sorted() {
    //Error Detected
    //Fixed the return
    String expectedString = city1Name + " " + distanceOfCity + " " + city2Name;
    assertEquals(expectedString, link_0.toString(), "String returned wrong one");
  }

  @Test
  void testToString_unsorted() {
    //Error Detected
    //Fixed the ruturn
    String expectedString = city1Name + " " + distanceOfCity + " " + city2Name;
    assertEquals(expectedString, link_0.toString(), "Wrong String returned");

  }

  @Test
  void compareTo() {
    // Error detected.
    City city1 = new City("P");
    City city2 = new City("Q");
    City city3 = new City("R");
    Link link_5 = new Link(city1, city2,1);
    Link link_6 = new Link(city2, city3,5);

    assertTrue(link_5.compareTo(link_5)== 0,"The cities were incorrectly compared.");
    assertTrue(link_6.compareTo(link_5) < 0,"The cities were incorrectly compared.");
    assertTrue(link_6.compareTo(link_5) > 0,"The cities were incorrectly compared.");

  }
}