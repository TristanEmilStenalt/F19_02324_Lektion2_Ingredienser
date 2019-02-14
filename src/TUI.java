import java.util.List;
import java.util.Scanner;

public class TUI implements IUI {

    //TUI Fields
    private IData iData;
    Scanner scan = new Scanner(System.in);

    //TUI Constructor
    public TUI(IData iData)
    {
        this.iData = iData;
    }


    //TUI metoder, kalder metoderne i IData, som implementeres i DemoData.

    //viser menu med valgmuligheder
    @Override
    public void showMenu() {
        boolean menuActive = true;
        do {
            System.out.println("--- Main Menu ---\n(1) Show all ingredients\n(2) Show specific ingredient\n(3) Change ingredient\n(4) Create new ingredient\n(5) Exit\n--- Main Menu ---");
            int menu = scan.nextInt();

            switch (menu)
            {
                case 1:
                    showIngredients();
                    break;
                case 2:
                    showIngredient();
                    break;
                case 3:
                    changeIngredient();
                    break;
                case 4:
                    createIngredient();
                    break;
                case 5:
                    menuActive = false;
                    break;

                    default: break;
            }

        } while (menuActive == true);

        scan.close();
    }


    //viser alle ingredienser
    @Override
    public void showIngredients() {
        List<String> ingredients = iData.getAllIngredients();

        for (String ingredient: ingredients)
        {
            System.out.println(ingredient);
        }
        //scan.next();
    }


    //lader brugeren vælge ingrediens ud fra id og viser denne
    @Override
    public void showIngredient() {
        System.out.println("Type ID of ingredient you want to SHOW: ");
        int id = scan.nextInt();
        System.out.println("ID: "+id+ " Name: "+iData.getIngredientName(id-1)+ " Amount: "+iData.getIngredientAmount(id-1));
        scan.next();
    }


    //lader brugeren vælge ingrediens ud fra id, dernæst vælge et felt og så indtaste en ny værdi for denne
    @Override
    public void changeIngredient() {
        System.out.println("Type ID of ingredient you want to CHANGE: ");
        int id = scan.nextInt();
        System.out.println("ID: "+id+ " Name: "+iData.getIngredientName(id-1)+ " Amount: "+iData.getIngredientAmount(id-1));
        System.out.println("What do you want to change?\n(1) Name\n(2) Amount");
        int field = scan.nextInt();

        switch (field)
        {
            case 1:
                System.out.println("Enter new NAME: ");
                iData.setIngredientName(id-1, scan.next());
                break;
            case 2:
                System.out.println("Enter new AMOUNT: ");
                iData.setIngredientAmount(id-1, scan.nextInt());
                break;
        }

    }


    //lader brugeren indtaste værdier til en ny ingrediens
    @Override
    public void createIngredient() { //Skal ikke kunne lave ingrediens med allerede eksisterende ID.
        System.out.println("Enter ID, Name, & Amount of new ingredient");
        System.out.print("ID: ");
        int id = scan.nextInt();
        System.out.print("Name: ");
        String name = scan.next();
        System.out.print("Amount: ");
        int amount = scan.nextInt();
        iData.createIngredient(id,name,amount);
        System.out.println("Succesfully created new ingredient...");
    }


}
