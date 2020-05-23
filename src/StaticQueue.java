/**
 * Implementa��o de uma Fila com armazenamento est�tico,
 * baseado em array.
 */
public class StaticQueue<E> implements Queue<E> {
	// �ndice para o primeiro elemento
	protected int first;

	// �ndice para o �ltimo elemento
	protected int last;

	// Array que armazena as refer�ncias para os elementos
	protected E elements[];

	/**
	 * Constr�i uma fila com um tamanho m�ximo.
	 * @param maxSize O tamanho m�ximo da fila
	 */
	public StaticQueue(int maxSize) {
		elements = (E[])new Object[maxSize];
		first = last = -1;
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#isEmpty()
	 */
	public boolean isEmpty() {
		return first == -1;
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#isFull()
	 */
	public boolean isFull() {
		return first == ((last + 1) % elements.length);
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#numElements()
	 */
	public int numElements() {
		if (isEmpty())
			return 0;
		else {
			int n = elements.length; // p/ legibilidade da express�o abaixo
			return ((n + last - first) % n) + 1;
		}
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#enqueue(java.lang.Object)
	 */
	public void enqueue(E element) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		else {
			if (last == -1)
				first = last = 0;
			else
				last = (last + 1) % elements.length;
			elements[last] = element;
		}

	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#dequeue()
	 */
	public E dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = elements[first];
		elements[first] = null; // p/ coleta de lixo
		if (first == last)
			first = last = -1;
		else
			first = (first + 1) % elements.length;

		return element;
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#front()
	 */
	public E front() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[first];
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#back()
	 */
	public E back() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[last];
	}

	/**
	 * Retorna uma representa��o String da fila.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (isEmpty())
			return "[Empty]";
		else {
			String s = "[" + elements[first];
			int n = numElements();
			for (int i = 1; i < n; i++) {
				int k = (first + i) % elements.length;
				s += ", " + elements[k];
			}
			s += "]";
			return s;
		}
	}
	
	/**
	 * 4. Implemente o método contains, definido abaixo, que informa se a fila contém
	 * determinado elemento.
	 */
	public boolean contains(E element) {
		for (int i = 0; i < numElements(); i++) {
			if(element == elements[i]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 5. Implemente um método que inverte a ordem dos elementos da fila.
	 */
	public void flip() {
		E[] aux = (E[])new Object[this.numElements()];		int cont = 0;
		for(int i = this.numElements() - 1; i >= 0; i--) {
			aux[cont] = this.elements[i];
			cont++;
		}
		this.elements = aux;
	}
	
	/**
	 * 6. Implemente uma sobrecarga do método enqueue que recebe como parâmetro uma fila,
	 * em vez de um elemento. Esse método deve adicionar ao final da fila corrente os
	 * elementos da fila passada como parâmetro, mantendo a ordem original.
	 */
	public void enqueue(Queue<E>lista) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		else {
			while(!lista.isEmpty()) {
				E aux = lista.dequeue();
				this.enqueue(aux);
			}
		}
	}
	
	/**
	 * 7. Implemente o método abaixo, que insere um elemento na primeira posição da fila.
	 */
	public void enqueueWithPriority(E element) throws OverflowException{
		if(isFull()) {
			throw new OverflowException();
		} else {	
			int tamanho = numElements();
			enqueue(element);
			for(int i = 0; i < tamanho; i++) {
				E aux = dequeue();
				enqueue(aux);
			}
		}
	}
	
	/**
	 * 8. Implemente um método equals para a fila. Uma fila será igual a outra se contiver os
	* mesmos elementos, dispostos na mesma ordem. Para comparar os elementos, use
	* também o método equals.
	 */
	public boolean equals(Queue<E>lista) {
		int tamanho = numElements();
		for(int i = 0; i < tamanho; i++) {
			E aux = lista.dequeue();
			if(elements[i] != aux) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 9. Implemente um método clone para a fila. Esse método deve retornar uma nova fila
	 * contendo os mesmos elementos da atual. Os elementos em si não devem ser
	 * duplicados.
	 */
	public Queue<E> clone() {
		Queue<E> aux = new StaticQueue<E>(numElements());
		int tamanho = numElements();
		for(int i = 0; i < tamanho; i++) {
			aux.enqueue(elements[i]);
		}
		return aux;
	}
}



