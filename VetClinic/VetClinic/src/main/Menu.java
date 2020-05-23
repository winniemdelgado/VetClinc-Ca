package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	//The method that takes the user's input.
	Scanner scanner = new Scanner(System.in);

	// This method is responsible to call the main menu and wait the user's input.
	public int showMenu() {
		this.showOptions();
		return this.scanner.nextInt();
	}

	//This method is responsible to call the sub menu under the user's input.
	public int showSubMenu(ArrayList<String> options) {
		this.showSubOptions(options);
		return this.scanner.nextInt();
	}

	//The main menu contains the options that the user wants to check.
	private void showOptions() {

		StringBuilder sb = new StringBuilder();
		sb.append("\n===== VET CLINIC =====\n");
		sb.append("1 - List all Staff\n");
		sb.append("2 - List Staff by category\n");
		sb.append("3 - List all Admin Staff by task\n");
		sb.append("4 - List all Staff by name\n");
		sb.append("5 - List all Animals\n");
		sb.append("6 - List all Animals by category\n");
		sb.append("7 - List all Animals by name\n");
		sb.append("8 - List all Animals by Medical Staff\n");
		sb.append("9 - Sort all Animals by Medical Staff\n");
		sb.append("10 - Show next Animal by Medical Staff\n");
		sb.append("0 - Exit\n");
		sb.append(selectOption());

		System.out.println(sb.toString());
	}

	//Here the code "read" the text inputs from the user.
	public String readInput(String message) {
		System.out.print(message);
		return scanner.next();
	}

	//Here is the list that contains the sub menu after user's input in the main menu.
	private void showSubOptions(ArrayList<String> options) {
		StringBuilder sb = new StringBuilder();
		for (String string : options) {
			sb.append("\n" + (options.indexOf(string) + 1) + " - " + string);
		}
		sb.append("\n0 - Back\n");
		sb.append(selectOption());

		System.out.println(sb.toString());
	}
 
	//This code is responsible to get the option chosen.
	private String selectOption() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nSelect option: ");

		return sb.toString();
	}

}
