package com.plubdev.socialproject.post;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class PostHashTag {

    @GeneratedValue @Id
    @Column(name = "post_hashtag_id")
    private Long id;
}
