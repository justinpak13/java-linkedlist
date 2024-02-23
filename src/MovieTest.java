import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import movies.Movie;
import movies.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Movie class.
 */
public class MovieTest {
  private Movie theApartment;
  private Movie someLikeItHot;
  private Movie sunsetBoulevard;
  private Movie sunsetBoulevardDeluxe;

  /**
   * Set up movies to use for our tests.
   */
  @Before public void setUp() {
    Person billyWilder = new Person("Billy", "Wilder");
    this.theApartment = new Movie("The Apartment", billyWilder, 1960);
    this.someLikeItHot = new Movie("Some Like It Hot", billyWilder, 1959);
    this.sunsetBoulevard = new Movie("Sunset Boulevard", billyWilder, 1950);
    this.sunsetBoulevardDeluxe = new Movie("Sunset Boulevard", billyWilder, 1951);
  }

  /**
   * Test the title of the movie.
   */
  @Test public void testTitle() {
    assertEquals("The Apartment", theApartment.getTitle());
  }

  /**
   * Test the director of the movie.
   */
  @Test public void testDirector() {
    assertEquals("Billy Wilder", theApartment.getDirector().toString());
  }

  /**
   * Test the year of the movie.
   */
  @Test public void testYear() {
    assertEquals(1960, theApartment.getYear());
  }

  /**
   * Test toString method.
   */
  @Test public void testToString() {
    assertEquals("The Apartment (Billy Wilder, 1960)", theApartment.toString());
  }


  @Test public void testCompareTo() {
    assertTrue(sunsetBoulevard.compareTo(someLikeItHot) > 0);
    assertTrue(sunsetBoulevard.compareTo(theApartment) < 0);
    assertTrue(sunsetBoulevard.compareTo(sunsetBoulevardDeluxe) < 0);
    assertTrue(sunsetBoulevardDeluxe.compareTo(sunsetBoulevard) > 0);
  }

}

  