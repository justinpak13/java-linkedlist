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

  private void increaseLength(){
    this.length ++;
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
   * swaps two elements in the linked list. The element at index position and the one prior.
   * @param index position in which to swap
   */
  private void swap(int index){
    MovieNode current = this.head;
    for (int i = 0; i < index - 1; i++){
      current = current.getNext();
    }

    MovieNode temp = new MovieNode(current.getMovie());
    temp.setNext(current.getNext().getNext());
    current.getNext().setNext(temp);
    this.remove(index - 1);
    if (index == 1){
      this.increaseLength();

    }
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


  /**
   * Default sort function with no parameters. Sorts by year, then director, then title.
   */
  public void sort(){
    this.sortByYear();
    this.sortByDirector();
    this.sortByTitle();
  }

  /**
   * Sorts the linked list by title of movie.
   */
  private void sortByTitle(){
    if (this.getLength() <2){
      return;
    }

    int length = this.getLength();

    for (int j = 0; j < length; j++){
      MovieNode previous = this.head;
      MovieNode current = this.head.getNext();
      for (int i = 1; i < length; i++){
        if (previous.getMovie().getTitle().compareToIgnoreCase(current.getMovie().getTitle())> 0){
          this.swap(i);
          previous = current;
          current = current.getNext();
        }
        previous = current;
        current = current.getNext();
      }
    }

  }

  /**
   * Sorts the linked list by year movie was made.
   */
  private void sortByYear(){
    if (this.getLength() <2){
      return;
    }


    int length = this.getLength();

    for (int j = 0; j < length; j++){
      MovieNode previous = this.head;
      MovieNode current = this.head.getNext();
      for (int i = 1; i < length; i++){
        if (previous.getMovie().getYear()  - current.getMovie().getYear() > 0){
          this.swap(i);
          previous = current;
          current = current.getNext();
        }
        previous = current;
        current = current.getNext();
      }
    }

  }

  /**
   * Sorts linked list by director first and last name.
   */
  private void sortByDirector(){
    if (this.getLength() <2){
      return;
    }

    int length = this.getLength();

    for (int j = 0; j < length; j++){
      MovieNode previous = this.head;
      MovieNode current = this.head.getNext();
      for (int i = 1; i < length; i++){
        if (previous.getMovie().getDirector().toString().compareToIgnoreCase(current.getMovie().getDirector().toString()) > 0){
          this.swap(i);
          previous = current;
          current = current.getNext();
        }
        previous = current;
        current = current.getNext();
      }
    }
  }

  /**
   * Overloading of sort function that takes in a parameter to specify sorting.
   * @param sortBy an enum indicating how to sort the linked list
   */
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

  /**
   * Prints the linked list in order
   */
  public void printList(){
    MovieNode current = this.head;
    while (current != null){
      System.out.println(current.getMovie().toString());
      current = current.getNext();

    }

  }

  /**
   * compares the list to another list to see if the contents and ordering are the same.
   * @param otherList another movie linked list
   * @return true if the same, false otherwise
   */
  public boolean compareLists(MovieLinkedList otherList){
    if (this.getLength() != otherList.getLength()) {
      System.out.println(this.getLength());
      System.out.println(otherList.getLength());
      return false;
    }

    while (this.head != null) {
      if (!this.head.getMovie().equals(otherList.head.getMovie())){
        System.out.println(this.head.getMovie());
        System.out.println(otherList.head.getMovie());
        return false;
      }
      this.remove();
      otherList.remove();
    }

    return otherList.head == null;


  }
}
