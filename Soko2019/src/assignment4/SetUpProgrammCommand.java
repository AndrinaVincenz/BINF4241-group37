package assignment4;

import java.util.Scanner;

public class SetUpProgrammCommand implements Command {
	
	private String name = "SetUpProgram";
	private Programmable programmableObject;
	
	public SetUpProgrammCommand(Programmable programmable) {
		this.programmableObject = programmable;
	}

	@Override
	public void execute() {
		System.out.println("Choose a Program");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which Program?");
		for (int i = 0; i < programmableObject.getPrograms().size(); i++){
			System.out.println(programmableObject.getPrograms().get(i));
		}
		String tempInput = scanner.nextLine(); 
		programmableObject.setProgram(tempInput);
}

	@Override
	public String getName() {
		return name;
	}
	
}
