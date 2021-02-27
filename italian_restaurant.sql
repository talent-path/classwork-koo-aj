-- ITALIAN RESTAURANT DATABASE
  
-- 2 menus
INSERT into "Menus" ("name") VALUES ('Lunch Menu'), ('Dinner Menu');

  
-- 5 food items
INSERT into "Dishes" ("name") VALUES ('Arancini'), ('Lasagne'), ('Pizza'), ('Pasta'), ('Gelato');
-- LUNCH MENU --> Arancini, Pizza, Gelato
INSERT into "MenusDishes" ("menuID", "dishID", "price") VALUES ('1', '1', '5.50'), ('1', '3', '16.99'), ('1', '5', '3.25');

-- DINNER MENU --> Pasta, Lasagne, Gelato
INSERT into "MenusDishes" ("menuID", "dishID", "price") VALUES ('2', '2', '13.00'), ('2', '4', '8.75'), ('2', '5', '3.25');

-- 10 recipes
-- Recipes for Pizza --> Cheese, Pepperoni, Deluxe
-- Recipes for Pasta --> Vegetarian, Non-Vegetarian
-- Recipes for Lasagne --> Vegetarian, Non-Vegetarian
-- Recipes for Gelato --> Vanilla, Chocolate
INSERT into "Recipes" ("dishID", "name", "instruction") VALUES ('3', 'Cheese Pizza', 'Make sure the pizza is REAL cheesy.'), ('3', 'Pepperoni', 'Make sure not to skimp on the Pepperoni.'), ('3', 'Deluxe', 'Make sure to have a fair amount of everything.');
INSERT into "Recipes" ("dishID", "name", "instruction") VALUES ('4', 'Non-Vegetarian Pasta', 'Please add a sufficient amount of MEAT.'), ('4', 'Vegetarian Pasta', 'NO MEAT PLEASE.');
INSERT into "Recipes" ("dishID", "name", "instruction") VALUES ('2', 'Non-Vegetarian Lasagne', 'Please add a sufficient amount of MEAT.'), ('2', 'Vegetarian Lasagne', 'NO MEAT PLEASE.');
INSERT into "Recipes" ("dishID", "name", "instruction") VALUES ('1', 'Arancini', 'Has Mozarella and rice in it.');
INSERT into "Recipes" ("dishID", "name", "instruction") VALUES ('5', 'Vanilla Gelato', 'Better be the most quality vanilla Gelato ever!'), ('5', 'Chocolate Gelato', 'Better be the most quality chocolate Gelato ever!');

 
-- Pizza --> Flour, Tomato Sauce, Mozarella, Pepperoni, Bacon, Peppers, Onions, Ham, Olives, Mushroom
-- Pasta --> Rigatoni, Tomato Sauce, Parmesan, Meat Sauce
-- Lasagne --> Lasagne Noodles, , Tomato Sauce, Parmesan, Meat Sauce
-- Gelato --> Milk, Cream, Sugar, Vanilla Bean
-- Arancini --> Rice, Mozarella, Tomato Sauce (side)
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Tomato Sauce', '20', 'Gallons'); -- 1
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Mozarella', '50', 'Pounds'); -- 2
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Flour', '70', 'Pounds'); -- 3
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Pepperoni', '10', 'Pounds'); -- 4 
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Meat Sauce', '20', 'Gallons'); -- 5
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Rigatoni', '10', 'Pounds'); -- 6
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Parmesan', '30', 'Pounds'); -- 7
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Lasagne Noodles', '10', 'Pounds'); --8
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Milk', '30', 'Gallons'); -- 9
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Cream', '15', 'Gallons'); -- 10
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Bacon', '12', 'Pounds'); -- 11
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Peppers', '10', 'Pounds'); -- 12
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Mushrooms', '10', 'Pounds'); -- 13
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Onions', '15', 'Pounds'); -- 14
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Vanilla Bean', '35', 'Pounds'); -- 15
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Sugar', '35', 'Pounds'); -- 16
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Rice', '50', 'Pounds'); -- 17
INSERT into "Ingredients" ("name", "stock", "unit") VALUES ('Chocolate', '35', 'Pounds'); -- 18


-- This is the amount of ingredients we needed for each ingredients.
-- Cheese Pizza 1
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('1', '1', '0.05', 'Gallons');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('1', '2', '0.04', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('1', '3', '0.5', 'Pounds');
-- Pepperoni Pizza 2
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('2', '1', '0.05', 'Gallons');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('2', '2', '0.04', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('2', '3', '0.5', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('2', '4', '0.01', 'Pounds');
-- Deluxe Pizza 3
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('3', '1', '0.05', 'Gallons');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('3', '2', '0.04', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('3', '3', '0.5', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('3', '4', '0.01', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('3', '11', '0.01', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('3', '12', '0.01', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('3', '13', '0.01', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('3', '14', '0.01', 'Pounds');
-- Non-Vegetarian Pasta 4
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('4', '6', '0.05', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('4', '5', '0.08', 'Gallons');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('4', '7', '0.01', 'Pounds');
-- Vegetarian Pasta 5 
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('5', '6', '0.05', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('5', '1', '0.08', 'Gallons');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('5', '7', '0.01', 'Pounds');
-- Non-Vegetarian Lasagne 6 
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('6', '8', '0.05', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('6', '5', '0.08', 'Gallons');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('6', '7', '0.01', 'Pounds');

-- Vegetarian Lasagne 7
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('7', '8', '0.05', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('7', '1', '0.08', 'Gallons');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('7', '7', '0.01', 'Pounds');

-- Arancini 8
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('8', '2', '0.02', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('8', '17', '0.02', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('8', '3', '0.05', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('8', '1', '0.01', 'Gallons');

-- Vanilla Gelato 9
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('9', '9', '0.02', 'Gallons');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('9', '10', '0.02', 'Gallons');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('9', '15', '0.02', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('9', '16', '0.02', 'Pounds');

-- Chocolate Gelato 10
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('10', '9', '0.02', 'Gallons');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('10', '10', '0.02', 'Gallons');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('10', '18', '0.02', 'Pounds');
INSERT into "RecipesIngredients" ("recipeID", "ingredientID", "quantity", "unit") VALUES ('10', '16', '0.02', 'Pounds');




-- 3 suppliers (all ingredients should have at least two of the three suppliers, distributed semi-evenly)
INSERT into "Suppliers" ("name") VALUES ('Italianos'), ('Genos'), ('Santo');

-- For each suppliers we had different prices of ingredients. 
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('1', '1', '1000', 'Gallons', '7.00');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('1', '2', '1000', 'Gallons', '6.75');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('2', '2', '1000', 'Pounds', '6.20');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('2', '3', '1000', 'Pounds', '6.15');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('3', '1', '2000', 'Pounds', '0.50');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('3', '3', '2000', 'Pounds', '0.55');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('4', '1', '2000', 'Pounds', '6.50');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('4', '2', '1000', 'Pounds', '6.75');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('5', '2', '2000', 'Gallons', '8.00');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('5', '3', '1500', 'Gallons', '8.20');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('6', '1', '1750', 'Pounds', '7.30');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('6', '3', '1800', 'Pounds', '7.70');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('7', '1', '2000', 'Pounds', '7.20');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('7', '2', '2000', 'Pounds', '7.10');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('8', '2', '1000', 'Pounds', '7.00');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('8', '3', '1000', 'Pounds', '7.15');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('9', '1', '1000', 'Gallons', '1.50');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('9', '3', '1000', 'Gallons', '1.70');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('10', '1', '2000', 'Gallons', '3.00');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('10', '3', '2000', 'Gallons', '3.05');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('11', '1', '2000', 'Pounds', '10.00');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('11', '2', '1000', 'Pounds', '11.00');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('12', '2', '2000', 'Pounds', '8.00');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('12', '3', '1500', 'Pounds', '8.20');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('13', '1', '1750', 'Pounds', '5.00');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('13', '3', '1800', 'Pounds', '5.15');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('14', '1', '2000', 'Pounds', '6.15');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('14', '2', '2000', 'Pounds', '6.10');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('15', '1', '2000', 'Pounds', '4.50');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('15', '3', '2000', 'Pounds', '4.20');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('16', '1', '2000', 'Pounds', '20.00');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('16', '2', '1000', 'Pounds', '21.05');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('17', '2', '2000', 'Pounds', '0.75');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('17', '3', '1500', 'Pounds', '0.80');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('18', '1', '1750', 'Pounds', '10.00');
INSERT into "SuppliersIngredients" ("ingredientID", "supplierID", "quantityAvailable", "unit", "unitCost") VALUES ('18', '3', '1800', 'Pounds', '10.10');



-- Desired report:
-- show me each menu and with that show me the name of the dish 
-- that makes the most profit
-- (price we sell at minus the cost of lowest total cost recipe 
-- sourced from the cheapest ingredients) and the amount of profit it makes.

-- FIRST: find cheapest ingredient from supplier
select "ingredientID", min("unitCost") as cheapestCost 
	from "SuppliersIngredients" 
	group by "ingredientID" 
	order by "ingredientID"
-- SECOND: find cheapest cost for each recipe
select ri."recipeID", sum(ri."quantity" * cic."cheapestcost") as "totalRecipeCost"
	from "RecipesIngredients" as ri
	inner join "cheapestIngredientCost" as cic
	on ri."ingredientID" = cic."ingredientID"
	group by "recipeID" 
	order by "recipeID"
-- THIRD: find cheapest recipe to make
select r."dishID", min(ct."totalRecipeCost") as "cheapestDishRecipe"
	from "Recipes" as r
	inner join "cheapestTotalRecipeCost" as ct
	on r."recipeID" = ct."recipeID" 
	group by "dishID"
	order by "dishID"
-- FOURTH: find get menuID, dishID, cost, and price
select md."menuID", md."dishID", md."price" - crpd."cheapestDishRecipe" as "profit"
	from "MenusDishes" as md
	inner join "cheapestRecipePerDish" as crpd
	on md."dishID" = crpd."dishID"
	order by "dishID"
	
-- FIFTH: find the name of the menu and name of the dish with the profit
select menu."name", max(pro."profit") as "profit"
	from "Menus" as menu
	inner join "MenusDishes" as md on menu."menuID" = md."menuID"
	inner join "Dishes" as dish on md."dishID" = dish."dishID"
	inner join "highestDishProfits" as pro on dish."dishID" = pro."dishID"
	group by menu."name"


-- Challenge:
-- show me the AVERAGE profit of all dishes on each menu
select menu."name", round(avg(dp."profit")::numeric, 4) as "avgProfit"
	from "Menus" as menu
	inner join "dishProfit" as dp on menu."name" = dp."name"
	group by menu."name"
	

TRUNCATE TABLE "Dishes", "Ingredients", "Menus", "MenusDishes", "Orders", "OrdersDishes", "Recipes", "RecipesIngredients", "Suppliers", "SuppliersIngredients", "Tabletops" RESTART IDENTITY 

