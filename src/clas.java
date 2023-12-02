class clas {

    private int num;
    private char b;
    private int count;
    private double avg;

    public student[] stt = new student[30];

    clas() {
        for (int i = 0;i<30;i++)
            stt[i] = new student();
    }

    public void setNum(int nNum) {
        num = nNum;
    }
    public void setB(char nB) {
        b = nB;
    }
    public void setCount(int nCount) {
        count = nCount;
    }
    public void setAvg(double nAvg) {
        avg = nAvg;
    }

    public int getNum() {
        return num;
    }
    public char getB() {
        return b;
    }
    public int getCount() {
        return count;
    }
    public double getAvg() {
        return avg;
    }

}
