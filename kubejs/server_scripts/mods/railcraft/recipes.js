ServerEvents.recipes(allthemods => {
    allthemods.remove({ id: 'railcraft:iron_tank_wall' })
    allthemods.shaped(Item.of('railcraft:white_iron_tank_wall', 16), [
        'PPP',
        'P P',
        'PPP'
    ], {
        P: '#c:plates/iron'
    });
})