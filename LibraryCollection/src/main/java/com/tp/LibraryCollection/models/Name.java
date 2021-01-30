package com.tp.LibraryCollection.models;

public class Name implements Comparable<Name> {

    private String firstName;
    private String middleName;
    private String lastName;


    /**
     * Constructor for the Name class.
     *
     * @param first
     *            firstName
     * @param last
     *            lastName
     */
    public Name(String first, String last) {
        firstName = first;
        middleName = "";
        lastName = last;
    }

    /**
     * Overloaded Constructor to include middle name
     * @param first
     * @param middle
     * @param last
     */
    public Name(String first, String middle, String last) {
        firstName = first;
        middleName = middle;
        lastName = last;
    }


    /**
     * This will return the fullName of the Student.
     *
     * @return returns fullName
     */
    public String fullName() {
        String result = firstName.substring(0, 1).toUpperCase() + firstName.substring(1) + " ";
        if(middleName.length() > 0) {
            result += middleName.substring(0,1).toUpperCase() + middleName.substring(1) + " ";
        }
        result += lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        return result;
    }


    /**
     * This returns the firstName of the Student.
     *
     * @return returns firstName
     */
    public String firstName() {
        return firstName;
    }

    /**
     * This returns the middleName of the Student
     *
     * @return returns middleName (empty String if no middle name)
     */
    public String middleName() {
        return middleName;
    }

    /**
     * This returns the lastName of the Student.
     *
     * @return returns lastName
     */
    public String lastName() {
        return lastName;
    }


    /**
     * This sets the first name of the student.
     *
     * @param newFirst
     *            firstName
     */
    public void setFirst(String newFirst) {
        firstName = newFirst;
    }


    /**
     * This sets the middle name of the student.
     *
     * @param newMiddle
     */
    public void setMiddle(String newMiddle) {
        middleName = newMiddle;
    }


    /**
     * This sets the last name of the student.
     *
     * @param newLast
     *            lastName
     */
    public void setLast(String newLast) {
        lastName = newLast;
    }


    /**
     * This compares the first name and last name of one name object to the
     * other name object.
     *
     * @param obj
     *            Name type to be compared
     * @return returns result
     */
    public int compareTo(Name obj) {
        int result = this.lastName.compareTo(obj.lastName());
        if (result == 0) {
            result = this.firstName.compareTo(obj.firstName());
        }
        return result;
    }


    /**
     * This is the equals method that tests if one object is equal to the other.
     *
     * @param other
     *            other
     * @return true or false depending if the object is equal to each other
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            return (this.lastName() == ((Name)other).lastName() && this
                    .firstName() == ((Name)other).firstName());
        }
        return false;
    }


    /**
     * This returns the toString of the name.
     *
     * @return toString fullName
     */
    public String toString() {
        return fullName();
    }
}