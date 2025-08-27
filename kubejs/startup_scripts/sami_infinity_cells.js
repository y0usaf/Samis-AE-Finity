// Sami's AE Infinity - All Custom Infinity Cells
// Port of ExtendedAE custom cells to Sami's system

StartupEvents.registry('item', event => {

    //##### Fluids #####

    //Lava
    event.create('samisaeinfinity:sami_fluid_lava_cell', 'sami_infinity_fluid_cell')
        .fluidType('minecraft:lava')
        .texture('kubejs:item/sami_fluid_lava_cell')
        .cellModel('kubejs:block/drive/infinity_lava_cell')
        .displayName('SAMI ME Infinity Lava Cell');


    // ##### Basic Materials #####
    
    //Sand
    event.create('samisaeinfinity:sami_item_sand_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:sand')
        .texture('kubejs:item/sami_item_sand_cell')
        .cellModel('kubejs:block/drive/infinity_sand_cell')
        .displayName('SAMI ME Infinity Sand Cell');

    
    //Gravel
    event.create('samisaeinfinity:sami_item_gravel_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:gravel')
        .texture('kubejs:item/sami_item_gravel_cell')
        .cellModel('kubejs:block/drive/infinity_gravel_cell')
        .displayName('SAMI ME Infinity Gravel Cell');

    
    //Dirt
    event.create('samisaeinfinity:sami_item_dirt_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:dirt')
        .texture('kubejs:item/sami_item_dirt_cell')
        .cellModel('kubejs:block/drive/infinity_dirt_cell')
        .displayName('SAMI ME Infinity Dirt Cell');

    
    //Moss
    event.create('samisaeinfinity:sami_item_moss_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:moss_block')
        .texture('kubejs:item/sami_item_moss_cell')
        .cellModel('kubejs:block/drive/infinity_moss_cell')
        .displayName('SAMI ME Infinity Moss Cell');

    
    //Andesite
    event.create('samisaeinfinity:sami_item_andesite_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:andesite')
        .texture('kubejs:item/sami_item_andesite_cell')
        .cellModel('kubejs:block/drive/infinity_andesite_cell')
        .displayName('SAMI ME Infinity Andesite Cell');

    
    //Diorite
    event.create('samisaeinfinity:sami_item_diorite_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:diorite')
        .texture('kubejs:item/sami_item_diorite_cell')
        .cellModel('kubejs:block/drive/infinity_diorite_cell')
        .displayName('SAMI ME Infinity Diorite Cell');

    
    //Granite
    event.create('samisaeinfinity:sami_item_granite_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:granite')
        .texture('kubejs:item/sami_item_granite_cell')
        .cellModel('kubejs:block/drive/infinity_granite_cell')
        .displayName('SAMI ME Infinity Granite Cell');

    
    //Tuff
    event.create('samisaeinfinity:sami_item_tuff_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:tuff')
        .texture('kubejs:item/sami_item_tuff_cell')
        .cellModel('kubejs:block/drive/infinity_tuff_cell')
        .displayName('SAMI ME Infinity Tuff Cell');

    
    //Red Sand
    event.create('samisaeinfinity:sami_item_red_sand_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:red_sand')
        .texture('kubejs:item/sami_item_red_sand_cell')
        .cellModel('kubejs:block/drive/infinity_red_sand_cell')
        .displayName('SAMI ME Infinity Red Sand Cell');

    
    //End Stone
    event.create('samisaeinfinity:sami_item_end_stone_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:end_stone')
        .texture('kubejs:item/sami_item_end_stone_cell')
        .cellModel('kubejs:block/drive/infinity_end_stone_cell')
        .displayName('SAMI ME Infinity End Stone Cell');

    
    //Netherrack
    event.create('samisaeinfinity:sami_item_netherrack_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:netherrack')
        .texture('kubejs:item/sami_item_netherrack_cell')
        .cellModel('kubejs:block/drive/infinity_netherrack_cell')
        .displayName('SAMI ME Infinity Netherrack Cell');

    
    //Clay
    event.create('samisaeinfinity:sami_item_clay_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:clay')
        .texture('kubejs:item/sami_item_clay_cell')
        .cellModel('kubejs:block/drive/infinity_clay_cell')
        .displayName('SAMI ME Infinity Clay Cell');

    
    //Blackstone
    event.create('samisaeinfinity:sami_item_blackstone_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:blackstone')
        .texture('kubejs:item/sami_item_blackstone_cell')
        .cellModel('kubejs:block/drive/infinity_blackstone_cell')
        .displayName('SAMI ME Infinity Blackstone Cell');

    
    //Basalt
    event.create('samisaeinfinity:sami_item_basalt_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:basalt')
        .texture('kubejs:item/sami_item_basalt_cell')
        .cellModel('kubejs:block/drive/infinity_basalt_cell')
        .displayName('SAMI ME Infinity Basalt Cell');

    
    //Calcite
    event.create('samisaeinfinity:sami_item_calcite_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:calcite')
        .texture('kubejs:item/sami_item_calcite_cell')
        .cellModel('kubejs:block/drive/infinity_calcite_cell')
        .displayName('SAMI ME Infinity Calcite Cell');

    
    //Cobbled Deepslate
    event.create('samisaeinfinity:sami_item_cobbled_deepslate_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:cobbled_deepslate')
        .texture('kubejs:item/sami_item_cobbled_deepslate_cell')
        .cellModel('kubejs:block/drive/infinity_cobbled_deepslate_cell')
        .displayName('SAMI ME Infinity Cobbled Deepslate Cell');

    
    //Soul Sand
    event.create('samisaeinfinity:sami_item_soul_sand_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:soul_sand')
        .texture('kubejs:item/sami_item_soul_sand_cell')
        .cellModel('kubejs:block/drive/infinity_soul_sand_cell')
        .displayName('SAMI ME Infinity Soul Sand Cell');

    
    //Sky Stone
    event.create('samisaeinfinity:sami_item_sky_stone_cell', 'sami_infinity_item_cell')
        .itemType('ae2:sky_stone_block')
        .texture('kubejs:item/sami_item_sky_stone_cell')
        .cellModel('kubejs:block/drive/infinity_sky_stone_cell')
        .displayName('SAMI ME Infinity Sky Stone Cell');

    
    //Kivi (XyCraft World)
    event.create('samisaeinfinity:sami_item_kivi_cell', 'sami_infinity_item_cell')
        .itemType('xycraft_world:kivi')
        .texture('kubejs:item/sami_item_kivi_cell')
        .cellModel('kubejs:block/drive/infinity_kivi_cell')
        .displayName('SAMI ME Infinity Kivi Cell');

    
    //Ancient Stone (ATM)
    event.create('samisaeinfinity:sami_item_ancient_stone_cell', 'sami_infinity_item_cell')
        .itemType('allthemodium:ancient_stone')
        .texture('kubejs:item/sami_item_ancient_stone_cell')
        .cellModel('kubejs:block/drive/infinity_ancient_stone_cell')
        .displayName('SAMI ME Infinity Ancient Stone Cell');


    // ##### Dyes #####
    
    //White dye
    event.create('samisaeinfinity:sami_item_white_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:white_dye')
        .texture('kubejs:item/sami_item_white_dye_cell')
        .cellModel('kubejs:block/drive/infinity_white_dye_cell')
        .displayName('SAMI ME Infinity White Dye Cell');

    
    //Light Gray dye
    event.create('samisaeinfinity:sami_item_light_gray_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:light_gray_dye')
        .texture('kubejs:item/sami_item_light_gray_dye_cell')
        .cellModel('kubejs:block/drive/infinity_light_gray_dye_cell')
        .displayName('SAMI ME Infinity Light Gray Dye Cell');

    
    //Gray dye
    event.create('samisaeinfinity:sami_item_gray_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:gray_dye')
        .texture('kubejs:item/sami_item_gray_dye_cell')
        .cellModel('kubejs:block/drive/infinity_gray_dye_cell')
        .displayName('SAMI ME Infinity Gray Dye Cell');

    
    //Black dye
    event.create('samisaeinfinity:sami_item_black_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:black_dye')
        .texture('kubejs:item/sami_item_black_dye_cell')
        .cellModel('kubejs:block/drive/infinity_black_dye_cell')
        .displayName('SAMI ME Infinity Black Dye Cell');

    
    //Brown dye
    event.create('samisaeinfinity:sami_item_brown_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:brown_dye')
        .texture('kubejs:item/sami_item_brown_dye_cell')
        .cellModel('kubejs:block/drive/infinity_brown_dye_cell')
        .displayName('SAMI ME Infinity Brown Dye Cell');

    
    //Red dye
    event.create('samisaeinfinity:sami_item_red_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:red_dye')
        .texture('kubejs:item/sami_item_red_dye_cell')
        .cellModel('kubejs:block/drive/infinity_red_dye_cell')
        .displayName('SAMI ME Infinity Red Dye Cell');

    
    //Orange dye
    event.create('samisaeinfinity:sami_item_orange_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:orange_dye')
        .texture('kubejs:item/sami_item_orange_dye_cell')
        .cellModel('kubejs:block/drive/infinity_orange_dye_cell')
        .displayName('SAMI ME Infinity Orange Dye Cell');

    
    //Yellow dye
    event.create('samisaeinfinity:sami_item_yellow_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:yellow_dye')
        .texture('kubejs:item/sami_item_yellow_dye_cell')
        .cellModel('kubejs:block/drive/infinity_yellow_dye_cell')
        .displayName('SAMI ME Infinity Yellow Dye Cell');

    
    //Lime dye
    event.create('samisaeinfinity:sami_item_lime_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:lime_dye')
        .texture('kubejs:item/sami_item_lime_dye_cell')
        .cellModel('kubejs:block/drive/infinity_lime_dye_cell')
        .displayName('SAMI ME Infinity Lime Dye Cell');

    
    //Green dye
    event.create('samisaeinfinity:sami_item_green_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:green_dye')
        .texture('kubejs:item/sami_item_green_dye_cell')
        .cellModel('kubejs:block/drive/infinity_green_dye_cell')
        .displayName('SAMI ME Infinity Green Dye Cell');

    
    //Cyan dye
    event.create('samisaeinfinity:sami_item_cyan_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:cyan_dye')
        .texture('kubejs:item/sami_item_cyan_dye_cell')
        .cellModel('kubejs:block/drive/infinity_cyan_dye_cell')
        .displayName('SAMI ME Infinity Cyan Dye Cell');

    
    //Light Blue dye
    event.create('samisaeinfinity:sami_item_light_blue_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:light_blue_dye')
        .texture('kubejs:item/sami_item_light_blue_dye_cell')
        .cellModel('kubejs:block/drive/infinity_light_blue_dye_cell')
        .displayName('SAMI ME Infinity Light Blue Dye Cell');

    
    //Blue dye
    event.create('samisaeinfinity:sami_item_blue_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:blue_dye')
        .texture('kubejs:item/sami_item_blue_dye_cell')
        .cellModel('kubejs:block/drive/infinity_blue_dye_cell')
        .displayName('SAMI ME Infinity Blue Dye Cell');

    
    //Purple dye
    event.create('samisaeinfinity:sami_item_purple_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:purple_dye')
        .texture('kubejs:item/sami_item_purple_dye_cell')
        .cellModel('kubejs:block/drive/infinity_purple_dye_cell')
        .displayName('SAMI ME Infinity Purple Dye Cell');

    
    //Magenta dye
    event.create('samisaeinfinity:sami_item_magenta_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:magenta_dye')
        .texture('kubejs:item/sami_item_magenta_dye_cell')
        .cellModel('kubejs:block/drive/infinity_magenta_dye_cell')
        .displayName('SAMI ME Infinity Magenta Dye Cell');

    
    //Pink dye
    event.create('samisaeinfinity:sami_item_pink_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:pink_dye')
        .texture('kubejs:item/sami_item_pink_dye_cell')
        .cellModel('kubejs:block/drive/infinity_pink_dye_cell')
        .displayName('SAMI ME Infinity Pink Dye Cell');
});

// Add all KJS infinity cells to the Sami's AE Infinity creative tab
StartupEvents.modifyCreativeTab('samisaeinfinity.main', event => {
    // Add all the custom cells to the creative tab
    event.add([
        'samisaeinfinity:sami_fluid_lava_cell',
        'samisaeinfinity:sami_item_sand_cell',
        'samisaeinfinity:sami_item_gravel_cell',
        'samisaeinfinity:sami_item_dirt_cell',
        'samisaeinfinity:sami_item_moss_cell',
        'samisaeinfinity:sami_item_andesite_cell',
        'samisaeinfinity:sami_item_diorite_cell',
        'samisaeinfinity:sami_item_granite_cell',
        'samisaeinfinity:sami_item_tuff_cell',
        'samisaeinfinity:sami_item_red_sand_cell',
        'samisaeinfinity:sami_item_end_stone_cell',
        'samisaeinfinity:sami_item_netherrack_cell',
        'samisaeinfinity:sami_item_clay_cell',
        'samisaeinfinity:sami_item_blackstone_cell',
        'samisaeinfinity:sami_item_basalt_cell',
        'samisaeinfinity:sami_item_calcite_cell',
        'samisaeinfinity:sami_item_cobbled_deepslate_cell',
        'samisaeinfinity:sami_item_soul_sand_cell',
        'samisaeinfinity:sami_item_sky_stone_cell',
        'samisaeinfinity:sami_item_kivi_cell',
        'samisaeinfinity:sami_item_ancient_stone_cell',
        'samisaeinfinity:sami_item_white_dye_cell',
        'samisaeinfinity:sami_item_light_gray_dye_cell',
        'samisaeinfinity:sami_item_gray_dye_cell',
        'samisaeinfinity:sami_item_black_dye_cell',
        'samisaeinfinity:sami_item_brown_dye_cell',
        'samisaeinfinity:sami_item_red_dye_cell',
        'samisaeinfinity:sami_item_orange_dye_cell',
        'samisaeinfinity:sami_item_yellow_dye_cell',
        'samisaeinfinity:sami_item_lime_dye_cell',
        'samisaeinfinity:sami_item_green_dye_cell',
        'samisaeinfinity:sami_item_cyan_dye_cell',
        'samisaeinfinity:sami_item_light_blue_dye_cell',
        'samisaeinfinity:sami_item_blue_dye_cell',
        'samisaeinfinity:sami_item_purple_dye_cell',
        'samisaeinfinity:sami_item_magenta_dye_cell',
        'samisaeinfinity:sami_item_pink_dye_cell'
    ]);
});