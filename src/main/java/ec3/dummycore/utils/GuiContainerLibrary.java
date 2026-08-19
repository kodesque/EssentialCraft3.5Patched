package ec3.dummycore.utils;

import DummyCore.Utils.Notifier;

import java.util.ArrayList;
import java.util.List;

public class GuiContainerLibrary {
    public static List<String> guis = new ArrayList();
    public static List<String> containers = new ArrayList();

    public GuiContainerLibrary() {
    }

    public static int registerGuiContainer(String guiClassPath, String containerClassPath) {
        int lstSize = guis.size();

        try {
            guis.add(guiClassPath);
            containers.add(containerClassPath);
            return lstSize;
        } catch (Exception e) {
            Notifier.notifySimple("Unable to register GUI-Container with ID " + lstSize);
            e.printStackTrace();
            return -1;
        }
    }
}
