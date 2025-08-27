// Fix for glass tag changes from c:glass/colorless to c:glass_blocks/colorless
// This affects many recipes that use glass as an ingredient

KubeJSTweaks.beforeRecipes(event => {
  console.log('Applying global glass tag fixes...')
  
  // Get all recipes (not just a specific one like in the original fix)
  event.getEntry('*')
    .forEach(entry => {
      // Fix tag references in recipe keys (for shaped recipes)
      let keys = entry.json().get('key')
      if (keys != null) {
        keys.asMap().forEach((key, value) => {
          if (value.has('tag') && value.get('tag').getAsString() === 'c:glass/colorless') {
            entry.replaceValueAtKey('key', 'tag', 'c:glass/colorless', 'c:glass_blocks/colorless')
            console.log(`Fixed glass tag in recipe ${entry.id()} (key format)`)
          }
        })
      }
      
      // Fix tag references in ingredients (for shapeless recipes)
      let ingredients = entry.json().get('ingredients')
      if (ingredients != null) {
        for (let i = 0; i < ingredients.size(); i++) {
          let ing = ingredients.get(i)
          if (ing.has('tag') && ing.get('tag').getAsString() === 'c:glass/colorless') {
            entry.json().set('ingredients', i, 'tag', 'c:glass_blocks/colorless')
            console.log(`Fixed glass tag in recipe ${entry.id()} (ingredients format)`)
          }
        }
      }
    })
  
  console.log('Glass tag fixes completed')
})