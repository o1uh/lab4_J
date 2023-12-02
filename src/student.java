
public class student {
    private static int count =0;
        private String fio;
        attestat att = new attestat();
        student() {}
        public static void  setCount(int n){count += n;}
        public void setFio(String fio) {this.fio = fio;}
        public String getFio() {
            return fio;
        }
        public static int getCount(){return count;}


}
