package leetcode.editor.en;

public class HeapSort {



    /**
     * 堆
     *
     * @param tree 数组
     * @param n    节点数
     * @param i    第i个
     */
    private static void heapify(int tree[], int n, int i) {
        // 节点i < n
        if (i >= n) {
            return;
        }

        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && tree[c1] > tree[max]) {
            max = c1;
        }
        if (c2 < n && tree[c2] > tree[max]) {
            max = c2;
        }
        // if max does not equal i,then change the value
        if (max != i) {
            swap(tree, max, i);
            heapify(tree,n,max);
        }

    }

    private static void swap(int[] tree, int j, int i) {
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }

    public static void main(String[] args) {

        int tree[] = {4,10,3,5,1,11};
        int n = 6;
        heapify(tree,n,0);
        for (int i = 0; i < n; i++) {
            System.out.println(tree[i]);
        }
    }
}
