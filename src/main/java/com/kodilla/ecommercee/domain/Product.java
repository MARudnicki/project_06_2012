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
    @NotNull
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

    @Access(AccessType.FIELD)
    @Column(name = "GROUPID")
    private String groupId;

    @ManyToOne(cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @ManyToOne(targetEntity = Order.class,
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private Order order;

}
