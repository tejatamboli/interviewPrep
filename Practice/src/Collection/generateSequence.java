package Collection;

public class generateSequence {

	private static int count = 0;
	
	public static void main(String[] args) {
		int n1 = 1; int n2 = 2; int n3 = 3; int n4 = 4;
		int cnt = Sequence(n1, n2, n3, n4);
		System.out.println("cnt is : " + cnt);
		cnt = Sequence2(n1, n2, n3, n4);
		System.out.println("cnt is : " + cnt);
	}
    public static int Sequence(int n1, int n2, int n3, int n4)
    {
        SequenceRecursion(n1, n2, n3, n4, "");
        return count;
    }

    public static boolean SequenceRecursion(int n1, int n2, int n3, int n4, String str)
    {
        if (n1 == 0 && n2 == 0 && n3 == 0 && n4 == 0)
        {
            count++;
            System.out.println(str);
            return true;
        }

        char arr[] = str.toCharArray();
        if (str.length() == 0 || (str.length() > 0 && n1 > 0 && (arr[str.length() - 1] != '1')))
        {
            str += "1";
            SequenceRecursion(n1 - 1, n2, n3, n4, str);
            str = str.substring(0, str.length() - 1);
        }

        if (str.length() == 0 || (str.length() > 0 && n2 > 0 && (arr[str.length() - 1] != '2')))
        {
            str += "2";
            SequenceRecursion(n1, n2 - 1, n3, n4, str);
            str = str.substring(0, str.length() - 1);
        }

        if (str.length() == 0 || (str.length() > 0 && n3 > 0 && (arr[str.length() - 1] != '3')))
        {
            str += "3";
            SequenceRecursion(n1, n2, n3 - 1, n4, str);
            str = str.substring(0, str.length() - 1);
        }

        if (str.length() == 0 || (str.length() > 0 && n4 > 0 && (arr[str.length() - 1] != '4')))
        {
            str += "4";
            SequenceRecursion(n1, n2, n3, n4 - 1, str);
            str = str.substring(0, str.length() - 1);
        }

        return false;
    }
    
    public static int Sequence2(int n1, int n2, int n3, int n4)
    {
        int[][][][] dp1 = new int[n1 + 1][n2 + 1][n3 + 1][n4 + 1];
        int[][][][] dp2 = new int[n1 + 1][n2 + 1][n3 + 1][n4 + 1];
        int[][][][] dp3 = new int[n1 + 1][n2 + 1][n3 + 1][n4 + 1];
        int[][][][] dp4 = new int[n1 + 1][n2 + 1][n3 + 1][n4 + 1];
        
        int MOD = 1000000007;
        
        dp1[1][0][0][0] = 1;
        dp2[0][1][0][0] = 1;
        dp3[0][0][1][0] = 1;
        dp4[0][0][0][1] = 1;
        
        for (int i = 0; i <= n1; i++)
        {
            for (int j = 0; j <= n2; j++)
            {
                for (int k = 0; k <= n3; k++)
                {
                    for (int l = 0; l <= n4; l++)                                        {                             
                        if (i + j + k + l > 1)
                        {
                            if (i > 0) dp1[i][j][k][l] = dp2[i-1][j][k][l] + dp3[i-1][j][k][l] + dp4[i-1][j][k][l] % MOD;
                            if (j > 0) dp2[i][j][k][l] = dp1[i][j-1][k][l] + dp3[i][j-1][k][l] + dp4[i][j-1][k][l] % MOD;
                            if (k > 0) dp3[i][j][k][l] = dp2[i][j][k-1][l] + dp1[i][j][k-1][l] + dp4[i][j][k-1][l] % MOD;
                            if (l > 0) dp4[i][j][k][l] = dp2[i][j][k][l-1] + dp3[i][j][k][l-1] + dp1[i][j][k][l-1] % MOD;
                        }
                    }
                }

            }
        }
        return (dp1[n1][n2][n3][n4] + dp2[n1][n2][n3][n4] + dp3[n1][n2][n3][n4] + dp4[n1][n2][n3][n4]) % MOD;
    }
}
