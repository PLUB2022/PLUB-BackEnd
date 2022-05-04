package com.plubdev.socialproject.social;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class SocialCatergory {

    @GeneratedValue @Id
    @Column(name = "social_category_id")
    private Long id;
}
