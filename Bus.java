import java.io.*;
import java.util.*;

public class Bus {

    static class Bus {
        long s, t;
        double time;

        Bus(long s, long t, long l, long x, long y) {
            this.s = s;
            this.t = t;

            // Time from t = 0 until the person reaches l
            // if they use this bus.
            time = (double)(t - s) / x
                 + (double)(l - t) / y;
        }
    }

    static class Person {
        long p;
        int id;

        Person(long p, int id) {
            this.p = p;
            this.id = id;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();

        long l = fs.nextLong();
        long x = fs.nextLong();
        long y = fs.nextLong();

        Bus[] buses = new Bus[n];

        for (int i = 0; i < n; i++) {
            long s = fs.nextLong();
            long t = fs.nextLong();

            buses[i] = new Bus(s, t, l, x, y);
        }

        Person[] people = new Person[m];

        for (int i = 0; i < m; i++) {
            long p = fs.nextLong();
            people[i] = new Person(p, i);
        }

        // Sort buses by starting position
        Arrays.sort(buses, Comparator.comparingLong(b -> b.s));

        // Sort people by their position
        Arrays.sort(people, Comparator.comparingLong(p -> p.p));

        /*
         * Min-heap based on the total time obtained by using a bus.
         */
        PriorityQueue<Bus> pq =
                new PriorityQueue<>(Comparator.comparingDouble(b -> b.time));

        double[] answer = new double[m];

        int j = 0;

        for (Person person : people) {

            long p = person.p;

            // Add every bus that has already started
            // by the time we consider this person's position.
            while (j < n && buses[j].s <= p) {
                pq.add(buses[j]);
                j++;
            }

            /*
             * Remove buses that have already reached
             * their destination.
             *
             * A bus is usable only when:
             *
             * s <= p < t
             */
            while (!pq.isEmpty() && pq.peek().t <= p) {
                pq.poll();
            }

            // Person can always walk directly to the end.
            double walkTime = (double)(l - p) / y;

            double best = walkTime;

            // Best currently usable bus
            if (!pq.isEmpty()) {
                best = Math.min(best, pq.peek().time);
            }

            answer[person.id] = best;
        }

        StringBuilder out = new StringBuilder();

        for (double ans : answer) {
            out.append(ans).append('\n');
        }

        System.out.print(out);
    }

    // Fast input
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0)
                    return -1;
            }

            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            boolean negative = false;

            if (c == '-') {
                negative = true;
                c = read();
            }

            long result = 0;

            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }

            return negative ? -result : result;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}