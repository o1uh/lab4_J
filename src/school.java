class school {

    private int n_cl;

    public clas[] cls = new clas[5];
    public school() {
        n_cl = 0;
        for (int i = 0;i<5;i++)
            cls[i] = new clas();
    }

    public void setN_cl(int nN_cl) {
        n_cl = nN_cl;
    }
    public int getN_cl() {
        return n_cl;
    }

}