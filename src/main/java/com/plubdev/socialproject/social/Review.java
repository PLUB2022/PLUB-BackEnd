package com.plubdev.socialproject.social;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Review {

    @GeneratedValue @Id
    @Column(name = "review_id")
    private Long id;

    private String reviewTitle;
    private String reviewContent;


}
