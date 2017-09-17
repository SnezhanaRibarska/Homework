package restaurant;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import dish.Dessert;
import dish.Dish;
import dish.MainDish;
import dish.Salat;
import drink.Alcohol;
import drink.Drink;
import drink.NonAlcohol;
import person.Waiter;

public class Menu {
	
	private HashSet<Dish> dishes;
	private HashSet<Drink> drinks;
	
	public Menu() {
		dishes=new HashSet<Dish>();
		dishes.add(new Salat("Shopska",400));
		dishes.add(new Salat("Cezar",500));
		dishes.add(new MainDish("Parjola",600));
		dishes.add(new MainDish("Sirene po shopski",400));
		dishes.add(new Dessert("Sufle",200));
		dishes.add(new Dessert("Melba",300));
		drinks=new HashSet<Drink>();
		drinks.add(new Alcohol("Vodka"));
		drinks.add(new Alcohol("Menta"));
		drinks.add(new Alcohol("Bira"));
		drinks.add(new NonAlcohol("Cola"));
		drinks.add(new NonAlcohol("Sok"));
		drinks.add(new NonAlcohol("Voda"));
		
	}

	public Set getDishesh() {
		return Collections.unmodifiableSet(dishes);
	}

	public Set getDrinks() {
		return Collections.unmodifiableSet(drinks);
	}
	
	public Dish getRandomDish(){
		Dish[] d=dishes.toArray(new Dish[dishes.size()]);
		return d[new Random().nextInt(dishes.size())];
	}
	
	public Drink getRandomDrink(){
		Drink[] d=drinks.toArray(new Drink[drinks.size()]);
		return d[new Random().nextInt(drinks.size())];
	}

	@Override
	public String toString() {
		return "Menu [dishes=" + dishes + ", drinks=" + drinks + "]";
	}
	
}
