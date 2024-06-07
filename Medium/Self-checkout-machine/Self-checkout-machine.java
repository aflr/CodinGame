import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Machine myMachine = new Machine(in.nextLine());
        boolean error = false;
        int N = in.nextInt();
        for (int i = 0; !error && i < N; i++) {
            int bill = Math.round(in.nextFloat() * 100f);
            String given = in.next();
            int change = new Machine(given).getTotalMoney() - bill;
            if (change == 0) {
                System.out.println(0);
            } else {
                myMachine.addMoney(given);
                System.out.println(myMachine.getChange(change));
            }
        }
    }

    /* Money is stored in integer amounts of cents */
    private static class Machine {
        // Map <Money Value, Money Amount>
        Map<Integer, Integer> money;
        List<Integer> jammed;

        public Machine() {
            // Sort money in order of descending value
            this.money = new TreeMap<>((a, b) -> b - a);
            this.jammed = new ArrayList<>();
        }

        public Machine(String money) {
            this();
            addMoney(money);
        }

        public void addMoney(String money) {
            for (String m : money.split("\\+")) {
                String[] mm = m.split("X");
                int value = Math.round(Float.parseFloat(mm[1]) * 100);
                int amount = (mm[0].contains("J") && jammed.add(value))
                        ? Integer.parseInt(mm[0].substring(0, mm[0].length() - 1))
                        : Integer.parseInt(mm[0]);
                int prevAmount = this.money.getOrDefault(value, 0);
                this.money.put(value, prevAmount + amount);
            }
        }

        public int getTotalMoney() {
            int total = 0;
            Iterator<Map.Entry<Integer, Integer>> it = this.money.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> en = it.next();
                total += en.getKey() * en.getValue();
            }
            return total;
        }

        public String getChange(int change) {
            StringBuilder sb = new StringBuilder();
            Iterator<Map.Entry<Integer, Integer>> it = this.money.entrySet().iterator();
            while (change > 0 && it.hasNext()) {
                Map.Entry<Integer, Integer> en = it.next();
                int amountNeeded = (int) (change / en.getKey());
                if (amountNeeded == 0)
                    continue;
                if (jammed.contains(en.getKey())) {
                    System.out.println("ERROR: JAM");
                    Runtime.getRuntime().exit(1);
                }
                int amountTaken = Math.min(amountNeeded, en.getValue());
                String str = (en.getKey() % 100 == 0)
                        ? String.format("+%dX%d", amountTaken, en.getKey() / 100)
                        : String.format("+%dX%.2f", amountTaken, en.getKey() / 100f);
                sb.append(str);
                change -= amountTaken * en.getKey();
                if (amountTaken == en.getValue())
                    it.remove();
                else
                    en.setValue(en.getValue() - amountTaken);
            }
            if (change > 0) {
                System.out.println("ERROR: OUT OF MONEY");
                Runtime.getRuntime().exit(1);
            }
            return sb.substring(1);
        }
    }
}
