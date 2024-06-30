package com.tools.binarytree.services.interfaces;

import com.tools.binarytree.models.Node;

public interface INodeService {
    void insertNode(Node node);
    Node findNodeById(Long id);   
    String inorder(Node node, String info);
    String preorder(Node node, String info);
    String postorder(Node node, String info);
}
