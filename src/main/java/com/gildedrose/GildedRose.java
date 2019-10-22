package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void increaseQuality (Item item)
    {

        if (item.quality < 50)
        {
            item.quality++;
        }

    }

    private void decreaseSellIn (Item item)
    {

        item.sellIn--;

    }

    private void decreaseQuality (Item item)
    {

        if (item.quality > 0)
        {
            item.quality--;
        }

    }

    public void updateQuality() {
        for (Item item : items)
        {

            // Si l'objet courant n'est ni le brie, ni le pass et que sa qualité est supérieure a 0 alors il perd 1 de qualité sauf s'il s'agit de Ragnaros mais dans ce cas là on ignore aussi le else

            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) 
                {
                    decreaseQuality(item);
                }
            }

            // Sinon :
            // Si la qualité de l'objet est inférieure a 50 sa qualité augmente
            // S'il s'agit d'un pass alors sa qualité peut augmenter encore de 0,1 ou 2 en fonction de son age

            else
            {
                increaseQuality(item);

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
                {
                    if (item.sellIn < 11)
                    {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6)
                    {
                        increaseQuality(item);
                    }
                }
            }

            // Si l'objet n'est pas sulfuras alors il vieillis

            if (!item.name.equals("Sulfuras, Hand of Ragnaros"))
            {
                decreaseSellIn(item);
            }

            // Objet périmé

            if (item.sellIn < 0) 
            {
                if (!item.name.equals("Aged Brie")) 
                {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
                    {

                        // Si la qualité de l'objet n'est pas a 0 et qu'il ne s'agit pas de Sulfuras alors il perd en qualité

                        if (!item.name.equals("Sulfuras, Hand of Ragnaros"))
                        {
                            decreaseQuality(item);;
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
                    increaseQuality(item);
                }
            }
        }
    }
}