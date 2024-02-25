package movies;


/**
 * A movieLinkedList class that inherits from the MovieList class.
 */
public class MovieLinkedList implements MovieList {
  private int length;
  private MovieNode head;

  /**
   * Constructor for the MovieLinkedList class.
   */
  public MovieLinkedList() {
    this.length = 0;
    this.head = null;
  }


  /**
   * Add a Movie to the list at the specified position.
   *
   * @param index index at which the movie is to be inserted
   * @param movie movie to be inserted
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
   */
  @Override
  public void add(int index, Movie movie) throws IndexOutOfBoundsException {
    if (index < 0 || index > this.length) {
      throw new IndexOutOfBoundsException();
    }

    MovieNode currentNode = this.head;
    MovieNode newNode = new MovieNode(movie);

    this.length++;


    // handles the case where there are no other nodes
    if (this.head == null) {
      this.head = newNode;
      return;
    }

    // handles the case when you are putting at beginning of node
    // and there are other nodes
    if (index == 0) {
      newNode.setNext(this.head);
      this.head = newNode;
    } else {
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      newNode.setNext(currentNode.getNext());
      currentNode.setNext(newNode);
    }

  }


  /**
   * Add a Movie to the list at the end of the list.
   *
   * @param movie movie to be inserted
   */
  public void add(Movie movie) {
    if (this.head == null) {
      this.head = new MovieNode(movie);
    } else {
      MovieNode current = this.head;

      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(new MovieNode(movie));
    }
    this.length++;
  }

  /**
   * Removes the first occurrence of the specified movie from this list, if it is present.
   * If this list does not contain the movie, it is unchanged.
   *
   * @param movie movie to be removed from this list, if present
   * @return true if the movie was found; false otherwise
   */
  @Override
  public boolean remove(Movie movie) {

    MovieNode currentNode = this.head;

    // check the first instance
    if (currentNode.getMovie().compareTo(movie) == 0) {
      this.head = currentNode.getNext();
      this.length--;
      return true;
    }

    // check the rest
    while (currentNode.getNext() != null) {
      if (currentNode.getNext().getMovie().compareTo(movie) == 0) {
        currentNode.setNext(currentNode.getNext().getNext());
        this.length--;
        return true;
      }

      currentNode = currentNode.getNext();
    }

    return false;
  }

  /**
   * Removes element from linked list based on index if it is present.
   * If this list does not contain the movie, it is unchanged.
   *
   * @param index index to be removed, if present
   * @return true if the movie was found; false otherwise
   */
  public boolean remove(int index) {
    if (index > this.getLength() || index < 0){
      return false;
    }


    // check the first instance
    if (index == 0) {
      this.head = this.head.getNext();
      this.length--;
      return true;
    }

    // check the rest
    MovieNode current = this.head;
    for (int i = 0; i < index - 1; i++){
      current = current.getNext();
    }

    current.setNext(current.getNext().getNext());

    return true;

  }


  // removes from the head

  /**
   * removes the first instance of a movie in the list.
   * @return true if method was successful false if there were no items in the list
   */
  public boolean remove() {
    if (this.length == 0) {
      return false;
    }

    this.head = this.head.getNext();
    length--;
    return true;
  }

  /**
   * Create a list of movies made in a certain period (before, during or after a certain year).
   *
   * @param timeIndicator indicates if the movies we want were made before, during or after a year
   * @param year          the year
   * @return the list of movies made during that period
   */
  @Override
  public MovieList moviesMade(TimeIndicator timeIndicator, int year) {
    MovieLinkedList resultList = new MovieLinkedList();

    MovieNode current = this.head;

    while (current != null) {
      int currentYear = current.getMovie().getYear();
      switch (timeIndicator) {
        case AFTER:
          if (currentYear > year) {
            Movie temp = current.getMovie();
            resultList.add(temp);
          }
          break;
        case BEFORE:
          if (currentYear < year) {
            Movie temp = current.getMovie();
            resultList.add(temp);
          }
          break;
        default:
          if (currentYear == year) {
            Movie temp = current.getMovie();
            resultList.add(temp);
          }
          break;
      }
      current = current.getNext();
    }

    return resultList;
  }

  /**
   * Create a list of movies made by a particular director.
   *
   * @param director the director
   * @return the list of movies made by that director
   */
  @Override
  public MovieList moviesDirectedBy(Person director) {

    MovieLinkedList resultList = new MovieLinkedList();
    MovieNode current = this.head;

    while (current != null) {
      if (current.getMovie().getDirector().isEqual(director)) {
        resultList.add(current.getMovie());
      }

      current = current.getNext();

    }

    return resultList;
  }

  /**
   * Getter function for the length of the list.
   * @return the length of the list
   */
  public int getLength() {
    return this.length;
  }

  /**
   * checks the head of the list.
   * @return the first movie node if the list is greater than 0 else returns null
   */
  public Movie peek() {
    if (this.head == null) {
      System.out.println("No items in the list");
      return null;
    }
    return this.head.getMovie();
  }




  public void sort(){
    if (this.getLength() <2){
      return;
    }

    for (int j = 0; j < this.length - 1; j++){
      MovieNode current = this.head;
      for (int i = 0; i < this.length - 1; i++){
        if (current.getMovie().compareTo(current.getNext().getMovie()) > 0){
          MovieNode temp = new MovieNode(current.getMovie());
          temp.setNext(current.getNext().getNext());
          current.getNext().setNext(temp);
          this.remove(i);
          current = current.getNext();
        }
        current = current.getNext();

      }
    }
  }

  private void sortByTitle(){
    if (this.getLength() <2){
      return;
    }

    for (int j = 0; j < this.length - 1; j++){
      MovieNode current = this.head;
      for (int i = 0; i < this.length - 1; i++){
        if (current.getMovie().getTitle().compareToIgnoreCase(current.getNext().getMovie().getTitle()) > 0){
          MovieNode temp = new MovieNode(current.getMovie());
          temp.setNext(current.getNext().getNext());
          current.getNext().setNext(temp);
          this.remove(i);
          current = current.getNext();
        }
        current = current.getNext();

      }
    }
  }

  private void sortByYear(){
    if (this.getLength() <2){
      return;
    }

    for (int j = 0; j < this.length - 1; j++){
      MovieNode current = this.head;
      for (int i = 0; i < this.length - 1; i++){
        if (current.getMovie().getYear() - (current.getNext().getMovie().getYear()) > 0){
          MovieNode temp = new MovieNode(current.getMovie());
          temp.setNext(current.getNext().getNext());
          current.getNext().setNext(temp);
          this.remove(i);
          current = current.getNext();
        }
        current = current.getNext();

      }
    }
  }

  private void sortByDirector(){
    if (this.getLength() <2){
      return;
    }

    for (int j = 0; j < this.length - 1; j++){
      MovieNode current = this.head;
      for (int i = 0; i < this.length - 1; i++){
        if (current.getMovie().getDirector().toString().compareToIgnoreCase(current.getNext().getMovie().getDirector().toString()) > 0){
          MovieNode temp = new MovieNode(current.getMovie());
          temp.setNext(current.getNext().getNext());
          current.getNext().setNext(temp);
          this.remove(i);
          current = current.getNext();
        }
        current = current.getNext();

      }
    }
  }

  public void sort(SortBy sortBy){
    if (sortBy == SortBy.TITLE){
      this.sortByTitle();
    }
    if (sortBy == SortBy.YEAR){
      this.sortByYear();
    }
    if (sortBy == SortBy.DIRECTOR_NAME){
      this.sortByDirector();
    }



  }

  public void printList(){
    MovieNode current = this.head;
    while (current != null){
      System.out.println(current.getMovie().toString());
      current = current.getNext();

    }

  }
}
