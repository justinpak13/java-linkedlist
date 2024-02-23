package movies;

/**
 * This class represents a person, the person has a first name and last name.
 */
public class Person {

  private final String firstName;
  private final String lastName;

  /**
   * Constructs a Person object and initializes it to the given first name and last name.
   *
   * @param firstName the first name of this person
   * @param lastName  the last name of this person
   */
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Get the first name of this person.
   *
   * @return the first name of this person
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Return the last name of this person.
   *
   * @return the last name of this person
   */
  public String getLastName() {
    return this.lastName;
  }

  @Override
  public String toString() {
    return this.getFirstName() + " " + this.getLastName();
  }

  /**
   * Checks whether two people are equal by checking both first and last name.
   * @param otherDirector the other person to be compared to.
   * @return true if the names are the same. false otherwise.
   */
  public boolean isEqual(Person otherDirector) {
    if (this.getFirstName().compareTo(otherDirector.getFirstName()) != 0) {
      return false;
    }

    if (this.getFirstName().compareTo(otherDirector.getLastName()) != 0) {
      return false;
    }

    return true;
  }
}

