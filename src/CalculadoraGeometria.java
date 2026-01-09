import java.util.Scanner;

class CalculadoraGeometria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] historialFig = new String[20];
        double[] historialArea = new double[20];
        double[] historialPerimetro = new double[20];
        int idx = 0;

        System.out.println("====================================");
        System.out.println("    Calculadora Geometrica");
        System.out.println("          Areas y Perimetros");
        System.out.println("====================================");

        while(true) {

            if (idx >= 20) {
                System.out.println("\n⚠️ Historial lleno. No se pueden agregar más calculos.");
                System.out.println("Seleccione [5] para ver historial y salir.");
            }

            System.out.println("\nSeleccione la figura que desea calcular:");
            System.out.println("[1] Circulo");
            System.out.println("[2] Rectangulo");
            System.out.println("[3] Triangulo");
            System.out.println("[4] Cilindro");
            System.out.println("[5] Ver historial y Salir");
            System.out.print("Opcion: ");
            int opcion = sc.nextInt();

            if (opcion == 5) {
                System.out.println("\n========== Historial de Calculos ==========");
                double totalArea = 0;
                for (int i = 0; i < idx; i++) {
                    System.out.println((i+1) + ". " + historialFig[i] +
                            " -> Area: " + historialArea[i] +
                            ", Perimetro/Volumen: " + historialPerimetro[i]);
                    totalArea += historialArea[i];
                }
                System.out.println("-------------------------------------------");
                System.out.println("Area total acumulada: " + totalArea);
                System.out.println("Gracias por usar la calculadora.");
                break;
            }

            double valor1 = 0;
            double valor2 = 0;

            if (opcion == 1) {
                System.out.print("Ingrese el radio del circulo: ");
                valor1 = sc.nextDouble();
                if (valor1 > 0 && idx < 20) {
                    double area = Math.PI * valor1 * valor1;
                    double perimetro = 2 * Math.PI * valor1;
                    System.out.println("Area: " + area);
                    System.out.println("Perimetro: " + perimetro);
                    historialFig[idx] = "Circulo";
                    historialArea[idx] = area;
                    historialPerimetro[idx] = perimetro;
                    idx++;
                    System.out.println("✅ Calculo completado.\n");
                } else {
                    System.out.println("❌ Radio invalido o historial lleno\n");
                }
            } else if (opcion == 2) {
                System.out.print("Ingrese la base del rectangulo: ");
                valor1 = sc.nextDouble();
                System.out.print("Ingrese la altura del rectangulo: ");
                valor2 = sc.nextDouble();
                if (valor1 > 0 && valor2 > 0 && idx < 20) {
                    double area = valor1 * valor2;
                    double perimetro = 2 * (valor1 + valor2);
                    System.out.println("Area: " + area);
                    System.out.println("Perimetro: " + perimetro);
                    historialFig[idx] = "Rectangulo";
                    historialArea[idx] = area;
                    historialPerimetro[idx] = perimetro;
                    idx++;
                    System.out.println("✅ Calculo completado.\n");
                } else {
                    System.out.println("❌ Dimensiones invalidas o historial lleno\n");
                }
            } else if (opcion == 3) {
                System.out.print("Ingrese la base del triangulo: ");
                valor1 = sc.nextDouble();
                System.out.print("Ingrese la altura del triangulo: ");
                valor2 = sc.nextDouble();
                System.out.print("Ingrese lado 1 del triangulo: ");
                double lado2 = sc.nextDouble();
                System.out.print("Ingrese lado 2 del triangulo: ");
                double lado3 = sc.nextDouble();
                if (valor1 > 0 && valor2 > 0 && lado2 > 0 && lado3 > 0 && idx < 20) {
                    double area = (valor1 * valor2) / 2;
                    double perimetro = valor1 + lado2 + lado3;
                    System.out.println("Area: " + area);
                    System.out.println("Perimetro: " + perimetro);
                    historialFig[idx] = "Triangulo";
                    historialArea[idx] = area;
                    historialPerimetro[idx] = perimetro;
                    idx++;
                    System.out.println("✅ Calculo completado.\n");
                } else {
                    System.out.println("❌ Datos invalidos o historial lleno\n");
                }
            } else if (opcion == 4) {
                System.out.print("Ingrese el radio del cilindro: ");
                valor1 = sc.nextDouble();
                System.out.print("Ingrese la altura del cilindro: ");
                valor2 = sc.nextDouble();
                if (valor1 > 0 && valor2 > 0 && idx < 20) {
                    double areaBase = Math.PI * valor1 * valor1;
                    double areaLateral = 2 * Math.PI * valor1 * valor2;
                    double areaTotal = 2 * areaBase + areaLateral;
                    double volumen = areaBase * valor2;
                    System.out.println("Area Superficial: " + areaTotal);
                    System.out.println("Volumen: " + volumen);
                    historialFig[idx] = "Cilindro";
                    historialArea[idx] = areaTotal;
                    historialPerimetro[idx] = volumen;
                    idx++;
                    System.out.println("✅ Calculo completado.\n");
                } else {
                    System.out.println("❌ Dimensiones invalidas o historial lleno\n");
                }
            } else {
                System.out.println("❌ Opcion no valida\n");
            }
        }
        sc.close();
    }
}
