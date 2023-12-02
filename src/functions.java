import java.io.IOException;
import java.util.Scanner;

public class functions {
    Scanner in = new Scanner(System.in);
    void p() {
        in.nextLine();
    }
    void press()
    {
        System.out.println("\nНажмите enter чтобы продолжить...");
        p();
    }
    void cl()  {
        press();
        String clear = "\n".repeat(60);
        System.out.print(clear);
    }

     void cl_ogl() { //ф-я вывода оглавления
        String[] ogl = {
            "Класс",
            "Количество учеников",
            "Средний балл аттестации"
        };
        System.out.printf("\n%s", ogl[0]);
        for (int i = 1; i < 3; i++)
            System.out.printf("%25s", ogl[i]);
        System.out.printf("\n");
    }
    void st_ogl() { //ф-я вывода оглавления
        String[] ogl = {
            "ФИО",
                "Математика",
                "История",
                "Русский язык",
                "Средний балл аттестации"
        };
        System.out.printf("\n");
        for (int i = 0; i < 5; i++)
            System.out.printf("%25s", ogl[i]);
        System.out.printf("\n");
    }
    void menu() {
        String[] razdel = {
            "Вывод",
                    "Добавление",
                    "Удаление",
                    "Редактирование",
                    "Выход из программы",
                    "Узнать общее количество учеников"
        };
        for (int i = 0; i < 6; i++)
            System.out.printf("%d) %s\n", i + 1, razdel[i]);
        System.out.printf("\n");
    }
    int students(){return student.getCount();}
    void red_avg(school scl, int n, int i) {
        double s = 0;
        scl.cls[n].stt[i].att.setAvg();
        for (int j = 0; j < scl.cls[n].getCount(); j++) {
            s += (double)(scl.cls[n].stt[j].att.getAvg());
        }
        scl.cls[n].setAvg(s / (double)(scl.cls[n].getCount()));
    }
    void vivod_scl(school scl, int n_class) {
        cl_ogl();
        for (int i = 0; i < n_class; i++) {
            System.out.printf("%4d%s %24d %24.2f\n", scl.cls[i].getNum(), scl.cls[i].getB(), scl.cls[i].getCount(), scl.cls[i].getAvg());
        }
    }
    void vivod_cls(school scl, int i) {
        st_ogl();

        for (int j = 0; j < scl.cls[i].getCount(); j++)
            System.out.printf("%d)%24s %24d %24d %24d %22.2f\n", j + 1, scl.cls[i].stt[j].getFio(), scl.cls[i].stt[j].att.getMath(), scl.cls[i].stt[j].att.getHistory(), scl.cls[i].stt[j].att.getRussian(), scl.cls[i].stt[j].att.getAvg());
    }
    void vivod(school scl) {
        if (scl.getN_cl() > 0) {
            int v = 0, c=0;
            do {
                try {
                    System.out.printf("1)Вывод всех классов\n2)Вывод состава отдельного класса\n");
                    System.out.printf("Введите пункт меню: ");
                    c = in.nextInt();
                    v = 1;
                }
                catch (Exception ex) {
                    System.out.printf("Ошибка ввода. Попробуйте снова");
                    v = 0;
                    p();
                }
                cl();
            } while (c > 2 || c < 1 || v < 1);
            switch (c)
            {
                case 2: {
                    int num = 0, p = 0;
                    char b;
                    do {
                        try {
                            System.out.printf("Введите номер класса (1-11): ");
                            num = in.nextInt();
                            v = 1;
                        }
                        catch (Exception ex){
                            System.out.printf("Ошибка ввода. Попробуйте снова");
                            v = 0;
                            p();
                        }
                    } while (num > 11 || num < 1 || v < 1);

                    System.out.printf("Введите букву класса: ");
                    p();
                    b = in.next().charAt(0);
                    for (int i = 0; i < scl.getN_cl(); i++) {
                        if (scl.cls[i].getB() == b && num == scl.cls[i].getNum()) {
                            vivod_cls(scl, i);
                            p = 1;
                            break;
                        }
                    }
                    if (p == 0) {
                        System.out.printf("Такого класса нет");
                    }
                    break;
                }
                case 1: {
                    vivod_scl(scl, scl.getN_cl());
                    break;
                }

                default:
                    break;
            }
        }
    else
        System.out.printf("База классов пуста.\n");
    cl();
    }

    int create_class(school scl) {
        int st = 0, s = 0, n = scl.getN_cl(), c = 0, num = 0, v;
        char b;
        String f;
        do {
            try {
            System.out.printf("1)Добавить класс\n2)Добавить ученика в класс\n");
            System.out.printf("Введите пункт меню: ");
                c = in.nextInt();
                v = 1;
            }
            catch (Exception ex) {
                System.out.printf("Ошибка ввода. Попробуйте снова");
                v = 0;
                p();
            }
            cl();
        } while (c > 2 || c < 1 || v < 1 );

        switch (c) {
            case 1: {
                if (n == 5) {
                    System.out.printf("Места под классы больше нет");
                    cl();
                    return 0;
                }

                do {
                    try {
                        System.out.printf("Введите номер класса (1-11): ");
                        num = in.nextInt();
                        v = 1;
                    }
                    catch (Exception ex){
                        System.out.printf("Ошибка ввода. Попробуйте снова");
                        p();
                    }
                } while (num > 11 || num < 1 || v < 1);p();
                System.out.printf("Введите букву класса: ");
                b = in.next().charAt(0);
                do {
                    try {
                        System.out.printf("Введите, сколько учеников хотите добавить: ");
                        st = in.nextInt();
                        v = 1;
                    }
                    catch (Exception ex){
                        System.out.printf("Ошибка ввода. Попробуйте снова");
                        v = 0;
                        p();
                    }
                } while (st < 1 || v < 1 || st > 30);
                scl.cls[n].setB(b);
                scl.cls[n].setNum(num);
                scl.cls[n].setCount(st);
                student.setCount(st);
                scl.setN_cl(scl.getN_cl() + 1);
                for (int i = 0; i < st; i++) {
                    System.out.printf("Ученик %d:\n", i + 1);
                    do {
                        System.out.printf("Введите ФИО (25 символов максимум): ");
                        p();
                        f = in.nextLine();
                    }while (f.length()>25);
                    scl.cls[n].stt[i].setFio(f);

                    do {
                        try {
                            System.out.printf("Введите аттестацию за математику (2-5): ");
                            num = in.nextInt();
                            v = 1;
                        }
                        catch (Exception ex){
                            System.out.printf("Ошибка ввода. Попробуйте снова");
                            v = 0;
                            p();
                        }
                    } while (num > 5 || num < 2 || v < 1);
                    scl.cls[n].stt[i].att.setMath(num);
                    s += num;

                    do {
                        try {
                            System.out.printf("Введите аттестацию за историю (2-5): ");
                            num = in.nextInt();
                            v = 1;
                        }
                        catch (Exception ex){
                            System.out.printf("Ошибка ввода. Попробуйте снова");
                            v = 0;
                            p();
                        }
                    } while (num > 5 || num < 2 || v < 1);
                    scl.cls[n].stt[i].att.setHistory(num);
                    s += num;
                    do {
                        try {
                            System.out.printf("Введите аттестацию за русский (2-5): ");
                            num = in.nextInt();
                            v = 1;
                        }
                        catch (Exception ex){
                            System.out.printf("Ошибка ввода. Попробуйте снова");
                            v = 0;
                            p();
                        }
                    } while (num > 5 || num < 2 || v < 1);
                    scl.cls[n].stt[i].att.setRussian(num);
                    s += num;
                    scl.cls[n].stt[i].att.setAvg();
                }
                scl.cls[n].setAvg((double)s / ((double)scl.cls[n].getCount() * 3.f));
                cl();
                break;
            }
            case 2: {
                c = 0;
                if (n < 1) {
                    System.out.printf("База классов пуста.\n");
                    cl();
                    return 0;
                }
                do {
                    try {
                        System.out.printf("Введите номер класса (1-11): ");
                        num = in.nextInt();
                        v = 1;
                    }
                    catch (Exception ex){
                        System.out.printf("Ошибка ввода. Попробуйте снова");
                        v = 0;
                        p();
                    }
                } while (num > 11 || num < 1 || v < 1);

                System.out.printf("Введите букву класса: ");
                p();
                b = in.next().charAt(0);

                for (int i = 0; i < n; i++) {
                    if (scl.cls[i].getB() == b && num == scl.cls[i].getNum()) {
                        if (scl.cls[i].getCount() == 30) {
                            System.out.printf("Места под учащихся больше нет");
                            cl();
                            return 0;
                        }
                        do {
                            System.out.printf("Введите ФИО (25 символов максимум): ");
                            p();
                            f = in.nextLine();
                        }while (f.length()>25);
                        scl.cls[i].stt[scl.cls[i].getCount()].setFio(f);
                        student.setCount(1);
                        do {
                            try {
                                System.out.printf("Введите аттестацию за математику (2-5): ");
                                num = in.nextInt();
                                v = 1;
                            }
                            catch (Exception ex){
                                System.out.printf("Ошибка ввода. Попробуйте снова");
                                v = 0;
                                p();
                            }
                        } while (num > 5 || num < 2 || v < 1);
                        scl.cls[i].stt[scl.cls[i].getCount()].att.setMath(num);


                        do {
                            try {
                                System.out.printf("Введите аттестацию за историю (2-5): ");
                                num = in.nextInt();
                                v = 1;
                            }
                            catch (Exception ex){
                                System.out.printf("Ошибка ввода. Попробуйте снова");
                                v = 0;
                                p();
                            }
                        } while (num > 5 || num < 2 || v < 1);
                        scl.cls[i].stt[scl.cls[i].getCount()].att.setHistory(num);

                        do {
                            try {
                                System.out.printf("Введите аттестацию за русский (2-5): ");
                                num = in.nextInt();
                                v = 1;
                            }
                            catch (Exception ex){
                                System.out.printf("Ошибка ввода. Попробуйте снова");
                                v = 0;
                                p();
                            }
                        } while (num > 5 || num < 2 || v < 1);
                        scl.cls[i].stt[scl.cls[i].getCount()].att.setRussian(num);

                        scl.cls[i].setCount(scl.cls[i].getCount() + 1);
                        red_avg(scl, i, scl.cls[i].getCount() - 1);

                        c = 1;
                    }
                }
                if (c == 0)
                    System.out.printf("Такого класса нет");
                p();
                cl();
                break;

            }
            default:
                break;
        }
        return 0;
    }
    void red_class(school scl) {
        char b;
        String f;
        int v = 0, num = 0, n = scl.getN_cl(), p = 0, att = 0;

        do {
            try {
                System.out.printf("Введите номер класса (1-11): ");
                num = in.nextInt();
                v = 1;
            }
            catch (Exception ex){
                System.out.printf("Ошибка ввода. Попробуйте снова");
                v = 0;
                p();
            }
        } while (num > 11 || num < 1 || v < 1);p();
        System.out.printf("Введите букву класса: ");
        b = in.next().charAt(0);

        for (int i = 0; i < n; i++) {
            if (scl.cls[i].getB() == b && num == scl.cls[i].getNum()) {

                do {
                    try {
                    vivod_cls(scl, i);
                        System.out.printf("Введите номер ученика, информацию которого хотите отредактировать: ");
                        num = in.nextInt();
                        v = 1;
                    }
                    catch (Exception ex){
                        System.out.printf("Ошибка ввода. Попробуйте снова");
                        p();
                    }
                } while (num - 1 > scl.cls[i].getCount() || num < 1 || v < 1);

                do {
                    try {
                    vivod_cls(scl, i);
                        System.out.printf("Введите номер пункта, который хотите отредактировать: ");
                        p = in.nextInt();
                        v = 1;
                    }
                    catch (Exception ex){
                        System.out.printf("Ошибка ввода. Попробуйте снова");
                        v = 0;
                        p();
                    }
                } while (p > 4 || p < 1 || v < 1);

                switch (p) {
                    case 1: {
                        do{
                        System.out.printf("Введите новое ФИО: ");
                            p();
                            f = in.nextLine();
                        }while (f.length()>25);
                        scl.cls[i].stt[num - 1].setFio(f);
                        break;
                    }
                    case 2: {
                        do {
                            try{
                                System.out.printf("Введите новую аттестацию за математику (2-5): ");
                                att = in.nextInt();
                                v = 1;
                            }
                            catch (Exception ex){
                                System.out.printf("Ошибка ввода. Попробуйте снова");
                                v = 0;
                                p();
                            }
                        } while (att > 5 || att < 2 || v < 1);
                        scl.cls[i].stt[num - 1].att.setMath(att);
                        red_avg(scl, i, num - 1);
                        break;
                    }
                    case 3: {
                        do {
                            try{
                                System.out.printf("Введите новую аттестацию за историю (2-5): ");
                                att = in.nextInt();
                                v = 1;
                            }
                            catch (Exception ex){
                                System.out.printf("Ошибка ввода. Попробуйте снова");
                                v = 0;
                                p();
                            }
                        } while (att > 5 || att < 2 || v < 1);
                        scl.cls[i].stt[num - 1].att.setHistory(att);
                        red_avg(scl, i, num - 1);
                        break;
                    }
                    case 4: {
                        do {
                            try{
                                System.out.printf("Введите новую аттестацию за русский (2-5): ");
                                att = in.nextInt();
                                v = 1;
                            }
                            catch (Exception ex){
                                System.out.printf("Ошибка ввода. Попробуйте снова");
                                v = 0;
                                p();
                            }
                        } while (att > 5 || att < 2 || v < 1);
                        scl.cls[i].stt[num - 1].att.setRussian(att);
                        red_avg(scl, i, num - 1);
                        break;
                    }
                    default:
                        break;
                }
                p = 1;
                break;
            }

        }
        if (p == 0) {
            System.out.printf("Такого класса нет");
            cl();
        }

    }

    void del(school scl) {
        char b;
        String f;
        int v = 0, num = 0, n = scl.getN_cl(), p = 0, att = 0;
        do {
            try {
                System.out.printf("1)удалить класс\n2)Удалить ученика\nВведите номер пункта, по которому будет происходить удаление: ");
                p = in.nextInt();
                v = 1;
            }
            catch (Exception ex) {
                System.out.printf("Ошибка ввода. Попробуйте снова");
                v = 0;
                p();
            }
            cl();
        } while (p > 2 || p < 1 || v < 1);

        switch (p) {

            case 1: {
                p = 0;
                do {
                    try {
                        System.out.printf("Введите номер класса (1-11): ");
                        num = in.nextInt();
                        v = 1;
                    }
                    catch (Exception ex){
                        System.out.printf("Ошибка ввода. Попробуйте снова");
                        v = 0;
                        p();
                    }
                } while (num > 11 || num < 1 || v < 1);

                System.out.printf("Введите букву класса: ");
                b = in.next().charAt(0);

                for (int i = 0; i < n; i++) { // через деструктор?
                    if (scl.cls[i].getB() == b && num == scl.cls[i].getNum()) {
                        student.setCount(-(scl.cls[i].getCount()));
                        for (int j = i; j < n; j++) {
                            scl.cls[j] = scl.cls[j + 1];
                        }
                        scl.setN_cl(scl.getN_cl() - 1);
                        p = 1;
                        break;
                    }

                }
                if (p == 0) {
                    System.out.printf("Такого класса нет");
                    cl();
                }
                break;
            }
            case 2: {
                p = 0;
                do {
                    try {
                        System.out.printf("Введите номер класса (1-11): ");
                        num = in.nextInt();
                        v = 1;
                    }
                    catch (Exception ex){
                        System.out.printf("Ошибка ввода. Попробуйте снова");
                        v = 0;
                        p();
                    }
                } while (num > 11 || num < 1 || v < 1);

                System.out.printf("Введите букву класса: ");
                b = in.next().charAt(0);

                for (int i = 0; i < n; i++) {
                    if (scl.cls[i].getB() == b && num == scl.cls[i].getNum()) {
                        do {
                            try{
                            vivod_cls(scl, i);
                            System.out.printf("Введите номер ученика, информацию которого хотите удалить: ");
                                num = in.nextInt();
                                v = 1;
                            }
                            catch (Exception ex){
                                System.out.printf("Ошибка ввода. Попробуйте снова");
                                v = 0;
                                p();
                            }
                        } while (num - 1 > scl.cls[i].getCount() || num < 1 || v < 1);
                        student.setCount(-1);
                        for (int j = num - 1; j < scl.cls[i].getCount(); j++) {
                            scl.cls[i].stt[j] = scl.cls[i].stt[j + 1];
                        }
                        scl.cls[i].setCount(scl.cls[i].getCount() - 1);
                        if (scl.cls[i].getCount() == 0) {
                            for (int j = i; j < n; j++) {
                                scl.cls[j] = scl.cls[j + 1];
                            }
                            scl.setN_cl(scl.getN_cl() - 1);
                        }
                        p = 1;
                        break;
                    }

                }
                if (p == 0) {
                    System.out.printf("Такого класса нет");
                    cl();
                }
                break;
            }
            default:
                break;
        }
    }
}



