import java.util.ArrayList;

public class Actors{
ArrayList<String> actlist = new ArrayList<String>();

void setActor(String actName) {
	if (actlist.contains(actName)) {
		return;
		}
	actlist.add(actName);
	}
}