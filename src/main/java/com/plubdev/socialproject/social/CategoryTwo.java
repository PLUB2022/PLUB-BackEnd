package com.plubdev.socialproject.social;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class CategoryTwo {

    @GeneratedValue @Id
    @Column(name = "category2_id")
    private Long id;

    private String categoryName;
}
