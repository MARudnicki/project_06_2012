package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.dto.ProductDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "CART_ID",updatable = false)
    private List<Product> shoppingCart;

    @Access(AccessType.FIELD)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER")
    private User user;

}
