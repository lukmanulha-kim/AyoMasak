package com.lukman.ayomasak.model

data class Response(
	val method: String? = null,
	val results: Results? = null,
	val status: Boolean? = null
)

data class Results(
	val difficulty: String? = null,
	val servings: String? = null,
	val times: String? = null,
	val ingredient: List<String?>? = null,
	val thumb: String? = null,
	val author: Author? = null,
	val step: List<String?>? = null,
	val title: String? = null,
	val needItem: List<NeedItemItem?>? = null,
	val desc: String? = null
)

data class NeedItemItem(
	val thumbItem: String? = null,
	val itemName: String? = null
)

data class Author(
	val datePublished: String? = null,
	val user: String? = null
)

