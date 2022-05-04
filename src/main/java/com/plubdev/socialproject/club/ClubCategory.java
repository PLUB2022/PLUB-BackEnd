package com.plubdev.socialproject.club;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class ClubCategory {

    @GeneratedValue @Id
    @Column(name = "club_category_id")
    private Long id;

    private String name;
}
