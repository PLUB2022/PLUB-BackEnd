package com.plubdev.socialproject.post;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class PostHashTag {

    @GeneratedValue @Id
    @Column(name = "post_hashtag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id")
    private HashTag hashTag;
}
