package Auto.Bahn;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener {
	@EventHandler
	public void playerJoinEvent(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if (p != null) {
			if (!RegisteredConfig.registeredPlayers
					.containsKey(p.getUniqueId())) {
				showTOS(p);
			}
		}
	}

	public void showTOS(Player p) {
		if (p == null) {
			return;
		}
		TextComponent welcome = new TextComponent("Welcome to Civcraft!");
		welcome.setColor(ChatColor.RED);
		welcome.setBold(true);
		p.spigot().sendMessage(welcome);
		TextComponent agree = new TextComponent(
				"To be able to play, you need to read our terms of service first and agree to those");
		p.spigot().sendMessage(agree);
		TextComponent click = new TextComponent(
				"You can click this message to open up the terms of service");
		click.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,
				"http://pornhub.com")); // TODO TODO TODO change to wherever the
										// tos are
		p.spigot().sendMessage(click);
		TextComponent confirm = new TextComponent("Once you've read it, you can click this message to agree to the terms");
		confirm.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/replace with right command"));  //TODO
		p.spigot().sendMessage(confirm);
	}
}
