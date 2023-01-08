package com.example.cryptocurrency.data.mapper

import com.example.cryptocurrency.data.model.*
import com.example.cryptocurrency.domain.entities.*


fun CoinDto.toDomain() = Coin(
    id = this.id,
    isActive = this.isActive,
    isNew = this.isNew,
    name = this.name,
    rank = this.rank,
    symbol = this.symbol,
    type = this.type
)

fun LinksDto.toDomain() = Links(
    explorer = this.explorer,
    facebook = this.facebook,
    reddit = this.reddit,
    sourceCode = this.sourceCode,
    website = this.website,
    youtube = this.youtube
)

fun TagDto.toDomain() = Tag(
    coinCounter = this.coinCounter,
    icoCounter = this.icoCounter,
    id = this.id,
    name = this.name
)
fun TeamDto.toDomain() = Team(
    id = this.id,
    name = this.name,
    position = this.position
)

fun LinksExtendedDto.toDomain() = LinksExtended(
    stats = this.stats?.toDomain(),
    type = this.type,
    url = this.url)

fun WhitepaperDto.toDomain() = Whitepaper(
    link = this.link,
    thumbnail = this.thumbnail
)

fun StatsDto.toDomain() = Stats(
    contributors = this.contributors,
    followers = this.followers,
    stars = this.stars,
    subscribers = this.subscribers
)

fun CoinDetailDto.toDomain() = CoinDetail(
    description = this.description,
    developmentStatus =  this.developmentStatus,
    firstDataAt = this.firstDataAt,
    hardwareWallet = this.hardwareWallet,
    hashAlgorithm = this.hashAlgorithm,
    id = this.id,
    isActive = this.isActive,
    isNew = this.isNew,
    lastDataAt = this.lastDataAt,
    links = this.links?.toDomain(),
    linksExtended = this.linksExtended?.map { it.toDomain() },
    logo = this.logo,
    message = this.message,
    name = this.name,
    openSource = this.openSource,
    orgStructure = this.orgStructure,
    proofType = this.proofType,
    rank = this.rank,
    startedAt = this.startedAt,
    symbol = this.symbol,
    tags = this.tags?.map { it.toDomain() },
    team = this.team?.map { it.toDomain() },
    type = this.type,
    whitepaper = this.whitepaper?.toDomain()
)