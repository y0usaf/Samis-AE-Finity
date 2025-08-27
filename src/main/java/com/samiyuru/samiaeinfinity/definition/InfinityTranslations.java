package com.samiyuru.samiaeinfinity.definition;

import appeng.core.localization.LocalizationEnum;

import com.samiyuru.samiaeinfinity.SamiAEInfinity;

public enum InfinityTranslations implements LocalizationEnum {
    AcceleratorThreads("Provides 4 co-processing threads per block."),
    ALot("A lot."),
    ClassicCellColours("Infinity: Classic Cell Colours", "pack"),
    ClassicCellColoursDesc("Old red-purple colours for both AE2 and Infinity cell tiers.", "pack"),
    Compression("Compression: %s"),
    CompressionCutoff("Bulk Compression Cutoff"),
    Cutoff("Cutoff: %s"),
    Contains("Contains: %s"),
    ContainsTraceUnits("Contains trace units!"),
    Disabled("Disabled"),
    Empty("Empty"),
    Enabled("Enabled"),
    FilterChemicalUnsupported("Filter chemical unsupported!"),
    MismatchedFilter("Mismatched filter! (%s)"),
    ModName("Infinity Cells", "gui"),
    NotInstalled("%s not installed."),
    NotYetAvailable("Not yet available."),
    PartitionedFor("Partitioned for: %s"),
    ProcessingOnly("Supports processing patterns only."),
    Quantity("Quantity: %s"),
    NotPartitioned("Not Partitioned"),
    TraceUnits("Trace Units: %s (%s)"),
    WorkbenchCell("Cell:"),
    WorkbenchConfig("Config:");

    private final String englishText;
    private final String root;

    InfinityTranslations(String englishText, String root) {
        this.englishText = englishText;
        this.root = root;
    }

    InfinityTranslations(String englishText) {
        this(englishText, "gui.tooltips");
    }

    @Override
    public String getEnglishText() {
        return englishText;
    }

    @Override
    public String getTranslationKey() {
        return String.format("%s.%s.%s", root, SamiAEInfinity.MODID, name());
    }
}