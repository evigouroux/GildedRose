package com.gildedrose;

public class BackstagePassUpdater implements Updater
{

    private static final int CONCERT_HAS_PAST = 0;
    private static final int CONCERT_GETS_NEAR = 10;
    private static final int CONCERT_GETS_VERY_NEAR = 5;

    public void Update (Item item) {

        item.sellIn --;

        if (item.sellIn < CONCERT_HAS_PAST)
        {
            
            item.quality -= item.quality;
            
        }
        else if (item.sellIn <= CONCERT_GETS_NEAR){

            item.quality += 2;

        }
        else if (item.sellIN <= CONCERTS_GETS_VERY_NEAR)
        {

            item.quality += 3;

        }
        else
        {

            item.quality ++;

        }

    }


}