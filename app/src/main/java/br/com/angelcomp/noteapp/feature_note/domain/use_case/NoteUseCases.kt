package br.com.angelcomp.noteapp.feature_note.domain.use_case

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNotes,
    val addNote: AddNote
)
