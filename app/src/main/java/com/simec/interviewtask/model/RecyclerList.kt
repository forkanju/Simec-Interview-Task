package com.simec.interviewtask.model


data class RecyclerList(val results: List<Results>)
data class Results(val text: String, val translations: List<Translations>)
data class Translations(val t_name: String, val t_text: String)
