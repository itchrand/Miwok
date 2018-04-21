package it.chrand.miwok

class Word (val miwokTranslation: String, val defaultTranslation: String, val imageRessourceId: Int = -1){
    fun hasImage (): Boolean = imageRessourceId != -1
}

