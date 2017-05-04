package edu.dtcc.cis282student.recipegenerator;

import java.util.ArrayList;

public class RecipeListObjects {
    public ArrayList<Recipe> recipes=new ArrayList<>();

    public RecipeListObjects(){
        recipes.add(new Recipe("Chili"));
        recipes.get(0).addIngredient("1","large","onion");
        recipes.get(0).addIngredient("2","cloves","garlic");
        recipes.get(0).addIngredient("1","lb","ground beef");
        recipes.get(0).addIngredient("1","tablespoon","chili powder");
        recipes.get(0).addIngredient("2","teaspoons","oregano");
        recipes.get(0).addIngredient("1","teaspoon","ground cumin");
        recipes.get(0).addIngredient("1/2","teaspoon","salt");
        recipes.get(0).addIngredient("1/2","teaspoon","red pepper sauce");
        recipes.get(0).addIngredient("14.5","ounces","tomatoes");
        recipes.get(0).addIngredient("1","can","kidney beans");

        recipes.add(new Recipe("Baked salmon"));
        recipes.get(1).addIngredient("2","cloves","garlic");
        recipes.get(1).addIngredient("6","tablespoons","olive oil");
        recipes.get(1).addIngredient("1","teaspoon","basil");
        recipes.get(1).addIngredient("1","teaspoon","salt");
        recipes.get(1).addIngredient("1","teaspoon","black pepper");
        recipes.get(1).addIngredient("1","tablespoon","lemon juice");
        recipes.get(1).addIngredient("1","tablespoon","parsley");
        recipes.get(1).addIngredient("2","fillets","salmon");

        recipes.add(new Recipe("Kofta"));
        recipes.get(2).addIngredient("1","lb","ground beef");
        recipes.get(2).addIngredient("1","large","onion");
        recipes.get(2).addIngredient("1","yolk","egg");
        recipes.get(2).addIngredient("2","teaspoons","oregano");
        recipes.get(2).addIngredient("","to taste","salt");
        recipes.get(2).addIngredient("","to taste","black pepper");

        recipes.add(new Recipe("Lemon pepper chicken"));
        recipes.get(3).addIngredient("6","","chicken breast");
        recipes.get(3).addIngredient("1/2","teaspoon","lemon");
        recipes.get(3).addIngredient("1/2","teaspoon","black pepper");
        recipes.get(3).addIngredient("1","teaspoon","onion powder");

        recipes.add(new Recipe("Spaghetti sauce with ground beef"));
        recipes.get(4).addIngredient("1","lb","ground beef");
        recipes.get(4).addIngredient("1","large","onion");
        recipes.get(4).addIngredient("4","cloves","garlic");
        recipes.get(4).addIngredient("1","small","bell pepper");
        recipes.get(4).addIngredient("28","ounces","tomatoes");
        recipes.get(4).addIngredient("1","can","tomato sauce");
        recipes.get(4).addIngredient("1","can","tomato paste");
        recipes.get(4).addIngredient("2","teaspoons","oregano");
        recipes.get(4).addIngredient("2","teaspoon","basil");
        recipes.get(4).addIngredient("1","teaspoon","salt");
        recipes.get(4).addIngredient("1/2","teaspoon","black pepper");
    }

    public String compareList(String[] ingredientList){
        String recipeString="";
        int count;

        for (Recipe dish:recipes){
            count=0;
            for (Ingredient ing:dish.ingredients){
                for (int i=0;i<ingredientList.length;i++){
                    if (ingredientList[i]==ing.getName()){
                        count++;
                        break;
                    }
                }
            }if (count==dish.ingredients.size())
                recipeString+=dish.recipeName+"\t";
        }return recipeString;
    }
}

class Recipe{
    ArrayList<Ingredient> ingredients =new ArrayList<>();
    String recipeName="";


    public Recipe(String recipeName){
        this.recipeName=recipeName;
    }

    public void addIngredient(String measure,String unit,String name){
        ingredients.add(new Ingredient(measure,unit,name));
    }

    public String ingredientsPrintout(){
        String list="";
        for (Ingredient ing:ingredients)
            list+="\n"+ing;
        return list;
    }

    @Override
    public String toString() {
        return recipeName+ingredientsPrintout();
    }
}

class Ingredient{
    String measure,unit,name;

    public Ingredient(String measure,String unit,String name){
        this.measure=measure;
        this.unit=unit;
        this.name=name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return measure+" "+unit+" "+name;
    }
}