package com.kodilla.domain;

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
    Long id;

    @Access(AccessType.FIELD)
    @Column(name = "NAME")
    String name;

    @Access(AccessType.FIELD)
    @Column(name = "DESCRIPTION")
    String description;

    @Access(AccessType.FIELD)
    @Column(name = "PRICE")
    BigDecimal price;

    @Access(AccessType.FIELD)
    @Column(name = "GROUPID")
    String groupId;
}

