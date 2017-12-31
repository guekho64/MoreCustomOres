package guekho64.code.minecraft.coreMods;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;
import net.minecraftforge.common.Configuration;

/** Important Information
@author guekho64
@version 0.64
@category Library
@since 31/12/2017
@lastUpdated 31/12/2017 12:53 PM
@link http://www.guekho64.webs.com
 **/

//TODO: This class must contain all variables, methods, types, ETC
public final class TandemLibrary {
  public static final class Universal {
    public static final class Environment {
      public static final class General {
        public static final class ID {
          public static final class Block {
            public static final class Ranges {
              public static final class Impossible {
                public static final int firstID = 0;
                public static final int lastID = net.minecraft.block.Block.blocksList.length;
              }
              public static final class Possible {
                public static final int firstID = Impossible.firstID + 1;
                public static final int lastTerrainID = Impossible.firstID + 255;
                public static final int lastID = Impossible.lastID - 1;
              }
            }
          }
          public static final class Item {
            public static final class Ranges {
              public static final class Impossible {
                public static final int firstID = Block.Ranges.Possible.lastID;
                public static final int lastID = net.minecraft.item.Item.itemsList.length;
              }
              public static final class Possible {
                public static final int firstID = Impossible.firstID + 1;
                public static final int lastID = Impossible.lastID - 1;
              }
            }
          }
        }
        public static final class Misc {
          public static final class Messages {
            public static final class Exceptions {
              public static final class Fixable {
                public static final String defaultMessage = "I'm a default exception. CHANGE THIS MESSAGE!";
                //TODO. Tal vez algún dia me encargue de arreglar este famoso problema de una buena vez por todas...pero aún no (Modificando aún más clases de FML)
                public static final String providedIDNotAvailableBlock = "Provided ID isn't available for: BLOCK";
                public static final String providedIDNotAvailableItem = "Provided ID isn't available for: ITEM";
                public static final String providedIDNotAvailableTerrainBlock = "Provided ID isn't available for: TERRAIN BLOCK";
                public static final String providedIDNotValid = "Provided ID isn't valid";
              }
              public static final class Fatal {
                public static final String defaultMessage = "I'm a fatal message that must be added after the defaultError message!";
              }
            }
            public static final class Special {
              public static final String emptyString = "";
              public static final String thisExists = "Don't forget I'm here!";
            }
          }
        }
      }
    }
    public static final class Utils {
      public static final class MoldClasses {
        public static class InfobyGuekho64 {
          public static final String[] authors = Methods.Standalone.ToArray("guekho64");
          public static final String website = "http://guekho64.webs.com/";
        }
      }
      public static final class Methods {
        public static final class Standalone {
          public static final boolean CheckValidID (int id, int firstPossibleID, int lastPossibleID) {
            if ( !(id < firstPossibleID) && !(id > lastPossibleID) ) {
              return true;
            }
            else {
              return false;
            }
          }
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
          public static final List<List> EmptyIDs (Map<Integer, ItemData> occupiedIDsList) {
            final List<List> listOfLists = new ArrayList<List>();
            final List<List> availableBlockIDListOfLists = new ArrayList<List>();
            final List<Integer> availableTerrainBlockIDList = new ArrayList<Integer>();
            final List<Integer> availableNormalBlockIDList = new ArrayList<Integer>();
            final List<Integer> availableItemIDList = new ArrayList<Integer>();
            for (int id = 0; !(id > Environment.General.ID.Item.Ranges.Possible.lastID) ;++id) {
              if (!(occupiedIDsList.containsKey(id))) {
                if (CheckValidID(id, true)) {
                  if (!(id > Environment.General.ID.Block.Ranges.Possible.lastTerrainID)) {
                    availableTerrainBlockIDList.add(id);
                  }
                  else {
                    availableNormalBlockIDList.add(id);
                  }
                }
                else if (CheckValidID(id, false)) {
                  availableItemIDList.add(id);
                }
                else {
                  CustomException(Environment.General.Misc.Messages.Exceptions.Fixable.providedIDNotValid, false);
                }
              }
              else {
                if (CheckValidID(id, true)) {
                  if (!(id > Environment.General.ID.Block.Ranges.Possible.lastTerrainID)) {
                    CustomException(Environment.General.Misc.Messages.Exceptions.Fixable.providedIDNotAvailableTerrainBlock, false);
                  }
                  else {
                    CustomException(Environment.General.Misc.Messages.Exceptions.Fixable.providedIDNotAvailableBlock, false);
                  }
                }
                else if (CheckValidID(id, false)) {
                  CustomException(Environment.General.Misc.Messages.Exceptions.Fixable.providedIDNotAvailableItem, false);
                }
                else {
                  CustomException(Environment.General.Misc.Messages.Exceptions.Fixable.providedIDNotValid, false);
                }
              }
            }
            listOfLists.add(availableBlockIDListOfLists);
            availableBlockIDListOfLists.add(availableTerrainBlockIDList);
            availableBlockIDListOfLists.add(availableNormalBlockIDList);
            listOfLists.add(availableItemIDList);
            return listOfLists;
          }
          public static final boolean CheckValidID (int id, boolean isBlock) {
            if (isBlock) {
              return Standalone.CheckValidID(id, Environment.General.ID.Block.Ranges.Possible.firstID, Environment.General.ID.Block.Ranges.Possible.lastID);
            }
            else {
              return Standalone.CheckValidID(id, Environment.General.ID.Item.Ranges.Possible.firstID, Environment.General.ID.Item.Ranges.Possible.lastID);
            }
          }
          public static final Map<Integer, ItemData> GetIDMap () {
            try {
              return (new Reflections.IDMap().idMap);
            }
            catch (Exception problem) {
              //TODO: Create a custom msg
              throw CustomException("Something went wrong when retrieving a new IDMap", true);
            }
          }
          public static final int GetEmptyID (List<Integer> emptyIDsList, int preferredValue, List<Integer> myOccupiedIDs) {
            int value;
            if (emptyIDsList.contains(preferredValue)) {
              value = preferredValue;
            }
            else if ( (preferredValue == 0) || !(emptyIDsList.contains(preferredValue)) ) {
              value = emptyIDsList.get(0);
            }
            else {
              //TODO: Create a custom msg
              throw CustomException("No ID available", true);
            }
            emptyIDsList.remove(value);
            myOccupiedIDs.add(value);
            return value;
          }
          public static final byte[] TransformClass (List<String> listOfClassesToModify, File jarLocation, String arg0, String arg1, byte[] arg2) {
            if (listOfClassesToModify.contains(arg0)) {
              arg2 = PatchClassInJar(arg0, arg2, jarLocation);
              listOfClassesToModify.remove(arg0);
            }
            return arg2;
          }
          public static final byte[] PatchClassInJar (String classToModify, byte[] bytes, File jarLocation) {
            try {
              final ZipFile zip = new ZipFile(jarLocation);
              final ZipEntry entry = zip.getEntry(classToModify.replace(".", "/") + "." + "class");
              if (entry != null) {
                final InputStream zin = zip.getInputStream(entry);
                bytes = new byte[((int) entry.getSize())];
                try {
                  zin.read(bytes);
                }
                catch (Exception problem) {
                  problem.printStackTrace();
                  //TODO: Create a special msg in variable
                  throw CustomException("Ded", true);
                }
                finally {
                  zin.close();
                }
              }
              else {
                //TODO: Create a special msg in variable
                throw CustomException("Ded", true);
              }
              zip.close();
            }
            catch (Exception problem) {
              problem.printStackTrace();
              //TODO: Create a special msg in variable
              throw CustomException("Ded", true);
            }
            return bytes;
          }
          //TODO: This shouldn't be used...instead, specify the reason of the problem
          public static final RuntimeException CustomException (boolean fatal) {
            return CustomException(Environment.General.Misc.Messages.Special.emptyString, fatal);
          }
          public static final RuntimeException CustomException (String message, boolean fatal) {
            if (!fatal) {
              return (new Types.CustomException((Environment.General.Misc.Messages.Exceptions.Fixable.defaultMessage + message), fatal));
            }
            else {
              return (new Types.CustomException((Environment.General.Misc.Messages.Exceptions.Fatal.defaultMessage + Environment.General.Misc.Messages.Exceptions.Fixable.defaultMessage + message), fatal));
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
      public static final class Reflections {
        public static final class IDMap {
          public static Field map;
          public static Map<Integer, ItemData> idMap; {
            try {
              map = GameData.class.getDeclaredField("idMap");
              map.setAccessible(true);
              idMap = (Map<Integer, ItemData>) map.get(new GameData());
            }
            catch (Exception problem) {
              //TODO: Create a custom msg
              throw Methods.Dependent.CustomException("Something went wrong when obtaining anew IDMap", true);
            }
          }
        }
      }
    }
  }
  public static final class Local {
    public static final class Environment {
      public static final class General {
        public static final class Info extends Universal.Utils.MoldClasses.InfobyGuekho64 {
          public static final String minecraftVersionDesignedFor = "1.6.4";
          public static final String libraryName = "TandemLibrary";
          public static final String libraryVersion = "0.64";
        }
      }
    }
    public static final class Utils {
      public static final class Methods {
        public static final class Dependent {
          //TODO: Don't forget this!
          public static final void TandemLibraryConstructor (boolean doNothing) {
            if(!doNothing) {
              CoreTandeMod.Local.Utils.Methods.Dependent.CoreTandeModConstructor(true);
              TandeMod.Local.Utils.Methods.TandeModConstructor(true);
              PrintToLog("%s", Universal.Environment.General.Misc.Messages.Special.thisExists);
            }
            else {
              assert true;
            }
          }
          public static final void PrintToLog (String format, Object... data) {
            Universal.Utils.Methods.Dependent.PrintToLog(Environment.General.Info.libraryName, format, data);
          }
        }
      }
    }
  }
  public TandemLibrary () {
    Local.Utils.Methods.Dependent.TandemLibraryConstructor(false);
  }
}
