package guekho64.code.minecraft.coreMods;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.toposort.TopologicalSort.DirectedGraph;
import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.common.Configuration;

/** Important Information

@author guekho64
@version 0.64
@category Minecraft Mod
@since 1/11/2017
@lastUpdated 25/12/2017 9:00 PM MX
@link http://www.guekho64.webs.com

 **/

/* Comment Section Starts Here

 **Rules**

 *Classes are always uppercase in their first letter and camelCase onwards
 *Methods too
 *Classes mustn't collide with Curly Braces
 *(While declaring) Method Descriptor (Name) mustn't collide with parenthesis
 *(While calling) Method Descriptor (Name) must collide with parenthesis
 *Compartive/Assignment symbols mustn't collide with any character (Excepting "++")
 *After typing a comma (Or semicolon) , a space must follow it (Unless it's EOL)
 *Variables must always be lowercase in their first letter and camelCase onwards
 * "!" Must collide with the expression on which the symbol wants to be used
 *Calls to other methods must be as specific and firect as possible
 *Casts to objects must be wrapped around in parenthesis, to ease readability.
 *If you plan to use disposable data, it must be contained into a List.
 *In General, code must be as readable and compact as possible (Not too compact, nor trying to explain every bit. Just try to find balance between these terms)

 * New files should be named in such a way that you can distinguish their "Stability level" and author. Here's an example:
 *   (Default) -> TandeMod.java
 *   (Just by looking at it you can tell that the original author wrote this file too, BUT isn't as Stable or trustworthy as "TandeMod.java") -> TandeMod2.java
 *   (Same Author, but lower stability) -> TandeMod3.java
 *   (Wow! Some dude wrote new code) -> CoolDude_TandeMod.java
 *   (Same dude, newer file, less stable) -> CoolDude_TandeMod2.java
 *   (Some other guys made a file together) -> Mario-Luigi_TandeMod.java

 *   As you can see, files are kinda ordered & named by "Author" & "Stability Level"
 *   Also, every author should have their own "Base File", like "AuthorName_TandeModStability.java", so everybody can have their own inner API (Or Pseudo-API?) and distinguish between files, to avoid overwritting someone else's code.
 *   It's your decidion to rely or not in these "Inner APIs" written by other poeple. Obviously, "TandeMod.java", being the "Base" file for every class in here,  will NEVER make a critical modification UNLESS really necessary.
 *   That way, everybody will know where to look for erros & bugs in a faster way. by just looking at the name of a class.

 *   In fact, the author follows these rules when creating a new class (And you should follow 'em too!):
 *   If last class has been declared "Stable", a new class should be created, so this one will stay fully functional.
 *   If last class hasn't been declared "Stable", but you don't want to pollute it (Various reasons may overcome for it to happen...), he may create a new file just to store in these newer methods...

 * That being said, this file HAS NOT been declared as "Stable" yet. Written by guekho64. (In fact, it's just an empty "Shell")
 * As a side note, this file uses "2 spaces" indentation.

 * TODO: Otra checadita...
 * TODO: THIS SHIT WORKS?! (Hay que ver si funciona igual en modo OFUSCADO)
 * TODO: Recuerda que hay que revivir-hallar 5 mods en total, contando este CoreMod.
 * TODO: Después de todo esto, seguir adelante :D (¿Iré por buen camino?) 

 * TODO: Ya hasta el final, ordenaré los métodos por orden alfabético (SI es que no ya tienen un order ya establecido) o por orden topológico

 */

@MCVersion(TandeMod.Content.API.Local.Environment.General.Info.minecraftVersionDesignedFor)
@Mod(modid = TandeMod.Content.API.Local.Environment.General.Info.modIDAlt, name = TandeMod.Content.API.Local.Environment.General.Info.modIDAlt, version = TandeMod.Content.API.Local.Environment.General.Info.modVersion, acceptedMinecraftVersions = TandeMod.Content.API.Local.Environment.General.Info.minecraftVersionDesignedFor)
public final class TandeMod extends DummyModContainer implements IClassTransformer, IFMLCallHook, IFMLLoadingPlugin {
  public static final class Content {
    public static final class API {
      public static final class Universal {
        public static final class Config {}
        public static final class Environment {
          public static final class General {
            public static final class Misc {
              public static final class Exception {
                public static final class Fixable {
                  public static final class Messages {
                    //TODO: This goes somewhere else...
                    public static final String emptyString = "";
                    public static final String defaultMessage = "I'm a default exception. CHANGE THIS MESSAGE!";
                    //TODO. Tal vez algún dia me encargue de arreglar este famosos problema de una buena vez por todas...pero aún no
                    public static final String providedIDNotAvailableBlock = "Provided ID isn't available for: BLOCK";
                    public static final String providedIDNotAvailableItem = "Provided ID isn't available for: ITEM";
                    public static final String providedIDNotAvailableTerrainBlock = "Provided ID isn't available for: TERRAIN BLOCK";
                    public static final String providedIDNotValid = "Provided ID isn't valid";
                  }
                }
                public static final class Fatal {
                  public static final class Messages {
                    public static final String defaultMessage = "I'm a fatal message that must be added after the defaultError message!";
                  }
                }
              }
            }
          }
          public static final class Specific {}
        }
        public static final class Utils {
          public static final class Methods {
            public static final class Standalone {
              public static final void LoadConfig (Configuration config, boolean var) {
                if (var) {
                  config.load();
                }
              }
              public static final void SaveConfig (Configuration config, boolean var) {
                if (var) {
                  config.save();
                }
              }
              public static final void SetModConfig (Configuration config, File file, boolean isNecessary) {
                //TODO: If a config file IS really necessary...
                if (isNecessary) {
                  config = new Configuration(file, true);
                }
              }
              public static final boolean RegisterBus (EventBus bus, Object klass) {
                bus.register(klass);
                return true;
              }
              public static final String[] ToArray (String... array) {
                return array;
              }
            }
            public static final class Dependent {
              public static final byte[] TransformClass (List<String> listOfClassesToModify, File jarLocation, String arg0, String arg1, byte[] arg2) {
                if (listOfClassesToModify.contains(arg0)) {
                  arg2 = PatchClassInJar(arg0, arg2, jarLocation);
                  listOfClassesToModify.remove(arg0);
                }
                return arg2;
              }
              public static final byte[] PatchClassInJar (String classToModify, byte[] bytes, File jarLocation) {
                try {
                  ZipFile zip = new ZipFile(jarLocation);
                  ZipEntry entry = zip.getEntry(classToModify.replace(".", "/") + "." + "class");
                  if (entry != null) {
                    InputStream zin = zip.getInputStream(entry);
                    bytes = new byte[( (int) entry.getSize() )];
                    try {
                      zin.read(bytes);
                    }
                    catch (Exception problem) {
                      problem.printStackTrace();
                      // TODO: Create a special msg in variable
                      throw CustomException("Ded", true);
                    }
                    finally {
                      zin.close();
                    }
                  }
                  else {
                    // TODO: Create a special msg in variable
                    throw CustomException("Ded", true);
                  }
                  zip.close();
                }
                catch (Exception problem) {
                  problem.printStackTrace();
                  // TODO: Create a special msg in variable
                  throw CustomException("Ded", true);
                }
                return bytes;
              }
              public static final RuntimeException CustomException (boolean fatal) {
                return CustomException(Environment.General.Misc.Exception.Fixable.Messages.emptyString, fatal);
              }
              public static final RuntimeException CustomException (String message, boolean fatal) {
                if (!fatal) {
                  return (new Types.CustomException((Environment.General.Misc.Exception.Fixable.Messages.defaultMessage + message), fatal));
                }
                else {
                  return (new Types.CustomException((Environment.General.Misc.Exception.Fatal.Messages.defaultMessage + Environment.General.Misc.Exception.Fixable.Messages.defaultMessage + message), fatal));
                }
              }
              public static final void PrintToLog (String modID, String format, Object... data) {
                FMLLog.log(modID, Level.INFO, format, data);
              }
            }
          }
          public static final class Types {
            public static final class CustomException extends RuntimeException {
              public CustomException (String message, boolean fatal) {
                super(message);
                if (fatal) {
                  printStackTrace();
                }
              }
            }
            public static final class ModInfo extends ModMetadata {
              public ModInfo (String modID, String modName, String modVersion, String modDescription, String modWebsite, String... modAuthors) {
                authorList = Arrays.asList(modAuthors);
                description = modDescription;
                modId = modID;
                name = modName;
                url = modWebsite;
                version = modVersion;
              }
            }
          }
        }
      }
      public static final class Local {
        public static final class Config {}
        public static final class Environment {
          public static final class General {
            public static final class Info {
              public static final int modNumber = 0;
              public static final String minecraftVersionDesignedFor = "1.6.4";
              public static final String[] modAuthors = new String[] {"guekho64"};
              public static final String modDescription = "The Ultime Mod for Minecraft 1.6.4!";
              public static final String modIDAlt = "TandeMod";
              public static final String modID = Mods.Info.modsContained.get(modNumber);
              public static final String modName = modID;
              public static final String modVersion = "0.64";
              public static final String modWebsite = "http://guekho64.webs.com/";
            }
            public static final class Files {
              public static File modLocation;
            }
          }
          public static final class Specific {
            public static final class Info {
              // This is the list of clases to be modified by this mod
              public static final List<String> classesToModify = new ArrayList<String>() {{
                add("cpw.mods.fml.common.toposort.ModSorter");
              }};
              public static final String rootClassName = TandeMod.class.getName();
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
              public static final void TandeMod () {
                // TODO: Don't forget this method it's still here!
                PrintToLog("%s", "Don't forget I'm still Here!");
              }
              // TODO: Don't forget this method it's still here!
              public static final Void Call () {
                PrintToLog("%s", "Don't forget I'm still Here!");
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
                Environment.General.Files.modLocation = (File) data.get("coremodLocation");
              }
              public static final byte[] TransformClass (String arg0, String arg1, byte[] arg2) {
                return Universal.Utils.Methods.Dependent.TransformClass(Environment.Specific.Info.classesToModify, Environment.General.Files.modLocation, arg0, arg1, arg2);
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
    }
    public static final class Mods {
      public static final class Info {
        // All of these are listed in the right order
        public static final List<String> modsContained = new ArrayList<String>() {{
          add("CoreTandeMod");
          add("TandeMod");
        }};
      }
    }
  }
  /*    All the following methods won't receive as much attention as the above ones in many
aspects. Instead, our own methods will be created and all of these methods will return
what our methods return.    */
  public TandeMod () {
    super(new Content.API.Universal.Utils.Types.ModInfo(Content.API.Local.Environment.General.Info.modID, Content.API.Local.Environment.General.Info.modName, Content.API.Local.Environment.General.Info.modVersion, Content.API.Local.Environment.General.Info.modDescription, Content.API.Local.Environment.General.Info.modWebsite, Content.API.Local.Environment.General.Info.modAuthors));
    Content.API.Local.Utils.Methods.Dependent.TandeMod();
  }
  @Override
  public Void call () throws Exception {
    return Content.API.Local.Utils.Methods.Dependent.Call();
  }
  @Override
  public final String[] getASMTransformerClass () {
    return Content.API.Local.Utils.Methods.Dependent.ClassNameToArray();
  }
  @Override
  public final String getModContainerClass () {
    return Content.API.Local.Utils.Methods.Dependent.ClassName();
  }
  @Override
  public String getSetupClass () {
    return Content.API.Local.Utils.Methods.Dependent.ClassName();
  }
  @Override
  public final void injectData (Map<String, Object> data) {
    Content.API.Local.Utils.Methods.Dependent.InjectData(data);
  }
  @Override
  public boolean registerBus (EventBus bus, LoadController controller) {
    return Content.API.Universal.Utils.Methods.Standalone.RegisterBus(bus, this);
  }
  @Override
  public final byte[] transform (String arg0, String arg1, byte[] arg2) {
    return Content.API.Local.Utils.Methods.Dependent.TransformClass(arg0, arg1, arg2);
  }
  @Override
  public String[] getLibraryRequestClass () {
    return null;
  }
}
