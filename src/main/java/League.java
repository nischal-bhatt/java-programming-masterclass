import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team> {

    private String name;
    private ArrayList<T> league = new ArrayList<T>();

    public League(String name) {
        this.name = name;
    }

    public boolean add(T team)
    {
        if (this.league.contains(team))
        {
            return false;
        }
        league.add(team);
        return true;
    }

    public void showLeagueTable( )
    {
        Collections.sort(this.league);
        //internally uses compareTo

        for (T t : league)
        {
            System.out.println(t.getTeamName() + " : " + t.ranking()) ;
        }
    }
}
