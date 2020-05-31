
public class Exercicios {

	/**
	 * 2. Implemente, em uma classe qualquer, um método que recebe duas filas q1, e q2 de
	 * inteiros e transfere os elementos da segunda para a primeira de modo que eles fiquem
	 * na frente dos originais. Exemplo: supondo q1 = {1, 2, 3, 4} e q2 = {5, 6, 7, 8}, após a
	 * chamada do método devemos ter q1 = {5, 6, 7, 8, 1, 2, 3, 4} e q2 = {}. Dica: use uma fila
	 * auxiliar.
	 */
	public void prependQueue(Queue<Integer> q1, Queue<Integer> q2) {
		
	}
	
	/**
	 * 3. Implemente, em uma classe qualquer, um método que remove todas as ocorrências de
	 * um determinado elemento em uma fila de caracteres. 
	 */
	public void exterminateFromQueue(Queue<Character> q, char element) {
		
	}
	
	/**
	 * 9. Em uma classe qualquer, implemente um método que recebe uma StaticQueue<Character>
	 * chamada letters e uma String chamada word por parâmetro. Caso os caracteres de letters
	 * (na ordem recebida) formem a palavra word, o método retorna um array contendo os caracteres
	 * de letters invertidos. Caso contrário, o método retorna null. Dica: use uma estrutura
	 * adicional para auxiliar. Utilize a assinatura abaixo:
	 */
	public Character[] invertLetters(StaticQueue<Character> letters, String word) {
		String aux = "";
		while(!letters.isEmpty()) {
			aux += letters.dequeue();
		}
		if(aux.equals(word)) {
			Character[] auxChar = new Character[aux.length()];
			char [] letras = aux.toCharArray();
			for(int i = 0; i < aux.length(); i++) {
				auxChar[i] = letras[i];
			}
			return auxChar;
		} else {
			return null;
		}
	}
}
