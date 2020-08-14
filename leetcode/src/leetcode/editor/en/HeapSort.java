package leetcode.editor.en;

/**
 * 堆排序
 */
public class HeapSort {


    /**
     * 第一步
     * 堆（使得：三角区域父节点为最大值）
     *
     * @param tree 数组
     * @param n    节点数
     * @param i    第i个节点做heapify
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
            heapify(tree, n, max);
        }

    }


    private static void swap(int[] tree, int j, int i) {
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }

    /**
     * 第二步
     * 此次操作是建立一个堆，堆的root节点为最大值
     * 假设是乱序的情况，则从最后一个父节点（相当于最后一个叶子的节点的parent）开始做heapify一直到root节点
     * parent = (i-1)/2
     * c1 = 2i+1 (左子节点)
     * c2 = 2i+2 (右子节点)
     *
     * @param tree 数组乱序
     * @param n    n个节点
     */
    private static void buildHeapify(int tree[], int n) {
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;
        int i;
        for (i = parent; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }


    /**
     * 最后一步：堆排序
     * 先构造一个大顶堆，后交换root最大值（把最大值一个个隔离开堆结构）
     * @param tree
     * @param n
     */
    private static void heapSort(int tree[],int n){
        //先造一个完整的大顶堆
        buildHeapify(tree,n);
        for (int i = n - 1; i >= 0 ; i--) {
            //把root（最大值）与尾节点交换
            swap(tree,i,0);
            //i代表当前需要排序的节点个数
            heapify(tree,i,0);
        }
    }

    public static void main(String[] args) {

        int tree[] = {4, 10, 3, 5, 1, 11};
        int n = 6;
        heapSort(tree, n);
        for (int i = 0; i < n; i++) {
            System.out.println(tree[i]);
        }
    }
}
