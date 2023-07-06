fun main() {
    val recipe1 = KenyanRecipe("githeri", 6, "beans, nuts and maize", "30 mins", "stew", "well balanced meal")
    println(recipe1.portions(6))
    val recipe2 = RwandaRecipe("Isombe", "beans, meat, onions", "30 mins", "boil and fry", "kills children with no pain")
    println(recipe2.allergic("yams"))
}
open class Recipe(
    val ingredients: String,
    val preparationTime: String,
    val cookingMethod: String,
    val nutritionalInfo: String
)
class KenyanRecipe(
    val recipeName: String,
    val serving: Int,
    ingredients: String,
    preparationTime: String,
    cookingMethod: String,
    nutritionalInfo: String
) : Recipe(ingredients, preparationTime, cookingMethod, nutritionalInfo) {
    fun portions(preferredServing: Int): String {
        return when {
            preferredServing > serving -> {
                val portionAmount = (preferredServing / serving)
                "The portion of ingredients can be increased $portionAmount times"
            }
            preferredServing < serving -> {
                val portionAmount = (serving / preferredServing)
                "The portion of ingredients can be decreased $portionAmount times"
            }
            else ->{
                "The portion of food serves $serving"
            }
        }
    }
}
class RwandaRecipe(
    val recipeName: String,
    ingredients: String,
    preparationTime: String,
    cookingMethod: String,
    nutritionalInfo: String
) : Recipe(ingredients, preparationTime, cookingMethod, nutritionalInfo) {
    fun allergic(allergen: String): String {
        return if (allergen in ingredients) {
            "Beware! $allergen are in $recipeName dish"
        } else {
            "Relax! $allergen is not in $recipeName dish"
        }
    }
}