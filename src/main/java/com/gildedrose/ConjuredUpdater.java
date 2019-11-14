package com.gildedrose;

public class ConjuredUpdater implements Updater
{

    public void Update (Item item) {

        item.sellIn --;

        if (item.SellIn(item) < 0){

            item.quality -= 4;

        }
        else {

            item.quality -= 2;

        }

    }

}