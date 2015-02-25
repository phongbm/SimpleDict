import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dictionary {
	private Node head;

	public Dictionary() {
		head = null;
	}

	public void loadDictionaryFromFile(String fileName) {
		BufferedReader bufferedReader = null;
		try {
			String word;
			String meanings;
			String currentLine = null;
			bufferedReader = new BufferedReader(new FileReader(fileName));
			while ((currentLine = bufferedReader.readLine()) != null) {
				int index = currentLine.indexOf(":");
				word = currentLine.substring(0, index);
				meanings = currentLine.substring(index + 2,
						currentLine.length());
				Node node = new Node(word, meanings);
				if (head == null) {
					head = node;
				} else {
					Node currentNode = head;
					while (currentNode.next != null) {
						currentNode = currentNode.next;
					}
					currentNode.next = node;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return;
	}

	public void add(String word, String meanings) {
		Node newNode = new Node(word, meanings);
		if (head == null) {
			head = newNode;
			return;
		}
		if (head.word.compareTo(word) > 0) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node currentNode = head;
		while (currentNode.next != null) {
			if (currentNode.word.equals(word)) {
				if (currentNode.meanings.indexOf(meanings) < 0)
					currentNode.concatMeanings(meanings);
				else
					System.out.println("Word and meanings already exists!");
				return;
			}
			if (currentNode.next.word.compareTo(word) > 0) {
				newNode.next = currentNode.next;
				currentNode.next = newNode;
				return;
			}
			currentNode = currentNode.next;
		}
		if (currentNode.word.equals(word)) {
			if (currentNode.meanings.indexOf(meanings) < 0)
				currentNode.concatMeanings(meanings);
			else
				System.out.println("Word and meanings already exists!");
			return;
		}
		currentNode.next = newNode;
		return;
	}

	public void lookup(String word) {
		if (head == null) {
			System.out.println("Dictionary is empty!");
			return;
		}
		Node currentNode = head;
		while (currentNode != null) {
			if (currentNode.word.equals(word)) {
				System.out.println(currentNode.meanings);
				return;
			}
			currentNode = currentNode.next;
		}
		System.out.println("Not found!");
		return;
	}

	public void delete(String word) {
		if (head == null) {
			System.out.println("Dictionary is empty!");
			return;
		}
		if (head.word.equals(word)) {
			if (head.next == null) {
				head = null;
			} else {
				head = head.next;
			}
			System.out.println(word + " deleted!");
			return;
		}
		Node currentNode = head;
		while (currentNode.next != null) {
			if (currentNode.next.word.equals(word)) {
				currentNode.next = currentNode.next.next;
				System.out.println(word + " deleted!");
				return;
			}
			currentNode = currentNode.next;
		}
		if (currentNode.word.equals(word)) {
			currentNode = null;
			System.out.println(word + " deleted!");
			return;
		}
		System.out.println("Not found!");
		return;
	}

	public void save(String fileName) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(fileName));
			if (head == null) {
				System.out.println("Dictionary is empty!");
				return;
			}
			Node currentNode = head;
			while (currentNode.next != null) {
				bufferedWriter.write(currentNode.toString() + "\n");
				currentNode = currentNode.next;
			}
			bufferedWriter.write(currentNode.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedWriter != null)
					bufferedWriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return;
	}

	public void use() {
		System.out.println("> add <word>: <meanings>");
		System.out.println("> lookup <word>");
		System.out.println("> delete <word>");
		System.out.println("> save");
		System.out.println("> quit");
	}

}