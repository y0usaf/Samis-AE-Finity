// This File has been authored by AllTheMods Staff, or a Community contributor for use in AllTheMods - AllTheMods 10.
// As all AllTheMods packs are licensed under All Rights Reserved, this file is not allowed to be used in any public packs not released by the AllTheMods Team, without explicit permission.

const materials = [
    'aluminum', 'lead', 'nickel', 'osmium', 'platinum', 'silver', 'tin', 'uranium', 'zinc', 'iridium', 'copper', 'iron', 'gold', 'allthemodium', 'vibranium', 'unobtainium' 
];

ServerEvents.recipes(allthemods => {

    materials.forEach(material => {
        allthemods.remove({id: `occultism:crushing/${material}_dirty_dust_from_clump`})
    })
})

// This File has been authored by AllTheMods Staff, or a Community contributor for use in AllTheMods - AllTheMods 10.
// As all AllTheMods packs are licensed under All Rights Reserved, this file is not allowed to be used in any public packs not released by the AllTheMods Team, without explicit permission.