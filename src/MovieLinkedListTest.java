import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import movies.Movie;
import movies.MovieLinkedList;
import movies.Person;
import movies.TimeIndicator;
import org.junit.Before;
import org.junit.Test;


/**
 * Test class for the MovieLinkedList.
 */
public class MovieLinkedListTest {


  Person director1;
  Person director2;
  Movie movie1;
  Movie movie2;
  Movie movie3;
  Movie movie4;


  /**
   * Set up for the tests.
   */
  @Before
  public void setUp() {
    director1 = new Person("John", "Smith");
    director2 = new Person("Mike", "Reeves");
    movie1 = new Movie("Paddington 1", director1, 2004);
    movie2 = new Movie("Paddington 2", director1, 2005);
    movie3 = new Movie("Star Wars", director2, 2005);
    movie4 = new Movie("Lord of the Rings", director2, 2002);
  }

  /**
   * tests the add functionality with index.
   */
  @Test
  public void add() {
    MovieLinkedList testList = new MovieLinkedList();
    testList.add(0, movie1);
    assertEquals(testList.peek(), movie1);
    testList.add(1, movie2);
    assertEquals(testList.peek(), movie2);
    assertNotEquals(testList.peek(), movie1);

    assertEquals(testList.getLength(), 2);
    assertEquals(testList.getLength(), 2);

  }

  /**
   * Tests exception thrown when accessing an index that is out of bounds.
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testAddExceptionGreaterThanLength() {
    MovieLinkedList testList = new MovieLinkedList();
    testList.add(4, movie1);
  }

  /**
   * Tests index out of bounds exception for less than 0.
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testAddExceptionLessThanZero() {
    MovieLinkedList testList = new MovieLinkedList();
    testList.add(-1, movie1);
  }

  /**
   * Tests the add functionality without an index specified.
   */
  @Test
  public void testAdd() {
    MovieLinkedList testList = new MovieLinkedList();
    testList.add(movie1);
    assertEquals(testList.peek(), movie1);
    testList.add(movie2);
    assertEquals(testList.peek(), movie1);
    testList.add(movie3);
    assertEquals(testList.peek(), movie1);

    assertEquals(testList.getLength(), 3);
  }

  /**
   * Tests the remove functionality.
   */
  @Test
  public void remove() {
    MovieLinkedList testList = new MovieLinkedList();
    testList.add(movie1);
    testList.add(movie2);
    testList.add(movie3);

    assertEquals(testList.peek(), movie1);
    testList.remove(movie3);
    assertFalse(testList.remove(movie3));
    assertEquals(testList.peek(), movie1);

    testList.add(movie3);
    testList.remove(movie1);
    assertEquals(testList.peek(), movie2);

    assertEquals(testList.getLength(), 2);

    MovieLinkedList emptyList = new MovieLinkedList();
    assertFalse(emptyList.remove());
  }

  /**
   * Tests the moviesMade function for before, during, and after a specified year.
   */
  @Test
  public void moviesMade() {
    MovieLinkedList totalList = new MovieLinkedList();
    totalList.add(movie1);
    totalList.add(movie2);
    totalList.add(movie3);
    totalList.add(movie4);

    TimeIndicator timeAfter = TimeIndicator.AFTER;
    TimeIndicator timeBefore = TimeIndicator.BEFORE;
    TimeIndicator timeDuring = TimeIndicator.DURING;

    MovieLinkedList after = (MovieLinkedList) totalList.moviesMade(timeAfter, 2004);

    while (after.getLength() != 0) {
      assertTrue(after.peek().getYear() > 2004);
      after.remove();
    }

    MovieLinkedList before = (MovieLinkedList) totalList.moviesMade(timeBefore, 2004);

    while (before.getLength() != 0) {
      assertTrue(before.peek().getYear() < 2004);
      before.remove();
    }

    MovieLinkedList during = (MovieLinkedList) totalList.moviesMade(timeDuring, 2004);

    while (during.getLength() != 0) {
      assertEquals(during.peek().getYear(), 2004);
      during.remove();
    }

  }

  /**
   * Tests when there would be no results for movieMade.
   */
  @Test
  public void movieMadeEmpty() {
    MovieLinkedList empty = new MovieLinkedList();
    MovieLinkedList none = (MovieLinkedList) empty.moviesDirectedBy(director1);

    assertEquals(none.peek(), null);

  }

  /**
   * Tests when there would be no results for moviesDirectedBy.
   */
  @Test
  public void moviesDirectedByEmpty() {
    MovieLinkedList totalList = new MovieLinkedList();
    totalList.add(movie1);
    totalList.add(movie2);
    totalList.add(movie3);
    totalList.add(movie4);

    Person notDirector = new Person("Tom", "Hanks");

    MovieLinkedList testList = (MovieLinkedList) totalList.moviesDirectedBy(notDirector);

    assertEquals(testList.peek(), null);
  }

  /**
   * Tests the moviesDirectedBy function.
   */
  @Test
  public void moviesDirectedBy() {
    MovieLinkedList totalList = new MovieLinkedList();
    totalList.add(movie1);
    totalList.add(movie2);
    totalList.add(movie3);
    totalList.add(movie4);

    MovieLinkedList john = (MovieLinkedList) totalList.moviesDirectedBy(director1);
    MovieLinkedList mike = (MovieLinkedList) totalList.moviesDirectedBy(director2);

    while (john.getLength() != 0) {
      assertEquals(john.peek().getDirector(), director1);
      john.remove();
    }
    while (mike.getLength() != 0) {
      assertEquals(mike.peek().getDirector(), director2);
      mike.remove();
    }

  }
}