package atama.atama;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class redeem_skullCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        ItemStack heldItem = player.getInventory().getItem(player.getInventory().getHeldItemSlot());

        if (heldItem.getType() == Material.PLAYER_HEAD){
            player.sendMessage("You have claimed a skull!");

            int RN = RandomNum(0, 10);
            ItemStack itemGive = null;
            if(RN == 0){
                itemGive = new ItemStack(Material.NETHERITE_INGOT, RandomNum(1, 3));
            } else if(RN == 1){
                RN = RandomNum(1, 4);
                if(RN==1){
                    itemGive = new ItemStack(Material.ENCHANTED_BOOK, 1);
                    ItemMeta itemMeta = itemGive.getItemMeta();
                    itemMeta.addEnchant(Enchantment.MENDING, 1, false);
                    itemGive.setItemMeta(itemMeta);
                } else if(RN==2){
                    itemGive = new ItemStack(Material.ENCHANTED_BOOK, 1);
                    ItemMeta itemMeta = itemGive.getItemMeta();
                    itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, false);
                    itemGive.setItemMeta(itemMeta);
                } else if(RN==3){
                    itemGive = new ItemStack(Material.ENCHANTED_BOOK, 1);
                    ItemMeta itemMeta = itemGive.getItemMeta();
                    itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
                    itemGive.setItemMeta(itemMeta);
                } else if(RN==4){
                    itemGive = new ItemStack(Material.ENCHANTED_BOOK, 1);
                    ItemMeta itemMeta = itemGive.getItemMeta();
                    itemMeta.addEnchant(Enchantment.DIG_SPEED, 5, false);
                    itemGive.setItemMeta(itemMeta);
                }
            } else if(RN == 2){
                itemGive = new ItemStack(Material.GLISTERING_MELON_SLICE, RandomNum(32, 64));
                ItemMeta itemMeta = itemGive.getItemMeta();
                itemMeta.setDisplayName("Elite Watermelon Slices");
                itemMeta.setLore(Collections.singletonList("Is this a shameless plug? Yes"));
                itemGive.setItemMeta(itemMeta);
            } else if(RN == 3){
                itemGive = new ItemStack(Material.DIAMOND, RandomNum(4, 12));
            }

            player.getInventory().addItem(itemGive);
            Bukkit.broadcastMessage(player.getDisplayName()+"redeemed a skull and was given: " + itemGive.getAmount() + " " + itemGive.getType().name()+"s");
        } else {
            player.sendMessage("You are not holding a skull!");
        }

        return false;
    }

    int RandomNum(int minBound, int maxBound){
        int result;
        result = ThreadLocalRandom.current().nextInt(minBound, maxBound + 1);
        return result;
    }
}
