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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.ItemData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

/** Important Information
@author guekho64
@version 0.64
@category Library
@since 31/12/2017
@lastUpdated 5/1/2018 1:57 PM
@link http://www.guekho64.webs.com
 **/

//TODO: This class must contain all variables, methods, types, ETC
public final class TandemLibrary {
  public static final class Universal {
    public static final class Environment {
      public static final class General {
        public static final class Config {
          public static final class Details {
            public static final String folderName = "config";
            public static final String fileExtension = "cfg";
          }
          public static final class DefaultValues {
            public static final boolean autoIDFix = false;
          }
          public static final class Categories {
            public static final String behaviorChanges = "Behavior Changes";
            public static final String itemIDs = "Items ID's";
            public static final String normalBlockIDs = "Normal Block ID's";
            public static final String terrainBlockIDs = "Terrain Block ID's";
          }
          public static final class Options {
            public static final String autoIDFix = "AutoIDFix";
          }
          public static final class Suffixes {
            public static final String id = "ID";
          }
        }
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
        public static final class Registry {
          public static final class InGameData {
            public static final class Slots {
              public static final class Available {
                public static final List<List> all = new ArrayList<List>() {{
                  /*0  block*/ add(new ArrayList<List>() {{
                    /*0 terrainId*/ add(new ArrayList<Integer>() {{
                    }});
                    /*1 normaId*/ add(new ArrayList<Integer>() {{
                    }});
                  }});
                  /*1 itemId*/ add(new ArrayList<Integer>() {{
                  }});
                }};
                public static final List<List> blocks = all.get(0);
                public static final List<Integer> terrain = blocks.get(0);
                public static final List<Integer> normal = blocks.get(1);
                public static final List<Integer> item = all.get(1);
              }
              public static final class Occupied {
                public static final List<List> allData = new ArrayList<List>() {{
                  /*0  block*/ add(new ArrayList<List>() {{
                    /*0 terrain*/ add(new ArrayList<List>() {{
                      /*0 id*/ add(new ArrayList<Integer>());
                      /*1 (Block) Object*/ add(new ArrayList<Block>());
                    }});
                    /*1 normal*/ add(new ArrayList<List>() {{
                      /*0 id*/ add(new ArrayList<Integer>());
                      /*1 (Block) Object*/ add(new ArrayList<Block>());
                    }});
                  }});
                  /*1 item*/ add(new ArrayList<List>() {{
                    /*0 id*/ add(new ArrayList<Integer>());
                    /*1 (Item) Object*/ add(new ArrayList<Item>());
                  }});
                }};
                public static final List<List> blockData = allData.get(0);
                public static final List<List> terrainBlockData = blockData.get(0);
                public static final List<Integer> terrainBlockIDs = terrainBlockData.get(0);
                public static final List<Block> terrainBlocks = terrainBlockData.get(1);
                public static final List<List> normalBlockData = blockData.get(1);
                public static final List<Integer> normalBlockIDs = normalBlockData.get(0);
                public static final List<Block> normalBlocks = normalBlockData.get(1);
                public static final List<List> itemData = allData.get(1);
                public static final List<Integer> itemIDs = itemData.get(0);
                public static final List<Item> items = itemData.get(1);
              }
            }
          }
          public static final class InternalData {
            public static final class Assumptions {
              public static boolean hasGuekho64CodeCinecraftCoreModsTandemLibraryUniversalUtilsMethodsDependentEmptyIDsBeenExecutedAtLeastOnce = false;
            }
          }
        }
        public static final class Misc {
          public static final class CompatibilityStandards {
            public static final class Strings {
              public static final class ExtendedWorkbench {
                public static final String extendedWorkbench = "extendedWorkbench";
              }
            }
            public static final class Symbols {
              public static final String replaceableSymbol = "?";
            }
          }
          public static final class Messages {
            public static final class Exceptions {
              public static final class Fixable {
                public static final String defaultMessage = "I'm a default exception. CHANGE THIS MESSAGE!";
                //TODO: Tal vez algún dia me encargue de arreglar este famoso problema de una buena vez por todas...pero aún no (Modificando aún más clases de FML)
                public static final String providedIDNotAvailableItem = "Provided ID isn't available for: ITEM ------> [" + (CompatibilityStandards.Symbols.replaceableSymbol + "]");
                public static final String providedIDNotAvailableBlock = "Provided ID isn't available for: BLOCK ------> [" + (CompatibilityStandards.Symbols.replaceableSymbol + "]");
                public static final String providedIDNotAvailableTerrainBlock = "Provided ID isn't available for: TERRAIN BLOCK ------> [" + (CompatibilityStandards.Symbols.replaceableSymbol + "]");
                public static final String providedIDNotValid = "Provided ID isn't valid ------> [" + (CompatibilityStandards.Symbols.replaceableSymbol + "]");
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
          public static final void DropUnusedID (int unusedID, List<Integer> emptyIDsList, List<Integer> occupiedIDsList) {
            if (!emptyIDsList.contains(unusedID)) {
              emptyIDsList.add(unusedID);
            }
            if (occupiedIDsList.contains(unusedID)) {
              occupiedIDsList.remove((Integer) unusedID);
            }
          }
          public static final int ItemIDPlus (int value) {
            return (value + 256);
          }
          public static final int ItemIDLess (int value) {
            return (value - 256);
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
            //TODO: Maybe this is useless...
            if (isNecessary) {
              config = new Configuration(file, true);
            }
          }
          public static final void SetInfoToMetadata (ModMetadata metadata, String modID, String modName, String modVersion, String modDescription, String modWebsite, String... modAuthors) {
            metadata.autogenerated = false;
            metadata.authorList = Arrays.asList(modAuthors);
            metadata.description = modDescription;
            metadata.modId = modID;
            metadata.name = modName;
            metadata.url = modWebsite;
            metadata.version = modVersion;
          }
          public static final boolean RegisterBus (EventBus bus, Object klass) {
            bus.register(klass);
            return true;
          }
          public static final String[] ToArray (String... array) {
            return array;
          }
          public static final String ToUppercaseFirstLetter (String string) {
            if (!string.isEmpty()) {
              string = (string.substring(0, 1).toUpperCase() + string.substring(1));
            }
            return string;
          }
        }
        public static final class Dependent {
          public static final void AddItemToRegistry (Item item) {
            if (!Environment.General.Registry.InGameData.Slots.Occupied.items.contains(item)) {
              Environment.General.Registry.InGameData.Slots.Occupied.items.add(item);
            }
          }
          public static final void AddBlockToRegistry (Block block, boolean isTerrainType) {
            if (isTerrainType) {
              if (!Environment.General.Registry.InGameData.Slots.Occupied.terrainBlocks.contains(block)) {
                Environment.General.Registry.InGameData.Slots.Occupied.terrainBlocks.add(block);
              }
            }
            else {
              if (!Environment.General.Registry.InGameData.Slots.Occupied.normalBlocks.contains(block)) {
                Environment.General.Registry.InGameData.Slots.Occupied.normalBlocks.add(block);
              }
            }
          }
          public static final boolean GetAutoIDFixStatus (Configuration config) {
            //TODO: Set custom msg
            return config.get(Environment.General.Config.Categories.behaviorChanges, Environment.General.Config.Options.autoIDFix, Environment.General.Config.DefaultValues.autoIDFix, "Setting this to TRUE will override ID's from below, so they'll change if needed.\nYou should activate this when creating a NEW ModPack or if you're adding this\nmod for first time to a NEW OR EXISTING ModPack.\nIf you're going to add more mods to an EXISTING ONE that may alredy have\nsome worlds or if IT ISN'T the first time you add this mod, turn this off to avoid data/world corruption.").getBoolean(Environment.General.Config.DefaultValues.autoIDFix);
          }
          public static final void DropUnusedItemID (int unusedID) {
            Standalone.DropUnusedID(unusedID, Environment.General.Registry.InGameData.Slots.Available.item, Environment.General.Registry.InGameData.Slots.Occupied.itemIDs);
          }
          public static final void DropUnusedBlockID (int unusedID, boolean isTerrainType) {
            if (isTerrainType) {
              Standalone.DropUnusedID(unusedID, Environment.General.Registry.InGameData.Slots.Available.terrain, Environment.General.Registry.InGameData.Slots.Occupied.terrainBlockIDs);
            }
            else {
              Standalone.DropUnusedID(unusedID, Environment.General.Registry.InGameData.Slots.Available.normal, Environment.General.Registry.InGameData.Slots.Occupied.normalBlockIDs);
            }
          }
          public static final String GetItemCategory () {
            return Environment.General.Config.Categories.itemIDs;
          }
          public static final String GetBlockCategory (boolean isTerrainType) {
            if (isTerrainType) {
              return Environment.General.Config.Categories.terrainBlockIDs;
            }
            else {
              return Environment.General.Config.Categories.normalBlockIDs;
            }
          }
          public static final int GetItemID (Configuration config, String rawName, boolean autoIDFix) {
            int configRetrievedID;
            boolean wasFallbackIDUseful = false;
            final int fallbackID = GetEmptyItemID(0);
            final Property configProperty = config.get(GetItemCategory(), (rawName + Environment.General.Config.Suffixes.id), fallbackID);
            if (configProperty.isIntValue()) {
              configRetrievedID = configProperty.getInt();
              if (configRetrievedID == fallbackID) {
                wasFallbackIDUseful = true;
              }
            }
            else {
              if (autoIDFix) {
                configRetrievedID = fallbackID;
                wasFallbackIDUseful = true;
              }
              else {
                //TODO: Create a custom msg
                throw CustomException("Config value isn't a valid ID", true);
              }
            }
            if (!wasFallbackIDUseful) {
              DropUnusedItemID(fallbackID);
            }
            if (CheckValidItemID(configRetrievedID)) {
              if ( (!Environment.General.Registry.InGameData.Slots.Available.item.contains(configRetrievedID)) && (!wasFallbackIDUseful) ) {
                if (autoIDFix) {
                  configRetrievedID = GetEmptyItemID(0);
                }
                else {
                  //TODO: Create custom message
                  throw CustomException("Config value was alredy in use", true);
                }
              }
            }
            else {
              if (autoIDFix) {
                configRetrievedID = GetEmptyItemID(0);
              }
              else {
                //TODO: Create a custom msg
                throw CustomException("Config value isn't a valid ID (Not in recommended range of ID's", true);
              }
            }
            if (configProperty.isIntValue()) {
              if (configProperty.getInt() != configRetrievedID) {
                configProperty.set(configRetrievedID);
              }
            }
            else {
              configProperty.set(configRetrievedID);
            }
            return configRetrievedID;
          }
          public static final int GetBlockID (Configuration config, String rawName, boolean isTerrainType, boolean autoIDFix) {
            int configRetrievedID;
            boolean wasFallbackIDUseful = false;
            final int fallbackID = GetEmptyBlockID(0, isTerrainType);
            final Property configProperty = config.get(GetBlockCategory(isTerrainType), (rawName + Environment.General.Config.Suffixes.id), fallbackID);
            if (configProperty.isIntValue()) {
              configRetrievedID = configProperty.getInt();
              if (configRetrievedID == fallbackID) {
                wasFallbackIDUseful = true;
              }
            }
            else {
              if (autoIDFix) {
                configRetrievedID = fallbackID;
                wasFallbackIDUseful = true;
              }
              else {
                //TODO: Create a custom msg
                throw CustomException("Config value isn't a valid ID", true);
              }
            }
            if (!wasFallbackIDUseful) {
              DropUnusedBlockID(fallbackID, isTerrainType);
            }
            if (CheckValidBlockID(configRetrievedID, isTerrainType)) {
              if (isTerrainType) {
                if ( (!Environment.General.Registry.InGameData.Slots.Available.terrain.contains(configRetrievedID)) && (!wasFallbackIDUseful) ) {
                  if (autoIDFix) {
                    configRetrievedID = GetEmptyBlockID(0, isTerrainType);
                  }
                  else {
                    //TODO: Create custom message
                    throw CustomException("Config value was alredy in use", true);
                  }
                }
              }
              else {
                if ( (!Environment.General.Registry.InGameData.Slots.Available.normal.contains(configRetrievedID)) && (!wasFallbackIDUseful) ) {
                  if (autoIDFix) {
                    configRetrievedID = GetEmptyBlockID(0, isTerrainType);
                  }
                  else {
                    //TODO: Create custom message
                    throw CustomException("Config value was alredy in use", true);
                  }
                }
              }
            }
            else {
              if (autoIDFix) {
                configRetrievedID = GetEmptyBlockID(0, isTerrainType);
              }
              else {
                //TODO: Create a custom msg
                throw CustomException(("Config value isn't a valid ID (Not in recommended range of ID's) [isTerrainType --->  " + (((Boolean) isTerrainType).toString() + "]")), true);
              }
            }
            if (configProperty.isIntValue()) {
              if (configProperty.getInt() != configRetrievedID) {
                configProperty.set(configRetrievedID);
              }
            }
            else {
              configProperty.set(configRetrievedID);
            }
            return configRetrievedID;
          }
          public static final int GetEmptyItemID (int preferredID) {
            return (GetEmptyID(preferredID, Environment.General.Registry.InGameData.Slots.Available.item, Environment.General.Registry.InGameData.Slots.Occupied.itemIDs));
          }
          public static final int GetEmptyBlockID (int preferredID, boolean isTerrainType) {
            int value;
            if (isTerrainType) {
              if (CheckValidBlockID(preferredID, isTerrainType)) {
                value = GetEmptyID(preferredID, Environment.General.Registry.InGameData.Slots.Available.terrain, Environment.General.Registry.InGameData.Slots.Occupied.terrainBlockIDs);
              }
              else {
                value = GetEmptyID(0, Environment.General.Registry.InGameData.Slots.Available.terrain, Environment.General.Registry.InGameData.Slots.Occupied.terrainBlockIDs);
              }
            }
            else {
              if (CheckValidBlockID(preferredID, isTerrainType)) {
                value = GetEmptyID(preferredID, Environment.General.Registry.InGameData.Slots.Available.normal, Environment.General.Registry.InGameData.Slots.Occupied.normalBlockIDs);
              }
              else {
                value = GetEmptyID(0, Environment.General.Registry.InGameData.Slots.Available.normal, Environment.General.Registry.InGameData.Slots.Occupied.normalBlockIDs);
              }
            }
            return value;
          }
          public static final int GetEmptyID (int preferredID, List<Integer> emptyIDsList, List<Integer> occupiedIDsList) {
            int value;
            if (Environment.General.Registry.InternalData.Assumptions.hasGuekho64CodeCinecraftCoreModsTandemLibraryUniversalUtilsMethodsDependentEmptyIDsBeenExecutedAtLeastOnce) {
              if (emptyIDsList.contains(preferredID)) {
                value = preferredID;
              }
              else if ( (preferredID == 0) || !(emptyIDsList.contains(preferredID)) ) {
                value = emptyIDsList.get(emptyIDsList.size() - 1);
              }
              else {
                //TODO: Create a custom msg
                throw CustomException("No ID or requested one isn't available", true);
              }
              if (emptyIDsList.contains(value)) {
                emptyIDsList.remove((Integer) value);
              }
              if (!occupiedIDsList.contains(value)) {
                occupiedIDsList.add(value);
              }
              return value;
            }
            else {
              //TODO: Create a custom msg
              throw CustomException("EmptyIDs hasn't been run at least one", true);
            }
          }
          public static final void EmptyIDs (Map<Integer, ItemData> occupiedIDsMap) {
            for (int id = 0; !(id > Environment.General.ID.Item.Ranges.Possible.lastID); ++id) {
              if ( !(occupiedIDsMap.containsKey(id)) && !(Environment.General.Registry.InGameData.Slots.Occupied.terrainBlockIDs.contains(id)) && !(Environment.General.Registry.InGameData.Slots.Occupied.normalBlockIDs.contains(id)) && !(Environment.General.Registry.InGameData.Slots.Occupied.itemIDs.contains(id)) ) {
                if (CheckValidID(id, true)) {
                  if (!(id > Environment.General.ID.Block.Ranges.Possible.lastTerrainID)) {
                    if (!Environment.General.Registry.InGameData.Slots.Available.terrain.contains(id)) {
                      Environment.General.Registry.InGameData.Slots.Available.terrain.add(id);
                    }
                  }
                  else {
                    if (!Environment.General.Registry.InGameData.Slots.Available.normal.contains(id)) {
                      Environment.General.Registry.InGameData.Slots.Available.normal.add(id);
                    }
                  }
                }
                else if (CheckValidID(id, false)) {
                  if (!Environment.General.Registry.InGameData.Slots.Available.item.contains(id)) {
                    Environment.General.Registry.InGameData.Slots.Available.item.add(id);
                  }
                }
                else {
                  CustomException(Environment.General.Misc.Messages.Exceptions.Fixable.providedIDNotValid.replaceFirst(("//" + Environment.General.Misc.CompatibilityStandards.Symbols.replaceableSymbol), ((Integer) id).toString()) , false);
                }
              }
              else {
                if (CheckValidID(id, true)) {
                  if (!(id > Environment.General.ID.Block.Ranges.Possible.lastTerrainID)) {
                    CustomException(Environment.General.Misc.Messages.Exceptions.Fixable.providedIDNotAvailableTerrainBlock.replaceFirst(("//" + Environment.General.Misc.CompatibilityStandards.Symbols.replaceableSymbol), ((Integer) id).toString()) , false);
                  }
                  else {
                    CustomException(Environment.General.Misc.Messages.Exceptions.Fixable.providedIDNotAvailableBlock.replaceFirst(("//" + Environment.General.Misc.CompatibilityStandards.Symbols.replaceableSymbol), ((Integer) id).toString()) , false);
                  }
                }
                else if (CheckValidID(id, false)) {
                  CustomException(Environment.General.Misc.Messages.Exceptions.Fixable.providedIDNotAvailableItem.replaceFirst(("//" + Environment.General.Misc.CompatibilityStandards.Symbols.replaceableSymbol), ((Integer) id).toString()) , false);
                }
                else {
                  CustomException(Environment.General.Misc.Messages.Exceptions.Fixable.providedIDNotValid.replaceFirst(("//" + Environment.General.Misc.CompatibilityStandards.Symbols.replaceableSymbol), ((Integer) id).toString()) , false);
                }
              }
            }
            if (!Environment.General.Registry.InternalData.Assumptions.hasGuekho64CodeCinecraftCoreModsTandemLibraryUniversalUtilsMethodsDependentEmptyIDsBeenExecutedAtLeastOnce) {
              Environment.General.Registry.InternalData.Assumptions.hasGuekho64CodeCinecraftCoreModsTandemLibraryUniversalUtilsMethodsDependentEmptyIDsBeenExecutedAtLeastOnce = true;
            }
          }
          public static final boolean CheckValidItemID (int id) {
            return Standalone.CheckValidID(id, Environment.General.ID.Item.Ranges.Possible.firstID, Environment.General.ID.Item.Ranges.Possible.lastID);
          }
          public static final boolean CheckValidBlockID (int id, boolean isTerrainType) {
            if (isTerrainType) {
              return Standalone.CheckValidID(id, Environment.General.ID.Block.Ranges.Possible.firstID, Environment.General.ID.Block.Ranges.Possible.lastTerrainID);
            }
            else {
              return Standalone.CheckValidID(id, (Environment.General.ID.Block.Ranges.Possible.lastTerrainID + 1), Environment.General.ID.Block.Ranges.Possible.lastID);
            }
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
          public static final byte[] TransformClass (List<String> listOfClassesToModify, File jarLocation, String arg0, String arg1, byte[] arg2) {
            if (listOfClassesToModify.contains(arg0)) {
              arg2 = PatchClassInJar(arg0, arg2, jarLocation);
              listOfClassesToModify.remove((String) arg0);
            }
            return arg2;
          }
          public static final byte[] PatchClassInJar (String classToModify, byte[] bytes, File jarLocation) {
            try {
              final ZipFile zip = new ZipFile(jarLocation);
              final ZipEntry entry = zip.getEntry(classToModify.replace('.', '/') + '.' + "class");
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
              return (new Types.Others.CustomException((Environment.General.Misc.Messages.Exceptions.Fixable.defaultMessage + message), fatal));
            }
            else {
              return (new Types.Others.CustomException((Environment.General.Misc.Messages.Exceptions.Fatal.defaultMessage + Environment.General.Misc.Messages.Exceptions.Fixable.defaultMessage + message), fatal));
            }
          }
          public static final void PrintToLog (String modID, String format, Object... data) {
            FMLLog.log(modID, Level.INFO, format, data);
          }
        }
      }
      public static final class Types {
        public static final class GameRelated {
          public static final class Item extends net.minecraft.item.Item {
            public Item (Configuration config, String rawName, CreativeTabs creativeTab) {
              super(Methods.Standalone.ItemIDLess(Methods.Dependent.GetItemID(config, rawName, Methods.Dependent.GetAutoIDFixStatus(config))));
              setCreativeTab(creativeTab);
              setUnlocalizedName(rawName);
              Methods.Dependent.AddItemToRegistry(this);
            }
          }
          public static final class Block extends net.minecraft.block.Block {
            public Block (Configuration config, String rawName, Material material, CreativeTabs creativeTab, boolean isTerrainType) {
              super(Methods.Dependent.GetBlockID(config, rawName, isTerrainType, Methods.Dependent.GetAutoIDFixStatus(config)), material);
              setCreativeTab(creativeTab);
              setUnlocalizedName(rawName);
              GameRegistry.registerBlock(this);
              Methods.Dependent.AddBlockToRegistry(this, isTerrainType);
            }
          }
          public static final class CreativeTab extends CreativeTabs {
            private ItemStack tabImage;
            public CreativeTab (String label, ItemStack itemStack) {
              super(label);
              tabImage = itemStack;
            }
            @SideOnly(Side.CLIENT)
            @Override
            public int getTabIconItemIndex() {
              return tabImage.itemID;
            }
          }
          public static final class ModInfo extends ModMetadata {
            public ModInfo (String modID, String modName, String modVersion, String modDescription, String modWebsite, String... modAuthors) {
              Methods.Standalone.SetInfoToMetadata(this, modID, modName, modVersion, modDescription, modWebsite, modAuthors);
            }
          }
          public static final class Config extends Configuration {
            public Config (File file) {
              super(file, true);
            }
          }
        }
        public static final class Others {
          public static final class CustomException extends RuntimeException {
            public CustomException (String message, boolean fatal) {
              super(message);
              if (fatal) {
                printStackTrace();
              }
            }
          }
          public static class InfobyGuekho64 {
            public static final String[] authors = Methods.Standalone.ToArray("guekho64");
            public static final String website = "http://guekho64.webs.com/";
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
        public static final class Info extends Universal.Utils.Types.Others.InfobyGuekho64 {
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
