package br.com.angelcomp.noteapp.di

import android.app.Application
import androidx.room.Room
import br.com.angelcomp.noteapp.feature_note.data.data_source.NoteDatabase
import br.com.angelcomp.noteapp.feature_note.data.repository.NoteRepositoryImpl
import br.com.angelcomp.noteapp.feature_note.domain.repository.NoteRepository
import br.com.angelcomp.noteapp.feature_note.domain.use_case.AddNote
import br.com.angelcomp.noteapp.feature_note.domain.use_case.DeleteNotes
import br.com.angelcomp.noteapp.feature_note.domain.use_case.GetNotes
import br.com.angelcomp.noteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME,
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNotes(repository),
            addNote = AddNote(repository)
        )
    }
}