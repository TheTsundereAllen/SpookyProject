package me.allen.spooky.scripts.type.kitchen;

import me.allen.spooky.scripts.ScriptManager;
import me.allen.spooky.scripts.SpookyScript;
import me.allen.spooky.scripts.type.ScriptEnter;

public class ScriptKitchen extends SpookyScript {

    public String getName() {
        return "Kitchen";
    }

    @Override
    public boolean canTrigger() {
        return spooky.getScriptManager().getLastScript().getName().equalsIgnoreCase("Enter");
    }

    public String[] getMessage() {
        return new String[] {
                "There is a long countertop with dirty dishes everywhere. Off to one side, there is a refrigerator. You hear a noise inside. Do you want to open the \"refrigerator\" or go \"back\"?"
        };
    }

    public SpookyScript getNextScript(String trigger) {
        switch (trigger.toLowerCase()) {
            case "refrigerator":
            case "back":
                return new ScriptEnter();
            default:
                return ScriptManager.DENIED;
        }
    }

}
