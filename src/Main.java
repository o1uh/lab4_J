import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        functions f = new functions();
        school a = new school();
        int v = 0,c = 0;
        while (true) {

            do {
                try{
                f.menu();
                    System.out.printf("Введите пункт меню: ");
                    c = f.in.nextInt();
                    v = 1;
                }
                catch (Exception ex) {
                    System.out.printf("Ошибка ввода. Попробуйте снова");
                    v = 0;
                    f.p();
                }
                f.cl();
            } while (c > 6 || c < 1 || v < 1);
            switch (c)
            {
                case 1: {
                    f.vivod(a);
                    break;
                }
                case 2: {
                    f.create_class(a);
                    break;
                }
                case 3: {
                    f.del(a);
                    break;
                }
                case 4: {
                    f.red_class(a);
                    break;
                }
                case 5: {
                    System.exit(0);
                    break;
                }
                case 6:{
                    int r = f.students();
                    System.out.printf("В настоящий момент всего студентов: %d",r);
                    f.cl();
                    break;
                }
                default:
                    break;
            }
        }
    }
}
