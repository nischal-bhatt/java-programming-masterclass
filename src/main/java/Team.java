import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
    private String TeamName;
    
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name)
    {
        this.TeamName = name;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public boolean addPlayer(T player)
    {
        if (members.contains(player))
        {
            System.out.println(player.getName() + "already on the team!");
            return false;
        }
        this.members.add(player);
        System.out.println("added");
        return true;
    }

    public int numPlayers()
    {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore)
    {
        String message;
        if (ourScore>theirScore)
        {
            won++;
            message = " beat ";
        }else if (ourScore == theirScore)
        {
            tied++;
            message = " drew with ";
        }else
        {
            lost++;
            message = " lost to ";
        }
        played++;
        if (opponent != null)
        {
            System.out.println(this.getTeamName() + message + opponent.getTeamName());
            opponent.matchResult(null,theirScore,ourScore);
        }
    }

    public int ranking() {

        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> o) {
        if ( this.ranking() > o.ranking() )
        {
            return -1;
        }else if (this.ranking() < o.ranking())
        {
            return 1;
        }else {
            return 0;
        }

    }
}
