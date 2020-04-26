package com.educational.platform.course.reviews;

import com.educational.platform.course.reviews.create.ReviewCourseCommand;

import javax.persistence.*;

/**
 * Represents Course Review domain model.
 */
@Entity
public class CourseReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Reviewer reviewer;

    @ManyToOne
    private ReviewableCourse course;
    private CourseRating rating;
    private Comment comment;

    // for JPA
    private CourseReview() {

    }

    CourseReview(ReviewCourseCommand command, ReviewableCourse course, Reviewer reviewer) {
        this.course = course;
        this.reviewer = reviewer;
        this.rating = new CourseRating(command.getRating());
        this.comment = new Comment(command.getComment());
    }
}