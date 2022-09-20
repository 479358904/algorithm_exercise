package com.sqw.graph;

import java.util.Arrays;

/**
 * 最小生成树
 * 道路修建最短路径问题
 */
public class MinimumSpanningTree {

    public static void main(String[] args) {
        char[] vertexs = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        //使用数组表示邻接矩阵， N表示不连通
        int[][] weight = new int[][]{
                {N, 1, 1, 2, N, N},
                {1, N, 2, 1, N, N},
                {1, 2, N, 1, 1, 2},
                {2, 1, 1, N, 2, 1},
                {N, N, 1, 2, N, 1},
                {N, N, 2, 1, 1, N}};

        Graph graph = new Graph(vertexs, weight);
        System.out.println("图的存储信息");
        graph.showGraph();
        System.out.println("选择修建的连接边的信息");
        graph.prim(0);

    }

    //用一个大数表示两个点之间走不通，没有连接
    public  static  final int N = 1000;

    static class Graph {
        // 表示顶点信息
        private char[] vertex;
        // 存放邻接矩阵 ，表示边之间的权值
        private int[][] edges;

        public Graph(char[] vertex, int[][] edges) {
            this.vertex = vertex;
            this.edges = edges;
        }

        // 打印图的矩阵
        public void showGraph() {
            for (int[] edge : edges) {
                System.out.println(Arrays.toString(edge));
            }
        }

        /**
         * 使用prim算法求解最短路径
         * @param beginIndex 开始访问的图的顶点
         */
        public void prim( int beginIndex) {
            // 储存已经访问过的顶点，已经访问过的为1,没有访问过的为0
            int[] selected = new int[vertex.length];
            // 开始的顶点已经访问过了，所以标记为1
            selected[beginIndex] = 1;

            // 已经访问过的下标和没有访问过的下标，为后面循环遍历定义变量
            int visitYesIndex = -1;
            int visitNoIndex = -1;

            //初始化最小权值为一个不可达的数
            int minWright = N;
            int length = vertex.length;

            // 为什么从1开始？因为普利姆算法结束后，k个顶点，生成的边只能是k-1个
            for (int k = 1; k < length; k++) {
                // 每次都需要遍历已经选择的顶点，比如第一次遍历只有A点是已选择的，第二次有A，G，第三次有A，G，B，第四次......
                for (int i = 0; i < length; i++) {
                    //每次都需要遍历还没有被选择的顶点，比如当i 对应的为A时，j对应的有C，G，B(排除不可达的顶点)
                    for (int j = 0; j < length; j++) {

                        if(selected[i] == 1 && selected[j] == 0 && edges[i][j] < minWright ) {
                            visitYesIndex = i;
                            visitNoIndex = j;
                            minWright = edges[i][j];
                        }
                    }
                }

                // 一次循环之后  得到了最小一条边，此时要把没访问的置为已访问了
                System.out.println("选择边 <" + vertex[visitYesIndex] + "," +vertex[visitNoIndex] + "> 权值:" + minWright);
                selected[visitNoIndex] = 1;
                //minWright 重新设置最大值
                minWright = N;
            }

        }

    }
}
