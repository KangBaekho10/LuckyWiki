package org.real7.luckywiki.domain.wiki.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "popular_word")
class PopularWord private constructor(
    @Column(name = "search_word")
    val searchWord: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @CreatedDate
    @Column(name = "searched_at")
    var searchedAt: LocalDateTime = LocalDateTime.now()
        protected set

    companion object {
        fun from(searchWord: String): PopularWord {
            return PopularWord(searchWord)
        }
    }
}
