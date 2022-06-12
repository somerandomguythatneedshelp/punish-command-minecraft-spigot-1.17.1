package punish.punish;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;

public class PunishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("stuff.punish")){



                if (args.length == 2) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[0]);

                        switch (args[1].toLowerCase()) {
                            case "kick":
                                target.kickPlayer(ChatColor.RED + "You have been kicked for doing something that is not allowed on our server\nif you are wondering why this isn't a warn\nIt is because this is to much for a warn");
                                break;
                            case "ban":
                                Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "You have Been banned for one of these reasons\nHacking\nexploiting\nchat spam\nscams", null, null);
                                target.kickPlayer(ChatColor.RED + "You have Been banned for one of these reasons\nHacking\nexploiting\nchat spam\nscams");
                                break;

                            case "tempban":
                                Calendar cal = Calendar.getInstance();
                                cal.add(Calendar.HOUR, 12);

                                Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "is stipd\nplz sty awy", null, null);
                                target.kickPlayer(ChatColor.RED + "You have Been banned for one of these reasons\nHacking and giving other players an unfair advantage\nexploiting\nchat spam\nscams\nbulling other players");
                                break;

                            case "warn":
                                Calendar cale = Calendar.getInstance();
                                cale.add(Calendar.MILLISECOND, 1);

                                Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "You have been warned for: \nGlitching\nautoclicking\nspam\n you have 2 more warns until you get banned", null, null);

                                break;

                            case "fwarn":
                                Calendar calen = Calendar.getInstance();
                                calen.add(Calendar.MILLISECOND, 1);

                                Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "This is your last Chance to Actually play the game, if you chose not to do so\nYou will be banned forever ", null, null);

                            default:
                                player.sendMessage(ChatColor.RED + "You didn't specify whether to kick ban for tempban");
                                return false;

                        }
                    }

                } else {
                    player.sendMessage("This Player is offline, please wait until this  player so rejoined");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage! Please use /punish <player> <kick/ban/tempban>");
            }
        }


        return false;
    }
}
