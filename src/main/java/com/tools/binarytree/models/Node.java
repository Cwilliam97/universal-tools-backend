package com.tools.binarytree.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "left_child_id")
    private Node leftChild;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "right_child_id")
    private Node rightChild;
}
