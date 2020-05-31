
public class TesteFila {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StaticQueue<Integer> fila = new StaticQueue<Integer>(7);
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(1);
		fila.enqueue(4);
		fila.enqueue(5);
		fila.enqueue(1);
		fila.ensureCapacity(8);
		fila.enqueue(8);

		
		//Queue<Integer> fila2 = fila.split(1);
		//fila.moveToBackAllOccurrencesOf(9);
		//System.out.println(fila.toString() + "\n\n");
		
		//System.out.println(fila2.toString());
		
		Exercicios e = new Exercicios();
		String palavra = "Hello";
		StaticQueue<Character> letras = new StaticQueue<Character>(5);
		letras.enqueue('H');
		letras.enqueue('e');
		letras.enqueue('l');
		letras.enqueue('l');
		
		Character[] retorno = e.invertLetters(letras, palavra);
		for(int i = 0; i < retorno.length; i++) {
			System.out.print(retorno[i].toString());
		}
	}

}
