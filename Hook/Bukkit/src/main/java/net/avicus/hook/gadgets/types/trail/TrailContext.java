package net.avicus.hook.gadgets.types.trail;

import com.google.gson.JsonObject;
import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;
import net.avicus.hook.utils.Messages;
import net.avicus.magma.module.gadgets.AbstractGadgetContext;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TrailContext extends AbstractGadgetContext<TrailGadget> {

  @Getter
  @Setter
  private boolean enabled;

  public TrailContext(TrailGadget gadget, boolean enabled) {
    super(gadget);
    this.enabled = enabled;
  }

  @Override
  public ItemStack icon(Player player) {
    ItemStack stack = super.icon(player);
    ItemMeta meta = stack.getItemMeta();

    meta.setLore(Arrays.asList(
        Messages.enabledOrDisabled(this.enabled).render(player).toLegacyText()
    ));

    stack.setItemMeta(meta);
    return stack;
  }

  @Override
  public JsonObject serialize() {
    JsonObject json = new JsonObject();
    json.addProperty("enabled", this.enabled);
    return json;
  }
}
