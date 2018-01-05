package guekho64.code.minecraft.coreMods;

import guekho64.code.minecraft.coreMods.TandemLibrary.Universal;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.toposort.TopologicalSort.DirectedGraph;
import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import net.minecraft.launchwrapper.IClassTransformer;

/** Important Information
@author guekho64
@version 0.64
@category CoreMod
@since 31/12/2017
@lastUpdated 5/1/2018 2:04 PM
@link http://www.guekho64.webs.com
 **/

//TODO: Many instaces of this class are created at runtime, so this class must be as lightweight as possible
@MCVersion(CoreTandeMod.Local.Environment.General.Info.minecraftVersionDesignedFor)
public final class CoreTandeMod extends DummyModContainer implements IClassTransformer, IFMLCallHook, IFMLLoadingPlugin {
  public static final class Local {
    public static final class Config {
      //TODO: If someday I need to implement some kind of config for THIS mod
    }
    public static final class Environment {
      public static final class General {
        public static final class Info extends Universal.Utils.Types.Others.InfobyGuekho64 {
          public static final int modNumber = 0;
          public static final String minecraftVersionDesignedFor = "1.6.4";
          public static final String modDescription = "The Ultime CoreMod for Minecraft 1.6.4!";
          public static final String modID = "CoreTandeMod";
          public static final String modName = modID;
          public static final String modVersion = "0.64";
        }
        public static final class Files {
          public static File thisCoreModLocation;
        }
      }
      public static final class Specific {
        public static final class Info {
          //TODO: This is the list of clases to be overriden by this CoreMod (And Maybe someday I'll add "classesToModify" for classes to be modified)
          public static final List<String> classesToOverride = new ArrayList<String>() {{
            add("cpw.mods.fml.common.toposort.ModSorter");
          }};
          public static final String rootClassName = CoreTandeMod.class.getName();
        }
      }
    }
    public static final class Utils {
      public static final class Methods {
        public static final class Standalone {
          public static final boolean ExtraModSorterMethod (String UUID, HashMap<String, Boolean> allowedMods, DirectedGraph<ModContainer> modGraph, ModContainer afterAll, ModContainer beforeAll, ModContainer mod) {
            if (allowedMods.containsKey(UUID)) {
              for (Map.Entry<String, Boolean> entry : allowedMods.entrySet()) {
                if (entry.getKey().equals(UUID)) {
                  if (entry.getValue()) {
                    modGraph.addEdge(afterAll, mod);
                  }
                  else {
                    modGraph.addEdge(mod, beforeAll);
                  }
                  break;
                }
              }
              allowedMods.remove(UUID);
              return true;
            }
            else {
              return false;
            }
          }
        }
        public static final class Dependent {
          //TODO: Don't forget this method it's still here!
          public static final void CoreTandeModConstructor (boolean doNothing) {
            if (!doNothing) {
              TandemLibrary.Local.Utils.Methods.Dependent.TandemLibraryConstructor(true);
              TandeMod.Local.Utils.Methods.TandeModConstructor(true);
              PrintToLog("%s", Universal.Environment.General.Misc.Messages.Special.thisExists);
            }
            else {
              assert true;
            }
          }
          public static final ModMetadata GetModMetadata () {
            return new Universal.Utils.Types.GameRelated.ModInfo(Environment.General.Info.modID, Environment.General.Info.modName, Environment.General.Info.modVersion, Environment.General.Info.modDescription, Environment.General.Info.website, Environment.General.Info.authors);
          }
          //TODO: Don't forget this method it's still here!
          public static final Void Call () {
            PrintToLog("%s", Universal.Environment.General.Misc.Messages.Special.thisExists);
            return null;
          }
          public static final void PrintToLog (String format, Object... data) {
            Universal.Utils.Methods.Dependent.PrintToLog(Environment.General.Info.modID, format, data);
          }
          public static final String[] ClassNameToArray () {
            return Universal.Utils.Methods.Standalone.ToArray(ClassName());
          }
          public static final String ClassName () {
            return Environment.Specific.Info.rootClassName;
          }
          public static final void InjectData (Map<String, Object> data) {
            Environment.General.Files.thisCoreModLocation = (File) data.get("coremodLocation");
          }
          public static final byte[] TransformClass (String arg0, String arg1, byte[] arg2) {
            return Universal.Utils.Methods.Dependent.TransformClass(Environment.Specific.Info.classesToOverride, Environment.General.Files.thisCoreModLocation, arg0, arg1, arg2);
          }
        }
      }
      public static final class Types {
        public static final class ExtraModSorterHashMap<K,V> extends HashMap {
          public ExtraModSorterHashMap () {
            put("12a8f8cd-015d-46c3-a5b5-9341f0c3e29d", true);
            put("1638ddf3-3f4b-47b6-8c72-1ce6a32512c2", true);
            put("238585ed-9ea6-4081-a172-50aef9940b10", true);
            put("3d14c1bf-5c14-49a6-bb34-63475b597fe6", true);
            put("4873e598-41e6-4dc5-9b14-3668ac3cc22f", true);
            put("58cfbaf2-77f5-45bd-9764-838b7298797d", true);
            put("5fdaa574-6bb1-4ab2-99ca-ce11afc1255c", true);
            put("6f31f67d-1975-4371-85ca-0417f546df2b", true);
            put("82dc371e-432b-469b-8cd6-b3a8e7197001", false);
            put("8e861236-057b-4082-aef3-11f0bad1d30f", false);
            put("991c29ad-8cd6-4765-a8a1-981bf0475e13", false);
            put("9d4201ee-fa82-4542-be9b-305e4a4df427", false);
            put("b9d86de5-f8d9-4760-90c2-5ad252da5fde", false);
            put("cd35cb73-e343-441d-aade-85fa7f84ce99", false);
            put("d475c64c-3441-417d-bb3c-5f1889c83b07", false);
            put("f9f45778-36b5-45b3-a7f1-df7ac46bc608", false);
          }
        }
      }
    }
  }
  public CoreTandeMod () {
    super(Local.Utils.Methods.Dependent.GetModMetadata());
    Local.Utils.Methods.Dependent.CoreTandeModConstructor(false);
  }
  @Override
  public Void call () throws Exception {
    return Local.Utils.Methods.Dependent.Call();
  }
  @Override
  public final String[] getASMTransformerClass () {
    return Local.Utils.Methods.Dependent.ClassNameToArray();
  }
  @Override
  public final String getModContainerClass () {
    return Local.Utils.Methods.Dependent.ClassName();
  }
  @Override
  public String getSetupClass () {
    return Local.Utils.Methods.Dependent.ClassName();
  }
  @Override
  public final void injectData (Map<String, Object> data) {
    Local.Utils.Methods.Dependent.InjectData(data);
  }
  @Override
  public boolean registerBus (EventBus bus, LoadController controller) {
    return Universal.Utils.Methods.Standalone.RegisterBus(bus, this);
  }
  @Override
  public final byte[] transform (String arg0, String arg1, byte[] arg2) {
    return Local.Utils.Methods.Dependent.TransformClass(arg0, arg1, arg2);
  }
  @Override
  public String[] getLibraryRequestClass () {
    return null;
  }
}
