package br.com.leandro.booksearch

import br.com.leandro.booksearch.domain.Book
import br.com.leandro.booksearch.domain.Line
import br.com.leandro.booksearch.domain.Page

//reference: https://kitty-ipsum.com/
private fun kittyIpsum(): String = "Miav meogre miaou mjá miáú. Miav miav miauw miauw niaou. Miyav nyā mi'au νιάου mňau miav miáú"

private fun kittyContent(): List<Line> =
    listOf(
        Line(1, kittyIpsum()),
        Line(2, kittyIpsum()),
        Line(3, kittyIpsum()),
        Line(4, kittyIpsum())
    )

private fun relevantContent(): String = "Are you looking for me??"

private fun kittyPage(page: Int) = Page(page, kittyContent())

private fun relevantPage(page: Int): Page =
    Page(page,
        listOf(
            Line(1, kittyIpsum()),
            Line(2, kittyIpsum()),
            Line(3, kittyIpsum()),
            Line(4, kittyIpsum()),
            Line(5, relevantContent())
        )
    )

fun kittyBook(): Book =
    Book(
        "Kitty, the cat",
        listOf(
            kittyPage(1),
            kittyPage(2),
            kittyPage(3),
            kittyPage(4),
            kittyPage(5),
            relevantPage(6)
        )
    )