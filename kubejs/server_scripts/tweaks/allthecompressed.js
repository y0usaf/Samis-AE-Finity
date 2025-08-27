// This File has been authored by AllTheMods Staff, or a Community contributor for use in AllTheMods - AllTheMods 10: To the Sky.
// As all AllTheMods packs are licensed under All Rights Reserved, this file is not allowed to be used in any public packs not released by the AllTheMods Team, without explicit permission.

ServerEvents.recipes(allthemods => {
    
    function crushing(input, output) {
        let id = `${input.split(':')[1]}_to_${output.split(':')[1]}`
        let ing  = Ingredient.of(input).toJson()
        let stack = Item.of(output, 1)
        
        allthemods.custom(
            {
                "type": "create:crushing",
                "ingredients": [
                    ing
                ],
                "processingTime": 100,
                "results": [
                    stack
                ]
            }
        )
        
        allthemods.custom(
            {
                type: 'mekanism:crushing',
                input: ing,
                output: stack
            }
        ).id(`allthemods:mekanism/crushing/${id}`)
    }
    
    function smelting(input, output) {
        
    }
    
    function haunting(input, output) {
        let id = `${input.split(':')[1]}_to_${output.split(':')[1]}`
        let ing  = Ingredient.of(input).toJson()
        let stack = Item.of(output, 1)
        
        allthemods.custom(
            {
                "type": "create:haunting",
                "ingredients": [
                    ing
                ],
                "results": [
                    stack
                ]
            }
        ).id(`allthemods:create/haunting/${id}`)
    }

    for (let i = 1; i < 10; i++) {
        [
            `allthecompressed:cobblestone_${i}x`,
            `allthecompressed:granite_${i}x`,
            `allthecompressed:andesite_${i}x`,
            `allthecompressed:diorite_${i}x`,
        ].forEach(ing => {
            crushing(ing, `allthecompressed:gravel_${i}x`)
        })
        crushing(`allthecompressed:gravel_${i}x`, `allthecompressed:sand_${i}x`)
        
        haunting(`allthecompressed:cobblestone_${i}x`, `allthecompressed:blackstone_${i}x`)
        haunting(`allthecompressed:sand_${i}x`, `allthecompressed:soul_sand_${i}x`)
        
        allthemods.smelting(`allthecompressed:stone_${i}x`, `allthecompressed:cobblestone_${i}x`)
        allthemods.smelting(`allthecompressed:glass_${i}x`, `allthecompressed:sand_${i}x`)

        allthemods.recipes.exdeorum.barrel_mixing(`allthecompressed:clay_${i}x`, `allthecompressed:sand_${i}x`, '1000x minecraft:water')
    } 
})

// This File has been authored by AllTheMods Staff, or a Community contributor for use in AllTheMods - AllTheMods 10: To the Sky.
// As all AllTheMods packs are licensed under All Rights Reserved, this file is not allowed to be used in any public packs not released by the AllTheMods Team, without explicit permission.
