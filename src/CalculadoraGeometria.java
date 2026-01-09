import java.util.Scanner;

class CalculadoraGeometria {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] histFig = new String[20];
        double[] histArea = new double[20];
        double[] histValor = new double[20]; // perimetro o volumen
        int idx = 0;

        System.out.println("Calculadora Geometrica - Areas y Perimetros");

        while (true) {
            System.out.println("\n[1] Circulo");
            System.out.println("[2] Rectangulo");
            System.out.println("[3] Triangulo");
            System.out.println("[4] Cilindro");
            System.out.println("[5] Ver historial y Salir");
            System.out.print("Seleccione figura: ");
            int op = sc.nextInt();

            if (op == 5) {
                System.out.println("\nHistorial de Calculos");
                double areaTotal = 0;

                for (int i = 0; i < idx; i++) {
                    System.out.println((i + 1) + ". " + histFig[i] +
                            " -> Area: " + histArea[i] +
                            ", Perimetro/Volumen: " + histValor[i]);
                    areaTotal += histArea[i];
                }

                System.out.println("Area total acumulada: " + areaTotal);
                System.out.println("Gracias por usar la calculadora.");
                break;
            }

            if (idx >= 20) {
                System.out.println("Historial lleno.");
                continue;
            }

            if (op == 1) { // Circulo
                System.out.print("Radio: ");
                double r = sc.nextDouble();

                if (r > 0) {
                    double area = Math.PI * r * r;
                    double perimetro = 2 * Math.PI * r;

                    System.out.println("Area: " + area);
                    System.out.println("Perimetro: " + perimetro);

                    histFig[idx] = "Circulo";
                    histArea[idx] = area;
                    histValor[idx] = perimetro;
                    idx++;

                    System.out.println("Calculo completado.");
                } else {
                    System.out.println("Radio invalido.");
                }

            } else if (op == 2) { // Rectangulo
                System.out.print("Base: ");
                double base = sc.nextDouble();
                System.out.print("Altura: ");
                double altura = sc.nextDouble();

                if (base > 0 && altura > 0) {
                    double area = base * altura;
                    double perimetro = 2 * (base + altura);

                    System.out.println("Area: " + area);
                    System.out.println("Perimetro: " + perimetro);

                    histFig[idx] = "Rectangulo";
                    histArea[idx] = area;
                    histValor[idx] = perimetro;
                    idx++;

                    System.out.println("Calculo completado.");
                } else {
                    System.out.println("Dimensiones invalidas.");
                }

            } else if (op == 3) { // Triangulo
                System.out.print("Base: ");
                double base = sc.nextDouble();
                System.out.print("Altura: ");
                double altura = sc.nextDouble();
                System.out.print("Lado 1: ");
                double l1 = sc.nextDouble();
                System.out.print("Lado 2: ");
                double l2 = sc.nextDouble();

                if (base > 0 && altura > 0 && l1 > 0 && l2 > 0) {
                    double area = (base * altura) / 2;
                    double perimetro = base + l1 + l2;

                    System.out.println("Area: " + area);
                    System.out.println("Perimetro: " + perimetro);

                    histFig[idx] = "Triangulo";
                    histArea[idx] = area;
                    histValor[idx] = perimetro;
                    idx++;

                    System.out.println("Calculo completado.");
                } else {
                    System.out.println("Datos invalidos.");
                }

            } else if (op == 4) { // Cilindro
                System.out.print("Radio: ");
                double r = sc.nextDouble();
                System.out.print("Altura: ");
                double h = sc.nextDouble();

                if (r > 0 && h > 0) {
                    double area = 2 * Math.PI * r * (r + h);
                    double volumen = Math.PI * r * r * h;

                    System.out.println("Area Superficial: " + area);
                    System.out.println("Volumen: " + volumen);

                    histFig[idx] = "Cilindro";
                    histArea[idx] = area;
                    histValor[idx] = volumen;
                    idx++;

                    System.out.println("Calculo completado.");
                } else {
                    System.out.println("Dimensiones invalidas.");
                }

            } else {
                System.out.println("Opcion no valida.");
            }
        }

        sc.close();
    }
}
