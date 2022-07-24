package com.javanar.realestate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tbl_image")
public class Image {


    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String id;

    private String name;

    private String type;

    @JsonIgnore
    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property propertyId;

    @Column(nullable = false)
    private Boolean featured;

    public Image(String name, String type ,byte[] data,Boolean featured){
            this.name=name;
            this.type=type;
            this.data=data;
            this.featured=featured;
    }
}