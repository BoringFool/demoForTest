package service;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        new Sub();

//        Scanner sc = new Scanner( System.in );
//
//        for (; ; ) {
//            System.out.println(sc.next());
//            System.out.println(sc.nextLine());
//        }
//        int[] a = new int[Integer.MAX_VALUE];
//        for (int s : a) {
//            a[s] = s;
//        }a
//
//
//        int max = 0;
//        long currented = System.currentTimeMillis();
//
//        for (int s : a) {
//            max = Math.max(a[s], max);
//        }
//        long currented1 = System.currentTimeMillis();
//
//        System.out.println("diff = " + (currented1 - currented));
//        SummaryRanges summaryRanges = new SummaryRanges();
//        summaryRanges.addNum(6);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
//        summaryRanges.addNum(6);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
//        summaryRanges.addNum(0);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
//        summaryRanges.addNum(4);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
//        summaryRanges.addNum(8);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
//        summaryRanges.addNum(7);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
//        summaryRanges.addNum(6);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
//        summaryRanges.addNum(4);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
//        summaryRanges.addNum(7);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
//        summaryRanges.addNum(5);
//        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));

//        int[] a = {162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98};
//        System.out.println(minimumJumps(a, 29, 98, 80));
//        int[][] a = new int[][]{
//                {3, 5},
//                {4, 3},
//                {5, 1},
//                {1, 4},
//                {2, 3},
//                {4, 5},
//                {2, 6},
//                {1, 3},
//        };
//        minTrioDegree(6, a);

//        eliminateMaximum(new int[]{3,5,7,4,5}, new int[]{2,3,6,3,2});
        Test t = new Test();
//        t.countDifferentSubsequenceGCDs(new int[]{5852,6671,170275,141929,2414,99931,179958,56781,110656,190278,7613,138315,58116,114790,129975,144929,61102,90624,60521,177432,57353,199478,120483,75965,5634,109100,145872,168374,26215,48735,164982,189698,77697,31691,194812,87215,189133,186435,131282,110653,133096,175717,49768,79527,74491,154031,130905,132458,103116,154404,9051,125889,63633,194965,105982,108610,174259,45353,96240,143865,184298,176813,193519,98227,22667,115072,174001,133281,28294,42913,136561,103090,97131,128371,192091,7753,123030,11400,80880,184388,161169,155500,151566,103180,169649,44657,44196,131659,59491,3225,52303,141458,143744,60864,106026,134683,90132,151466,92609,120359,70590,172810,143654,159632,191208,1497,100582,194119,134349,33882,135969,147157,53867,111698,14713,126118,95614,149422,145333,52387,132310,108371,127121,93531,108639,90723,416,141159,141587,163445,160551,86806,120101,157249,7334,60190,166559,46455,144378,153213,47392,24013,144449,66924,8509,176453,18469,21820,4376,118751,3817,197695,198073,73715,65421,70423,28702,163789,48395,90289,76097,18224,43902,41845,66904,138250,44079,172139,71543,169923,186540,77200,119198,184190,84411,130153,124197,29935,6196,81791,101334,90006,110342,49294,67744,28512,66443,191406,133724,54812,158768,113156,5458,59081,4684,104154,38395,9261,188439,42003,116830,184709,132726,177780,111848,142791,57829,165354,182204,135424,118187,58510,137337,170003,8048,103521,176922,150955,84213,172969,165400,111752,15411,193319,78278,32948,55610,12437,80318,18541,20040,81360,78088,194994,41474,109098,148096,66155,34182,2224,146989,9940,154819,57041,149496,120810,44963,184556,163306,133399,9811,99083,52536,90946,25959,53940,150309,176726,113496,155035,50888,129067,27375,174577,102253,77614,132149,131020,4509,85288,160466,105468,73755,4743,41148,52653,85916,147677,35427,88892,112523,55845,69871,176805,25273,99414,143558,90139,180122,140072,127009,139598,61510,17124,190177,10591,22199,34870,44485,43661,141089,55829,70258,198998,87094,157342,132616,66924,96498,88828,89204,29862,76341,61654,158331,187462,128135,35481,152033,144487,27336,84077,10260,106588,19188,99676,38622,32773,89365,30066,161268,153986,99101,20094,149627,144252,58646,148365,21429,69921,95655,77478,147967,140063,29968,120002,72662,28241,11994,77526,3246,160872,175745,3814,24035,108406,30174,10492,49263,62819,153825,110367,42473,30293,118203,43879,178492,63287,41667,195037,26958,114060,99164,142325,77077,144235,66430,186545,125046,82434,26249,54425,170932,83209,10387,7147,2755,77477,190444,156388,83952,117925,102569,82125,104479,16506,16828,83192,157666,119501,29193,65553,56412,161955,142322,180405,122925,173496,93278,67918,48031,141978,54484,80563,52224,64588,94494,21331,73607,23440,197470,117415,23722,170921,150565,168681,88837,59619,102362,80422,10762,85785,48972,83031,151784,79380,64448,87644,26463,142666,160273,151778,156229,24129,64251,57713,5341,63901,105323,18961,70272,144496,18591,191148,19695,5640,166562,2600,76238,196800,94160,129306,122903,40418,26460,131447,86008,20214,133503,174391,45415,47073,39208,37104,83830,80118,28018,185946,134836,157783,76937,33109,54196,37141,142998,189433,8326,82856,163455,176213,144953,195608,180774,53854,46703,78362,113414,140901,41392,12730,187387,175055,64828,66215,16886,178803,117099,112767,143988,65594,141919,115186,141050,118833,2849});
//        t.canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 2}});
//        int[][] a = new int[][]{{5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2}, {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}};
//        System.out.println(t.queensAttacktheKing(a, new int[]{3, 4}));
//        System.out.println(t.checkValidGrid(a));

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(1);
//        System.out.println(t.rob(root));
//        int[] a = new int[]{2, 7, 9, 3, 1, 5};
//        System.out.println(t.minCapability(a, 3));
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        obj.get(1);
        obj.put(3,3);
        obj.get(2);
    }

    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] g = new List[n];
        int[] degree = new int[n];
        Arrays.setAll(g, e -> new ArrayList<>());

        //记录边和节点度
        for (int[] arr : edges) {
            g[arr[0]].add(arr[1]);
            g[arr[1]].add(arr[0]);
            degree[arr[0]]++;
            degree[arr[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        //没有金币的叶子节点
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1 && coins[i] == 0) {
                q.offer(i);
            }
        }

        //当前边数
        int edge = n;
        while (!q.isEmpty()) {
            int i = q.poll();
            degree[i]--;//节点度减为0
            edge--;//减去边
            //删除叶子节点后，判断父节点是否变为无金币的也子节点
            for (int p : g[i]) {
                if (--degree[p] == 1 && coins[p] == 0) {
                    q.offer(p);
                }
            }
        }

        //统计包含金币的叶子节点
        for (int i = 0; i < n; i++) {
            //度为1没有金币的节点，在上面的排序中已经删除，度为0了。剩下度为1的都是有金币的
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        //先删除第一层有金币的节点
        edge = edge - q.size();
        while (!q.isEmpty()) {
            for (int p : g[q.poll()]) {
                //父节点去掉子节点度为1时，则可以删除。否则表示另有节点也已此节点为父节点，不可删除。
                if (--degree[p] == 1) {
                    edge--;
                }
            }
        }
        //假设存在最后两个节点都要删除，会出现多删一次。所以需要做0判断。
        return edge == 0 ? 0 : (edge - 1) * 2;
    }


    private boolean check(int[] nums, int k, int mid) {
        int dp0 = 0, dp1 = 0;//dp0代表i-2,dp1代表i-1
        for (int i : nums) {
            if (i <= mid) {//符合要求
                int temp = dp1;
                dp1 = Math.max(dp0 + 1, dp1);//偷当前则dp[i-2] + 1和i-1对比
                dp0 = temp;
            } else {
                dp0 = dp1;//不偷，则等于i-1的结果
            }
        }

        return dp1 >= k;//当前最大值的结果是否符合要求
    }

    public int minCapability(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (check(nums, k, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }


    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //只有两者都是null才会成立
        if (root.left == root.right) {
            return root.val;
        }

        int pre = root.val;
        int next = Math.max((root.left != null ? root.left.val : 0) + (root.right != null ? root.right.val : 0), pre);

        Queue<TreeNode> q = new LinkedList<>();
        if (root.left != null) {
            if (root.left.left != null) q.offer(root.left.left);
            if (root.left.right != null) q.offer(root.left.right);
        }

        if (root.right != null) {
            if (root.right.left != null) q.offer(root.right.left);
            if (root.right.right != null) q.offer(root.right.right);
        }

        while (!q.isEmpty()) {
            int sum = 0;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;

                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }

            int temp = next;
            next = Math.max(sum + pre, next);
            pre = temp;
        }

        return next;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int giveGem(int[] gem, int[][] operations) {
        for (int[] op : operations) {
            int diff = gem[op[0]] / 2;
            gem[op[0]] -= diff;
            gem[op[1]] += diff;

        }

        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] g = new boolean[8][8];
        int[][] gs = new int[8][8];
        List<Integer> t;
        for (int[] arr : queens) {
            g[arr[0]][arr[1]] = true;
            gs[arr[0]][arr[1]] = 1;
        }
        gs[3][4] = 9;
        for (int i = king[0] - 1, j = king[1]; i >= 0; i--) {
            if (g[i][j]) {
                t = new ArrayList<>();
                t.add(i);
                t.add(j);
                ans.add(t);
                break;
            }
        }

        for (int i = king[0] - 1, j = king[1] + 1; i >= 0 && j < 8; i--, j++) {
            if (g[i][j]) {
                t = new ArrayList<>();
                t.add(i);
                t.add(j);
                ans.add(t);
                break;
            }
        }

        for (int i = king[0], j = king[1] + 1; j < 8; j++) {
            if (g[i][j]) {
                t = new ArrayList<>();
                t.add(i);
                t.add(j);
                ans.add(t);
                break;
            }
        }

        for (int i = king[0] + 1, j = king[1] + 1; i < 8 && j < 8; i++, j++) {
            if (g[i][j]) {
                t = new ArrayList<>();
                t.add(i);
                t.add(j);
                ans.add(t);
                break;
            }
        }

        for (int i = king[0] + 1, j = king[1]; i < 8; i++) {
            if (g[i][j]) {
                t = new ArrayList<>();
                t.add(i);
                t.add(j);
                ans.add(t);
                break;
            }
        }

        for (int i = king[0] + 1, j = king[1] - 1; j >= 0 && i < 8; i++, j--) {
            if (g[i][j]) {
                t = new ArrayList<>();
                t.add(i);
                t.add(j);
                ans.add(t);
                break;
            }
        }

        for (int i = king[0], j = king[1] - 1; j >= 0; j--) {
            if (g[i][j]) {
                t = new ArrayList<>();
                t.add(i);
                t.add(j);
                ans.add(t);
                break;
            }
        }

        for (int i = king[0] - 1, j = king[1] - 1; i >= 0 && j >= 0; i--, j--) {
            if (g[i][j]) {
                t = new ArrayList<>();
                t.add(i);
                t.add(j);
                ans.add(t);
                break;
            }
        }

        return ans;
    }


    public boolean checkValidGrid(int[][] grid) {
        int row = 0, col = 0;
        int cur = grid[row][col];
        int n = grid.length, end = n * n - 1;
        if (grid[row][col] != 0) {
            return false;
        }

        while (cur < end) {
            if (row + 1 < n) {
                if (col + 2 < n && grid[row + 1][col + 2] == cur + 1) {
                    cur++;
                    row += 1;
                    col += 2;
                    continue;
                } else if (col - 2 >= 0 && grid[row + 1][col - 2] == cur + 1) {
                    cur++;
                    row += 1;
                    col -= 2;
                    continue;
                }
            }

            if (row - 1 >= 0) {
                if (col + 2 < n && grid[row - 1][col + 2] == cur + 1) {
                    cur++;
                    row -= 1;
                    col += 2;
                    continue;
                } else if (col - 2 >= 0 && grid[row - 1][col - 2] == cur + 1) {
                    cur++;
                    row -= 1;
                    col -= 2;
                    continue;
                }
            }

            if (row + 2 < n) {
                if (col + 1 < n && grid[row + 2][col + 1] == cur + 1) {
                    cur++;
                    row += 2;
                    col += 1;
                    continue;
                } else if (col - 1 >= 0 && grid[row + 2][col - 1] == cur + 1) {
                    cur++;
                    row += 2;
                    col -= 1;
                    continue;
                }
            }

            if (row - 2 >= 0) {
                if (col + 1 < n && grid[row - 2][col + 1] == cur + 1) {
                    cur++;
                    row -= 2;
                    col += 1;
                    continue;
                } else if (col - 1 >= 0 && grid[row - 2][col - 1] == cur + 1) {
                    cur++;
                    row -= 2;
                    col -= 1;
                    continue;
                }
            }

            return false;
        }

        return true;
    }

    private final Map<Integer, int[]> map = new TreeMap<>();
    private int[] lastStartDay;

    public int scheduleCourse(int[][] courses) {
        for (int[] arr : courses) {
            if (arr[1] - arr[0] >= 0) {
                int[] old = map.get(arr[1] - arr[0]);
                if (old != null) {
                    old = old[0] > arr[0] ? arr : old;
                }
                //相同最晚起始时间，选择持续时间短的
                map.put(arr[1] - arr[0], arr);
            }
        }

        if (map.keySet().isEmpty()) {
            return 0;
        }

        lastStartDay = map.keySet().stream().mapToInt(Integer::valueOf).sorted().toArray();
        return Math.max(dfs(1, map.get(lastStartDay[0])[0], 1), dfs(0, 0, 1));
    }

    private int dfs(int cnt, int lastDay, int startIndex) {
        for (; startIndex < lastStartDay.length; startIndex++) {
            if (lastStartDay[startIndex] >= lastDay) {
                return Math.max(dfs(cnt + 1, lastDay + map.get(lastStartDay[startIndex])[0], ++startIndex), dfs(cnt, lastDay, startIndex));
            }
        }

        return cnt;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> maps = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            maps.add(new ArrayList<>());
        }

        for (int[] arr : prerequisites) {
            in[arr[0]]++;
            maps.get(arr[1]).add(arr[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int i = q.poll();
            ans.add(i);
            List<Integer> out = maps.get(i);
            for (int key : out) {
                in[key]--;
                if (in[key] == 0) {
                    q.offer(key);
                }
            }
        }

        return ans.size() == numCourses ? ans.stream().mapToInt(Integer::valueOf).toArray() : new int[]{};
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        Set<Integer> ans = new TreeSet<>();

        for (int i : nums) {
            ans.add(i);
        }

        List<Integer> ordered = new ArrayList<>(ans);

        for (int i = 0; i < ordered.size(); i++) {
            for (int j = i + 1; j < ordered.size(); j++) {
                int k = j + 1;
                int gcd = GCD(ordered.get(i), ordered.get(j));
                ans.add(gcd);
                while (k < ordered.size()) {
                    gcd = GCD(ordered.get(k), gcd);
                    ans.add(gcd);
                    k++;
                }
            }
        }

        return ans.size();
    }

    private int GCD(int a, int b) {
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        int[] minute = new int[dist.length];

        for (int i = 0; i < dist.length; i++) {
            minute[i] = (dist[i] / speed[i]) + (dist[i] % speed[i] == 0 ? 0 : 1);
        }

        Arrays.sort(minute);
        int i = 0;

        while (minute[i] - i > 0) {
            i++;
        }

        return i;
    }

    static class Monster {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] rela : prerequisites) {
            in[rela[0]]++;
            List<Integer> val = map.computeIfAbsent(rela[1], key -> new ArrayList<>());
            val.add(rela[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int i = q.poll();
            numCourses--;

            List<Integer> val = map.getOrDefault(i, new ArrayList<>());
            for (int n : val) {
                in[n]--;
                if (in[n] == 0) {
                    q.offer(n);
                }
            }
        }

        return numCourses == 0;
    }

    public static int minTrioDegree(int n, int[][] edges) {
        //度
        int[] degree = new int[n + 1];
        int[] edgeNum = new int[n + 1];
        //记录边
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> edge = new ArrayList<>();
        //是否是
        //队列
        Queue<Integer> q = new LinkedList<>();

        //统计度,记录边
        for (int[] arr : edges) {
            edge.add(arr);

            degree[arr[0]]++;
            degree[arr[1]]++;
        }

        //获取度为1的点
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        //减边
        while (!q.isEmpty()) {
            int e = q.poll();

            for (int i = edge.size() - 1; i >= 0; i--) {
                int[] arr = edge.get(i);
                if (arr[0] == e || arr[1] == e) {
                    int next = arr[0] == e ? arr[1] : arr[0];
                    edgeNum[next]++;//对应点的另一个点边数+1
                    //对应点的另一个点的度-1，如果等于1说明变成起点了
                    if (--degree[next] == 1) {
                        q.offer(next);
                    }
                    //移除边
                    edge.remove(i);
                    break;
                }
            }
        }

        Set<Integer> node = new TreeSet<>();
        for (int[] arr : edge) {
            node.add(arr[0]);
            node.add(arr[1]);

            List<Integer> list = map.computeIfAbsent(arr[0], key -> new ArrayList<>());
            list.add(arr[1]);
            list = map.computeIfAbsent(arr[1], key -> new ArrayList<>());
            list.add(arr[0]);
        }

        for (Integer key : map.keySet()) {
            map.get(key).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
        }

        int ans = Integer.MAX_VALUE;
        for (int i : node) {
            List<Integer> list = map.get(i);
            int[] line = new int[3];
            line[0] = i;

            for (int j : list) {
                List<Integer> sub = map.get(j);
                Iterator<Integer> it = sub.iterator();
                line[1] = j;
                while (it.hasNext()) {
                    int k = it.next();
                    if (k == line[0]) {
                        continue;
                    }

                    line[2] = k;
                    List<Integer> subs = map.get(k);
                    for (int z : subs) {
                        if (z == line[0]) {
                            ans = Math.min(ans, edgeNum[line[0]] + edgeNum[line[1]] + edgeNum[line[2]] + degree[line[0]] + degree[line[1]] + degree[line[2]] - 6);
                        }
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }


    //todo 未完成1654leetCode
    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        int[] dp = new int[x + b + 1];
        dp[0] = 0;

        for (int i : forbidden) {
            if (i < dp.length) {
                dp[i] = -1;
            }
        }


        return dp[x];
    }

    public static int numFactoredBinaryTrees(int[] arr) {
        //不用long会因为精度导致数据丢失
        long[] dp = new long[arr.length];
        long sum = 0, mod = 1000000007;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            int lo = 0, hi = i - 1;
            while (lo <= hi) {
                if ((long) arr[lo] * arr[hi] > arr[i]) {
                    hi--;
                } else if (lo <= hi && (long) arr[lo] * arr[hi] == arr[i]) {
                    int p = hi == lo ? 1 : 2;
                    dp[i] = (dp[i] + dp[lo] * dp[hi] * p) % mod;
                    hi--;
                    lo++;
                } else {
                    lo++;
                }
            }

            sum = (sum + dp[i]) % mod;
        }

        return (int) sum;
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        boolean ok = false;
        for (int i = 0; i < intervals.length; i++) {
            if (ok) {
                ans.add(intervals[i]);
                continue;
            }

            if (newInterval[0] > intervals[i][1]) {
                ans.add(intervals[i]);
                continue;
            }

            if (newInterval[1] < intervals[i][0]) {
                ok = true;
                ans.add(new int[]{newInterval[0], newInterval[1]});
                ans.add(intervals[i]);
                continue;
            }

            int[] cur = intervals[i];
            int start = Math.min(newInterval[0], cur[0]);
            int end = Math.max(newInterval[1], cur[1]);

            if (end > cur[1]) {
                while (++i < intervals.length) {
                    cur = intervals[i];

                    if (cur[0] > end) {
                        ans.add(new int[]{start, end});
                        ans.add(cur);
                        ok = true;
                        break;
                    } else if (end <= cur[1]) {
                        end = cur[1];
                        ans.add(new int[]{start, end});
                        ok = true;
                        break;
                    }
                }

                if (!ok) {
                    ans.add(new int[]{start, end});
                    ok = true;
                }
                continue;
            }

            ans.add(new int[]{start, end});
            ok = true;
        }

        if (!ok) {
            ans.add(newInterval);
        }

        return ans.toArray(new int[0][2]);
    }

    public static int[][] merge(int[][] intervals) {
//        if(intervals.length == 0){
//            return new int[0][2];
//        }
//
//        List<int[]> ans = new ArrayList<>();
//
//        //排序
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//
//        for(int[] cur : intervals){
//            if(ans.isEmpty() || ans.get(ans.size() -1)[1] < cur[0]){
//                ans.add(new int[]{cur[0], cur[1]});
//            }else{
//                int e = Math.max(ans.get(ans.size() -1)[1], cur[1]);
//                ans.get(ans.size() -1)[1] = e;
//            }
//        }
//        return ans.toArray(new int[ans.size()][]);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] arr : intervals) {
            //<= arr[0]
            Map.Entry<Integer, Integer> entryStart = map.floorEntry(arr[0]);

            //定位起点
            int start = arr[0], end = arr[1];
            Map.Entry<Integer, Integer> entry = map.firstEntry();
            if (entryStart != null) {
                entry = entryStart;

                if (arr[0] <= entry.getValue()) {
                    start = entry.getKey();
                }
            }

            //定位重点，同时删除被覆盖的区间
            while (entry != null) {
                if (end < entry.getKey()) {
                    map.put(start, end);
                    break;
                } else if (end <= entry.getValue()) {
                    map.remove(entry.getKey());
                    map.put(start, entry.getValue());
                    break;
                } else {
                    if (entry.getValue() >= start) {
                        map.remove(entry.getKey());
                    }
                    entry = map.higherEntry(entry.getKey());
                }
            }

            if (entry == null) {
                if (entryStart == null) {
                    map.clear();
                }
                map.put(start, end);
            }
        }

        int[][] ans = new int[map.size()][2];
        int i = 0;
        Map.Entry<Integer, Integer> entry = map.firstEntry();

        while (entry != null) {
            ans[i++] = new int[]{entry.getKey(), entry.getValue()};
            entry = map.higherEntry(entry.getKey());
        }

        return ans;
    }

    public Test() {
        System.out.println("test contruct");
    }

}
