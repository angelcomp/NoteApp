package br.com.angelcomp.noteapp.feature_note.domain.use_case

import br.com.angelcomp.noteapp.feature_note.domain.model.InvalidNoteException
import br.com.angelcomp.noteapp.feature_note.domain.model.Note
import br.com.angelcomp.noteapp.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't ne empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The title of the note can't ne empty")
        }
        repository.insertNote(note)
    }
}