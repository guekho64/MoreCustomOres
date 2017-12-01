package guekho64.code.minecraft.coreMods;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

/** Important Information

@author guekho64
@version 0.64
@category Minecraft Mod
@since 1/11/2017
@lastUpdated 30/11/2017 8:26 PM MX
@link http://www.guekho64.webs.com

 **/

/* Comment Section Starts Here

 **Rules**

 *Classes are always uppercase in their first letter and camelCase onwards
 *Methods too
 *Method Descriptor must collide with parenthesis
 *Variables are always lowercase in their first letter and camelCase onwards

 *THIS file, "TandeMod.java" MUST contain only the default & original methods that were planned inicially.
 *As a matter of fact, all these methods, variables and content in general, being part of the "Default" set
 *Will be tested and tested till no one of these are buggy, or have some other kind of failure, therefore declared stable.
 *Anyways, stable or not, THIS file should only be modified by the author of this file (And other files too), to keep control over it.
 *(If declared stable, not even the author will modify THIS file from there onwards...unless a bug is discovered or (Even more) optimization has to be made)

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

 *In fact, the author follows these rules when creating a new class (And you should follow 'em too!):
 *   If last class has been declared "Stable", a new class should be created, so this one will stay fully functional.
 *   If last class hasn't been declared "Stable", but you don't want to pollute it (Various reasons may overcome for it to happen...), he may create a new file just to store in these newer methods...

 * That being said, this file HAS NOT been declared as "Stable" yet. Written by guekho64. (In fact, it's just an empty "Shell")
 * As a side note, this file uses "4 spaces" indentation.

 */

@Mod(modid = "TandeMod")
public final class TandeMod  {
    public static final class Essentials {
        public static final class Local {
            public static final class Config {}
            public static final class Environment {}
            public static final class Utils {
                public static final class Methods {
                    public static final class Complicated {}
                }
            }
        }
        public static final class Universal {
            public static final class Config {}
            public static final class Environment {}
            public static final class Utils {
                public static final class Methods {
                    public static final class Complicated {}
                    public static final class Simple {}
                }
                public static final class Reflections {}
                public static final class Types {}
            }
        }
    }
}
