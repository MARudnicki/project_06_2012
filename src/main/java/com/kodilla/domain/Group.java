package com.kodilla.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Group")
public class Group {

    @Access(AccessType.FIELD)
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Access(AccessType.FIELD)
    @Column(name = "NAME")
    private String name;

    @Access(AccessType.FIELD)
    @Column(name = "PRODUCTS")
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "productList"
    )
    private List<Product> products = new ArrayList<>();

}
