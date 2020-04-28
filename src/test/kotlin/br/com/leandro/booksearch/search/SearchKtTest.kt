package br.com.leandro.booksearch.search

import br.com.leandro.booksearch.indexing.WordPosition
import org.junit.Assert
import org.junit.Test

class SearchKtTest {

    //My car is red My house is blue
    private val indexes: Map<String, List<WordPosition>> = mapOf(
        "My" to listOf(WordPosition(1, 1, 1), WordPosition(1, 1, 5)),
        "car" to listOf(WordPosition(1, 1, 2)),
        "is" to listOf(WordPosition(1, 1, 3), WordPosition(1, 1, 7)),
        "red" to listOf(WordPosition(1, 1, 4)),
        "blue" to listOf(WordPosition(1, 1, 8))
    )

    @Test
    fun `test if search doesn't just positions`() {
        val result = findFirstSentence("My car is blue", indexes)

        Assert.assertEquals(emptyList<WordPosition>(), result)
    }
}
