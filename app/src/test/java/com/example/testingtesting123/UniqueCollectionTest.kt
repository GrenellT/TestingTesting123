package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun getItem() {

        val expectedItem1 = Item("Item1")
        val expectedItem2 = Item("Item2")
        collection.addItem(expectedItem1)
        val actualItem1 = collection.get(0)
        assert(expectedItem1 == actualItem1) {"Get does not return the correct item"}

        collection.addItem(expectedItem2)
        val actualItem2 = collection.get(1)
        assert(expectedItem2 == actualItem2) {"Get does not return the correct item"}
    }

    @Test
    fun removeItem() {
        collection.remove(Item("InvalidItem"))
        assert(collection.size() == 0)

        collection.addItem(Item("Item1"))
        collection.addItem(Item("Item2"))
        collection.addItem(Item("Item3"))

        collection.remove(Item("InvalidItem"))
        assert(collection.size() == 3)

        collection.remove(Item("Item2"))
        val secondItem = collection.get(1)
        assert(collection.size() == 2)
        assert(secondItem.name == "Item3")
    }
}