package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class TableDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Game g = new Game();
		g.play();
		
		sc.close();
	}
}
