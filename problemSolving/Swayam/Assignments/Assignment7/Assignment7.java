import java.util.*;

public class Assignment7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int k = scanner.nextInt();
        int d = scanner.nextInt();

        List<Pair<Integer, Integer>> a = new ArrayList<>();
        a.add(new Pair<>(0, 0));

        for (int i = 0; i < d; ++i) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            a.add(new Pair<>(u, v));
        }

        Collections.sort(a, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return Integer.compare(o1.getKey(), o2.getKey());
            }
        });

        int[][] dp = new int[350][350];
        int[][] dist = new int[350][350];

        for (int i = 1; i <= d; ++i) {
            for (int j = 1; j <= d; ++j) {
                if (dist[i][j] == 0) {
                    dist[i][j] = dist[j][i] = Math.abs(a.get(i).getKey() - a.get(j).getKey())
                            + Math.abs(a.get(i).getValue() - a.get(j).getValue());
                }
            }
        }

        for (int i = 1; i <= d - k + 1; ++i) {
            dp[1][i] = a.get(i).getKey() + a.get(i).getValue();
        }

        for (int i = 2; i <= k; ++i) {
            for (int j = i; j <= d; ++j) {
                int temp = Integer.MAX_VALUE;
                for (int p = j - 1; p >= 1; --p) {
                    if (dp[i - 1][p] != 0 && temp > dist[p][j] + dp[i - 1][p]) {
                        temp = dist[p][j] + dp[i - 1][p];
                    }
                }
                dp[i][j] = temp;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = k; i <= d; ++i) {
            ans = Math.min(ans, dp[k][i]);
        }

        System.out.println(ans);
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}