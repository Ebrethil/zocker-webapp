package com.asozialesnetzwerk.net.zockerwebapp.sandbox.pattern.composite;

public class ParentElement extends AbstractParentElement {
    @Override
    public int countChildElements() {
        int count = 1;
        for (TreeElement element : treeElements) {
            count += element.countChildElements();
        }

        return count;
    }
}
