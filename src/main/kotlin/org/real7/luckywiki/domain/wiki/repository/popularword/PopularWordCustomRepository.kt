package org.real7.luckywiki.domain.wiki.repository.popularword

interface PopularWordCustomRepository {

    fun getPopularWordTop10(): List<String>
}