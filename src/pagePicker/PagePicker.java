package pagePicker;

import java.util.Scanner;
import java.util.Random;

public class PagePicker {

	public static void main(String[] args) {

		int minPage = 1;
		int maxPage = 10;
		int pagesDoneNum = 0;
		boolean exit = false;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Pick the minimum range of pages: ");
		try {
			minPage = Integer.parseInt(scanner.nextLine());
		} catch(NumberFormatException nfe) {
			System.err.println("Must be a number!");
			System.exit(0);
		}

		System.out.print("Pick the maximum range of pages: ");
		try {
			maxPage = Integer.parseInt(scanner.nextLine()) + 1;
		} catch(NumberFormatException nfe) {
			System.err.println("Must be a number!");
			System.exit(0);
		}
		
		int[] pagesDone = new int[maxPage - minPage + 1];
		
		while (!exit) {

			int page = pickPage(minPage, maxPage);
			for (int i = 0; i <= pagesDoneNum; i++) {
				while(page == pagesDone[i]) {
					page = pickPage(minPage, maxPage);
					i = 0;
				} 
			}
			pagesDone[pagesDoneNum] = page;
			
			System.out.println("Page: ** " + page + " **");
			pagesDoneNum++;
			System.out.println("Pages left: " + (pagesDone.length - pagesDoneNum - 1));

			if (pagesDone.length - pagesDoneNum - 1 == 0) {
				System.out.println("All pages done! Good job!");
				System.out.println("Quitting program...");
				exit = true;
				break;
			}

			System.out.print("Pick a new page? Y/N: ");
			String in = scanner.nextLine();
			if(in.toString().equals("n")) exit = true;
			
		}
		System.exit(0);
		
	}
	
	public static int pickPage(int min, int max) {
		Random r = new Random();
		int page = r.nextInt(min, max);
		return page;
	}

}
