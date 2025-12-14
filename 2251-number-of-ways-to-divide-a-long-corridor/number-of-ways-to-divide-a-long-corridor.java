class Solution {
    public int numberOfWays(String corridor) {
        int mod = 1_000_000_007;
        int totalSeats = 0;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') totalSeats++;
        }
        if (totalSeats % 2 != 0 || totalSeats == 0) return 0;
        int seat = 0;
        int plants = 0;
        long ways = 1;

        for (int i = 0; i < corridor.length(); i++) {
            char c = corridor.charAt(i);

            if (c == 'S') {
                seat++;
                if (seat == 3) {
                    ways = (ways * (plants + 1)) % mod;
                    plants = 0;
                    seat = 1;
                }
            } 
            else if (seat == 2) {
                plants++;
            }
        }

        return (int) ways;
    }
}
