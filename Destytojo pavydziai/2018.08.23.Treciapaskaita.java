public class Main {

    public static void main(String[] args) {
        int rezultatas=0;
        for (int i=1; i <=100; i++){
            rezultatas += i;
        }
        System.out.println("rezulatas = " + rezultatas);

        String a = "Jonas";
        String b = "Jonas";
//        if (a == b) {
//            System.out.println(a + " ir " + b + " lygios");
//        } else {
//            System.out.println(a + " ir " + b + " nelygios");
//        }
        System.out.println(a + " ir " + b + (a == b ? " lygios " : " nelygios "));

        int[] m;

        m = new int[]{2,3,4};

        m[2] = 12;
        //...
        m = new int[10];
        m[0] = 10;
        m[1] = 22;

        int suma = 0;
        for(int k = 0; k < m.length; k++) {
            suma += m[k];
        }
        System.out.println("masyvo elementu suma = " + suma);
        System.out.println("masyvo elementu vidurkis = " + 1.0 * suma/m.length);

    }
}
