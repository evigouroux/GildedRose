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



            }

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {



            }

            if (item.name.equals("Sulfuras, Hand of Ragnaros")){


                
            }

            // Si l'objet courant n'est ni le brie, ni le pass et que sa qualité est supérieure a 0 alors il perd 1 de qualité sauf s'il s'agit de Ragnaros mais dans ce cas là on ignore aussi le else

            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) 
                {
                    decreaseQualityBy(item, 1);
                }
            }

            // Sinon :
            // Si la qualité de l'objet est inférieure a 50 sa qualité augmente
            // S'il s'agit d'un pass alors sa qualité peut augmenter encore de 0,1 ou 2 en fonction de son age

            else
            {
                increaseQualityBy(item, 1);

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
                {
                    if (item.sellIn <= CONCERT_GETS_NEAR)
                    {
                        increaseQualityBy(item, 1);
                    }

                    if (item.sellIn <= CONCERT_GETS_VERY_NEAR)
                    {
                        increaseQualityBy(item, 1);
                    }
                }
            }

            // Si l'objet n'est pas sulfuras alors il vieillis

            if (!item.name.equals("Sulfuras, Hand of Ragnaros"))
            {
                decreaseSellIn(item);
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

                // Si l'objet est un brie alors sa qualité augmente

                else
                {
                    increaseQualityBy(item, 1);
                }
            }
        }
    }
}