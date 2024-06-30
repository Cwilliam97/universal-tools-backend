package com.tools.binarytree.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tools.binarytree.models.Node;
import com.tools.binarytree.repository.NodeRepository;
import com.tools.binarytree.services.interfaces.INodeService;

@Service
public class NodeService implements INodeService{
     @Autowired
    private NodeRepository nodeRepository;

    @Override
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

    @Override
    public Node findNodeById(Long id) {
        return nodeRepository.findById(id).orElse(null);
    }

    @Override
    public String inorder(Node node, String info) {
        if(node != null){
            info = inorder(node.getLeftChild(), info);
            info += node.getValue() + " ";
            info = inorder(node.getRightChild(), info);
        }
        return info;
    }

    @Override
    public String preorder(Node node, String info) {
        if(node != null){
            info += node.getValue() + " ";
            info = preorder(node.getLeftChild(), info);
            info = preorder(node.getRightChild(), info);
        }
        return info;
    }

    @Override
    public String postorder(Node node, String info) {
        if(node != null){
            info = postorder(node.getLeftChild(), info);
            info = postorder(node.getRightChild(), info);
            info += node.getValue() + " ";
        }
        return info;
    }

    
}
