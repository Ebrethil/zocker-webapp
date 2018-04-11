package com.asozialesnetzwerk.net.zockerwebapp.sandbox.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParentElement implements TreeElement {
    List<TreeElement> treeElements = new ArrayList<>();

    public List<TreeElement> getTreeElements() {
        return treeElements;
    }

    public void setTreeElements(List<TreeElement> treeElements) {
        this.treeElements = treeElements;
    }

    public void addTreeElement(TreeElement treeElement) {
        treeElements.add(treeElement);
    }

    public void deleteTreeElement(TreeElement treeElement) {
        treeElements.remove(treeElement);
    }
}
