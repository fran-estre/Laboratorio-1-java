package Laboratorio1;

public class Main {

	public static void main(String[] args) {

		System.out.println(
				"1. Cree una matriz unidimensional d de tipo long." + " Rellénela con los números del 3 al 20.");

		long[] d = createLong(3, 20);
		print(d);

		System.out.println("\n2. Cree una matriz unidimensional x de tipo double."
				+ " Rellénela con 15 números aleatorios que van desde -3.0 a 14.0.");

		double[] x = createDouble(15);
		print(x);

		System.out.println("\n3. Cree una matriz bidimensional d1 de 18*15."
				+ " Calcula sus elementos usando las siguientes fórmulas del deber");
		double[][] d1 = createDouble(d, x, 18, 15);
		print(d1);
	}

	private static void print(double[][] arrayToPrint) {
		for (int i = 0; i < arrayToPrint.length; i++) {
			for (int j = 0; j < arrayToPrint[i].length; j++) {
				System.out.format("%.5f%n", arrayToPrint[i][j]);
			}
			System.out.println();
		}
	}

	private static double[][] createDouble(long[] d, double[] x, int rows, int columns) {
		double[][] arrayToFill = new double[rows][columns];

		fill(arrayToFill, d, x);

		return arrayToFill;
	}

	private static void fill(double[][] arrayToFill, long[] d, double[] x) {
		for (int i = 0; i < d.length; i++) {
			if (d[i] == 13) {
				for (int j = 0; j < x.length; j++) {
					arrayToFill[i][j] = Math.tan(Math.atan(1 / Math.exp(Math.abs(x[j]))));
					// arrayToFill[i][j] = 1 / Math.exp(Math.abs(x[j])); 
					// tan is the inverse function of atan
					if (Double.isNaN(arrayToFill[i][j])) {
						System.out.println("Hola1 " + d[i] + " " + x[j]);
					}
				}
			} else if (d[i] == 5 || d[i] == 10 || d[i] == 14 || d[i] == 15 || d[i] == 16 || d[i] == 17 || d[i] == 18
					|| d[i] == 19 || d[i] == 20) {
				for (int j = 0; j < x.length; j++) {
					//esta operación es problemática, no es estable numéricamente
					double exponente = Math.pow(x[j], (4 * x[j]));
					double innerExpression = ((Math.sin(x[j]) - 3) / 3) / 4;
					arrayToFill[i][j] = Math.sin(Math.pow(innerExpression, exponente));

					if (Double.isNaN(arrayToFill[i][j])) {
						System.out.println("Hola2 " + i + " " + j + " " + d[i] + " " + x[j] + " " + innerExpression
								+ " " + exponente);
					}
				}
			} else {
				for (int j = 0; j < x.length; j++) {
					arrayToFill[i][j] = Math.tan(Math.pow(Math.PI * (2 - Math.asin(Math.sin(x[j]))), 3));
					// arrayToFill[i][j] = Math.tan(Math.pow(Math.PI * (2 - x[j]), 3));
					if (Double.isNaN(arrayToFill[i][j])) {
						System.out.println("Hola3 " + d[i] + " " + x[j]);
					}
				}
			}
		}
	}

	private static long[] createLong(int start, int end) {
		// Size of array
		int arraySize = (end - start) + 1;

		// Declare a long array
		long[] arrayToFill = new long[arraySize];

		fill(arrayToFill, start);

		// Devuelve el vector con los valores que acabamos de llenar
		return arrayToFill;
	}

	private static void fill(long[] arrayToFill, int start) {
		for (int i = 0; i < arrayToFill.length; i++)
			arrayToFill[i] = start + i;
	}

	private static void print(long[] arrayToPrint) {
		for (int i = 0; i < arrayToPrint.length; i++)
			System.out.println(String.valueOf(arrayToPrint[i]));
	}

	private static double[] createDouble(int total) {
		// Size of array
		int arraySize = total;

		// Declare a long array
		double[] arrayToFill = new double[arraySize];

		fill(arrayToFill, -3.0, 14.0);

		// Devuelve el vector con los valores que acabamos de llenar
		return arrayToFill;
	}

	private static double[] fill(double[] arrayToFill, double min, double max) {

		// Math.random() genera números aleatorios entre [0,1]
		// a esos números los multiplicamos por el rango para que queden entre [0,rango]
		// osea [0,17] (esto es escalar)
		// les sumamos min para que queden entre [min, rango + min] osea [-3,14] (esto
		// es desplazar)
		double rango = (max - min);
		for (int i = 0; i < arrayToFill.length; i++) {
			double aleatorio = (double) (Math.random() * rango) + min;
			arrayToFill[i] = truncate(aleatorio, 5);
		}
		return arrayToFill;
	}

	private static void print(double[] arrayToPrint) {
		for (int i = 0; i < arrayToPrint.length; i++)
			System.out.println(String.valueOf(arrayToPrint[i]));
	}

	private static double truncate(double number, int decimalPlaces) {
		double potencia = Math.pow(10, decimalPlaces);
		return ((long) (number * potencia)) / potencia;
	}
}