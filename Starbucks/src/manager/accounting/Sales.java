package manager.accounting;

public class Sales {
	private static int totalSales;

	public static int getTotalSales() {
		return totalSales;
	}

	public static void setTotalSales(int totalSales) {
		Sales.totalSales += totalSales;
	}
}
