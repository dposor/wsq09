import javax.swing.JOptionPane;

public class Wsq09 {

	public static void main(String finn[]){
		
		Dictionary movies = new Dictionary();
		movies.loadList();
		String window = JOptionPane.showInputDialog("Do you want to check movies (a) or check actors (b)?");
		if (window.equalsIgnoreCase("a")){
			String movie = JOptionPane.showInputDialog("Give me the names of two movies, separated by | (union), & (intersection) or ^ (symmetric difference)." );
			movies.Dictionaries(movie);
		}
		else if(window.equalsIgnoreCase("b")){
			String actor = JOptionPane.showInputDialog("Give me the name of an actor.");
			movies.optionB(actor);
		}
	}
}
