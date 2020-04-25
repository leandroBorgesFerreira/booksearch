package br.com.leandro.booksearch.search

import br.com.leandro.booksearch.indexing.WordPosition

//Todo this is a hard one o.O
fun findSentence(sentence: String, indexes: Map<String, List<WordPosition>>): List<List<WordPosition>> {
    return emptyList()
//    var currentPositions: MutableList<WordPosition> = mutableListOf()
//
//    sentence.forEach { word ->
//        val positionList: List<WordPosition>? = indexes[word]
//
//        if (positionList == null) {
//            return emptyList()
//        } else {
//
//        }
//    }
}

fun findFirstSentence(sentence: String, indexes: Map<String, List<WordPosition>>): List<WordPosition> {
    val words = sentence.split(" ")
    val positionsAnswer: MutableList<WordPosition> = mutableListOf()

    words.forEach { word ->
        val firstPosition: WordPosition? = indexes[word]?.get(0) //Primeira posição em que a palavra aparece

        if (firstPosition == null) {
            //A palavra não está indexada, retorna uma lista vazia
            return emptyList()
        } else { //A palavra está indexada
            if (positionsAnswer.isEmpty()) { //Se essa é a primeira palavra, basta colocar na lista de resposta
                positionsAnswer.add(firstPosition)
            } else { //Precisa ver se essa é a próxima palavra
                if(isNextWord(positionsAnswer.last(), firstPosition)) {
                    positionsAnswer.add(firstPosition)
                } else {
                    return emptyList()
                }
            }
        }
    }

    return positionsAnswer
}

private fun isNextWord(wordPosition: WordPosition, nexWordPosition: WordPosition) : Boolean =
    wordPosition.page == nexWordPosition.page &&
            wordPosition.line == nexWordPosition.line &&
            wordPosition.position == (nexWordPosition.position - 1)