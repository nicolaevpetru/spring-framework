package com.cinemaapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cinema extends BaseEntity {

    private String name;
    @Column(name = "sponsored_name")
    private String sponsorName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    public Cinema(String name, String sponsorName) {
        this.name = name;
        this.sponsorName = sponsorName;
    }
}
