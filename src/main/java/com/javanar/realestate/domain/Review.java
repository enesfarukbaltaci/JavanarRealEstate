package com.javanar.realestate.domain;

import com.javanar.realestate.domain.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tbl_review")
public class Review {

    @Id
    private Long id;

    @Column(nullable = false)
    private String review;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private Integer score;

    @ManyToOne
    @JoinColumn(name="property_id")
    private Property propertyId;

    //TODO : Iliski kur
    @Column(nullable=false)
    private Long userId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EStatus status;
}
