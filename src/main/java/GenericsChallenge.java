public class GenericsChallenge {
    public static void main(String[] args) {

        League<Team<FootballPlayer>> footballLeague
                = new League<>("AFL");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");


        Team<FootballPlayer> melbourne
                = new Team<>("melbourne");



        Team<FootballPlayer> hawthorn = new Team<>("Hawthorne");
        Team<FootballPlayer> fremantle = new Team<>("fremantle");

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago cubs");
        footballLeague.add(adelaideCrows);
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);
       // footballLeague.add(baseballTeam);

        hawthorn.matchResult(fremantle,1,0);
        hawthorn.matchResult(adelaideCrows,3,8);

        adelaideCrows.matchResult(fremantle,2,1);

        footballLeague.showLeagueTable();


    }
}
