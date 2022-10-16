package atama.atama;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerDeathsListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        if(e.getEntity().getKiller() instanceof Player){
            Player killed_player = (Player) e.getEntity();
            Player killer_player = (Player) e.getEntity().getKiller();

            ItemStack is = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) is.getItemMeta();
            meta.setOwningPlayer(killed_player);
            is.setItemMeta(meta);

            killer_player.getInventory().addItem(is);
        }
    }
}