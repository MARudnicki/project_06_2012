package com.kodilla.domain;

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

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "shoppingCart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> shoppingCart = new ArrayList<>();

    @OneToOne(
            cascade = CascadeType.ALL, fetch = FetchType.EAGER
    )
    @JoinColumn(name = "USER_ID")
    private User user;
}
