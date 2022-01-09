package menu.api.event

import trmenu.module.display.Menu
import trmenu.module.display.MenuSession
import taboolib.platform.type.BukkitProxyEvent

/**
 * @author Arasple
 * @date 2021/1/29 17:34
 */
class MenuOpenEvent(val session: MenuSession, val menu: Menu, val page: Int, val reason: Reason = Reason.UNKNOWN) :
    BukkitProxyEvent() {

    enum class Reason {

        RELOAD,

        PLAYER_COMMAND,

        CONSOLE,

        BINDING_COMMANDS,

        BINDING_ITEMS,

        BINDING_SHORTCUT,

        UNKNOWN

    }

}