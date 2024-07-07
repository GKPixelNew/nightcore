package su.nightexpress.nightcore.util.placeholder;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.function.UnaryOperator;

public interface AdvancedPlaceholder extends Placeholder {
    /**
     * @deprecated Use {@link #replacePlaceholders(Player)} or {@link #replacePlaceholders(CommandSender)} instead.
     */
    @Override
    @NotNull
    @Deprecated
    default UnaryOperator<String> replacePlaceholders() {
        return Placeholder.super.replacePlaceholders();
    }

    @NotNull
    default UnaryOperator<String> replacePlaceholders(Player player) {
        return str -> {
            str = this.replacePlaceholders().apply(str);
            return PlaceholderAPI.setPlaceholders(player, str);
        };
    }

    @NotNull
    default UnaryOperator<String> replacePlaceholders(CommandSender sender) {
        if (sender instanceof Player) {
            return this.replacePlaceholders((Player) sender);
        }
        return replacePlaceholders();
    }
}
