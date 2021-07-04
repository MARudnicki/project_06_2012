package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Access(AccessType.FIELD)
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Access(AccessType.FIELD)
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Access(AccessType.FIELD)
    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @ManyToOne(targetEntity = Order.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Order order;

    public Product(@NotNull String name, @NotNull String description, @NotNull BigDecimal price, @NotNull String groupId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
