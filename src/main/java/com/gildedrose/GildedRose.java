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

                decreaseQualityBy(item, 1);

            }

            // Objet périmé

            if (item.sellIn < MIN_SELLIN) 
            {
                if (!item.name.equals("Aged Brie")) 
                {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
                    {

                        // Si la qualité de l'objet n'est pas a 0 et qu'il ne s'agit pas de Sulfuras alors il perd en qualité

                        if (!item.name.equals("Sulfuras, Hand of Ragnaros"))
                        {
                            decreaseQualityBy(item, 1);
                        }
                    }

                    // Si l'objet est un pass alors sa qualité passe a 0

                    else
                    {
                        item.quality = item.quality - item.quality;
                    }
                }


            }
        }
    }
}