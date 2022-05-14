package com.plubdev.socialproject.club;

import com.plubdev.socialproject.member.domain.MemberCategory;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class ClubCategory {

    @GeneratedValue @Id
    @Column(name = "club_category_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @OneToMany(mappedBy = "clubCategory", cascade = CascadeType.ALL)
    private List<MemberCategory> memberCategoryList = new ArrayList<>();
}
