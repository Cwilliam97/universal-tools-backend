package com.tools.binarytree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tools.binarytree.models.Node;

public interface NodeRepository extends JpaRepository<Node, Long>{
    
}
