import java.util.Scanner;

public class SimpleDict {
	public static void main(String[] args) {
		Dictionary dict = new Dictionary();

		Scanner input = new Scanner(System.in);
		String command = new String();
		String[] commands = new String[3];

		dict.loadDictionaryFromFile("D:\\Workspace\\oop-asg021-SimpleDict\\DICT.DAT");
		dict.use();
		do {
			System.out.print("> ");
			command = input.nextLine();
			commands = command.split(" ", 3);
			switch (commands[0]) {
			case "add":
				dict.add(commands[1], commands[2]);
				break;
			case "lookup":
				dict.lookup(commands[1]);
				break;
			case "delete":
				dict.delete(commands[1]);
				break;
			case "save":
				dict.save("D:\\Workspace\\oop-asg021-SimpleDict\\DICT.DAT");
				break;
			case "quit":
				break;
			default:
				System.out.println("Error!");
			}
		} while (commands[0].equals("quit") == false);

		input.close();
	}

}