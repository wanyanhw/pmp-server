package com.wyhw.pmp;

public class RBTree<K, V> {
    private static boolean RED = false;
    private static boolean BLACK = true;


    private RBEntry<K, V> root;
    private int size;

    public int getSize() {
        return size;
    }

    V put(K key, V value) {
        RBEntry<K, V> current = root;
        // 空树
        if (current == null) {
            root = new RBEntry<>(key, value, null);
            size = 1;
            return null;
        }

        int compare;
        RBEntry<K, V> parent;
        if (key == null)
            throw new NullPointerException();
        @SuppressWarnings("unchecked")
        Comparable<? super K> k = (Comparable<? super K>) key;
        do {
            compare = k.compareTo(current.key);
            parent = current;
            if (compare < 0) {
                current = current.left;
            } else if (compare > 0) {
                current = current.right;
            } else {
                return current.setValue(value);
            }
        } while (current != null);

        RBEntry<K, V> x = new RBEntry<>(key, value, parent);
        if (compare < 0) {
            parent.left = x;
        } else {
            parent.right = x;
        }
        fixAfterInsertion(x);
        size ++;
        return null;

    }

    private RBEntry<K, V> parentOf(RBEntry<K, V> p) {
        return p == null ? null : p.parent;
    }
    private RBEntry<K, V> leftOf(RBEntry<K, V> p) {
        return p == null ? null : p.left;
    }
    private RBEntry<K, V> rightOf(RBEntry<K, V> p) {
        return p == null ? null : p.right;
    }

    private void fixAfterInsertion(RBEntry<K,V> x) {
        x.color = RED;
        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                // 父节点在祖父节点左链接
                RBEntry<K, V> uncle = rightOf(parentOf(parentOf(x)));
                if (colorOf(uncle) == RED) {
                    // 叔节点为红色
                    setColor(parentOf(x), BLACK);
                    setColor(uncle, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        // 内节点，变为外节点
                        // 左旋转
                        x = parentOf(x);
                        leftRotate(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    // 右旋转
                    rightRotate(parentOf(parentOf(x)));
                }
            } else {
                // 父节点在祖父节点右链接
                RBEntry<K, V> uncle = leftOf(parentOf(parentOf(x)));
                if (colorOf(uncle) == RED) {
                    // 叔节点为红色
                    setColor(parentOf(x), BLACK);
                    setColor(uncle, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        // 内节点，变为外节点
                        // 右旋转
                        x = parentOf(x);
                        rightRotate(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    // 左旋转
                    leftRotate(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
    }

    private boolean colorOf(RBEntry<K,V> p) {
        return p == null ? BLACK : p.color;
    }

    private void setColor(RBEntry<K,V> p, boolean color) {
        if (p != null) {
            p.color = color;
        }
    }

    private void rightRotate(RBEntry<K,V> x) {
        if (x != null) {
            RBEntry<K, V> l = x.left;
            x.left = l.right;
            if (l.right != null) {
                l.right.parent = x;
            }
            l.parent = x.parent;
            if (x.parent == null) {
                root = l;
            } else if (x.parent.right == x) {
                x.parent.right = l;
            } else {
                x.parent.left = l;
            }
            l.right = x;
            x.parent = l;
        }
    }

    private void leftRotate(RBEntry<K,V> x) {
        if (x != null) {
            RBEntry<K, V> r = x.right;
            x.right = r.left;
            if (r.left != null) {
                r.left.parent = x;
            }
            r.parent = x.parent;
            if (x.parent == null) {
                root = r;
            } else if (x.parent.left == x) {
                x.parent.left = r;
            } else {
                x.parent.right = r;
            }
            r.left = x;
            x.parent = r;
        }
    }

    class RBEntry<K, V>{
        K key;
        V value;
        RBEntry<K, V> left;
        RBEntry<K, V> right;
        RBEntry<K, V> parent;
        boolean color = BLACK;

        RBEntry(K k, V v, RBEntry<K, V> parent) {
            this.key = k;
            this.value = v;
            this.parent = parent;
        }

        void setKey(K k) {
            this.key = k;
        }

        V setValue(V v) {
            V oldValue = this.value;
            this.value = v;
            return oldValue;
        }
    }
}
