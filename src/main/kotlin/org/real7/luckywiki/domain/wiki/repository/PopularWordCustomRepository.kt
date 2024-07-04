package org.real7.luckywiki.domain.wiki.repository

interface PopularWordCustomRepository {

    fun getPopularWordTop10(): List<String>
}