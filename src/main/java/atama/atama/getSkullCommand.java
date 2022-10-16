package atama.atama;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Collections;

public class getSkullCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player CommandUser = (Player) sender;

        if(args.length == 0 && sender.isOp()){
            Player TargetUser = Bukkit.getPlayer(args[0]);

            ItemStack is = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) is.getItemMeta();
            meta.setOwningPlayer(TargetUser);
            meta.setLore(Collections.singletonList("The head of your enemy\nItem generated with Atama"));
            meta.setDisplayName(TargetUser.getDisplayName()+"'s head");
            is.setItemMeta(meta);
        } else CommandUser.sendMessage("You do not have permissions to use that command or you entered too many arguments");

        return false;
    }
}
