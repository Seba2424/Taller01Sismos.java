import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        double sismos [][]=new double[7][10];
        mostrarMenu();
        escogerOpcionMenu(sismos);
    }
    public static double [][] llenarMatriz(double matriz [][]){

        for(int i=0;i< matriz.length;i++){
            for(int j=0;j< matriz.length;j++){
                matriz[i][j]=(Math.random()*9.5+0);
            }
        }
        return matriz;
    }
    public static void imprimirMatriz(double matriz [][]){
        String resultado="";
        for(int i=0;i< matriz.length;i++){
            for(int j=0;j< matriz.length;j++){
                resultado=resultado+" - "+matriz[i][j];
            }
            resultado=resultado+"\n";
        }
        System.out.println(resultado);
    }
    public static double terremotoMayor(double matriz [][]){
        double mayor=matriz[0][0];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                if(matriz[i][j]>mayor){
                    mayor=matriz[i][j];
                    System.out.println("Los terremotos de mayor magnitud fueron de: "+mayor);
                }
            }
        }
        System.out.println("El ultimo valor es el de mayor magnitud");
        return mayor;
    }
    public static double terremotoMayorA(double matriz [][]){
        double mayora=5.0;
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                if(matriz[i][j]>mayora){
                    System.out.println("Los terremotos/sismos mayores a 5.0 fueron: "+matriz[i][j]);
                }
            }
        }
        return mayora;
    }
    public static void aletrarSMS(double matriz [][]){
        double alertar=7.0;
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                if(matriz[i][j]>alertar){
                    System.out.println("Alerta!!! se debe evacuar zona costera! "+matriz[i][j]);
                }
            }
        }
    }

    public static void mostrarMenu(){
        System.out.println("Bienvenid@");
        System.out.println("[1] Generar sismos/terremoto");
        System.out.println("[2] Mostrar sismos/terremotos de mayor magnitud");
        System.out.println("[3] Mostrar sismo/terremoto mayores o iguales a 5.0");
        System.out.println("[4] Enviar SMS por cada terremoto mayor o igual a 7.0");
        System.out.println("");
        System.out.println("[0] Salir");
    }
    public static boolean escogerOpcionMenu(double[][] sismos){
        Scanner teclado = new Scanner(System.in);
        System.out.println(" ");
        boolean bandera=true;
        while (bandera=true){
            switch (Validar(4)){
                case 1:
                    llenarMatriz(sismos);
                    imprimirMatriz(sismos);
                    System.out.println("Ahora que ya se generaron los sismos/terremotos puede usar las opciones :");
                    System.out.println("[2] Mostrar sismos/terremotos de mayor magnitud");
                    System.out.println("[3] Mostrar sismo/terremoto mayores o iguales a 5.0");
                    System.out.println("[4] Enviar SMS por cada terremoto mayor o igual a 7.0");
                    System.out.println("");
                    System.out.println("[0] Salir");
                    switch (Validar(4)) {
                        case 2:
                            terremotoMayor(sismos);
                            break;
                        case 3:
                            terremotoMayorA(sismos);
                            break;
                        case 4:
                            aletrarSMS(sismos);
                            break;
                        case 0:
                            break;
                    }
                case 0:
                    break;
            }
            System.out.println("Escoja una opcion valido, comenzando por [1]");
            return bandera=false;
        }
        return bandera=false;
    }
    public static int Validar(int x) {
        int n = -1;
        do {
            Scanner teclado = new Scanner(System.in);
            try {
                n = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Error");
            }
            if (n < 0 || n > x) {
                System.out.println("ingrese un numero valido");
            }
        } while (n < 0 || n > x);
        return n;
    }
}
