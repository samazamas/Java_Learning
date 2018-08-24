import java.util.Arrays;

public class Trikampiai03 {
    public static void main(String[] args) {
        int a = 2;
        int b = 10;
        int c = 8;
        int p = ((a+b+c)/2);
        double roundOff = Math.sqrt((p*(p-a)*(p-b)*(p-c)));
        double plotas = Math.round(roundOff*100)/100.00;
        String.format("%.2f", plotas);

        if (a < b + c && b < a + c && c < a + b && a==b && b==c && a==c) {
            System.out.println("Gali būti trikampiu" + " lygiakraščiu");
            System.out.println("Plotas=" + plotas);
        } else if (a < b + c && b < a + c && c < a + b && (a==b || a==c || b==c)) {
            System.out.println("Gali būti trikampiu" + " lygiašoniu");
            System.out.println("Plotas=" + plotas);
        } else if (a < b + c && b < a + c && c < a + b) {
            System.out.println("Gali būti trikampiu" + " įvairiakraščiu");
            System.out.println("Plotas=" + plotas);
        } else {
            System.out.println(" Negali būti trikampiu");
        }
//        if (a == b && b == c) {
//            System.out.println("Trikampis yra lygiakrastis");
//            System.out.println("Plotas=" + plotas);
//        } else if (a == b || a == c || b ==c) {
//            System.out.println("Trikampis yra lygiasonis");
//            System.out.println("Plotas=" + plotas);
//        } else {
//            System.out.println("Trikampis yra ivairiakrastis");
//            System.out.println("Plotas=" + plotas);
//        }
        // Masyvo rusiavimas
//        int [] bala;
//        bala = new int [] {-10, 0, 2, 9, -5};
//        System.out.println(bala);

        int[] MyArray = {-10, 0, 2, 9, -5};

        System.out.println("Arejus: " + Arrays.toString(MyArray));
        for(int i=0; i<MyArray.length; i++){
            for(int j=0; j<MyArray.length; j++){
                if (MyArray[j] > MyArray[i]) {
                    MyArray[i] = MyArray[i] + MyArray[j];
                    MyArray[j] = MyArray[i] - MyArray[j];
                    MyArray[i] = MyArray[i] - MyArray[j];
                }
            }
        }
        System.out.println("Pakeistas arejus: " + Arrays.toString(MyArray));
    }
}
