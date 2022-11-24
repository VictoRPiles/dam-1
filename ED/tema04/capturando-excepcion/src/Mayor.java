public class Mayor {
	/** @return El elemento más grande de una lista */
	public static int getMayorNum(int[] lista) {
		int max = Integer.MIN_VALUE;

		for (int i : lista) {
			if (i > max) max = i;
		}

		return max;
	}
}