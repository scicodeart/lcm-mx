package leetcode.editor.en.backTracing;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-19 17:10
 */
class BlackBox {

    int n1;
    int m1;

    int[] a = new int[(n1+m1)*2];
    int min = Math.min(n1,m1);


    public BlackBox(int n, int m) {

        n1 = n;
        m1 = m;

    }

    public int open(int index, int direction) {



        a[index] = 1;
        if (direction == 1){

        }else if (direction == -1){

        }


        return 1;
    }

    public void close(int index) {

    }
}
