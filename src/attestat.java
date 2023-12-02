public class attestat {

        private int math;
        private int history;
        private int russian;
        private double avg;

        public attestat() {
            math = 0;
            history = 0;
            russian = 0;
            avg = 0;
        }
        public void setMath(int nMath) {
            math = nMath;
        }
        public void setHistory(int nHistory) {
            history = nHistory;
        }
        public void setRussian(int nRussian) {
            russian = nRussian;
        }
        public void setAvg() {
            avg = (float)(math + history + russian) / 3.;
        }
        public int getMath() {
            return math;
        }
        public int getHistory() {
            return history;
        }
        public int getRussian() {
            return russian;
        }
        public double getAvg() {
            return avg;
        }

}
