package com.plubdev.socialproject.social;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Social {

    @GeneratedValue @Id
    @Column(name = "social_id")
    private Long id;

    private String title;
    private String content;

    private LocalDateTime createdAt;

    private String socialDate;
    private String socialTime;
    private String socialPeopleCount;

    private String entryFee;

    private String nthTime;

    @Enumerated(EnumType.STRING)
    private OnOffType onOffType;

    private boolean firstCome;

}
