package movies;

/**
 * A helper class that makes the MovieLinkedList class easier to work with.
 */
public class MovieNode {
  private MovieNode next;
  private Movie data;

  public MovieNode(Movie movie) {
    data = movie;
    next = null;
  }

  public void addNode(MovieNode nextNode) {
    this.next = nextNode;

  }

  public Movie getMovie() {
    return this.data;
  }

  public MovieNode getNext() {
    return this.next;
  }

  public void setNext(MovieNode nextNode) {
    this.next = nextNode;
  }


}


