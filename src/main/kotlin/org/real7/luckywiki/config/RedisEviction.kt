package org.real7.luckywiki.config

enum class RedisEviction(val policy: String){
    NO_EVICTION("noeviction"),  //메모리 부족 시 새로운 키를 추가하려는 작업이 실패한다
    ALL_KEYS_LRU("allkeys-lru"), //사용 빈도가 낮은 모든 키를 제거한다
    VOLATILE_LRU("volatile-lru"), //사용 빈도가 낮은 만료 키를 제거합니다.
    ALL_KEYS_RANDOM("allkeys-random"), //임의의 모든 키를 제거합니다.
    VOLATILE_RANDOM("volatile-random"), //임의의 만료 키를 제거합니다.
    VOLATILE_TTL("volatile-ttl") //만료 시간이 짧은 키를 제거합니다.
}