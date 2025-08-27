ServerEvents.recipes(event => {
    event.shapeless('kubejs:silent_allthemodium_plate', [
        'allthemodium:allthemodium_plate',
        'allthemodium:allthemodium_plate',
        'allthemodium:allthemodium_plate',
        'allthemodium:allthemodium_plate',
    ])
    event.smithing(
        'kubejs:silent_vibranium_plate',
        'allthemodium:vibranium_upgrade_smithing_template',
        'kubejs:silent_allthemodium_plate',
        'allthemodium:vibranium_ingot'
    )
    event.smithing(
        'kubejs:silent_unobtainium_plate',
        'allthemodium:unobtainium_upgrade_smithing_template',
        'kubejs:silent_vibranium_plate',
        'allthemodium:unobtainium_ingot'
    )
})