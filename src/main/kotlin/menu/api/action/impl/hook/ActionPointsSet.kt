package menu.api.action.impl.hook

import trmenu.api.action.base.AbstractAction
import trmenu.api.action.base.ActionOption
import trmenu.module.internal.hook.HookPlugin
import org.bukkit.entity.Player
import taboolib.common.platform.function.adaptPlayer
import trmenu.api.action.InternalAction
import trmenu.api.action.base.ActionDesc

/**
 * @author Arasple
 * @date 2021/1/31 16:21
 */
class ActionPointsSet(content: String, option: ActionOption) : InternalAction(content, option) {

    override fun onExecute(player: Player, placeholderPlayer: Player) {
            val amount = parseContent(adaptPlayer(placeholderPlayer)).toIntOrNull() ?: -1
            if (amount > 0) {
                HookPlugin.getPlayerPoints().setPoints(player, amount)
            }
    }

    companion object : ActionDesc {

        override val name = "(set|modify)-?points?".toRegex()

        override val parser: (Any, ActionOption) -> AbstractAction = { value, option ->
            ActionPointsSet(value.toString(), option)
        }

    }

}