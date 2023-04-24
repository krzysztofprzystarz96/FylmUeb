package model;

import java.util.Objects;

public class Actor {
    private String firstName;
    private String lastName;
    private String countryOfOrigin;

    public Actor(String firstName, String lastName, String countryOfOrigin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Actor actor = (Actor) o;
        return Objects.equals(firstName, actor.firstName) && Objects.equals(lastName, actor.lastName) && Objects.equals(countryOfOrigin, actor.countryOfOrigin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, countryOfOrigin);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", country of origin: " + countryOfOrigin;
    }
}