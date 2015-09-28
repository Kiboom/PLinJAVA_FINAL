package manager.accounting;

public class Sales {
	private static int totalSales;

	public static int getTotalSales() {
		return totalSales;
	}

	/* 판매 장부에 기록하기 */
	public static void addTotalSales(int totalSales) {
		Sales.totalSales += totalSales;
	}
}
