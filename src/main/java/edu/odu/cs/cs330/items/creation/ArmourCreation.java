package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Armour;
import edu.odu.cs.cs330.items.Item;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ArmourCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ArmourCreation construct()
    {
        return new ArmourCreation();
    }

    @Override
    public Item fromDefaults()
    {
        return new Armour();
    }

    @Override
    public int requiredNumberOfValues()
    {
        return 7;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        /*                    0      1       2    3   4
                             name   mat      dur def  mdr                    lvl    emt           
         * String rawStr = "Fancy Vibranium 9001 62 ProcrastinationReduction 999999 H20";
         */
        // Armour(String nme, int dur, int def, String mtl, String mdr, int lvl, String emt)
        return new Armour(tokens[0], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), tokens[1],
         tokens[4], Integer.parseInt(tokens[5]), tokens[6]);
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal",
        "PMD.OnlyOneReturn"
    })
    @Override
    public Item fromExisting(final Item original)
    {
        if (!(original instanceof Armour)) {
            return null;
        }

        Armour theOriginal = (Armour) original;

        return new Armour(theOriginal.getName(), theOriginal.getDurability(), theOriginal.getDefense(),
         theOriginal.getMaterial(), theOriginal.getModifier(), theOriginal.getModifierLevel(), theOriginal.getElement());
    }
}
