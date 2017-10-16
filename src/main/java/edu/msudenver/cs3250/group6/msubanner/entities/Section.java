package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Persistent Section class.
 *
 */
@Entity
@Table(name = "sections")
public class Section {

    /** Section's Id number. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long myId;

    /** Course this section belongs to. */
    @ManyToOne
    private Course myCourse;

    /** Section's professor. */
    @ManyToOne
    private User myProfessor;

    /** Number used to compute hash value. */
    private static final int HASH_SHIFT = 32;

    /**
     * Default constructor, creates a blank section.
     */
    public Section() {
        myProfessor = new User();
        myCourse = new Course();
    }

    /**
     * Creates a new section and instantiates the course and professor fields.
     * @param course The course that this section belongs to
     * @param professor The professor for this section
     */
    public Section(final Course course, final User professor) {
        if (course != null) {
            myCourse = course;
        }
        if (professor != null) {
            myProfessor = professor;
        }
    }

    //overloaded to allow creation without professor
    public Section(final Course course) throws IllegalArgumentException {
        if (course != null) {
            myCourse = course;
        }
        else
            throw new IllegalArgumentException("Course cannot be null");
    }

    /**
     * Returns the course id number.
     * @return id of this course
     */
    public long getId() {
        return myId;
    }

    /**
     * Sets the section id number.
     * @param id new id number for this section
     */
    public void setId(final long id) {
        if (id > 0) {
            myId = id;
        }
    }

    /**
     * Returns the course this section belongs to.
     * @return course this section belongs to
     */
    public Course getCourse() {
        return myCourse;
    }

    /**
     * Sets the course this section belongs to.
     * @param course new course for this section
     * @throws IllegalArgumentException if the course is null
     */
    public void setCourse(final Course course) throws IllegalArgumentException {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null!");
        }
        this.myCourse = course;
    }

    /**
     * Returns the professor of this section.
     * @return the professor of this section
     */
    public User getProfessor() {
        return myProfessor;
    }

    /**
     * Sets the professor of this section.
     * @param professor new professor for this section
     * @throws IllegalArgumentException if the professor is null
     */
    public void setProfessor(final User professor)
            throws IllegalArgumentException {
        if (professor == null) {
            throw new IllegalArgumentException("Professor cannot be null!");
        }
        this.myProfessor = professor;
    }

    /**
     * Hash code function.
     */
    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> HASH_SHIFT));
    }

    /**
     * Returns if one section is equal to another.
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null || !(other instanceof Section)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        final Section otherSection = (Section) other;
        return this.getId() == otherSection.getId()
                && this.getCourse().equals(otherSection.getCourse())
                && this.getProfessor().equals(otherSection.getProfessor());
    }

    /**
     * Returns the Section as a nice, readable string.
     */
    @Override
    public String toString() {
        return "Section{" + "id=" + myId + ", Course="
                + myCourse.toString() + ", professor:"
                + myProfessor.toString() + '}';
    }
}
