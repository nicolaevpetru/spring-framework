package com.ormmanytomany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "tags",cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<>();

    private String name;

    public Tag(String name) {
        this.name = name;
    }
}
