package project.ui;

import java.util.Scanner;

public class ProjectUI {
	private Scanner scanerInput = new Scanner(System.in);
	
	public ProjectUI() {
		boolean run=true;
		while(run) {
			
			printMainMenu();
		}
	}

	private void printMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("1 . 로그인");
		System.out.println("2 . 회원가입");
		System.out.println("3 . 관리자 로그인");
	}
}
