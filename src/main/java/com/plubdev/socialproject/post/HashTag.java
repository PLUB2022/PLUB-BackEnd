package com.plubdev.socialproject.post;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class HashTag {

    @GeneratedValue @Id
    @Column(name = "hashtag_id")
    private Long id;
}
