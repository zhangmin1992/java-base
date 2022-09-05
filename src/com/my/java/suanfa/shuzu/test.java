package com.my.java.suanfa.shuzu;

public class test {

    int MAXSIZE =10;
    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        matrix[0] = new int[]{1, 5,2};
        matrix[0] = new int[]{2, 6,3};
        matrix[0] = new int[]{5, 8, 7};
        System.out.println(isSearch(matrix,3,3,3));
    }

    static  boolean isSearch(int matrix[][], int searchValue , int row , int column)
    {
        if(null == matrix || row < 0 || column < 0)
        {
            return false;
        }
        boolean find = false;
        int x = 0;
        int y = column - 1;
        while( x <= row - 1 && y >= 0  )
        {
            if( matrix[x][y] < searchValue )
            {
                x++;
            }
            else if( matrix[x][y] > searchValue )
            {
                y--;
            }
            else
            {
                return true;
            }
        }
        return false;
    }

}
