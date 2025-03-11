package leetcode.editor.en.linkedList.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUseSDK {

    /**
     * 1. 需要随机可访问 （hash）
     * 2. 需要把数据插入到头部或者尾部
     */
    class LRUCache extends LinkedHashMap<Integer, Integer> {

        public int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}
