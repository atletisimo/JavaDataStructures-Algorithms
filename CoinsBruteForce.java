//da se vrati i brojot na paricki od sekoj tip sto ja formiraat sumata=kreiranje klasa i vrakjanje object od taa klasa
public class CoinsBruteForce {
public static int minNumberCoins(int sum) {
 final int INF=10000000;
	int m1,m2,m3,m4,m5,tmp;//brojac na moneti
	int result=INF;
	int numCoins=0;
	 //min broj na paricki potreben za kreiranje na konkretnata suma
		//za site paricki for ciklus
	for(m1=0;m1<=(sum/50);m1++) {//broj na paricki so vrednost 50...
		for(m2=0;m2<=(sum/10);m2++) {
		for(m3=0;m3<=(sum/5);m3++) {
			for(m4=0;m4<=(sum/2);m4++) {
				for(m5=0;m5<=(sum/1);m5++) {
					tmp=m1*50+m2*10+m3*5+m4*2+m5*1;//da ja generirame sekoja mozna suma probuvame
					if(tmp==sum) {//koga ke imame potrebnata suma
						numCoins=m1+m2+m3+m4+m5;//so kolku paricki e kreirana sumata
						if(numCoins<result)
							result=numCoins;
					}
				}
			}
		}
		}
	}
	return result;
}
public static void main(String[] args) {
	System.out.println("Minimalen broj na moneti: "+CoinsBruteForce.minNumberCoins(100));//pristapot do methodot
	//moze da bide i direktno so imeto na methodot t.e namesto klasata.metodot zaradi toa sto nie sme vekje vo klasata
	//ili ako ne bevme pristapuvame so imeto na klasata ili so kreiranje na object od klasata
	//CoinsBruteForce obj = new CoinsBruteForce();
//	System.out.println("Minimalen broj na moneti: " + obj.minNumberCoins(100));

}
}
