
public class CoinsGreedy {
	private static void sortCoins(int coins[],int n) {
		int tmp;
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(coins[i]<coins[j]) {
					tmp=coins[i];
					coins[i]=coins[j];
				coins[j]=tmp;	
				}
			}
		}
	}
public static int minNumberCoins(int coins[],int n,int sum,int numCoins[]) {
//kako niza e dadeno za ponataka da moze da se resava zadacata ne samo so paricki so vrednosti 5,10 tuku i so 40,30,vo nekoja drzava kade poinaku
//se mozda monetite napraveni
//ako numCoins se dadeni kako niza se menuva na konkretnata mem lokacija
//n -brojot na vakvi paricki
	
//najprvin potrebno e sortiranje za da se pocne od najgolemata paricka
	//za greedy se raboti ke koristime sortiranje tuka  bubble sort
	//numCoins nizata koja ja popolnuvame so br na paricki za odredenite vrednosti
//na 0-ta pozicija ako e vrednosta 50 tuka ke se naoggja brojot na paricki zemeni so vrednost 50
	sortCoins(coins,n);
	//coins nizata e vekje sortirana bidejki nizata e predadena kako referenca
	int totalCoins=0,i=0;
	while(sum>0) {//se dodeka ima uste suma
		numCoins[i]=sum/coins[i];//se odzema 50ki,10ki,t.e od najgolemata kolu sto mozeme najmnogu pa pomali od nejze kolku mozeme najmnogu
		
		sum-=numCoins[i]*coins[i];//vo numCoins na nulta pozicija sumata podeleno so vrednosta na taa pozicija pr sakame da pravime 70 denari
		//sumCoins na nulta pozicija ke bide 70 podeleno so prvite imaat vredost 50 ,znaci 1,1 50,od 70ka odzemame 70-50 ni ostanuvaat 20 i brojot na paricki se zgolemuva 20 e sumata ,20 eleno na 10 stavame 2,
		//sumata -= 2*10,20-20 e nula brojot se zgolemuva sumata e nula i od while-ot ke izlezeme
		
		totalCoins+=numCoins[i];
		i++;
	}
	while(i<n) {
		numCoins[i]=0;
		i++;
	}
	return totalCoins;
}
public static void main (String [] args) {
	//ili moze i object od klasata da se kreira
	int coins[]= {1,2,5,10,50};
	int n=5;
	int sum=79;
	int numCoins[]= {0,0,0,0,0};//prazna e na pocetok
	//0 zemeno paricki od sekoj vid
	//kolku paricki od sekoj tip sme zemale? so for ciklus,podatokot se naogja 
	//za toa kolku paricki od sekoj tip sme zemale vo numCoins nizata zatoa ja iterirame taa niza
	//ja pecatime vrednosta pa kolku paricki od taa vrednost
	System.out.println("Greedy coins:"+CoinsGreedy.minNumberCoins(coins,n,sum,numCoins));
	for(int i=0;i<n;i++) {
		System.out.println(coins[i]+ ": "+numCoins[i]);
	}
}
}
//ovoj algoritam ne dava sekogas optimalno resenie
//ako imame suma 13=optimalno e 8+5
//no so greedy ke raboti 10,2,1,3 praicki vrakja ,a optimalnoto e 2
//so brute force sekogas ke go najdeme tocnoto resenie vo r-ki na ovakov algoritam
