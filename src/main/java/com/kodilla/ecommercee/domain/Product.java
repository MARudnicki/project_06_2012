package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Access(AccessType.FIELD)
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @Access(AccessType.FIELD)
    @Column(name = "NAME")
    private String name;

    @Access(AccessType.FIELD)
    @Column(name = "DESCRIPTION")
    private String description;

    @Access(AccessType.FIELD)
    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @ManyToOne(targetEntity = Order.class,
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private Order order;

    public Product(@NotNull String name, @NotNull String description, @NotNull BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String description, BigDecimal price, Group group) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.group = group;
    }
}
