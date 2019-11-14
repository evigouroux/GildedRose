package com.gildedrose;

public class RegularItemUpdater implements Updater
{

    public void Update (Item item) {

        item.sellIn --;

        if (item.SellIn(item) < 0){

            item.quality -= 2;

        }
        else {

            item.quality -- 1;

        }



           else {

                decreaseSellIn(item);

                if (item.sellIn < MIN_SELLIN){

                    decreaseQualityBy(item, 2);

                }
                else {

                    decreaseQualityBy(item, 1);

                }


            }

    }

}