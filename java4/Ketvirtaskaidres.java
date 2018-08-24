public class Ketvirtaskaidres {
    public static void main(String[] args) {
        // pirmas uzdavinys
        int [] a = {5, 6, 10, 15, 8, 4};
        int [] b = {8, 5, 3};
        int suma = 0;
        int suma2 = 0;
        for(int k = 0; k < a.length; k++) {
            suma += a[k];
        }
        System.out.println("masyvo elementu vidurkis = " + 1.0 * suma/a.length);
        for(int k = 0; k < b.length; k++) {
            suma2 += b[k];
        }
        System.out.println("masyvo elementu vidurkis = " + 1.0 * suma2/b.length);
        System.out.println("Masyvu skirtumas = " + ((1.0 * suma/a.length)- (+ 1.0 * suma2/b.length)));

        // antras uzdavinys

        int mazas = 1;
        int didelis = 1000;
        for (mazas = 1; mazas <= didelis; mazas++) {
            int stebuklingasSkaicius = 0;
            for (int s = 1; s < mazas; s++) {
                if ((mazas % s) == 0) {
                    stebuklingasSkaicius += s;
                }
            }
            if (stebuklingasSkaicius == mazas) {
                System.out.println("Tobulas skaicius yra: " + stebuklingasSkaicius);
            }
        }

    }
}

