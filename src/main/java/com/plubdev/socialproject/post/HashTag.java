package com.plubdev.socialproject.post;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class HashTag {

    @GeneratedValue @Id
    @Column(name = "hashtag_id")
    private Long id;

    private String hashName;

    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
    private List<PostHashTag> postHashTagList = new ArrayList<>();
}
