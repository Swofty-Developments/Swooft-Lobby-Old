package org.swofty.Core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

public class Scoreboard {

    public static void setLobbyScoreboard(Player player) {
        ScoreboardManager m = Bukkit.getScoreboardManager();
        assert m != null;
        org.bukkit.scoreboard.Scoreboard b = m.getNewScoreboard();

        Objective o = b.registerNewObjective("LobbySB", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(Api.colorize("&d&lSwooft &8| &7Lobby"));

        Score score1 = o.getScore(Api.colorize("&a "));

        Score score2;

        if (Ranks.getRank(player).equalsIgnoreCase("default")) {
            score2 = o.getScore(Api.colorize("&fRank: &7&lDEFAULT"));
        } else {
            score2 = o.getScore(Api.colorize("&fRank: " + Ranks.getRankPrefix(player).replace("[", "").replace("]", "")));
        }
        Score score4 = o.getScore(Api.colorize("&fCosmetics: &60"));
        Score score5 = o.getScore(Api.colorize("&b "));
        Score score6 = o.getScore(Api.colorize("&fLobby: &a#1"));
        Score score7 = o.getScore(Api.colorize("&fOnline: &a" + Bukkit.getOnlinePlayers().size()));
        Score score8 = o.getScore(Api.colorize("&f "));

        Score score9 = o.getScore(Api.colorize("&d(BETA) play.swofty.net"));


        score1.setScore(9);
        score2.setScore(8);
        score4.setScore(6);
        score5.setScore(5);
        score6.setScore(4);
        score7.setScore(3);
        score8.setScore(2);
        score9.setScore(1);

        player.setScoreboard(b);
    }

    public static void setLobbyAdminScoreboard(Player player) {
        ScoreboardManager m = Bukkit.getScoreboardManager();
        assert m != null;
        org.bukkit.scoreboard.Scoreboard b = m.getNewScoreboard();

        Objective o = b.registerNewObjective("LobbySBAdmin", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(Api.colorize("&d&lSwooft &8| &7Lobby"));

        Score score1 = o.getScore(Api.colorize("&a "));
        Score score2 = o.getScore(Api.colorize("&fRank: " + Ranks.getRankPrefix(player).replace("[", "").replace("]", "")));
        Score score4 = o.getScore(Api.colorize("&fCosmetics: &60"));
        Score score5 = o.getScore(Api.colorize("&b "));
        Score score6 = o.getScore(Api.colorize("&fLobby: &a#1"));
        Score score7 = o.getScore(Api.colorize("&fOnline: &a" + Bukkit.getOnlinePlayers().size()));
        Score score8 = o.getScore(Api.colorize("&fStaff: &a" + Bukkit.getOperators().size()));
        Score score9 = o.getScore(Api.colorize("&fActions Needed: &c0"));
        Score score10 = o.getScore(Api.colorize("&f "));

        Score score11 = o.getScore(Api.colorize("&d(BETA) play.swofty.net"));


        score1.setScore(11);
        score2.setScore(10);
        score4.setScore(8);
        score5.setScore(7);
        score6.setScore(6);
        score7.setScore(5);
        score8.setScore(4);
        score9.setScore(3);
        score10.setScore(2);
        score11.setScore(1);

        player.setScoreboard(b);
    }
}
