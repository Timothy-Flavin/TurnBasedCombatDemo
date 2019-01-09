import java.util.*;
public class MapLoader{

	private int nextPlayerX, nextPlayerY;
	private Random rand;

	public MapLoader(){
		nextPlayerX = 0;
		nextPlayerY = 0;
		rand = new Random();
	}


	public boolean hitsAWall(String mapName, int x, int y){
		nextPlayerX = x;
		nextPlayerY = y;
		if(mapName == "starterMap.jpg"){
			//edge checks
			if(nextPlayerX-50 < 100){
				return true;
			}
			if(nextPlayerX+50 > 900 && (nextPlayerY-50 < 300 || nextPlayerY+50 > 400)){
				return true;
			}
			if(nextPlayerY-50 < 100 || nextPlayerY + 50 > 900){
				return true;
			}
			if(nextPlayerX+50 > 200 && nextPlayerX-50<300 && nextPlayerY+50 > 300 && nextPlayerY-50 < 500){
				return true;
			}
			if(nextPlayerY+50 > 200 && nextPlayerY-50<300 && nextPlayerX+50 > 300 && nextPlayerX-50 < 500){
				return true;
			}
			if(nextPlayerX+50 > 400 && nextPlayerX-50 < 500 && nextPlayerY+50 > 500 && nextPlayerY-50 < 800){
				return true;
			}
			if(nextPlayerX+50 > 500 && nextPlayerX-50<600 && nextPlayerY+50 > 700 && nextPlayerY-50 < 900){
				return true;
			}
		}
		else{
			System.out.println("this is not a map name or something is screwed...");
			return false;
		}
		return false;
	}


	public boolean testEncounter(String mapName, int x, int y){
		nextPlayerX = x;
		nextPlayerY = y;
		if(mapName == "starterMap.jpg"){
			if(nextPlayerX+50 > 300 && nextPlayerX-50 < 500 && nextPlayerY+50 > 300 && nextPlayerY-50 < 500){
				System.out.println("on encounter tile");
				if(rand.nextInt(8) == 0){
					System.out.println("encounter succesful");
					return true;
				}
			}
			if(nextPlayerX+50 > 500 && nextPlayerX-50 < 700 && nextPlayerY+50 > 400 && nextPlayerY-50 < 500){
				System.out.println("on encounter tile");
				if(rand.nextInt(8) == 0){
					System.out.println("encounter succesful");
					return true;
				}
			}
			if(nextPlayerX+50 > 400 && nextPlayerX-50 < 500 && nextPlayerY+50 > 800 && nextPlayerY-50 < 1000){
				System.out.println("on encounter tile");
				if(rand.nextInt(8) == 0){
					System.out.println("encounter succesful");
					return true;
				}
			}
		}
		else{
			System.out.println("you don fucked up on loading the map son");
		}
			return false;
	}
	public boolean testEncounterTile(String mapName, int x, int y){
		nextPlayerX = x;
		nextPlayerY = y;
		if(mapName == "starterMap.jpg"){
			if(nextPlayerX+50 > 300 && nextPlayerX-50 < 500 && nextPlayerY+50 > 300 && nextPlayerY-50 < 500){
				System.out.println("on encounter tile");
				System.out.println("encounter succesful");
				return true;
			}
			if(nextPlayerX+50 > 500 && nextPlayerX-50 < 700 && nextPlayerY+50 > 400 && nextPlayerY-50 < 500){
				System.out.println("on encounter tile");
				System.out.println("encounter succesful");
				return true;

			}
			if(nextPlayerX+50 > 400 && nextPlayerX-50 < 500 && nextPlayerY+50 > 800 && nextPlayerY-50 < 1000){
				System.out.println("on encounter tile");
					System.out.println("encounter succesful");
					return true;
			}
		}
		else{
			System.out.println("you don fucked up on loading the map son");
		}
			return false;
	}
	public int getMapStartX(String mapName){
		int mapStartX = 0;
		if(mapName == "starterMap.jpg"){
			mapStartX = -100;
		}
		else{
			System.out.println("failed to load map name for getMapStartX() or map name not option");
		}
		return mapStartX;
	}
	public int getMapStartY(String mapName){
		int mapStartY = 0;
		if(mapName == "starterMap.jpg"){
			mapStartY = -700;
		}
		else{
			System.out.println("failed to load map name for getMapStartY() or map name not option");
		}
		return mapStartY;
	}
}
