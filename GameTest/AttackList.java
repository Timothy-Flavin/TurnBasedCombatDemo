public class AttackList{

	private int damage;
	private String an;

	public AttackList(){

	}
	public int returnDamage(String attackName, int dmg){

		an = attackName;
		damage = dmg;
		int sentNumber;

		if(an.equals("bite")){
			sentNumber = damage * 3/10;
			return sentNumber;
		}
		else if(an.equals("rest")){
			sentNumber = damage*-1*2/10;
			return sentNumber;
		}
		else if(an.equals("slash")){
			sentNumber = damage * 4/10;
			return sentNumber;
		}
		else{
			System.out.println("this is not a move or somehting");
		}
		return 0;
	}
}
