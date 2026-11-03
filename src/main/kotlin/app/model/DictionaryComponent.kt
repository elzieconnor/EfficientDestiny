package app.model

import com.fasterxml.jackson.annotation.JsonProperty

data class DictionaryComponent<T>(

    @JsonProperty("data")
    val data: Map<String, T>,
)
