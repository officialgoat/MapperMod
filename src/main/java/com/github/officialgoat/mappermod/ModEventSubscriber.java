package com.github.officialgoat.mappermod;

import com.github.officialgoat.mappermod.mapper_app.GTemplate;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

@Mod.EventBusSubscriber(modid = Constants.MODID)
public final class ModEventSubscriber {
    private static final Logger LOGGER = LogManager.getLogger(Constants.MODID + " Mod event Sub");

    @SubscribeEvent
    public static void postInitEvent(final GuiOpenEvent event){
        if(event.getGui() instanceof MainMenuScreen){
            LOGGER.debug("Main menu opened.");
            System.setProperty("java.awt.headless", "false");
            //SwingUtilities.invokeLater(GTemplate::new);
        }
    }

    @SubscribeEvent
    public static void postGuiInitEvent(final GuiScreenEvent.InitGuiEvent.Post  event){
        if(event.getGui() instanceof MainMenuScreen){
            LOGGER.debug("Main menu initialised");
            MainMenuScreen mainMenu = (MainMenuScreen) event.getGui();
            int maxY = 0;
            for (final Widget button : event.getWidgetList()){
                maxY = Math.max(button.y, maxY);
            }
            int j = mainMenu.height / 4 + 48;
            event.addWidget(new Button(mainMenu.width / 2 + 104, j + 24 * 2, 20, 20, new TranslationTextComponent("menu.mapper-mod.mapper"), button -> {
                LOGGER.debug("Mapper Button pressed");
                System.setProperty("java.awt.headless", "false");
                SwingUtilities.invokeLater(GTemplate::new);
            }));
        }
    }

}
