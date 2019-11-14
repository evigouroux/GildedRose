package com.gildedrose;

public class UpdaterFactory
{
    public static Updater getUpdater (Item item)
    {
        if (item.Name.Contains("Sulfuras"))
        {
            return new LegendaryUpdater();
        }
        else if (item.Name.Contains("Aged Brie"))
        {
            return new ImprovedWithAgeUpdater();
        }
        else if (item.Name.Contains("Backstage pass"))
        {
            return new BackstagePassUpdater();
        }
        else if (item.Name.Contains("Conjured"))
        {
            return new ConjuredUpdater();
        }
        else
        {
            return new RegularItemUpdater();
        }
    }
}