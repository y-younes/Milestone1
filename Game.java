package engine;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	private Player firstPlayer;
	private Player secondPlayer;
	private boolean firstLeaderAbilityUsed;
	private boolean secondLeaderAbilityUsed;
	private Object[][] board;
	private static ArrayList<Champion> availableChampions;
	private static ArrayList<Ability> availableAbilities;
	private PriorityQueue turnOrder;
	private static int BOARDHEIGHT;
	private static int BOARDWIDTH;
	
	public Game(Player first, Player second)
	{
		this.firstPlayer = first;
		this.secondPlayer = second;
	}
	
	private void placeChampions()
	{
		board[0][1] = firstPlayer.getLeader();
		board[BOARDHEIGHT-2][1] = secondPlayer.getLeader();
		int a = 2;
		//int b = BOARDHEIGHT-2; 
		for(int j =0;j<(firstPlayer.getTeam()).length;j++){
			board[0][a] = firstPlayer.getTeam()[j];
			if (a<(firstPlayer.getTeam()))
			{
				a++;
			}
		}
		a =2 ;
		for(int k =0;k<(secondPlayer.getTeam()).length;k++){
			board[BOARDHEIGHT-1][a] = secondPlayer.getTeam()[k];
			if (a<(secondPlayer.getTeam()))
			{
				a++;
			}
		} 
		
	}
	
	private void placeCovers()
	{
		Random r = new Random();
		int p1 = r.nextInt(BOARDHEIGHT-1)+1;
		int p2 = r.nextInt(BOARDWIDTH-1)+1;
		while(p1 == 0 || p1 == BOARDHEIGHT-1)
		{
			p1 = r.nextInt(BOARDHEIGHT-1)+1;
		}
		while(p2 == 0 || p2 == BOARDWIDTH-1)
		{
			p2 = r.nextInt(BOARDWIDTH-1)+1;
		}
		
		for (int i=0; i<5; i++)
		{
		while (!(board[p1][p2] == null))
		{
			while(p1 == 0 || p1 == BOARDHEIGHT-1)
			{
				p1 = r.nextInt(BOARDHEIGHT-1)+1;
			}
			if (!(board[p1][p2] == null))
			{
				while(p2 == 0 || p2 == BOARDWIDTH-1)
				{
					p2 = r.nextInt(BOARDWIDTH-1)+1;
				}
			}
		}
		
		board[p1][p2] = Cover.getCover();
		}
	}
	
	public static void loadAbilities(String filePath)
	{
		
		
	}
	
	public static void loadChampions(String filePath)
	{
		
		
	}
	
	
	//GETTERS AND SETTERS
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public boolean isFirstLeaderAbilityUsed() {
		return firstLeaderAbilityUsed;
	}

	public boolean isSecondLeaderAbilityUsed() {
		return secondLeaderAbilityUsed;
	}

	public Object[][] getBoard() {
		return board;
	}

	public static ArrayList<Champion> getAvailableChampions() {
		return availableChampions;
	}

	public static ArrayList<Ability> getAvailableAbilities() {
		return availableAbilities;
	}

	public PriorityQueue getTurnOrder() {
		return turnOrder;
	}

	public static int getBOARDHEIGHT() {
		return BOARDHEIGHT;
	}

	public static int getBOARDWIDTH() {
		return BOARDWIDTH;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	 
}
