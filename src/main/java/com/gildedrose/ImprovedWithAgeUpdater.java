package com.gildedrose;

public class ImprovedWithAgeUpdater implements Updater
{

    public void Update (Item item) {

        decreaseSellIn(item);

        item.sellIn --;

        if (item.SellIn(item) < 0){

            item.quality += 2;

        }
        else {

            item.quality += 1;

        }

    }

}