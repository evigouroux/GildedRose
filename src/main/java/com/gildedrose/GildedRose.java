package com.gildedrose;

class GildedRose {

    Item[] items;
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private static final int MIN_SELLIN = 0;
    private static final int CONCERT_GETS_NEAR = 10;
    private static final int CONCERT_GETS_VERY_NEAR = 5;

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
        
        for (Item item : items)
        {

            if (item.name.equals("Aged Brie") {

                decreaseSellIn(item);

                if (item.sellIn < MIN_SELLIN){

                    increaseQualityBy(item, 2);
                }
                else{

                    increaseQualityBy(item, 1);
                }

            }
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                if (item.sellIn < MIN_SELLIN)
                {
                    
                    qualityCrashes(item);

                }
                else if (item.sellIn <= CONCERT_GETS_NEAR){

                    increaseQualityBy(item,2);

                }
                else if (item.sellIN <= CONCERTS_GETS_VERY_NEAR)
                {

                    increaseQualityBy(item,3);

                }
                else
                {

                    increaseQualityBy(item,1);

                }

            }
            else if (item.name.equals("Sulfuras, Hand of Ragnaros")){}
            else {

                if (item.sellIn < MIN_SELLIN){

                    decreaseQualityBy(item, 2);

                }
                else {

                    decreaseQualityBy(item, 1);

                }


            }
        }
    }
}