
public class App {

	public static void metodo2() {
		System.out.println("Inicio do metodo2");
		try {
			int v[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			for (int i = 0; i <= 10; i++)
				System.out.println(v[i]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		System.out.println("Fim do metodo2");
	}

	public static void metodo1() {
		System.out.println("Inicio do metodo1");
		metodo2();
		System.out.println("Fim do metodo1");
	}

	public static void main(String[] args) {
		System.out.println("Inicio do main");
		metodo1();
		System.out.println("Fim do main");
	}
}
