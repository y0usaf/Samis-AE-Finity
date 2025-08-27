// Sami's AE Infinity - All Custom Infinity Cells (FIXED VERSION)
// Port of ExtendedAE custom cells to Sami's system

StartupEvents.registry('item', event => {

    //##### Fluids #####

    //Lava
    event.create('samisaeinfinity:sami_fluid_lava_cell', 'sami_infinity_fluid_cell')
        .fluidType('minecraft:lava')
        .texture('kubejs:item/sami_fluid_lava_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_lava_cell'); // Fixed path


    // ##### Basic Materials #####
    
    //Sand
    event.create('samisaeinfinity:sami_item_sand_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:sand')
        .texture('kubejs:item/sami_item_sand_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_sand_cell'); // Fixed path

    
    //Gravel
    event.create('samisaeinfinity:sami_item_gravel_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:gravel')
        .texture('kubejs:item/sami_item_gravel_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_gravel_cell'); // Fixed path

    
    //Dirt
    event.create('samisaeinfinity:sami_item_dirt_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:dirt')
        .texture('kubejs:item/sami_item_dirt_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_dirt_cell'); // Fixed path

    
    //Moss
    event.create('samisaeinfinity:sami_item_moss_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:moss_block')
        .texture('kubejs:item/sami_item_moss_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_moss_cell'); // Fixed path

    
    //Andesite
    event.create('samisaeinfinity:sami_item_andesite_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:andesite')
        .texture('kubejs:item/sami_item_andesite_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_andesite_cell'); // Fixed path

    
    //Diorite
    event.create('samisaeinfinity:sami_item_diorite_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:diorite')
        .texture('kubejs:item/sami_item_diorite_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_diorite_cell'); // Fixed path

    
    //Granite
    event.create('samisaeinfinity:sami_item_granite_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:granite')
        .texture('kubejs:item/sami_item_granite_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_granite_cell'); // Fixed path

    
    //Tuff
    event.create('samisaeinfinity:sami_item_tuff_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:tuff')
        .texture('kubejs:item/sami_item_tuff_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_tuff_cell'); // Fixed path

    
    //Red Sand
    event.create('samisaeinfinity:sami_item_red_sand_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:red_sand')
        .texture('kubejs:item/sami_item_red_sand_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_red_sand_cell'); // Fixed path

    
    //End Stone
    event.create('samisaeinfinity:sami_item_end_stone_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:end_stone')
        .texture('kubejs:item/sami_item_end_stone_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_end_stone_cell'); // Fixed path

    
    //Netherrack
    event.create('samisaeinfinity:sami_item_netherrack_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:netherrack')
        .texture('kubejs:item/sami_item_netherrack_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_netherrack_cell'); // Fixed path

    
    //Clay
    event.create('samisaeinfinity:sami_item_clay_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:clay')
        .texture('kubejs:item/sami_item_clay_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_clay_cell'); // Fixed path

    
    //Blackstone
    event.create('samisaeinfinity:sami_item_blackstone_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:blackstone')
        .texture('kubejs:item/sami_item_blackstone_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_blackstone_cell'); // Fixed path

    
    //Basalt
    event.create('samisaeinfinity:sami_item_basalt_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:basalt')
        .texture('kubejs:item/sami_item_basalt_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_basalt_cell'); // Fixed path

    
    //Calcite
    event.create('samisaeinfinity:sami_item_calcite_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:calcite')
        .texture('kubejs:item/sami_item_calcite_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_calcite_cell'); // Fixed path

    
    //Cobbled Deepslate
    event.create('samisaeinfinity:sami_item_cobbled_deepslate_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:cobbled_deepslate')
        .texture('kubejs:item/sami_item_cobbled_deepslate_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_cobbled_deepslate_cell'); // Fixed path

    
    //Soul Sand
    event.create('samisaeinfinity:sami_item_soul_sand_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:soul_sand')
        .texture('kubejs:item/sami_item_soul_sand_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_soul_sand_cell'); // Fixed path

    
    //Sky Stone
    event.create('samisaeinfinity:sami_item_sky_stone_cell', 'sami_infinity_item_cell')
        .itemType('ae2:sky_stone_block')
        .texture('kubejs:item/sami_item_sky_stone_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_sky_stone_cell'); // Fixed path

    
    //Kivi (XyCraft World)
    event.create('samisaeinfinity:sami_item_kivi_cell', 'sami_infinity_item_cell')
        .itemType('xycraft_world:kivi')
        .texture('kubejs:item/sami_item_kivi_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_kivi_cell'); // Fixed path

    
    //Ancient Stone (ATM)
    event.create('samisaeinfinity:sami_item_ancient_stone_cell', 'sami_infinity_item_cell')
        .itemType('allthemodium:ancient_stone')
        .texture('kubejs:item/sami_item_ancient_stone_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_ancient_stone_cell'); // Fixed path


    // ##### Dyes #####
    
    //White dye
    event.create('samisaeinfinity:sami_item_white_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:white_dye')
        .texture('kubejs:item/sami_item_white_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_white_dye_cell'); // Fixed path

    
    //Light Gray dye
    event.create('samisaeinfinity:sami_item_light_gray_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:light_gray_dye')
        .texture('kubejs:item/sami_item_light_gray_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_light_gray_dye_cell'); // Fixed path

    
    //Gray dye
    event.create('samisaeinfinity:sami_item_gray_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:gray_dye')
        .texture('kubejs:item/sami_item_gray_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_gray_dye_cell'); // Fixed path

    
    //Black dye
    event.create('samisaeinfinity:sami_item_black_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:black_dye')
        .texture('kubejs:item/sami_item_black_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_black_dye_cell'); // Fixed path

    
    //Brown dye
    event.create('samisaeinfinity:sami_item_brown_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:brown_dye')
        .texture('kubejs:item/sami_item_brown_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_brown_dye_cell'); // Fixed path

    
    //Red dye
    event.create('samisaeinfinity:sami_item_red_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:red_dye')
        .texture('kubejs:item/sami_item_red_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_red_dye_cell'); // Fixed path

    
    //Orange dye
    event.create('samisaeinfinity:sami_item_orange_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:orange_dye')
        .texture('kubejs:item/sami_item_orange_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_orange_dye_cell'); // Fixed path

    
    //Yellow dye
    event.create('samisaeinfinity:sami_item_yellow_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:yellow_dye')
        .texture('kubejs:item/sami_item_yellow_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_yellow_dye_cell'); // Fixed path

    
    //Lime dye
    event.create('samisaeinfinity:sami_item_lime_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:lime_dye')
        .texture('kubejs:item/sami_item_lime_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_lime_dye_cell'); // Fixed path

    
    //Green dye
    event.create('samisaeinfinity:sami_item_green_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:green_dye')
        .texture('kubejs:item/sami_item_green_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_green_dye_cell'); // Fixed path

    
    //Cyan dye
    event.create('samisaeinfinity:sami_item_cyan_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:cyan_dye')
        .texture('kubejs:item/sami_item_cyan_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_cyan_dye_cell'); // Fixed path

    
    //Light Blue dye
    event.create('samisaeinfinity:sami_item_light_blue_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:light_blue_dye')
        .texture('kubejs:item/sami_item_light_blue_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_light_blue_dye_cell'); // Fixed path

    
    //Blue dye
    event.create('samisaeinfinity:sami_item_blue_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:blue_dye')
        .texture('kubejs:item/sami_item_blue_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_blue_dye_cell'); // Fixed path

    
    //Purple dye
    event.create('samisaeinfinity:sami_item_purple_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:purple_dye')
        .texture('kubejs:item/sami_item_purple_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_purple_dye_cell'); // Fixed path

    
    //Magenta dye
    event.create('samisaeinfinity:sami_item_magenta_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:magenta_dye')
        .texture('kubejs:item/sami_item_magenta_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_magenta_dye_cell'); // Fixed path

    
    //Pink dye
    event.create('samisaeinfinity:sami_item_pink_dye_cell', 'sami_infinity_item_cell')
        .itemType('minecraft:pink_dye')
        .texture('kubejs:item/sami_item_pink_dye_cell')  // Explicit texture mapping
        .cellModel('samisaefinity:block/drive/cells/infinity_pink_dye_cell'); // Fixed path
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