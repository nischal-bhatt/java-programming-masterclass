public class PlayerMain {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("joe");
        BaseballPlayer pat = new BaseballPlayer("pat");
        SoccerPlayer beck = new SoccerPlayer("beck");

        //adelaidecrows is a football team
        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
      //  adelaideCrows.addPlayer(pat);
       // adelaideCrows.addPlayer(beck);

        //baseball player is added to team!
        // any kind of player can be added to team!
        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("chicago cubs");
        baseballTeam.addPlayer(pat);

        System.out.println(baseballTeam.numPlayers());

       // Team<String> broken = new Team<> ("hi");

        Team<FootballPlayer> melbourne
                = new Team<>("melbourne");

        FootballPlayer banks = new FootballPlayer("gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorne");
        Team<FootballPlayer> fremantle = new Team<>("fremantle");

        hawthorn.matchResult(fremantle,1,0);
        hawthorn.matchResult(adelaideCrows,3,8);

        adelaideCrows.matchResult(fremantle,2,1);
//adelaideCrows.matchResult(baseballTeam,1,1); -- cannot!


    }
}
