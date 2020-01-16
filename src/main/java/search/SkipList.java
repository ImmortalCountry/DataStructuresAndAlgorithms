package search;

/**
 * 跳表
 *
 * @Date 2020/1/16
 * @Created by sundy
 */
public class SkipList {
    private static final float SKIP_LIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;

    // 带头链表
    private Node head = new Node();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        // 从 1 层 添加到 level 层
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node update[] = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        // 记录每个级别的最大值，该最大值小于update []中的插入值
        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            // 在搜索路径中使用更新保存节点
            update[i] = p;
        }

        // 在搜索路径节点中，下一个节点成为新节点的单词（下一个）
        for (int i = 0; i < level; i++) {
            newNode.forwards[i] = update[i].forwards[i];
        }
        // 更新高度节点
        if (levelCount < level) levelCount = level;
    }

    private int randomLevel() {
        return 0;
    }

    public class Node {
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ main.java.data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }
}
