import java.util.ArrayList;
import java.util.List;

public class DemoData implements IData {

    //private "inner class" Ingredient
    private class Ingredient
    {
        //Ingredient Fields
        int id;
        String name;
        int amount;

        //Ingredient Constructor
        Ingredient(int id, String name, int amount) {
            this.id = id;
            this.name = name;
            this.amount = amount;
        }

        //Ingredient Methods
        @Override
        public String toString()
        {
            String ingredient ="ID: "+id+ " Name: "+name+ " Amount: "+amount;
            return ingredient;
        }

    }



    //DemoData Fields
    private List<Ingredient> ingredients;

    //DemoData Constructor
    public DemoData() {
        ingredients = new ArrayList<>();
        //Adding Ingredients
        ingredients.add(new Ingredient(1, "flormelis", 60));
        ingredients.add(new Ingredient(2, "mel", 240));
        ingredients.add(new Ingredient(3, "smør", 185));
    }


    //DemoData Methods

    //returnerer alle ingredienser i String-format
    @Override
    public List<String> getAllIngredients() {

        ArrayList strIngredients = new ArrayList();

        for (Ingredient ingredient: ingredients)
        {
            strIngredients.add(ingredient.toString());
        }

        return strIngredients;

    }

    //returnerer navn for ingrediens
    @Override
    public String getIngredientName(int id) {
        return ingredients.get(id).name;
    }

    //returnerer mængde for ingrediens
    @Override
    public int getIngredientAmount(int id) {
        return ingredients.get(id).amount;
    }

    //ændrer navn for ingrediens til angivet værdi i 'name'
    @Override
    public void setIngredientName(int id, String name) {
        ingredients.get(id).name = name;
    }

    //ændrer mængde for ingrediens til angivet værdi i 'amount'
    @Override
    public void setIngredientAmount(int id, int amount) {
        ingredients.get(id).amount = amount;
    }

    //opretter en ny ingrediens med de angivne værdier
    @Override
    public void createIngredient(int id, String name, int amount) {
        ingredients.add(new Ingredient(id, name, amount));
    }



}
