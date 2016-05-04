import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Dictionary{
HashMap<String, Actors> name = new HashMap<String, Actors>();

void Dictionaries(String values){
	if (values.contains("|")){
		int place = values.indexOf("|");
		String movie1 = values.substring(0 , place);
		String movie2 = values.substring(place+1);
	findActors(movie1, movie2);	
	}
	else if (values.contains("&")){
		int place = values.indexOf("&");
		String movie1 = values.substring(0 , place);
		String movie2 = values.substring(place+1);
		andActors(movie1, movie2);
	}
	else if (values.contains("^")){
		int place = values.indexOf("^");
		String movie1 = values.substring(0 , place);
		String movie2 = values.substring(place+1);
		xorActors(movie1, movie2);
	}
}

void findActors(String mov1, String mov2){
	Actors a = name.get(mov1);
	for(int i = 0; i < a.actlist.size(); i++){
		System.out.println(a.actlist.get(i) + " ");
	}
	a = name.get(mov2);
	for(int i = 0; i < a.actlist.size(); i++){
		System.out.println(a.actlist.get(i) + " ");
	}
}

void andActors(String mov1, String mov2){
	Actors a = name.get(mov1), b = name.get(mov2);
	for(int i = 0; i < a.actlist.size(); i++){
		String A1 = a.actlist.get(i);
		for (int j = 0; j < b.actlist.size(); j++){
			String A2 = b.actlist.get(j);
			if(A1.equals(A2)){
				System.out.println(A1 + " ");
			}
		}
	}
}

void xorActors(String mov1, String mov2){
	Actors a = name.get(mov1), b = name.get(mov2);
	for (int i = 0; i < a.actlist.size(); i++){
		if(!b.actlist.contains(a.actlist.get(i))){
			System.out.println(a.actlist.get(i));
		}
	}
}

void optionB(String actorName){
	Set<String> keys = name.keySet();
	Iterator<String> i1 = keys.iterator();
	while(i1.hasNext()){
		Actors a = name.get(i1.next()); 
		if(a.actlist.contains(actorName)){
			for(int i = 0; i < a.actlist.size(); i++){
				if(!a.actlist.get(i).equals(actorName)){
					System.out.println(a.actlist.get(i) + " ");
				}
			}
		}
	}
}

void loadList(){
	String almacenamiento = "";
	try{
		FileReader fileReader = new FileReader("/home/finn/Dropbox/Uni/Auslandsaufenthalt/Cursos SS 16/java_workspace/wsq09/bin/movies.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while((almacenamiento = bufferedReader.readLine()) != null){
			String [] movies = almacenamiento.split(", ");
			for (int i = 1; i < movies.length; i++){
				if (!name.containsKey(movies[i])){
					name.put(movies[i], new Actors());
				}
				name.get(movies[i]).setActor(movies[0]);
			}
		
		}
		bufferedReader.close();
	}catch(Exception e){
		System.out.println("I can't find the file containing the information.");
	}
}
}