package com.kodilla.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @NotNull
    @OneToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @OneToMany(targetEntity = Product.class,
            mappedBy = "ORDER",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Product> productList;
}