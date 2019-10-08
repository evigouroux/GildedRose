package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void increaseQuality (Item item)
    {

        item.quality++;

    }

    private void decreaseQuality (Item item)
    {

        if (item.quality > 0)
        {
            item.quality--;
        }

    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++)
        {

            // Si l'objet courant n'est ni le brie, ni le pass et que sa qualité est supérieure a 0 alors il perd 1 de qualité sauf s'il s'agit de Ragnaros mais dans ce cas là on ignore aussi le else

            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) 
                {
                    decreaseQuality(items[i]);
                }
            }

            // Sinon :
            // Si la qualité de l'objet est inférieure a 50 sa qualité augmente
            // S'il s'agit d'un pass alors sa qualité peut augmenter encore de 0,1 ou 2 en fonction de son age

            else
            {
                if (items[i].quality < 50)
                {
                    increaseQuality(items[i]);

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
                    {
                        if (items[i].sellIn < 11)
                        {
                            if (items[i].quality < 50)
                            {
                                increaseQuality(items[i]);
                            }
                        }

                        if (items[i].sellIn < 6)
                        {
                            if (items[i].quality < 50)
                            {
                                increaseQuality(items[i]);
                            }
                        }
                    }
                }
            }

            // Si l'objet n'est pas sulfuras alors il vieillis

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros"))
            {
                items[i].sellIn = items[i].sellIn - 1;
            }

            // Objet périmé

            if (items[i].sellIn < 0) 
            {
                if (!items[i].name.equals("Aged Brie")) 
                {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
                    {

                        // Si la qualité de l'objet n'est pas a 0 et qu'il ne s'agit pas de Sulfuras alors il perd en qualité

                        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros"))
                        {
                            decreaseQuality(items[i]);;
                        }
                    }

                    // Si l'objet est un pass alors sa qualité passe a 0

                    else
                    {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                }

                // Si l'objet est un brie alors sa qualité augmente

                else
                {
                    if (items[i].quality < 50)
                    {
                        increaseQuality(items[i]);
                    }
                }
            }
        }
    }
}