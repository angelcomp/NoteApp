package br.com.angelcomp.noteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.angelcomp.noteapp.ui.theme.*

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightBlue, LightGreen, Violet, BabyBlue, RedPink)
    }
}
