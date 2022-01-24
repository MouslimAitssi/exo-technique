import java.util.Scanner;

public class Exercice {
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
        int nbrAbris = s.nextInt();
        s.nextLine();
        MyObject[] arrAbris = new MyObject[nbrAbris];
        for(int i = 0; i < nbrAbris; i++) {
        	arrAbris[i] = new MyObject();
        	String str = s.nextLine();
        	String[] arr = str.split("\\s+");
            arrAbris[i].name = arr[0];
            arrAbris[i].x = Integer.parseInt(arr[1]);
            arrAbris[i].y = Integer.parseInt(arr[2]);
        }
        
        int nbrEnfants = s.nextInt();
        s.nextLine();
        MyObject[] arrEnfants = new MyObject[nbrEnfants];
        String[] output = new String[nbrEnfants + nbrAbris];
        for(int i = 0; i < nbrEnfants; i++) {
        	arrEnfants[i] = new MyObject();
           	String str = s.nextLine();
        	String[] arr = str.split("\\s+");
            arrEnfants[i].name = arr[0];
            arrEnfants[i].x = Integer.parseInt(arr[1]);
            arrEnfants[i].y = Integer.parseInt(arr[2]);
        }
        
        for(int i = 0; i < nbrEnfants; i++) {
            System.out.println(arrEnfants[i].name + " " + findAbris(arrEnfants[i], arrAbris).name);
        }
	}
	
	public static double findDistance(MyObject obj1, MyObject obj2) {
	    return Math.sqrt((obj1.x - obj2.x)*(obj1.x - obj2.x) + (obj1.y - obj2.y)*(obj1.y - obj2.y));
	}
	
	public static MyObject findAbris(MyObject enfant, MyObject[] arrAbris) {
	    MyObject abris = arrAbris[0];
	    double distance = findDistance(arrAbris[0], enfant);
	    for(int i = 0; i < arrAbris.length; i++) {
	        if(findDistance(arrAbris[i], enfant) < distance) {
	        	abris = arrAbris[i];
	        	distance = findDistance(arrAbris[i], enfant);
	        }
	    }
	    return abris;
	}
}

class MyObject {
    String name;
    float x;
    float y;
    
}
