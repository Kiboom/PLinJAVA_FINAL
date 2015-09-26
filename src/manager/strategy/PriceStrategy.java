package manager.strategy;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import menus.Americano;
import menus.Kenya;
import menus.LatteCoffee;
import menus.MochaCoffee;


public class PriceStrategy {
	private static int americano, kenya, latte, mocha;
	private static Map<String, Integer> menu = new HashMap<String, Integer>();

	public static void initPriceList() {
		readStrategyFromFile();
		setPrice();
		printPrice();
	}

	private static void printPrice() {
		System.out.println("\n[가격 정보]");
		for(String key :menu.keySet()){
			System.out.println(String.format("%s : %d원    ", key, menu.get(key)));
		}
	}

	public static void setPrice(){
		menu.put("Americano", americano);
		menu.put("Kenya", kenya);
		menu.put("Milk", latte);
		menu.put("Mocha", mocha);
	}
	
	public static void readStrategyFromFile() {
		try {
			FileInputStream files = new FileInputStream("PriceStrategy.properties");
			Properties prop = new Properties();
			prop.load(files);
			setPriceForCoffee(prop);
			checkPropertyException();
			files.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void setPriceForCoffee(Properties prop) {
		americano = Integer.parseInt(prop.getProperty("AMERICANO"));
		kenya= Integer.parseInt(prop.getProperty("KENYA"));
		latte= Integer.parseInt(prop.getProperty("LATTE"));
		mocha= Integer.parseInt(prop.getProperty("MOCHA"));
		Americano.setPrice(americano);
		Kenya.setPrice(kenya);
		LatteCoffee.setDecoPrice(latte);
		MochaCoffee.setDecoPrice(mocha);
	}

	public static void checkPropertyException() throws Exception{
		if (americano<0 || kenya<0 || latte<0 || mocha<0) {
			throw new Exception("가격은 자연수만 가능합니다!");
		}
	}
	
	public static Map<String, Integer> getMenu() {
		return menu;
	}
}
