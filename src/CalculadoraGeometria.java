import java.util.Scanner;

class CalculadoraGeometria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] historialFig = new String[20];
        double[] historialArea = new double[20];
        double[] historialPerimetro = new double[20];
        int idx = 0;

        System.out.println("Calculadora Geometrica - Areas y Perimetros");

        while(true) {
            System.out.println("[1] Circulo");
            System.out.println("[2] Rectangulo");
            System.out.println("[3] Triangulo");
            System.out.println("[4] Cilindro");
            System.out.println("[5] Ver historial y Salir");
            System.out.print("Seleccione figura: ");
            int opcion = sc.nextInt();

            if (opcion == 5) {
                System.out.println("Historial de Calculos");
                double totalArea = 0;
                for (int i = 0; i < idx; i++) {
                    System.out.println((i+1) + ". " + historialFig[i] +
                            " -> Area: " + historialArea[i] +
                            ", Perimetro/Volumen: " + historialPerimetro[i]);
                    totalArea += historialArea[i];
                }
                System.out.println("Area total acumulada: " + totalArea);
                System.out.println("Gracias por usar la calculadora.");
                break;
            }

            double valor1 = 0;
            double valor2 = 0;

            if (opcion == 1) {
                System.out.print("Radio: ");
                valor1 = sc.nextDouble();
                if (valor1 > 0) {
                    double area = Math.PI * valor1 * valor1;
                    double perimetro = 2 * Math.PI * valor1;
                    System.out.println("Area: " + area);
                    System.out.println("Perimetro: " + perimetro);
                    if(idx < 20) {
                        historialFig[idx] = "Circulo";
                        historialArea[idx] = area;
                        historialPerimetro[idx] = perimetro;
                        idx++;
                    }
                    System.out.println("Calculo completado.");
                } else {
                    System.out.println("Radio invalido");
                }
            } else if (opcion == 2) {
                System.out.print("Base: ");
                valor1 = sc.nextDouble();
                System.out.print("Altura: ");
                valor2 = sc.nextDouble();
                if (valor1 > 0 && valor2 > 0) {
                    double area = valor1 * valor2;
                    double perimetro = 2 * (valor1 + valor2);
                    System.out.println("Area: " + area);
                    System.out.println("Perimetro: " + perimetro);
                    if(idx < 20) {
                        historialFig[idx] = "Rectangulo";
                        historialArea[idx] = area;
                        historialPerimetro[idx] = perimetro;
                        idx++;
                    }
                    System.out.println("Calculo completado.");
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else if (opcion == 3) {
                System.out.print("Lado 1: ");
                valor1 = sc.nextDouble();
                System.out.print("Lado 2: ");
                valor2 = sc.nextDouble();
                System.out.print("Lado 3: ");
                double valor3 = sc.nextDouble();
                if (valor1 > 0 && valor2 > 0 && valor3 > 0) {
                    double s = (valor1 + valor2 + valor3) / 2;
                    double area = Math.sqrt(s * (s - valor1) * (s - valor2) * (s - valor3));
                    double perimetro = valor1 + valor2 + valor3;
                    System.out.println("Area: " + area);
                    System.out.println("Perimetro: " + perimetro);
                    if(idx < 20) {
                        historialFig[idx] = "Triangulo";
                        historialArea[idx] = area;
                        historialPerimetro[idx] = perimetro;
                        idx++;
                    }
                    System.out.println("Calculo completado.");
                } else {
                    System.out.println("Lados invalidos o no forman un triangulo");
                }
            } else if (opcion == 4) {
                System.out.print("Radio: ");
                valor1 = sc.nextDouble();
                System.out.print("Altura: ");
                valor2 = sc.nextDouble();
                if (valor1 > 0 && valor2 > 0) {
                    double areaBase = Math.PI * valor1 * valor1;
                    double areaLateral = 2 * Math.PI * valor1 * valor2;
                    double areaTotal = 2 * areaBase + areaLateral;
                    double volumen = areaBase * valor2;
                    System.out.println("Area Superficial: " + areaTotal);
                    System.out.println("Volumen: " + volumen);
                    if(idx < 20) {
                        historialFig[idx] = "Cilindro";
                        historialArea[idx] = areaTotal;
                        historialPerimetro[idx] = volumen;
                        idx++;
                    }
                    System.out.println("Calculo completado.");
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else {
                System.out.println("Opcion no valida");
            }
        }
        sc.close();
    }
}
