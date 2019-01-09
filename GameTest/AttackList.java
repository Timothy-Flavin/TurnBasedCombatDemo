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
			sentNumber = damage * 9/10;
			return sentNumber;
		}
		else if(an.equals("rest")){
			sentNumber = damage*-1*4/10;
			return sentNumber;
		}
		else if(an.equals("slash")){
			sentNumber = damage;
			return sentNumber;
		}
		else{
			System.out.println("this is not a move or somehting");
		}
		return 0;
	}
}
