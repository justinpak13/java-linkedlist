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

  /**
   * Function to add a node to the current node.
   * @param nextNode the next node to be added
   */
  public void addNode(MovieNode nextNode) {
    if (this.getNext() == null) {
      nextNode.setNext(null);
      this.setNext(nextNode);
    } else {
      nextNode.setNext(this.getNext());
      this.setNext(nextNode);
    }


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


