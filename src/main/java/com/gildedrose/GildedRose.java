package com.gildedrose;

class GildedRose {

    Item[] items;
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private static final int MIN_SELLIN = 0;
    private static final int CONCERT_GETS_NEAR = 10;
    private static final int CONCERT_GETS_VERY_NEAR = 5;

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";    

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void increaseQualityBy (Item item, int increase)
    {

        if (item.quality < MAX_QUALITY)
        {
            item.quality += increase;
        }

    }

    private void qualityCrashes (Item item)
    {

            item.quality = 0;
    }

    private void decreaseSellIn (Item item)
    {

        item.sellIn--;

    }

    private void decreaseQualityBy (Item item, int decrease)
    {

        if (item.quality > MIN_QUALITY)
        {
            item.quality -= decrease;
        }

    }

    public void updateQuality() {
        
        UpdaterFactory updaterFactory = new UpdaterFactory;

        for (Item item : items)
        {

            Updater updater = updaterFactory.getUpdater(item);
            
            updater.update(item);
           
        }
    }
}