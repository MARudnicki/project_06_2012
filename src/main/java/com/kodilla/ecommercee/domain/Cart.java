package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CART")
public class Cart {

    @Access(AccessType.FIELD)
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Access(AccessType.FIELD)
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "CART",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> shoppingCart;

    @Access(AccessType.FIELD)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER")
    private User user;


}
