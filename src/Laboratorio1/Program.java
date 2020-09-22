package Laboratorio1;

public class Program {

	public static void main(String[] args) {

		System.out.println(
				"1. Cree una matriz unidimensional d de tipo long." + " Rell�nela con los n�meros del 3 al 20.");

		long[] d = createLong(3, 20);
		print(d);

		System.out.println("\n2. Cree una matriz unidimensional x de tipo double."
				+ " Rell�nela con 15 n�meros aleatorios que van desde -3.0 a 14.0.");

		double[] x = createDouble(15);
		print(x);

		System.out.println("\n3. Cree una matriz bidimensional d1 de 18*15."
				+ " Calcula sus elementos usando las siguientes f�rmulas.");
		double[][] d1 = createDouble(d, x, 18, 15);
		print(d1);
	}

	private static void print(double[][] d1) {

	}

	private static double[][] createDouble(long[] d, double[] x, int rows, int columns) {
		double[][] arrayToFill = new double[rows][columns];

		fill(arrayToFill, d, x);

		return arrayToFill;
	}

	private static void fill(double[][] arrayToFill, long[] d, double[] x) {
		
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

		// Math.random() genera n�meros aleatorios entre [0,1]
		// a esos n�meros los multiplicamos por el rango para que queden entre [0,rango]
		// osea [0,17] (esto es escalar)
		// les sumamos min para que queden entre [min, rango + min] osea [-3,14] (esto
		// es desplazar)
		double rango = (max - min);
		for (int i = 0; i < arrayToFill.length; i++) {
			double aleatorio = (double) (Math.random() * rango) + min;
			arrayToFill[i] = aleatorio;
		}
		return arrayToFill;
	}

	private static void print(double[] arrayToPrint) {
		for (int i = 0; i < arrayToPrint.length; i++)
			System.out.println(String.valueOf(arrayToPrint[i]));
	}
}