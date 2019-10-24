import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Listar implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}
	
}

public class App {
	public static List<String> carregarLista(String... nomes) {
		List<String> lista = new ArrayList<String>();
		for (String nome : nomes) {
			lista.add(nome);
		}
		return lista;
	}

	public static void main(String[] args) {
		List<String> lista = carregarLista("Andrey");
		List<String> lista2 = carregarLista("Andrey", "Joao", "Jose", "Maria");
		lista2.stream()
			.filter(t -> t.contains("s".toLowerCase()))
			.forEach(System.out::println);
		lista.forEach(System.out::println);
		lista2.forEach(System.out::println);
	}
}
