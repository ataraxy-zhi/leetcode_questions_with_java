package com.solution.onequestionperday.march2021.designhashset705;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @ClassName DesignHashSet
 * @Description 705. Design HashSet
 * Design a HashSet without using any built-in hash table libraries.
 * <p>
 * Implement MyHashSet class:
 * <p>
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * Output
 * [null, null, null, true, false, null, true, null, false]
 * <p>
 * Explanation
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found)
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // return True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // return False, (already removed)
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= key <= 106
 * At most 104 calls will be made to add, remove, and contains.
 * <p>
 * <p>
 * Follow up: Could you solve the problem without using the built-in HashSet library?
 * <p>
 * <p>
 * <p>
 * 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * <p>
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 * <p>
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= key <= 106
 * 最多调用 104 次 add、remove 和 contains 。
 * <p>
 * <p>
 * 进阶：你可以不使用内建的哈希集合库解决此问题吗？
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/design-hashset/
 * @Author
 * @Date 2021/3/13 9:01
 */
public class DesignHashSet {
}


class MyHashSet {
    private static final int BASE = 769;
    private LinkedList[] data;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        for (Integer element : (Iterable<Integer>) data[h]) {
            if (element == key) {
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        for (Integer element : (Iterable<Integer>) data[h]) {
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int h = hash(key);
        for (Integer element : (Iterable<Integer>) data[h]) {
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}