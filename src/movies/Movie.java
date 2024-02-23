package movies;

/**
 * This class represents a movie. The movie has a title, director, and year of release.
 */
public class Movie implements Comparable<Movie> {
  private final String title;
  private final Person director;
  private final int year;

  /**
   * Constructs a Movie object and initializes it to the movie's title, director and year.
   *
   * @param title     the title of this movie
   * @param director  the name of the movie's director
   * @param year      the year the movie was released
   */
  public Movie(String title, Person director, int year) {
    this.title = title;
    this.director = director;
    this.year = year;
  }

  /**
   * Get the title of the movie.
   *
   * @return the title of the movie
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Get the name of the director of the movie.
   *
   * @return the name of the director of the movie
   */
  public Person getDirector() {
    return this.director;
  }

  /**
   * Get the year of the movie.
   *
   * @return the year of the movie
   */
  public int getYear() {
    return this.year;
  }

  @Override
  public String toString() {
    // Example: The Apartment (Billy Wilder, 1960)
    return this.title + " " + "(" + this.director.toString() + ", " + this.year + ")";

  }

  @Override
  public int compareTo(Movie o) {
    int difference = this.title.compareTo(o.title);
    if (difference != 0) {
      return difference;
    }

    difference = this.director.toString().compareTo(o.director.toString());
    if (difference != 0) {
      return difference;
    }
    return this.year - o.getYear();
  }

  @Override
  public bool equals(Movie o){
  }
}
