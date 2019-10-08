package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void QualityConstantForAPositiveSellInSulfuras() {

        Item[] items = new Item[]
        {
            new Item("Sulfuras, Hand of Ragnaros", 1, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void QualityConstantForANegativeSellInSulfuras() {

        Item[] items = new Item[]
        {
            new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void SellinStayConstantSulfuras () {

        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 5, 55)
        };
        GildedRose app = new GildedRose(items);
        int temp = app.items[0].quality;
        app.updateQuality();

        assertEquals(temp, app.items[0].quality);

    }

    @Test
    public void QualityUnder50AgedBrie () {

        Item[] items = new Item[] {
            new Item("Aged Brie", 5, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);

    }

    @Test
    public void QualityUnder50WhenSellInUnder0AgedBrie () {

        Item[] items = new Item[] {
            new Item("Aged Brie", -5, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);

    }

    @Test
    public void QualityUnder50BackstagePasses() {

        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);

    }

    @Test
    public void QualityUnder50AfterIncreasingBackstagePasses() {

        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);

    }

    @Test
    public void QualityAbove0 () {

        Item[] items = new Item[] {
            new Item("Test item", 5, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);

    }

    @Test
    public void QualityAbove0AfterSellIn () {

        Item[] items = new Item[] {
            new Item("Test item", -5, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);

    }


    @Test
    public void QualityAbove0AfterDecreasing () {

        Item[] items = new Item[] {
            new Item("Test item", 5, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);

    }

    @Test
    public void QualityDecrease() {

        Item[] items = new Item[]
        {
            new Item("Test item", 10, 20)
        };
        GildedRose app = new GildedRose(items);
        int temp = app.items[0].quality;
        app.updateQuality();
        assertEquals(temp - 1, app.items[0].quality);
    }

    @Test
    public void SellInDecrease() {

        Item[] items = new Item[]
        {
            new Item("Test item", 10, 20)
        };
        GildedRose app = new GildedRose(items);
        int temp = app.items[0].sellIn;
        app.updateQuality();
        assertEquals(temp -1, app.items[0].sellIn);
    }

    @Test
    public void QualityDecreaseFasterWhenConjured() {

        Item[] items = new Item[] {
            new Item("Conjured spoon", 5, 10)
        };
        GildedRose app = new GildedRose(items);
        int temp = app.items[0].quality;
        app.updateQuality();

        assertEquals(temp -1, app.items[0].quality);

    }

    @Test
    public void QualityDecreaseFasterAfterSellIn () {

        Item[] items = new Item[] {
            new Item("Test item", -5, 10)
        };
        GildedRose app = new GildedRose(items);
        int temp = app.items[0].quality;
        app.updateQuality();

        assertEquals(temp -2, app.items[0].quality);

    }

    @Test
    public void QualityIncreaseAgedBrie() {

        Item[] items = new Item[] {
            new Item("Aged Brie", 5, 10)
        };
        GildedRose app = new GildedRose(items);
        int temp = app.items[0].quality;
        app.updateQuality();
        assertEquals(temp +1, app.items[0].quality);

    }

    @Test
    public void QualityIncreaseFasterAfterSellInAgedBrie() {

        Item[] items = new Item[] {
            new Item("Aged Brie", -5, 5)
        };
        GildedRose app = new GildedRose(items);
        int temp = app.items[0].quality;
        app.updateQuality();
        assertEquals(temp +2, app.items[0].quality);

    }

    @Test
    public void QualityIncreaseBackstagePasses10_() {

        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10)
        };
        GildedRose app = new GildedRose(items);
        int temp = app.items[0].quality;
        app.updateQuality();
        assertEquals(temp +1, app.items[0].quality);

    }

    @Test
    public void QualityIncreaseBackstagePasses5_10() {

        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10)
        };
        GildedRose app = new GildedRose(items);
        int temp = app.items[0].quality;
        app.updateQuality();
        assertEquals(temp +2, app.items[0].quality);

    }

    @Test
    public void QualityIncreaseBackstagePasses0_5() {

        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10)
        };
        GildedRose app = new GildedRose(items);
        int temp = app.items[0].quality;
        app.updateQuality();
        assertEquals(temp +3, app.items[0].quality);

    }

    @Test
    public void QualityNulOutOfDateBackstagePasses() {

        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", -2, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);

    }
    
}
