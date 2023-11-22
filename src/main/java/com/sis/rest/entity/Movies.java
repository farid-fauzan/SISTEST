package com.sis.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies", schema = "db_sis")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "rating", nullable = true)
    private Float rating;

    @Column(name = "image", nullable = true)
    private String image;

    @Column(name = "created_at", nullable = true )
    private Date createdt;

    @Column(name = "updated_at", nullable = true )
    private Date updatedAt;



}
