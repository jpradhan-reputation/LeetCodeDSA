package jp.dsa.array;

public class TheTownJudge {
    public static void main(String[] args) {
        int[][] trustArr = {{1, 2}, {2, 3}, {1, 3}};
        System.out.println("The Town Judge: " + findJudge(3, trustArr));
    }

    //Optimised approach
    public static int findJudge(int n, int[][] trust) {
        //count each trusts
        int[] tCount = new int[n + 1];
        for (int[] t: trust) {
            tCount[t[1]]++;
        }
        int judge = -1;
        //find the judge that has maximum (n - 1) trust
        for (int i = 1; i <= n; i++) {
            if (tCount[i] == (n - 1))
                judge = i;
        }
        //find if the judge trusts anyone
        for (int[] t : trust) {
            if (t[0] == judge) {
                return -1;
            }
        }
        return judge;
    }
}

//Bruit force approach
/*
public int findJudge(int n, int[][] trust) {
    if (n == 1) {
        return 1;
    } else if (n == 2 && trust.length == 1) {
        return trust[0][1];
    }
    Map<Integer, Integer> trustMap = new HashMap<>();
    Set<Integer> trustSet = new HashSet<>();
    for (int i = 0; i < trust.length; i++) {
        Integer trustVal = Integer.valueOf(trust[i][1]);
        if (trustMap.containsKey(trustVal)) {
            trustMap.put(trustVal, trustMap.get(trustVal) + 1);
        } else {
            trustMap.put(trustVal, 1);
        }
        trustSet.add(Integer.valueOf(trust[i][0]));
    }
    for (Integer people: trustMap.keySet()) {
        if ((trustMap.get(people) == (n - 1)) && !trustSet.contains(people))
            return people;
    }
    return -1;
}*/
