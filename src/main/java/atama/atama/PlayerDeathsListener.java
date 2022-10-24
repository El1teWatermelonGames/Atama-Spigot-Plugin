package atama.atama;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Collections;

public class PlayerDeathsListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        if(e.getEntity().getKiller() instanceof Player){
            Player killed_player = (Player) e.getEntity();
            Player killer_player = (Player) e.getEntity().getKiller();

            Item itemUsedToKill = (Item) killer_player.getInventory().getItem(killer_player.getInventory().getHeldItemSlot());

            ItemStack is = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) is.getItemMeta();
            meta.setOwningPlayer(killed_player);
            meta.setLore(Collections.singletonList("The head of your enemy | Item generated with Atama"));
            meta.setDisplayName(killed_player.getDisplayName()+"'s head");
            is.setItemMeta(meta);

            killer_player.getInventory().addItem(is);
            e.setDeathMessage(killed_player.getDisplayName()+" was decapitated by "+killer_player.getDisplayName()+"with a "+itemUsedToKill.getName());
        }
    }
}
