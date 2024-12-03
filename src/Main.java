import java.util.Scanner;
import java.util.Random;

class Crafting_Recipe
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        boolean roundTrue = false;
        boolean allGuessed = true;
        boolean showSystemProperties = false;

        //intro
        System.out.println("\n\n\nMinecraft Crafting Recipe Quiz");
        System.out.println("____________________");
        System.out.println("\nDo you know your basic crafts?");
        System.out.println("Enter the item(s) needed to craft the given object");
        System.out.println("\nReady?");
        System.out.println("\nEnter Any Key To Start");
        String Null = sc.nextLine();

        //array mappings
        String[] Obj = {"Magma Cream", "Andesite", "Book", "Cookie", "Bow", "Tinted Glass" };
        String[][] Item =   {
                {"blaze powder", "slimeball"},
                {"diorite", "cobblestone"},
                {"paper", "leather"},
                {"wheat", "cocoa beans"},
                {"stick", "string"},
                {"amethyst shard", "glass"}
                            };

        int selObjIndex = rand.nextInt(Obj.length);
        String randObj = Obj[selObjIndex];
        String[] requiredItems = Item[selObjIndex];

        System.out.println("\nCrafting Object: " + randObj);
        System.out.println("You have 3 attempts to guess ALL the items needed to craft it.");


        boolean[] guessCorrect = new boolean[requiredItems.length];

        for (int i = 3; i > 0; i--)
        {
            System.out.print(randObj + " is crafted using: ");
            String Guess = sc.nextLine();

            roundTrue = false;

            for (int j = 0; j < requiredItems.length; j++)
            {
                if (Guess.equalsIgnoreCase(requiredItems[j]) && !guessCorrect[j])
                {
                    guessCorrect[j] = true;
                    roundTrue = true;
                    System.out.println("\nCorrect! You guessed: " + requiredItems[j]);
                break;
                }
            }

            if (!roundTrue)
            {
                System.out.println("\nWrong guess! Attempts left: " + (i - 1));
            }

            //all?
            allGuessed = true;

            for (boolean guessed : guessCorrect)
                {
                if (!guessed)
                    {
                    allGuessed = false;
                    break;
                    }
                }

        if (allGuessed)
            break;

        System.out.println("\n\n\n----------");
        }


        //outro
        if (allGuessed)
        {
        System.out.println("Yay! You've used your spyglass and found all the items needed to craft " + randObj +
                " in Minecraft!");
        }
        else
            {
            System.out.println("Uh oh, a Ghast is crying at your failure. The required items were:");
            for (String itemList : requiredItems)
                {
                System.out.println("---> " + itemList);
                }
            }


        showSystemProperties = true;

        if (showSystemProperties)
            {
            System.out.println("\n\n\n");
            System.out.println("Java Version: " + System.getProperty("java.version") + " by " + System.getProperty("java.vendor"));
            System.out.println("User: " + System.getProperty("user.name"));  //<-- TURNED OFF FOR PRIVACY IN THE VIDEO
            System.out.print("Operating System: " + System.getProperty("os.name"));
            System.out.println(" " + System.getProperty("os.version"));
            System.out.println ("By: Blu");
            System.out.println ("Coded for Hack Club High Seas on December 2nd 2024");
            }


    }
}