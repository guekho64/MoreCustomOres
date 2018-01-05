package guekho64.code.minecraft.coreMods;

import guekho64.code.minecraft.coreMods.TandemLibrary.Universal;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/** Important Information
@author guekho64
@version 0.64
@category Mod
@since 31/12/2017
@lastUpdated 5/1/2018 2:02 PM
@link http://www.guekho64.webs.com
 **/

//TODO: Probably, Many instaces of this class are created at runtime, so this class must be as lightweight as possible
@Mod(modid = TandeMod.Local.Environment.General.Info.modID, name = TandeMod.Local.Environment.General.Info.modUUID, version = TandeMod.Local.Environment.General.Info.modVersion, acceptedMinecraftVersions = TandeMod.Local.Environment.General.Info.minecraftVersionDesignedFor, dependencies = TandeMod.Local.Environment.General.Info.modDependencies)
public final class TandeMod {
  public static final class Local {
    public static final class Environment {
      public static final class General {
        public static final class Info extends Universal.Utils.Types.Others.InfobyGuekho64 {
          public static final String minecraftVersionDesignedFor = "1.6.4";
          public static final String modDependencies = "required-after:FML;required-after:CoreTandeMod@[0.64,);";
          public static final String modDescription = "The Ultime Mod for Minecraft 1.6.4!";
          public static final String modID = "TandeMod";
          public static final String modUUID = "12a8f8cd-015d-46c3-a5b5-9341f0c3e29d";
          public static final String modName = modID;
          public static final String modVersion = "0.64";
        }
      }
    }
    public static final class Utils {
      public static final class Methods {
        //TODO: Don't forget this method it's still here!
        public static final void TandeModConstructor (boolean doNothing) {
          if (!doNothing) {
            TandemLibrary.Local.Utils.Methods.Dependent.TandemLibraryConstructor(true);
            CoreTandeMod.Local.Utils.Methods.Dependent.CoreTandeModConstructor(true);
            PrintToLog("%s", Universal.Environment.General.Misc.Messages.Special.thisExists);
          }
          else {
            assert true;
          }
        }
        public static final void SetInfoToMetadata (ModMetadata metadata) {
          Universal.Utils.Methods.Standalone.SetInfoToMetadata(metadata, Environment.General.Info.modID, Environment.General.Info.modName, Environment.General.Info.modVersion, Environment.General.Info.modDescription, Environment.General.Info.website, Environment.General.Info.authors);
        }
        public static final void PrintToLog (String format, Object... data) {
          Universal.Utils.Methods.Dependent.PrintToLog(Environment.General.Info.modName, format, data);
        }
      }
    }
  }
  public TandeMod () {
    Local.Utils.Methods.TandeModConstructor(false);
  }
  @EventHandler
  public static final void PreInitPhase (FMLPreInitializationEvent event) {
    Local.Utils.Methods.SetInfoToMetadata(event.getModMetadata());
  }
  @EventHandler
  public static final void InitPhase (FMLInitializationEvent event) {
    //TODO: Don't forget this method's here!
    Local.Utils.Methods.PrintToLog("%s", Universal.Environment.General.Misc.Messages.Special.thisExists);
  }
  @EventHandler
  public static final void PostInitPhase (FMLPostInitializationEvent event) {
    //TODO: Don't forget this method's here!
    Universal.Utils.Methods.Dependent.EmptyIDs(Universal.Utils.Methods.Dependent.GetIDMap());
  }
}
