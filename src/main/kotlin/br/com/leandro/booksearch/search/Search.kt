package br.com.leandro.booksearch.search

import br.com.leandro.booksearch.indexing.WordPosition

fun findFirstSentence(sentence: String, indexes: Map<String, List<WordPosition>>): List<WordPosition> {
    val words = sentence.split(" ")
    val positionsAnswer: MutableList<WordPosition> = mutableListOf()

    words.forEach { word ->
        val firstPosition: WordPosition? = indexes[word]?.get(0) //Primeira posição em que a palavra aparece

        when {
            firstPosition == null -> return emptyList()

            positionsAnswer.isEmpty() || isNextWord(positionsAnswer.last(), firstPosition) ->
                positionsAnswer.add(firstPosition)

            else -> return emptyList()
        }
    }

    return positionsAnswer
}

private fun isNextWord(wordPosition: WordPosition, nexWordPosition: WordPosition): Boolean =
    wordPosition.page == nexWordPosition.page &&
            wordPosition.line == nexWordPosition.line &&
            wordPosition.position == (nexWordPosition.position - 1)