package practica1.java;


public class Semanubi {
    public static void main(String[] args) {
        String[] semana = {"lunes", "martes", "miercoles", "jueves", "viernes"};
        String[] semanubi = new String[semana.length];

        for (int i = 0; i < semana.length; i++) {
            String dia = semana[i];
            String diubi = "";
            for (int j = 0; j < dia.length() - 2; j++) {
                diubi += dia.charAt(j);
            }

            diubi += "ernes";
            semanubi[i] = diubi;
        }

        for (String diubi : semanubi) {
            System.out.println(diubi);
        }
    }
}