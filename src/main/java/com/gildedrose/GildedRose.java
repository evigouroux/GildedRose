package com.gildedrose;

class GildedRose {

    Item[] items;  

    public GildedRose(Item[] items) {
        this.items = items;
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