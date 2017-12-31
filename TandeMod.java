package guekho64.code.minecraft.coreMods;

import guekho64.code.minecraft.coreMods.TandemLibrary.Universal;

import cpw.mods.fml.common.Mod;

/** Important Information
@author guekho64
@version 0.64
@category Mod
@since 31/12/2017
@lastUpdated 31/12/2017 12:53 PM
@link http://www.guekho64.webs.com
 **/

//TODO: Probably, Many instaces of this class are created at runtime, so this class must be as lightweight as possible
@Mod(modid = TandeMod.Local.Environment.General.Info.modID, name = TandeMod.Local.Environment.General.Info.modName, version = TandeMod.Local.Environment.General.Info.modVersion, acceptedMinecraftVersions = TandeMod.Local.Environment.General.Info.minecraftVersionDesignedFor)
public final class TandeMod {
  public static final class Local {
    public static final class Environment {
      public static final class General {
        public static final class Info extends Universal.Utils.MoldClasses.InfobyGuekho64 {
          public static final String minecraftVersionDesignedFor = "1.6.4";
          public static final String modDescription = "The Ultime Mod for Minecraft 1.6.4!";
          public static final String modID = "TandeMod";
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
        public static final void PrintToLog (String format, Object... data) {
          Universal.Utils.Methods.Dependent.PrintToLog(Environment.General.Info.modName, format, data);
        }
      }
    }
  }
  public TandeMod () {
    Local.Utils.Methods.TandeModConstructor(false);
  }
}
