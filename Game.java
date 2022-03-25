package engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Effect;
import model.effects.EffectType;
import model.world.Champion;
import model.world.Cover;

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
		for(int j =0;j<(firstPlayer.getTeam()).size();j++){
			board[0][a] = firstPlayer.getTeam().get(j);
			if (a<(firstPlayer.getTeam()).size())
			{
				a++;
			}
		}
		a =2 ;
		for(int k =0;k<(secondPlayer.getTeam()).size();k++){
			board[BOARDHEIGHT-1][a] = secondPlayer.getTeam().get(k);
			if (a<(secondPlayer.getTeam()).size())
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
		
		board[p1][p2] = new Cover(p1,p2);
				//availableAbilities.getcurrentHP().get();
		}
	}
	
	
		// loadAbilities converts arraylist of strings to arraylist of objects
		
		public static  void loadAbilities(String filepath) throws IOException
		{
			String line;
			BufferedReader br = null;
			ArrayList<String> s =  new ArrayList<>();
			try
			{
				br = new BufferedReader(new FileReader(filepath));
				while((line = br.readLine())!= null){
					s.add(line);
					
				}

			}catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			String[] parr;
			
			
			//declarations of attributes
			String type,name,effectName,AreaofEffect;
			
			int manaCost,castRange,baseCooldown,requiredActionsPerTurn,damageAmount,healAmount,effectDuration;
			
			
			for(int i =0;i<s.size();i++)
			{
				line = s.get(i); // "X,Y,Z"
				parr = line.split(",");
				type = parr[0];
				name = parr[1];
				manaCost = Integer.parseInt(parr[2]);
				castRange = Integer.parseInt(parr[3]);
				baseCooldown = Integer.parseInt(parr[4]);
				requiredActionsPerTurn = Integer.parseInt(parr[6]);
				AreaOfEffect a = AreaOfEffect.valueOf(parr[5]);
				  	
				if(type.equals("DMG")) {
					 damageAmount = Integer.parseInt(parr[7]);
					 availableAbilities.add(new DamagingAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,damageAmount));
				}
				else if(type.equals("Hel")) {
					healAmount = Integer.parseInt(parr[7]);
					availableAbilities.add(new HealingAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,healAmount));
			
				}
				else if (type.equals("CC"))
				{
			    	effectName = parr[7];
			    	effectDuration = Integer.parseInt( parr[8]);//String name, int manaCost, int baseCooldown, int castRange, AreaOfEffect castArea,
					//int requiredActionPoints, Effect effect)//	public Effect(String name, int duration, EffectType type)
					switch(effectName) {
					case "Disarm" :availableAbilities.add(new CrowdControlAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,new Effect(effectName,effectDuration,EffectType.DEBUFF)));break;
					case "PoweUp" :availableAbilities.add(new CrowdControlAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,new Effect(effectName,effectDuration,EffectType.BUFF)));break;
					case "Shield" :availableAbilities.add(new CrowdControlAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,new Effect(effectName,effectDuration,EffectType.BUFF)));break;
					case "Silence" :availableAbilities.add(new CrowdControlAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,new Effect(effectName,effectDuration,EffectType.DEBUFF)));break;
					case "SpeedUp" :availableAbilities.add(new CrowdControlAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,new Effect(effectName,effectDuration,EffectType.BUFF)));break;
					case "Embrace" :availableAbilities.add(new CrowdControlAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,new Effect(effectName,effectDuration,EffectType.BUFF)));break;
					case "Root" :availableAbilities.add(new CrowdControlAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,new Effect(effectName,effectDuration,EffectType.DEBUFF)));break;
					case "Shock" :availableAbilities.add(new CrowdControlAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,new Effect(effectName,effectDuration,EffectType.DEBUFF)));break;
					case "Dodge" :availableAbilities.add(new CrowdControlAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,new Effect(effectName,effectDuration,EffectType.BUFF)));break;
					case "Stun" :availableAbilities.add(new CrowdControlAbility(name,manaCost,baseCooldown,castRange,a,requiredActionsPerTurn,new Effect(effectName,effectDuration,EffectType.DEBUFF)));break;
					
					
					}
					
					
				}
				
					
				
					
			}
				
				
			
				
				
			  
			    	
			    
			
 
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
