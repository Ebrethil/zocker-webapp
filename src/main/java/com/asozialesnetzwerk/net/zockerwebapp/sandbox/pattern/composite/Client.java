package com.asozialesnetzwerk.net.zockerwebapp.sandbox.pattern.composite;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Client {
    private final Random random = new Random();

    public ParentElement setUp() {
        ParentElement root = new ParentElement();
        randomizeChildren(root, random.nextInt(3));

        return root;
    }

    private void randomizeChildren(ParentElement element, int quantifier) {
        for (int i = 0; i <= quantifier; i++) {
            if (isNodeElement()) {
                ParentElement parent = new ParentElement();
                element.addTreeElement(parent);

                randomizeChildren(parent, random.nextInt(3));
            } else {
                LeafElement leaf = new LeafElement();
                element.addTreeElement(leaf);
            }
        }
    }

    private boolean isNodeElement() {
        return random.nextBoolean();
    }
}
