package br.com.angelcomp.noteapp.feature_note.domain.use_case

import br.com.angelcomp.noteapp.feature_note.domain.model.Note
import br.com.angelcomp.noteapp.feature_note.domain.repository.NoteRepository

class DeleteNotes(
    val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}