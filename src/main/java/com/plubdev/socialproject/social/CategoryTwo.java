package com.plubdev.socialproject.social;

import com.plubdev.socialproject.member.MemberCategory;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class CategoryTwo {

    @GeneratedValue @Id
    @Column(name = "category2_id")
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "categoryTwo", cascade = CascadeType.ALL)
    private List<SocialCategory> socialCategoryList = new ArrayList<>();

    @OneToMany(mappedBy = "categoryTwo", cascade = CascadeType.ALL)
    private List<MemberCategory> memberCategoryList = new ArrayList<>();
}
