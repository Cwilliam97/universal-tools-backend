package com.tools.binarytree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeService {
     @Autowired
    private NodeRepository nodeRepository;

    public void insertNode(Node node) {
        if (nodeRepository.count() == 0) {
            nodeRepository.save(node);
        } else {
            insertNode(nodeRepository.findById(1L).orElse(null), node);
        }
    }

    private Node insertNode(Node current, Node newNode) {
        if (newNode.getValue().compareTo(current.getValue()) < 0) {
            if (current.getLeftChild() == null) {
                current.setLeftChild(newNode);
            } else {
                insertNode(current.getLeftChild(), newNode);
            }
        } else if (newNode.getValue().compareTo(current.getValue()) > 0) {
            if (current.getRightChild() == null) {
                current.setRightChild(newNode);
            } else {
                insertNode(current.getRightChild(), newNode);
            }
        }
        return nodeRepository.save(current);
    }

    public Node findNodeById(Long id) {
        return nodeRepository.findById(id).orElse(null);
    }
}
