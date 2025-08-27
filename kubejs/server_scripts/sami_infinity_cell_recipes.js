// Sami's AE Infinity - Custom Infinity Cell Recipes
// Port of ExtendedAE custom cell recipes to Sami's system

ServerEvents.recipes(event => {

    function cell(output, item, typeA, typeB, component){
        event.shaped(output, [
                'GIG',
                'XCY',
                'AVU'
            ], {
                G: 'ae2:quartz_glass',
                I: item,
                X: typeA,
                C: component,
                Y: typeB,
                A: 'allthemodium:allthemodium_ingot',
                V: 'allthemodium:vibranium_ingot',
                U: 'allthemodium:unobtainium_ingot'
            }
        )
    }

    // Basic Materials
    cell('samisaeinfinity:sami_fluid_lava_cell', 'allthecompressed:blazing_crystal_block_3x', 'minecraft:lava_bucket', 'minecraft:lava_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_sand_cell', 'allthecompressed:sand_6x', 'mekanism:crusher', 'mekanism:crusher', 'samisaefinity:infinity_cobblestone_cell')
    cell('samisaefinity:sami_item_gravel_cell', 'allthecompressed:gravel_6x', 'mekanism:crusher', 'mekanism:crusher', 'samisaefinity:infinity_cobblestone_cell')
    cell('samisaefinity:sami_item_dirt_cell', 'allthecompressed:dirt_6x', 'minecraft:water_bucket', 'minecraft:mud', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_moss_cell', 'allthecompressed:moss_block_5x', 'minecraft:bone_block', 'minecraft:bone_block', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_andesite_cell', 'allthecompressed:andesite_5x', 'minecraft:water_bucket', 'minecraft:lava_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_diorite_cell', 'allthecompressed:diorite_5x', 'minecraft:water_bucket', 'minecraft:lava_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_granite_cell', 'allthecompressed:granite_5x', 'minecraft:water_bucket', 'minecraft:lava_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_tuff_cell', 'allthecompressed:tuff_5x', 'minecraft:water_bucket', 'minecraft:lava_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_red_sand_cell', 'allthecompressed:red_sand_5x', 'minecraft:lava_bucket', 'minecraft:lava_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_end_stone_cell', 'allthecompressed:end_stone_6x', 'minecraft:purpur_block', 'minecraft:purpur_block', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_netherrack_cell', 'allthecompressed:netherrack_6x', 'minecraft:lava_bucket', 'minecraft:gravel', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_clay_cell', 'allthecompressed:clay_5x', 'minecraft:mud', 'minecraft:mud', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_blackstone_cell', 'allthecompressed:blackstone_6x', 'minecraft:lava_bucket', 'minecraft:blue_ice', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_basalt_cell', 'allthecompressed:basalt_6x', 'minecraft:lava_bucket', 'minecraft:blue_ice', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_calcite_cell', 'allthecompressed:calcite_5x', 'minecraft:water_bucket', 'minecraft:bone_block', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_cobbled_deepslate_cell', 'allthecompressed:cobbled_deepslate_6x', 'minecraft:lava_bucket', 'minecraft:packed_ice', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_soul_sand_cell', 'allthecompressed:soul_sand_6x', 'allthemodium:soul_lava_bucket', 'minecraft:sand', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_sky_stone_cell', 'allthecompressed:sky_stone_block_5x', 'allthemodium:soul_lava_bucket', 'ae2:sky_dust', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_kivi_cell', 'allthecompressed:kivi_5x', 'allthemodium:soul_lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_ancient_stone_cell', 'allthecompressed:ancient_stone_5x', 'allthemodium:soul_lava_bucket', 'minecraft:lava_bucket', 'megacells:cell_component_256m')

    // Dyes - all use similar lava+water recipe
    cell('samisaefinity:sami_item_white_dye_cell', 'allthecompressed:white_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_light_gray_dye_cell', 'allthecompressed:light_gray_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_gray_dye_cell', 'allthecompressed:gray_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_black_dye_cell', 'allthecompressed:black_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_brown_dye_cell', 'allthecompressed:brown_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_red_dye_cell', 'allthecompressed:red_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_orange_dye_cell', 'allthecompressed:orange_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_yellow_dye_cell', 'allthecompressed:yellow_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_green_dye_cell', 'allthecompressed:green_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_lime_dye_cell', 'allthecompressed:lime_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_cyan_dye_cell', 'allthecompressed:cyan_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_light_blue_dye_cell', 'allthecompressed:light_blue_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_blue_dye_cell', 'allthecompressed:blue_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_purple_dye_cell', 'allthecompressed:purple_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_magenta_dye_cell', 'allthecompressed:magenta_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
    cell('samisaefinity:sami_item_pink_dye_cell', 'allthecompressed:pink_concrete_6x', 'minecraft:lava_bucket', 'minecraft:water_bucket', 'megacells:cell_component_256m')
});