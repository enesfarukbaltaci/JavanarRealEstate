package com.javanar.realestate.domain;

import com.javanar.realestate.domain.enums.ECategory;
import com.javanar.realestate.domain.enums.EStatus;
import com.javanar.realestate.domain.enums.EType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="tbl_property")
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 70,nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    // Enum
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ECategory category;

    // Enum
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EType type;

    @Column(nullable = false)
    private Integer bedrooms;

    @Column(nullable = false)
    private Integer bathrooms;

    @Column(nullable = false)
    private Integer garages;

    @Column(nullable = false)
    private Integer area;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String district;

    @ManyToOne
    @JoinColumn(name="agent_id")
    private Agent agentId;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private Long likes;

    @Column(nullable = false)
    private Long visitCount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EStatus status;

    @OneToMany(mappedBy = "propertyId", fetch = FetchType.LAZY)
    private Set<Image> image;

    @OneToMany(mappedBy = "propertyId")
    private Set<Review> review;

    @OneToMany(mappedBy = "propertyId")
    private Set<TourRequest> tourRequest;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="property_propDetails", joinColumns=@JoinColumn(name="propertyDetail_id"),
            inverseJoinColumns=@JoinColumn(name="property_id"))
    private Set<PropertyDetail> propertyDetail;

}
