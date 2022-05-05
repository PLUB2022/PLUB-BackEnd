package com.plubdev.socialproject.social;

import com.plubdev.socialproject.member.MemberCategory;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class CategoryOne {

    @GeneratedValue @Id
    @Column(name = "category1_id")
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "categoryOne", cascade = CascadeType.ALL)
    private List<SocialCategory> socialCategoryList = new ArrayList<>();

    @OneToMany(mappedBy = "categoryOne", cascade = CascadeType.ALL)
    private List<MemberCategory> memberCategoryList = new ArrayList<>();
}
