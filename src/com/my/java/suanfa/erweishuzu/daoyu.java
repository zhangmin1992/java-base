package com.my.java.suanfa.erweishuzu;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * 功能描述:计算岛屿数量 numIslands
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * <p>
 **/


/**
 * 力扣第 1020 题「飞地的数量」，这题不让你求封闭岛屿的数量，而是求封闭岛屿的面积总和
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * 请返回封闭岛屿的数目。
 * <p>
 * <p>
 ***/

/**
 * 力扣第 694 题「不同的岛屿数量：numDistinctIslands
 * 还是输入一个二维矩阵，0表示海水，1表示陆地，求不同岛屿的数量
 * 怎么判断是相同岛屿呢？
 * 假设它们的遍历顺序是：
 * 下，右，上，撤销上，撤销右，撤销下
 * 如果我用分别用1, 2, 3, 4代表上下左右，用-1, -2, -3, -4代表上下左右的撤销，那么可以这样表示它们的遍历顺序：
 * 2, 4, 1, -1, -4, -2
 * 你看，这就相当于是岛屿序列化的结果，只要每次使用dfs遍历岛屿的时候生成这串数字进行比较，就可以计算到底有多少个不同的岛屿了。
 * <p>
 * <p>
 **/

/**
 * 在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
 * 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
 * largestIsland
 * 示例 1:
 * 输入: [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 * 输入: [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 * 输入: [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 */
/**
 * 功能描述: maxAreaOfIsland 求二维数组中岛屿的最大面积
 * 注意有2中错误写法
 */

/**
 * 功能描述: numDistinctIslands2 不同岛屿的数量升级版
 * 711对形状相同的岛屿的定义是：经过平移，旋转，或镜像翻转后，能够完全重合，则认为是相同的岛屿
 */
public class daoyu {

    //定义岛屿的面积
    public static int count = 0;

    public static void main(String args[]) {
//        int[][] grid  = new int[4][5];
//        grid[0] = new int[] {1,1,1,1,0};
//        grid[1] = new int[] {1,1,0,1,0};
//        grid[2] = new int[] {1,1,1,0,0};
//        grid[3] = new int[] {0,0,0,0,0};
//        System.out.println(numIslands(grid));

//        int[][] grid = new int[5][8];
//        grid[0] = new int[]{1, 1, 1, 1, 1, 1, 1, 0};
//        grid[1] = new int[]{1, 0, 0, 0, 0, 1, 1, 0};
//        grid[2] = new int[]{1, 0, 1, 0, 1, 1, 1, 0};
//        grid[3] = new int[]{1, 0, 0, 0, 0, 1, 0, 1};
//        grid[4] = new int[]{1, 1, 1, 1, 1, 1, 1, 0};
//        System.out.println(numEnclaves(grid));
//        System.out.println(JSONObject.toJSONString(grid));
//        System.out.println(numDistinctIslands(grid));

//        int[][] grid = new int[4][4];
//        grid[0] = new int[]{1, 1, 1, 1};
//        grid[1] = new int[]{1, 0, 0, 0};
//        grid[2] = new int[]{1, 0, 1, 0};
//        grid[3] = new int[]{1, 0, 0, 0};
//        System.out.println("--" + JSONObject.toJSONString(grid));
//        System.out.println(largestIsland(grid));

//        mada y1 = new mada(1);
//        mada y2 = new mada(2);
//        mada y3 = new mada(3);
//        mada y4 = new mada(4);
//
//        List<mada>[] shapes = new List[4];
//        for (int i = 0; i < 4; i++) {
//            shapes[i] = new ArrayList<>();
//        }
//        shapes[0].add(y1);
//        shapes[0].add(y2);
//        shapes[0].add(y3);
//        shapes[0].add(y4);
//        for (List<mada> s : shapes) {
//            Collections.sort(s);
//        }
//        System.out.println(JSONObject.toJSONString(shapes));


//        Pair y1 = new Pair(1,1);
//        Pair y2 = new Pair(1,2);
//        Pair y3 = new Pair(2,1);
//        Pair y4 = new Pair(2,2);
//        List<Pair>[] shapes = new List[4];
//        for (int i = 0; i < 4; i++) {
//            shapes[i] = new ArrayList<>();
//        }
//        shapes[0].add(y1);
//        shapes[0].add(y2);
//        shapes[0].add(y3);
//        shapes[0].add(y4);
//        for (List<Pair> s : shapes) {
//            Collections.sort(s);
//        }
//        System.out.println(JSONObject.toJSONString(shapes));


        int[][] grid  = new int[4][5];
        grid[0] = new int[] {1, 0, 0, 1, 1};
        grid[1] = new int[] {1, 1, 0, 0, 0};
        grid[2] = new int[] {0, 0, 0, 1, 1};
        grid[3] = new int[] {1, 1, 0, 0, 1};
        System.out.println(numDistinctIslands2(grid));
    }

    //求计算岛屿数量
    public static int numIslands(int[][] grid) {
        int num = grid.length;
        int size = grid[0].length;
        int result = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 1) {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    //淹没陆地
    public static void dfs(int[][] grid, int i, int j) {
        System.out.println(i + "--" + j);
        int num = grid.length;
        int size = grid[0].length;
        //因为底下有i+1，j+1等，注意这里不能越界，i>=num
        if (i < 0 || j < 0 || i >= num || j >= size) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    //求孤岛
    static int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 淹掉靠边的陆地
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        // 数一数剩下的陆地
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }

    //求不同岛屿的数量
    static int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 记录所有岛屿的序列化结果
        HashSet<String> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 淹掉这个岛屿，同时存储岛屿的序列化结果
                    StringBuilder sb = new StringBuilder();
                    // 初始的方向可以随便写，不影响正确性
                    dfs(grid, i, j, sb);
                    islands.add(sb.toString());
                }
            }
        }
        System.out.println(JSONObject.toJSONString(islands));
        // 不相同的岛屿数量
        return islands.size();
    }

    static void dfs(int[][] grid, int i, int j, StringBuilder sb) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i - 1, j, sb.append("1")); // 上
        dfs(grid, i + 1, j, sb.append("2")); // 下
        dfs(grid, i, j - 1, sb.append("3")); // 左
        dfs(grid, i, j + 1, sb.append("4")); // 右
    }

    //最多只能将一格 0 海洋变成 1变成陆地，求最大岛屿
    public static int largestIsland(int[][] grid) {
        int[] map = new int[grid.length * grid[0].length / 2 + 3];
        int index = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //对应位置的值设置为2
                    fullIsland(grid, i, j, index++);
                }
            }
        }
        System.out.println("--" + JSONObject.toJSONString(grid));

        //这里是把值放到map中去，设置map中的值2有几个，3有几个
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    map[grid[i][j]]++;
                }
            }
        }
        System.out.println("--" + JSONObject.toJSONString(map));


        int max = 0;
        //遍历二维数组，解析数组中的值，获取最大的值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int t = 1, t1 = 0, t2 = 0, t3 = 0, t4 = 0;
                    if (i > 0 && (t1 = grid[i - 1][j]) > 1) {
                        t += map[t1];
                    }
                    if (i < grid.length - 1 && (t2 = grid[i + 1][j]) > 1 && t2 != t1) {
                        t += map[t2];
                    }
                    if (j > 0 && (t3 = grid[i][j - 1]) > 1 && t2 != t3 && t1 != t3) {
                        t += map[t3];
                    }
                    if (j < grid[0].length - 1 && (t4 = grid[i][j + 1]) > 1 && t4 != t3 && t2 != t4 && t1 != t4) {
                        t += map[t4];
                    }
                    max = Math.max(max, t);
                }
            }
        }
        System.out.println("--" + JSONObject.toJSONString(grid));
        return max;
    }

    //这里是说淹没岛屿
    public static void fullIsland(int[][] grid, int i, int j, int index) {
        grid[i][j] = index;
        //如果他的上一个位置是岛屿，就把他当前设置为index
        if (i > 0 && grid[i - 1][j] == 1) {
            fullIsland(grid, i - 1, j, index);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            fullIsland(grid, i + 1, j, index);
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            fullIsland(grid, i, j - 1, index);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            fullIsland(grid, i, j + 1, index);
        }
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int num = grid.length;
        int size = grid[0].length;
        for (int i = 0;i<num;i++) {
            for (int j = 0;j<size;j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result,dfs2(grid,i,j));
                    //这里在一次淹没过程完成之后，设置全局变量count为0
                    count = 0;
                }
            }
        }
        return result;
    }

    static int dfs2(int[][] grid,int i,int j) {
        //1.边界处理
        int num = grid.length;
        int size = grid[0].length;
        if (i< 0 || i>= num || j<0 || j>= size) {
            return count;
        }
        //2.不是岛屿返回
        if (grid[i][j] == 0) {
            return count;
        }
        //3.淹没岛屿 和上下左右的位置
        grid[i][j] = 0;
        //只能定义一个全局变量count在dfs中累计面积
        count++;
        dfs2(grid,i+1,j);
        dfs2(grid,i-1,j);
        dfs2(grid,i,j+1);
        dfs2(grid,i,j-1);
        return count;
    }

    static int numDistinctIslands2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 存所有形状, 每一种形状用一个字符串表示
        Set<String> st = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    Vector<Pair> shape = new Vector<>();
                    helper(grid, i, j, shape);
                    System.out.println(JSONObject.toJSONString(shape));
                    st.add(normalize(shape));
                }
            }
        }
        return st.size();
    }

    static void helper(int[][] grid, int x, int y, Vector<Pair> shape) {
        //1.边界处理
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        //2.不是陆地直接返回
        if (grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;
        //路径中加入二维数据的坐标值,比如实例中的[{"i":0,"j":0},{"i":1,"j":0},{"i":1,"j":1}]
        shape.add(new Pair(x,y));
        helper(grid, x + 1, y, shape);
        helper(grid, x - 1, y, shape);
        helper(grid, x, y + 1, shape);
        helper(grid, x, y - 1, shape);
    }

    /**
     * 功能描述: xy坐标的翻转，总共有8种方式
     */
    static String  normalize(Vector<Pair> shape) {
        List<Pair>[] shapes = new List[8];
        for (int i = 0; i < 8; i++) {
            shapes[i] = new ArrayList<>();
        }
        for (Pair a : shape) {
            int x = a.i, y = a.j;
            shapes[0].add(new Pair(x, y));
            shapes[1].add(new Pair(x, -y));
            shapes[2].add(new Pair(-x, y));;
            shapes[3].add(new Pair(-x, -y));
            shapes[4].add(new Pair(y, x));;
            shapes[5].add(new Pair(y, -x));
            shapes[6].add(new Pair(-y, x));
            shapes[7].add(new Pair(-y, -x));
        }
        System.out.println("---" + JSONObject.toJSONString(shapes[0]));
        // 对每个shape进行排序, 确保每个shape中, 左上角的坐标排在第一个位置
        for (List<Pair> s : shapes) {
            Collections.sort(s);
        }
        // 对每个shape, 以左上角为基准, 进行坐标修正, 计算相对坐标
        for (List<Pair> s : shapes) {
            // 这里可以直接采用倒序遍历, 确保第一个位置的坐标最后才被更新
            Pair beginPos = s.get(0);
            int beginI = beginPos.i, beginJ = beginPos.j;
            for (Pair p : s) {
                p.i = p.i - beginI;
                p.j = p.j - beginJ;
            }
        }

        // 将每个shape的点全部拿出来, 放在一起, 进行扁平化
        List<Pair> allPair = new ArrayList<>();
        for (List<Pair> s : shapes) {
            for (Pair p : s) {
                allPair.add(p);
            }
        }

        // 对扁平化后的点, 进行排序
        Collections.sort(allPair);
        StringBuilder sb = new StringBuilder();
        // 序列化成字符串
        for (Pair p : allPair) {
            sb.append(p.toString());
        }
        return sb.toString();
    }


}
class Pair implements Comparable<Pair> {

    public int i;

    public int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Pair o) {
        // i越小, 越靠前
        // j越大, 越靠前
        // 结果就是右上角地点是第一个点 (最小的点)
        return this.i != o.i ? this.i - o.i : o.j - this.j;
    }

    @Override
    public String toString() {
        // 序列化一个坐标
        return "[" + i + "," + j + "]";
    }
}

class mada implements Comparable<mada> {

    public int i;

    public mada(int i) {
        this.i = i;
    }

    @Override
    public int compareTo(mada o) {

        return this.i - o.i;
    }
}

