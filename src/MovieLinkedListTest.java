import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import movies.Movie;
import movies.MovieLinkedList;
import movies.MovieNode;
import movies.Person;
import movies.SortBy;
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
  Movie movie5;
  Movie movie6;
  Movie movie7;
  Movie movie8;
  Movie movie9;
  Movie movie10;
  Movie movie11;
  Movie movie12;
  Movie movie13;
  Movie movie14;
  Movie movie15;
  Movie movie16;
  Movie movie17;
  Movie movie18;
  Movie movie19;
  Movie movie20;
  Movie movie21;
  Movie movie22;
  Movie movie23;
  Movie movie24;
  Movie movie25;
  Movie movie26;
  Movie movie27;


  MovieLinkedList sortedByYear = new MovieLinkedList();
  MovieLinkedList sortedByDirector = new MovieLinkedList();
  MovieLinkedList sortedByTitle = new MovieLinkedList();

  MovieLinkedList sortedTotal = new MovieLinkedList();

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
    movie5 = new Movie("the shawshank redemption", new Person("Frank", "Darabont"), 1994);
    movie6 = new Movie("the godfather", new Person("francis ford", "coppola"), 1972);
    movie7 = new Movie("the dark knight", new Person("Christopher", "Nolan"), 2008);
    movie8 = new Movie("schindler's list", new Person("steven", "spielberg"), 1993);
    movie9 = new Movie("pulp fiction", new Person("quentin", "tarantino"), 1994);
    movie10 = new Movie("the good the bad and the ugly", new Person("Sergio", "Leone"), 1966);
    movie11 = new Movie("fight club", new Person("david", "fincher"), 1999);
    movie12 = new Movie("forrest gump", new Person("robert", "Zemeckis"), 1994);
    movie13 = new Movie("inception", new Person("Christopher", "Nolan"), 2010);
    movie14 = new Movie("the silence of the lambs", new Person("Jonathan", "Demme"), 1991);
    movie15 = new Movie("batman begins", new Person("christopher", "nolan"), 2005);
    movie16 = new Movie("Pulp Fiction", new Person("Quentin", "Tarantino"), 1994);
    movie17 = new Movie("Nomadland", new Person("Chloé", "zhao"), 2020);
    movie18 = new Movie("the apartment", new Person("billy", "wilder"), 1960);
    movie19 = new Movie("Funny Games", new Person("Michael", "Haneke"), 2007);
    movie20 = new Movie("Ghostbusters", new Person("Paul", "Feig"), 2016);
    movie21 = new Movie("The Rider", new Person("Chloé", "Zhao"), 2017);
    movie22 = new Movie("Solaris", new Person("Steven", "Soderbergh"), 2002);
    movie23 = new Movie("The Godfather", new Person("Francis Ford", "Coppola"), 1972);
    movie24 = new Movie("Solaris", new Person("Andrei", "Tarkovsky"), 1972);
    movie25 = new Movie("Funny Games", new Person("Michael", "Haneke"), 1997);
    movie26 = new Movie("Selma", new Person("Ava", "DuVernay"), 2014);
    movie27 = new Movie("Ghostbusters", new Person("Ivan", "Reitman"), 1984);

    sortedByYear.add(movie18);
    sortedByYear.add(movie10);
    sortedByYear.add(movie6);
    sortedByYear.add(movie23);
    sortedByYear.add(movie24);
    sortedByYear.add(movie27);
    sortedByYear.add(movie14);
    sortedByYear.add(movie8);
    sortedByYear.add(movie5);
    sortedByYear.add(movie9);
    sortedByYear.add(movie12);
    sortedByYear.add(movie16);
    sortedByYear.add(movie25);
    sortedByYear.add(movie11);
    sortedByYear.add(movie22);
    sortedByYear.add(movie15);
    sortedByYear.add(movie19);
    sortedByYear.add(movie7);
    sortedByYear.add(movie13);
    sortedByYear.add(movie26);
    sortedByYear.add(movie20);
    sortedByYear.add(movie21);
    sortedByYear.add(movie17);

    sortedByTitle.add(movie15);
    sortedByTitle.add(movie11);
    sortedByTitle.add(movie12);
    sortedByTitle.add(movie19);
    sortedByTitle.add(movie25);
    sortedByTitle.add(movie20);
    sortedByTitle.add(movie27);
    sortedByTitle.add(movie13);
    sortedByTitle.add(movie17);
    sortedByTitle.add(movie9);
    sortedByTitle.add(movie16);
    sortedByTitle.add(movie8);
    sortedByTitle.add(movie26);
    sortedByTitle.add(movie22);
    sortedByTitle.add(movie24);
    sortedByTitle.add(movie18);
    sortedByTitle.add(movie7);
    sortedByTitle.add(movie6);
    sortedByTitle.add(movie23);
    sortedByTitle.add(movie10);
    sortedByTitle.add(movie21);
    sortedByTitle.add(movie5);
    sortedByTitle.add(movie14);

    sortedByDirector.add(movie24);
    sortedByDirector.add(movie26);
    sortedByDirector.add(movie18);
    sortedByDirector.add(movie17);
    sortedByDirector.add(movie21);
    sortedByDirector.add(movie7);
    sortedByDirector.add(movie13);
    sortedByDirector.add(movie15);
    sortedByDirector.add(movie11);
    sortedByDirector.add(movie6);
    sortedByDirector.add(movie23);
    sortedByDirector.add(movie5);
    sortedByDirector.add(movie27);
    sortedByDirector.add(movie14);
    sortedByDirector.add(movie19);
    sortedByDirector.add(movie25);
    sortedByDirector.add(movie20);
    sortedByDirector.add(movie9);
    sortedByDirector.add(movie16);
    sortedByDirector.add(movie12);
    sortedByDirector.add(movie10);
    sortedByDirector.add(movie22);
    sortedByDirector.add(movie8);

    sortedTotal.add(movie15);
    sortedTotal.add(movie11);
    sortedTotal.add(movie12);
    sortedTotal.add(movie25);
    sortedTotal.add(movie19);
    sortedTotal.add(movie27);
    sortedTotal.add(movie20);
    sortedTotal.add(movie13);
    sortedTotal.add(movie17);
    sortedTotal.add(movie9);
    sortedTotal.add(movie16);
    sortedTotal.add(movie8);
    sortedTotal.add(movie26);
    sortedTotal.add(movie24);
    sortedTotal.add(movie22);
    sortedTotal.add(movie18);
    sortedTotal.add(movie7);
    sortedTotal.add(movie6);
    sortedTotal.add(movie23);
    sortedTotal.add(movie10);
    sortedTotal.add(movie21);
    sortedTotal.add(movie5);
    sortedTotal.add(movie14);

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
    assertEquals(testList.peek(), movie1);
    assertNotEquals(testList.peek(), movie2);

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

  /**
   * Test function to determine whether the sort by year function works correctly.
   */
  @Test
  public void testSortingYear() {
    MovieLinkedList totalList = new MovieLinkedList();
    totalList.add(movie6);
    totalList.add(movie5);
    totalList.add(movie7);
    totalList.add(movie8);
    totalList.add(movie9);
    totalList.add(movie10);
    totalList.add(movie11);
    totalList.add(movie12);
    totalList.add(movie13);
    totalList.add(movie14);
    totalList.add(movie15);
    totalList.add(movie16);
    totalList.add(movie17);
    totalList.add(movie18);
    totalList.add(movie19);
    totalList.add(movie20);
    totalList.add(movie21);
    totalList.add(movie22);
    totalList.add(movie23);
    totalList.add(movie24);
    totalList.add(movie25);
    totalList.add(movie26);
    totalList.add(movie27);


    totalList.sort(SortBy.YEAR);


    assertTrue(totalList.compareLists(sortedByYear));
  }

  /**
   * Test function to determine whether the sort by title function works correctly.
   */
  @Test
  public void testSortingTitle() {
    MovieLinkedList totalList = new MovieLinkedList();
    totalList.add(movie6);
    totalList.add(movie5);
    totalList.add(movie7);
    totalList.add(movie8);
    totalList.add(movie9);
    totalList.add(movie10);
    totalList.add(movie11);
    totalList.add(movie12);
    totalList.add(movie13);
    totalList.add(movie14);
    totalList.add(movie15);
    totalList.add(movie16);
    totalList.add(movie17);
    totalList.add(movie18);
    totalList.add(movie19);
    totalList.add(movie20);
    totalList.add(movie21);
    totalList.add(movie22);
    totalList.add(movie23);
    totalList.add(movie24);
    totalList.add(movie25);
    totalList.add(movie26);
    totalList.add(movie27);

    totalList.sort(SortBy.TITLE);


    assertTrue(totalList.compareLists(sortedByTitle));
  }

  /**
   * Test function to determine whether the sort by director name function works correctly.
   */
  @Test
  public void testSortingDirector() {
    MovieLinkedList totalList = new MovieLinkedList();
    totalList.add(movie6);
    totalList.add(movie5);
    totalList.add(movie7);
    totalList.add(movie8);
    totalList.add(movie9);
    totalList.add(movie10);
    totalList.add(movie11);
    totalList.add(movie12);
    totalList.add(movie13);
    totalList.add(movie14);
    totalList.add(movie15);
    totalList.add(movie16);
    totalList.add(movie17);
    totalList.add(movie18);
    totalList.add(movie19);
    totalList.add(movie20);
    totalList.add(movie21);
    totalList.add(movie22);
    totalList.add(movie23);
    totalList.add(movie24);
    totalList.add(movie25);
    totalList.add(movie26);
    totalList.add(movie27);

    totalList.sort(SortBy.DIRECTOR_NAME);


    assertTrue(totalList.compareLists(sortedByDirector));
  }


  /**
   * Test function to determine whether the default sort function works correctly.
   */
  @Test
  public void testFullSort() {
    MovieLinkedList totalList = new MovieLinkedList();
    totalList.add(movie6);
    totalList.add(movie5);
    totalList.add(movie7);
    totalList.add(movie8);
    totalList.add(movie9);
    totalList.add(movie10);
    totalList.add(movie11);
    totalList.add(movie12);
    totalList.add(movie13);
    totalList.add(movie14);
    totalList.add(movie15);
    totalList.add(movie16);
    totalList.add(movie17);
    totalList.add(movie18);
    totalList.add(movie19);
    totalList.add(movie20);
    totalList.add(movie21);
    totalList.add(movie22);
    totalList.add(movie23);
    totalList.add(movie24);
    totalList.add(movie25);
    totalList.add(movie26);
    totalList.add(movie27);

    totalList.sort();

    assertTrue(totalList.compareLists(sortedTotal));

  }
}