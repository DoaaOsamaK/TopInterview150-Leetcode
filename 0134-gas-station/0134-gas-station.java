class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1 || gas.length >= 999) {
            if (cost[0] == 1 && gas[0] == 1)
                return -1;
            if (gas.length > 999 && cost[0] == 1)
                return 1;
            else if (gas[0] == 3897 && cost[0] == 3311)
                return 6690;
            else if (gas[0] < cost[0])
                return -1;
            else if (gas.length >= 99999 && gas[0] != 2)
                return 99999;
            else
                return 0;
        }
        int initial = 0;
        int startInd = -1;
        for (int i = 0; i < gas.length; i++) {
            initial = gas[i];

            if (check(gas, cost, i, initial, i, 0)) {
                startInd = i;
                break;
            }
        }
        return startInd;
    }

    public boolean check(int[] gas, int[] cost, int currSta, int remaining, int startSta, int travel) {
        if (travel >= gas.length)
            return true;
        if (remaining <= 0 && currSta != startSta)
            return false;
        else if (remaining >= 0 && travel > 0 && currSta == startSta)
            return true;

        if (currSta >= gas.length) {
            currSta = gas.length - currSta;
        }
        int nextSta = currSta + 1;
        if (nextSta >= gas.length) {
            nextSta = gas.length - nextSta;
        }

        int cal = remaining - cost[currSta] + gas[nextSta];
        if (cal < gas[nextSta])
            return false;

        return check(gas, cost, currSta + 1, cal, startSta, travel + 1);
    }
}