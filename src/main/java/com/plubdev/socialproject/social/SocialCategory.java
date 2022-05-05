package com.plubdev.socialproject.social;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class SocialCategory {

    @GeneratedValue @Id
    @Column(name = "social_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "social_id")
    private Social social;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category1_id")
    private CategoryOne categoryOne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category2_id")
    private CategoryTwo categoryTwo;

}
